package DAO;

import java.sql.*;
import Util.Conexion;

import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Matricula;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MatriculaDAO {

    public List<Alumno> cargarComboAlumnos() {

        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT codAlumno,Nombres FROM alumno WHERE Estado IN (0, 1)";
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                lista.add(new Alumno(rs.getInt("codAlumno"), rs.getString("Nombres")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar alumnos para matricula: " + e.getMessage());
        }
        return lista;
    }

    public List<Curso> cargarComboCurso() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT codCurso,Asignatura FROM curso ";
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                lista.add(new Curso(rs.getInt("codCurso"), rs.getString("Asignatura")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar cursos para matricula: " + e.getMessage());
        }
        return lista;

    }
    
    // Verifica si un alumno ya está matriculado a un curso
    private boolean alumnoYaMatriculado(long codAlumno) {
        String sql = "SELECT COUNT(*) FROM Matricula WHERE codAlumno = ?";
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, codAlumno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // true si ya tiene matrícula
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Insertar matriculas, primero verifica si el alumno ya está matriculado a un curso o no
    public void insertarMatricula(Alumno alumno, Curso curso) {

        if (alumnoYaMatriculado(alumno.getCodAlumno())) {
            JOptionPane.showMessageDialog(null, "Este alumno ya está matriculado en otro curso.");
            return;
        }

        String sql = "INSERT INTO Matricula(codAlumno,codCurso) VALUES (?, ?)";

        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, alumno.getCodAlumno());
            ps.setInt(2, curso.getCodCurso());
            ps.executeUpdate();

            // Poner estado del alumno a matriculado
            String sqlEstado = "UPDATE Alumno SET Estado = 1 WHERE codAlumno = ?";
            try (PreparedStatement ps2 = con.prepareStatement(sqlEstado)) {
                ps2.setLong(1, alumno.getCodAlumno());
                ps2.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Matricula insertada correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar matricula: " + e.getMessage());
        }
    }
    
    //  Para modificar una matricual, cambia el estado del nuevo alumno a 1 y el antiguo a 0
    public void modificarMatricula(Alumno alumnoNuevo, Curso curso, Matricula matricula) {

        String sqlObtenerAlumnoOriginal = "SELECT codAlumno FROM Matricula WHERE numMatricula = ?";

        try (Connection con = new Conexion().getConnection()) {

            con.setAutoCommit(false); // iniciar transacción

            long alumnoOriginal = -1;

            // 1. Obtener alumno original
            try (PreparedStatement ps0 = con.prepareStatement(sqlObtenerAlumnoOriginal)) {
                ps0.setLong(1, matricula.getNumMatricula());
                ResultSet rs = ps0.executeQuery();
                if (rs.next()) {
                    alumnoOriginal = rs.getLong(1);
                }
            }

            // 2. Validar si el alumno nuevo ya tiene matrícula (y no es el mismo)
            if (alumnoNuevo.getCodAlumno() != alumnoOriginal && alumnoYaMatriculado(alumnoNuevo.getCodAlumno())) {
                JOptionPane.showMessageDialog(null, "El alumno seleccionado ya está matriculado en otro curso.");
                return; // Salimos sin modificar nada
            }

            // 3. Actualizar matrícula
            String sqlActualizarMatricula = "UPDATE Matricula SET codAlumno = ?, codCurso = ? WHERE numMatricula = ?";
            try (PreparedStatement ps1 = con.prepareStatement(sqlActualizarMatricula)) {
                ps1.setLong(1, alumnoNuevo.getCodAlumno());
                ps1.setInt(2, curso.getCodCurso());
                ps1.setLong(3, matricula.getNumMatricula());
                ps1.executeUpdate();
            }

            // 4. Cambiar estado del alumno nuevo a 1
            String sqlEstadoAlumnoNuevo = "UPDATE Alumno SET Estado = 1 WHERE codAlumno = ?";
            try (PreparedStatement ps2 = con.prepareStatement(sqlEstadoAlumnoNuevo)) {
                ps2.setLong(1, alumnoNuevo.getCodAlumno());
                ps2.executeUpdate();
            }

            // 5. Cambiar estado del alumno original a 0 si es distinto del nuevo
            if (alumnoOriginal != alumnoNuevo.getCodAlumno()) {
                String sqlEstadoAlumnoOriginal = "UPDATE Alumno SET Estado = 0 WHERE codAlumno = ?";
                try (PreparedStatement ps3 = con.prepareStatement(sqlEstadoAlumnoOriginal)) {
                    ps3.setLong(1, alumnoOriginal);
                    ps3.executeUpdate();
                }
            }

            con.commit(); // commit transacción

            JOptionPane.showMessageDialog(null, "Matrícula modificada correctamente. Estado de alumnos actualizado.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar matrícula: " + e.getMessage());
        }
    }
    
    // Cambia el estado del alumno a 2 y lo pasa a la tabla de Retiros
    public void eliminarMatricula(Alumno alumno, Matricula matricula) {

        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la matrícula de " + alumno.getNombres() + " " + alumno.getApellidos() + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION) {
            return; // Usuario canceló
        }

        String sqlInsertRetiro = "INSERT INTO Retiro(numMatricula) VALUES (?)";
        String sqlEstadoAlumno = "UPDATE Alumno SET Estado = 2 WHERE codAlumno = ?";

        try (Connection con = new Conexion().getConnection()) {

            // 1. Insertar registro en Retiro
            try (PreparedStatement ps1 = con.prepareStatement(sqlInsertRetiro)) {
                ps1.setLong(1, matricula.getNumMatricula());
                ps1.executeUpdate();
            }

            // 2. Cambiar el estado del alumno a 2 (Retirado)
            try (PreparedStatement ps2 = con.prepareStatement(sqlEstadoAlumno)) {
                ps2.setLong(1, alumno.getCodAlumno());
                ps2.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Matrícula registrada como retirada y alumno actualizado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al retirar la matrícula: " + e.getMessage());
        }
    }

    // Carga matriculas en una tabla dependiendo de lo que se pase como filtro, si está vacío carga todos
    public void cargarMatriculas(DefaultTableModel modelo, String filtro) {

        modelo.setRowCount(0);

        int columnas;
        Connection con = new Conexion().getConnection();
        PreparedStatement ps;
        String sql = "SELECT m.numMatricula, a.codAlumno, a.Nombres, a.Apellidos, a.DNI, a.Edad, a.Celular, c.codCurso, c.Asignatura, c.Ciclo, c.Creditos, c.Horas FROM matricula m INNER JOIN alumno a ON m.codAlumno = a.codAlumno INNER JOIN curso c ON m.codCurso = c.codCurso WHERE a.Estado = 1 and numMatricula LIKE ?;";
        String sql1 = "SELECT m.numMatricula, a.codAlumno, a.Nombres, a.Apellidos, a.DNI, a.Edad, a.Celular, c.codCurso, c.Asignatura, c.Ciclo, c.Creditos, c.Horas FROM matricula m INNER JOIN alumno a ON m.codAlumno = a.codAlumno INNER JOIN curso c ON m.codCurso = c.codCurso WHERE a.Estado = 1 ;";
        try {
            if (filtro.equals("")) {
                ps = con.prepareStatement(sql1);
            } else {
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + filtro + "%");
            }

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de matriculas: " + e.toString());
        }
    }

}
