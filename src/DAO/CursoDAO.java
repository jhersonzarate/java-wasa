package DAO;

import java.sql.*;
import Util.Conexion;

import Modelo.Curso;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CursoDAO {
    
    // Para insertar un curso, primero verifica si el código se repite
    public void insertarCurso(Curso curso) {

        String verificarSql = "SELECT COUNT(*) FROM Curso WHERE codCurso = ?";
        String insertarSql = "INSERT INTO Curso (codCurso, Asignatura, Ciclo, Creditos, Horas) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = new Conexion().getConnection(); PreparedStatement psVerificar = con.prepareStatement(verificarSql); PreparedStatement psInsertar = con.prepareStatement(insertarSql)) {

            // Verificar si el código ya existe
            psVerificar.setInt(1, curso.getCodCurso());
            ResultSet rs = psVerificar.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "El código " + curso.getCodCurso() + " ya existe. No se puede insertar duplicado.");
                return;
            }

            // Si no existe, proceder con el insert
            psInsertar.setInt(1, curso.getCodCurso());
            psInsertar.setString(2, curso.getAsignatura());
            psInsertar.setInt(3, curso.getCiclo());
            psInsertar.setInt(4, curso.getCreditos());
            psInsertar.setInt(5, curso.getHoras());

            psInsertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso insertado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar curso: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Actualiza curso, verifica que el código existe
    public void actualizarCurso(Curso curso) {

        String verificarSql = "SELECT COUNT(*) FROM Curso WHERE codCurso = ?";
        String actualizarSql = "UPDATE Curso SET Asignatura = ?, Ciclo = ?, Creditos = ?, Horas = ? WHERE codCurso = ?";

        try (Connection con = new Conexion().getConnection(); PreparedStatement psVerificar = con.prepareStatement(verificarSql); PreparedStatement psActualizar = con.prepareStatement(actualizarSql)) {

            // Verificar si existe el curso con el código indicado
            psVerificar.setInt(1, curso.getCodCurso());
            ResultSet rs = psVerificar.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                JOptionPane.showMessageDialog(null, "El código " + curso.getCodCurso() + " no existe en la base de datos.");
                return; // Detenemos la ejecución
            }

            // Si existe, proceder con la actualización
            psActualizar.setString(1, curso.getAsignatura());
            psActualizar.setInt(2, curso.getCiclo());
            psActualizar.setInt(3, curso.getCreditos());
            psActualizar.setInt(4, curso.getHoras());
            psActualizar.setInt(5, curso.getCodCurso());

            int filasAfectadas = psActualizar.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Curso actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se actualizó ningún curso (verifica el código).");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar curso: " + e.getMessage());
        }
    }
    
    // Elimina curso, verifica si el curso tiene a algún alumno matriculado antes de eliminar
    public void eliminarCurso(Curso curso) {

        String verificarSql = "SELECT COUNT(*) AS total FROM Matricula WHERE codCurso = ?";
        String eliminarSql = "DELETE FROM Curso WHERE codCurso = ?";

        try (Connection con = new Conexion().getConnection(); PreparedStatement psVerificar = con.prepareStatement(verificarSql)) {

            // Verificamos si existen matrículas con ese curso
            psVerificar.setInt(1, curso.getCodCurso());
            try (ResultSet rs = psVerificar.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt("total");

                    if (total > 0) {
                        // Hay alumnos matriculados en este curso
                        JOptionPane.showMessageDialog(null, "No se puede eliminar este curso porque hay " + total + " alumno(s) matriculado(s).", "Eliminación no permitida", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }

            // No hay alumnos matriculados, pedimos confirmación
            int rpta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este curso?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (rpta == JOptionPane.YES_OPTION) {
                try (PreparedStatement psEliminar = con.prepareStatement(eliminarSql)) {
                    psEliminar.setInt(1, curso.getCodCurso());
                    int filas = psEliminar.executeUpdate();

                    if (filas > 0) {
                        JOptionPane.showMessageDialog(null, "Curso eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el curso especificado.");
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar curso: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Carga cursos en una tabla dependiendo de lo que se pase como filtro, si está vacío carga todos
    public void cargarCursos(DefaultTableModel modelo, String filtro) {

        modelo.setRowCount(0);

        int columnas;
        Connection con = new Conexion().getConnection();
        PreparedStatement ps;
        String sql = "SELECT * FROM curso";
        String sql1 = "SELECT * FROM curso WHERE codCurso LIKE ?";
        try {
            if (filtro.equals("")) {

                ps = con.prepareStatement(sql);
            } else {

                ps = con.prepareStatement(sql1);
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
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

}
