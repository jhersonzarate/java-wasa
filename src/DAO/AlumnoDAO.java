package DAO;

import java.sql.*;
import Util.Conexion;

import Modelo.Alumno;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlumnoDAO {
    
    // Para insertar alumnos
    public void insertarAlumno(Alumno alumno) {
        String sql = "INSERT INTO Alumno (Nombres, Apellidos, DNI, Edad, Celular) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombres());
            ps.setString(2, alumno.getApellidos());
            ps.setString(3, alumno.getDNI());
            ps.setInt(4, alumno.getEdad());
            ps.setString(5, alumno.getCelular());

            ps.executeUpdate(); // Usamos executeUpdate para INSERT, UPDATE o DELETE

            JOptionPane.showMessageDialog(null, "Alumno insertado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar alumno: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Para actualizar alumnos
    public void actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE Alumno SET Nombres = ?, Apellidos = ?, Edad = ?, Celular = ? WHERE codAlumno = ?";

        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombres());
            ps.setString(2, alumno.getApellidos());
            ps.setInt(3, alumno.getEdad());
            ps.setString(4, alumno.getCelular());
            ps.setInt(5, alumno.getCodAlumno());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alumno actualizado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar alumno: " + e.getMessage());
        }
    }
    
    // Para eliminar alumnos
    public void eliminarAlumno(Alumno alumno) {

        String verificarSql = "SELECT Estado FROM Alumno WHERE codAlumno = ?";
        String eliminarSql = "DELETE FROM Alumno WHERE codAlumno = ?";

        try (Connection con = new Conexion().getConnection(); PreparedStatement psVerificar = con.prepareStatement(verificarSql)) {

            // Verificamos el estado del alumno
            psVerificar.setInt(1, alumno.getCodAlumno());

            try (ResultSet rs = psVerificar.executeQuery()) {
                if (rs.next()) {
                    int estado = rs.getInt("Estado");

                    if (estado == 0) {

                        // Solo si el estado es 0, pedimos confirmación
                        int rpta = JOptionPane.showConfirmDialog(null, "ADVERTENCIA: ¿Desea eliminar al alumno?", "Eliminación de Alumno", JOptionPane.YES_NO_OPTION);

                        if (rpta == JOptionPane.YES_OPTION) {
                            try (PreparedStatement psEliminar = con.prepareStatement(eliminarSql)) {
                                psEliminar.setInt(1, alumno.getCodAlumno());
                                psEliminar.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
                            }
                        }

                    } else {
                        // Estado distinto de 0 → no se puede eliminar
                        JOptionPane.showMessageDialog(null, "No se puede eliminar este alumno porque su estado no es 0", "Eliminación no permitida", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Carga alumnos en una tabla dependiendo de lo que se pase como filtro, si está vacío carga todos
    public void cargarAlumnos(DefaultTableModel modelo, String codAlumno) {

        modelo.setRowCount(0);

        Connection con = new Conexion().getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql
                = "SELECT A.codAlumno, A.Nombres, A.Apellidos, A.DNI, A.Edad, A.Celular, A.Estado, "
                + "       C.codCurso, C.Asignatura, C.Ciclo, C.Creditos, C.Horas "
                + "FROM Alumno A "
                + "LEFT JOIN Matricula M ON A.codAlumno = M.codAlumno "
                + "LEFT JOIN Curso C ON M.codCurso = C.codCurso "
                + "WHERE A.codAlumno LIKE ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + codAlumno + "%");

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                modelo.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al buscar datos del alumno: " + e.getMessage());
        }
    }
}
