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

public class RetiroDAO {

    public List<Alumno> cargarComboAlumnos() {

        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT codAlumno,Nombres FROM alumno";
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Alumno(rs.getInt("codAlumno"), rs.getString("Nombres")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar alumnos para retiro: " + e.getMessage());
        }
        return lista;
    }

    public List<Curso> cargarComboCurso() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT codCurso,Asignatura FROM curso";
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Curso(rs.getInt("codCurso"), rs.getString("Asignatura")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar cursos para retiro: " + e.getMessage());
        }
        return lista;
    }

    // Carga retiros en una tabla dependiendo de lo que se pase como filtro, si está vacío carga todos
    public void cargarRetiros(DefaultTableModel modelo, String filtro) {

        modelo.setRowCount(0);

        int columnas;
        Connection con = new Conexion().getConnection();
        PreparedStatement ps;
        String sql = "SELECT m.numMatricula, a.codAlumno, a.Nombres, a.Apellidos, a.DNI, "
                + "a.Edad, a.Celular, c.codCurso, c.Asignatura, c.Ciclo, c.Creditos, c.Horas "
                + "FROM matricula m "
                + "INNER JOIN alumno a ON m.codAlumno = a.codAlumno "
                + "INNER JOIN curso c ON m.codCurso = c.codCurso "
                + "WHERE a.Estado = 2 AND m.numMatricula LIKE ?";

        String sql1 = "SELECT m.numMatricula, a.codAlumno, a.Nombres, a.Apellidos, a.DNI, "
                + "a.Edad, a.Celular, c.codCurso, c.Asignatura, c.Ciclo, c.Creditos, c.Horas "
                + "FROM matricula m "
                + "INNER JOIN alumno a ON m.codAlumno = a.codAlumno "
                + "INNER JOIN curso c ON m.codCurso = c.codCurso "
                + "WHERE a.Estado = 2";

        try {
            if (filtro == null || filtro.trim().isEmpty()) {
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
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de retiros: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
            }
        }
    }
    
    // Para buscar retiros en el módulo de Consulta
    public void buscarRetiros(DefaultTableModel modelo, String filtro) {

        modelo.setRowCount(0);

        int columnas;
        Connection con = new Conexion().getConnection();
        PreparedStatement ps;

        String sql
                = "SELECT r.numRetiro, m.numMatricula, a.codAlumno, a.Nombres, a.Apellidos, a.DNI, "
                + "a.Edad, a.Celular, c.codCurso, c.Asignatura, c.Ciclo, c.Creditos, c.Horas "
                + "FROM retiro r "
                + "INNER JOIN matricula m ON r.numMatricula = m.numMatricula "
                + "INNER JOIN alumno a ON m.codAlumno = a.codAlumno "
                + "INNER JOIN curso c ON m.codCurso = c.codCurso "
                + "WHERE a.Estado = 2 AND r.numRetiro LIKE ?";

        String sql1
                = "SELECT r.numRetiro, m.numMatricula, a.codAlumno, a.Nombres, a.Apellidos, a.DNI, "
                + "a.Edad, a.Celular, c.codCurso, c.Asignatura, c.Ciclo, c.Creditos, c.Horas "
                + "FROM retiro r "
                + "INNER JOIN matricula m ON r.numMatricula = m.numMatricula "
                + "INNER JOIN alumno a ON m.codAlumno = a.codAlumno "
                + "INNER JOIN curso c ON m.codCurso = c.codCurso "
                + "WHERE a.Estado = 2";

        try {
            if (filtro == null || filtro.trim().isEmpty()) {
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
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de retiros: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Inserta un retiro: 1) Inserta en tabla retiro(numMatricula) 2) Cambia
     * Estado del alumno a 2 (retirado)
     */
    public void InsertarRetiro(Matricula matricula) {
        String sqlRetiro = "INSERT INTO retiro(numMatricula) VALUES (?)";
        String sqlEstado = "UPDATE alumno SET Estado = 2 "
                + "WHERE codAlumno = (SELECT codAlumno FROM matricula WHERE numMatricula = ?)";

        try (Connection con = new Conexion().getConnection(); PreparedStatement psRetiro = con.prepareStatement(sqlRetiro); PreparedStatement psEstado = con.prepareStatement(sqlEstado)) {

            // insertar en retiro
            psRetiro.setInt(1, matricula.getNumMatricula());
            psRetiro.executeUpdate();

            // cambiar estado del alumno a retirado
            psEstado.setInt(1, matricula.getNumMatricula());
            psEstado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Retiro insertado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar retiro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Modificar retiro: aquí te dejo una implementación típica: cambiar el
     * curso de la matrícula retirada. Usamos: - codAlumno (alumno) - codCurso
     * (curso nuevo) - numMatricula (dentro de Matricula)
     */
    public void modificarRetiro(Alumno alumno, Curso curso, Matricula matricula) {
        String sql = "UPDATE matricula SET codCurso = ? "
                + "WHERE numMatricula = ? AND codAlumno = ?";

        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, curso.getCodCurso());
            ps.setInt(2, matricula.getNumMatricula());
            ps.setInt(3, alumno.getCodAlumno());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Retiro modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la matrícula a modificar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar retiro: " + e.getMessage());
        }
    }

    /**
     * Eliminar retiro: 1) Elimina el registro en la tabla retiro 2) Cambia
     * Estado del alumno a 1 (matriculado nuevamente)
     */
    public void eliminarRetiro(Alumno alumno, Matricula matricula) {
        String sqlDelete = "DELETE FROM retiro WHERE numMatricula = ?";
        String sqlEstado = "UPDATE alumno SET Estado = 1 WHERE codAlumno = ?";

        try (Connection con = new Conexion().getConnection(); PreparedStatement psDelete = con.prepareStatement(sqlDelete); PreparedStatement psEstado = con.prepareStatement(sqlEstado)) {

            // eliminar de retiro
            psDelete.setInt(1, matricula.getNumMatricula());
            psDelete.executeUpdate();

            // volver a poner al alumno como matriculado
            psEstado.setInt(1, alumno.getCodAlumno());
            psEstado.executeUpdate();

            JOptionPane.showMessageDialog(null, "Retiro eliminado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar retiro: " + e.getMessage());
        }
    }
}
