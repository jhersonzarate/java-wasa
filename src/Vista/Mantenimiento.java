package Vista;

import java.sql.*;
import Util.Conexion;

import Modelo.Alumno;
import Modelo.Curso;

import DAO.AlumnoDAO;
import DAO.CursoDAO;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mantenimiento extends javax.swing.JPanel {

    AlumnoDAO alumnoDAO = new AlumnoDAO();
    Alumno alumno = new Alumno();

    CursoDAO cursoDAO = new CursoDAO();
    Curso curso = new Curso();

    public Mantenimiento() {
        initComponents();
        cargarAlumnos();
        cargarCursos();
    }

    public void limpiarAlumno() {
        txtCodigoAlumno.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDNI.setText("");
        txtCelular.setText("");
        txtEdad.setText("");
    }

    public void limpiarCurso() {
        txtCodigoCurso.setText("");
        txtAsignatura.setText("");
        txtCiclo.setText("");
        txtCreditos.setText("");
        txtHoras.setText("");
    }

    public void cargarAlumnos() {
        DefaultTableModel tablaAlumnos = new DefaultTableModel(null, new String[]{"Codigo", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sql = "SELECT * FROM Alumno";

        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codAlumno");
                String nombres = rs.getString("Nombres");
                String apellidos = rs.getString("Apellidos");
                String dni = rs.getString("DNI");
                int edad = rs.getInt("Edad");
                String celular = rs.getString("Celular");
                int estado = rs.getInt("Estado");
                tablaAlumnos.addRow(new Object[]{codigo, nombres, apellidos, dni, edad, celular, estado});
            }

            tblAlumnos.setModel(tablaAlumnos);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de Cursos: " + e.getMessage());
        }
    }

    public void cargarCursos() {
        DefaultTableModel tablaCursos = new DefaultTableModel(null, new String[]{"Codigo", "Asignatura", "Ciclo", "Créditos", "Horas"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sql = "SELECT * FROM Curso ORDER BY codCurso";

        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codCurso");
                String asignatura = rs.getString("Asignatura");
                int ciclo = rs.getInt("Ciclo");
                int creditos = rs.getInt("Creditos");
                int horas = rs.getInt("Horas");
                tablaCursos.addRow(new Object[]{codigo, asignatura, ciclo, creditos, horas});
            }

            tblCursos.setModel(tablaCursos);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de Alumnos: " + e.getMessage());
        }
    }
    
    private boolean validarAlumno() {

        // Verificar que todos los campos estén llenos
        if (txtNombres.getText().trim().isEmpty()
                || txtApellidos.getText().trim().isEmpty()
                || txtDNI.getText().trim().isEmpty()
                || txtEdad.getText().trim().isEmpty()
                || txtCelular.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos antes de continuar.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar que el DNI tenga exactamente 8 dígitos numéricos
        String dni = txtDNI.getText().trim();
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 dígitos numéricos.", "DNI inválido", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar que la edad sea un número entero positivo
        try {
            int edad = Integer.parseInt(txtEdad.getText().trim());
            if (edad < 0) {
                JOptionPane.showMessageDialog(null, "La edad no puede ser negativa.", "Edad inválida", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un número válido.", "Edad inválida", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar que el celular tenga exactamente 9 dígitos numéricos
        String celular = txtCelular.getText().trim();
        if (!celular.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "El número de celular debe contener exactamente 9 dígitos.", "Celular inválido", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Si todas las validaciones pasan:
        return true;
    }

    private boolean validarCurso() {

        // Verificar que todos los campos estén llenos
        if (txtCodigoCurso.getText().trim().isEmpty()
                || txtAsignatura.getText().trim().isEmpty()
                || txtCiclo.getText().trim().isEmpty()
                || txtCreditos.getText().trim().isEmpty()
                || txtHoras.getText().trim().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos antes de continuar.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Validar código de 4 dígitos
        String codigoStr = txtCodigoCurso.getText().trim();
        if (!codigoStr.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(null, "El código del curso debe tener exactamente 4 dígitos numéricos.", "Código inválido", JOptionPane.WARNING_MESSAGE);
            txtCodigoCurso.requestFocus();
            return false;
        }

        // Validar ciclo entre 1 y 10
        try {
            int ciclo = Integer.parseInt(txtCiclo.getText().trim());
            if (ciclo < 1 || ciclo > 10) {
                JOptionPane.showMessageDialog(null, "El ciclo debe estar entre 1 y 10.", "Ciclo inválido", JOptionPane.WARNING_MESSAGE);
                txtCiclo.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ciclo debe ser un número válido.", "Error de formato", JOptionPane.WARNING_MESSAGE);
            txtCiclo.requestFocus();
            return false;
        }

        // Validar créditos y horas positivos
        try {
            int creditos = Integer.parseInt(txtCreditos.getText().trim());
            int horas = Integer.parseInt(txtHoras.getText().trim());
            if (creditos <= 0 || horas <= 0) {
                JOptionPane.showMessageDialog(null, "Créditos y horas deben ser mayores que cero.", "Valores inválidos", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Créditos y horas deben ser valores numéricos válidos.", "Error de formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true; // Todo está correcto
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        panelMantenimiento = new javax.swing.JTabbedPane();
        pnlAlumnos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoAlumno = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        btnRegistrarAlumno = new javax.swing.JButton();
        btnModificarAlumno = new javax.swing.JButton();
        btnEliminarAlumno = new javax.swing.JButton();
        btnLimpiarAlumnos = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        pnlCursos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        txtCodigoCurso = new javax.swing.JTextField();
        txtAsignatura = new javax.swing.JTextField();
        txtCiclo = new javax.swing.JTextField();
        txtCreditos = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        btnRegistrarCurso = new javax.swing.JButton();
        btnModificarCurso = new javax.swing.JButton();
        btnEliminarCurso = new javax.swing.JButton();
        btnLimpiarCursos = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        panelMantenimiento.setBackground(new java.awt.Color(221, 235, 250));
        panelMantenimiento.setForeground(new java.awt.Color(10, 31, 71));
        panelMantenimiento.setMinimumSize(new java.awt.Dimension(720, 640));

        pnlAlumnos.setBackground(new java.awt.Color(178, 223, 244));
        pnlAlumnos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        tblAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAlumnos.setGridColor(new java.awt.Color(204, 204, 204));
        tblAlumnos.setSelectionBackground(new java.awt.Color(10, 31, 71));
        tblAlumnos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);

        pnlAlumnos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 618, 260));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mantenimiento de Alumnos");
        pnlAlumnos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 25, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Código:");
        pnlAlumnos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombres:");
        pnlAlumnos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Apellidos:");
        pnlAlumnos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("DNI:");
        pnlAlumnos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Celular:");
        pnlAlumnos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Edad:");
        pnlAlumnos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        txtCodigoAlumno.setEditable(false);
        txtCodigoAlumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlAlumnos.add(txtCodigoAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 145, -1));

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        pnlAlumnos.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 145, -1));

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlAlumnos.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 145, -1));

        txtDNI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlAlumnos.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 189, -1));

        txtCelular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlAlumnos.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 189, -1));

        txtEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlAlumnos.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 189, -1));

        btnRegistrarAlumno.setBackground(new java.awt.Color(40, 167, 69));
        btnRegistrarAlumno.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRegistrarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarAlumno.setText("Registrar");
        btnRegistrarAlumno.setBorder(null);
        btnRegistrarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAlumnoActionPerformed(evt);
            }
        });
        pnlAlumnos.add(btnRegistrarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 90, 30));

        btnModificarAlumno.setBackground(new java.awt.Color(255, 193, 7));
        btnModificarAlumno.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnModificarAlumno.setForeground(new java.awt.Color(0, 0, 0));
        btnModificarAlumno.setText("Modificar");
        btnModificarAlumno.setToolTipText("");
        btnModificarAlumno.setBorder(null);
        btnModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAlumnoActionPerformed(evt);
            }
        });
        pnlAlumnos.add(btnModificarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 90, 30));

        btnEliminarAlumno.setBackground(new java.awt.Color(220, 53, 69));
        btnEliminarAlumno.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnEliminarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAlumno.setText("Eliminar");
        btnEliminarAlumno.setToolTipText("");
        btnEliminarAlumno.setBorder(null);
        btnEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlumnoActionPerformed(evt);
            }
        });
        pnlAlumnos.add(btnEliminarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 80, 30));

        btnLimpiarAlumnos.setBackground(new java.awt.Color(23, 162, 184));
        btnLimpiarAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnLimpiarAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarAlumnos.setText("Limpiar");
        btnLimpiarAlumnos.setToolTipText("");
        btnLimpiarAlumnos.setBorder(null);
        btnLimpiarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAlumnosActionPerformed(evt);
            }
        });
        pnlAlumnos.add(btnLimpiarAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 80, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/fondo.png"))); // NOI18N
        pnlAlumnos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelMantenimiento.addTab("Alumnos", pnlAlumnos);

        pnlCursos.setBackground(new java.awt.Color(178, 223, 244));
        pnlCursos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mantenimiento de Cursos");
        pnlCursos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 26, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Código:");
        pnlCursos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Asignatura:");
        pnlCursos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Ciclo:");
        jLabel11.setToolTipText("");
        pnlCursos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Créditos:");
        jLabel12.setToolTipText("");
        pnlCursos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Horas:");
        jLabel13.setToolTipText("");
        pnlCursos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        txtHoras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlCursos.add(txtHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 180, -1));

        txtCodigoCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlCursos.add(txtCodigoCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, -1));

        txtAsignatura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlCursos.add(txtAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 180, -1));

        txtCiclo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlCursos.add(txtCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 180, -1));

        txtCreditos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlCursos.add(txtCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 180, -1));

        tblCursos.setBackground(new java.awt.Color(255, 255, 255));
        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCursos.setGridColor(new java.awt.Color(204, 204, 204));
        tblCursos.setSelectionBackground(new java.awt.Color(10, 31, 71));
        tblCursos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCursosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCursos);

        pnlCursos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 640, 250));

        btnRegistrarCurso.setBackground(new java.awt.Color(40, 167, 69));
        btnRegistrarCurso.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRegistrarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCurso.setText("Registrar");
        btnRegistrarCurso.setBorder(null);
        btnRegistrarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCursoActionPerformed(evt);
            }
        });
        pnlCursos.add(btnRegistrarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 280, 90, 30));

        btnModificarCurso.setBackground(new java.awt.Color(255, 193, 7));
        btnModificarCurso.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnModificarCurso.setForeground(new java.awt.Color(0, 0, 0));
        btnModificarCurso.setText("Modificar");
        btnModificarCurso.setBorder(null);
        btnModificarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCursoActionPerformed(evt);
            }
        });
        pnlCursos.add(btnModificarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 90, 30));

        btnEliminarCurso.setBackground(new java.awt.Color(220, 53, 69));
        btnEliminarCurso.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnEliminarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCurso.setText("Eliminar");
        btnEliminarCurso.setBorder(null);
        btnEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCursoActionPerformed(evt);
            }
        });
        pnlCursos.add(btnEliminarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 90, 30));

        btnLimpiarCursos.setBackground(new java.awt.Color(23, 162, 184));
        btnLimpiarCursos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnLimpiarCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCursos.setText("Limpiar");
        btnLimpiarCursos.setBorder(null);
        btnLimpiarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCursosActionPerformed(evt);
            }
        });
        pnlCursos.add(btnLimpiarCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 90, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/fondo.png"))); // NOI18N
        pnlCursos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelMantenimiento.addTab("Cursos", pnlCursos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAlumnoActionPerformed
        if (!validarAlumno()) {
            return;
        }
        
        alumno.setNombres(txtNombres.getText());
        alumno.setApellidos(txtApellidos.getText());
        alumno.setDNI(txtDNI.getText());
        alumno.setEdad(Integer.parseInt(txtEdad.getText()));
        alumno.setCelular(txtCelular.getText());

        alumnoDAO.insertarAlumno(alumno);

        cargarAlumnos();
    }//GEN-LAST:event_btnRegistrarAlumnoActionPerformed

    private void btnLimpiarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAlumnosActionPerformed
        limpiarAlumno();
    }//GEN-LAST:event_btnLimpiarAlumnosActionPerformed

    private void btnModificarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAlumnoActionPerformed
        if (!validarAlumno()) {
            return;
        }
        
        alumno.setNombres(txtNombres.getText());
        alumno.setApellidos(txtApellidos.getText());
        alumno.setEdad(Integer.parseInt(txtEdad.getText()));
        alumno.setCelular(txtCelular.getText());
        alumno.setCodAlumno(Integer.parseInt(txtCodigoAlumno.getText()));

        alumnoDAO.actualizarAlumno(alumno);

        cargarAlumnos();
    }//GEN-LAST:event_btnModificarAlumnoActionPerformed

    private void tblAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosMouseClicked
        if (tblAlumnos.getSelectedRow() != -1) {
            int fila = tblAlumnos.getSelectedRow();
            txtCodigoAlumno.setText(tblAlumnos.getValueAt(fila, 0).toString());
            txtNombres.setText(tblAlumnos.getValueAt(fila, 1).toString());
            txtApellidos.setText(tblAlumnos.getValueAt(fila, 2).toString());
            txtDNI.setText(tblAlumnos.getValueAt(fila, 3).toString());
            txtEdad.setText(tblAlumnos.getValueAt(fila, 4).toString());
            txtCelular.setText(tblAlumnos.getValueAt(fila, 5).toString());
        }
    }//GEN-LAST:event_tblAlumnosMouseClicked

    private void btnEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlumnoActionPerformed
        if (txtCodigoAlumno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay un código establecido", "Código vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        alumno.setCodAlumno(Integer.parseInt(txtCodigoAlumno.getText()));
        alumnoDAO.eliminarAlumno(alumno);

        cargarAlumnos();
    }//GEN-LAST:event_btnEliminarAlumnoActionPerformed

    private void btnRegistrarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCursoActionPerformed
        if (!validarCurso()) {
            return;
        }

        curso.setCodCurso(Integer.parseInt(txtCodigoCurso.getText()));
        curso.setAsignatura(txtAsignatura.getText());
        curso.setCiclo(Integer.parseInt(txtCiclo.getText()));
        curso.setCreditos(Integer.parseInt(txtCreditos.getText()));
        curso.setHoras(Integer.parseInt(txtHoras.getText()));

        cursoDAO.insertarCurso(curso);

        cargarCursos();
    }//GEN-LAST:event_btnRegistrarCursoActionPerformed

    private void btnModificarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCursoActionPerformed
        if (!validarCurso()) {
            return;
        }

        curso.setCodCurso(Integer.parseInt(txtCodigoCurso.getText()));
        curso.setAsignatura(txtAsignatura.getText());
        curso.setCiclo(Integer.parseInt(txtCiclo.getText()));
        curso.setCreditos(Integer.parseInt(txtCreditos.getText()));
        curso.setHoras(Integer.parseInt(txtHoras.getText()));

        cursoDAO.actualizarCurso(curso);

        cargarCursos();
    }//GEN-LAST:event_btnModificarCursoActionPerformed

    private void btnEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursoActionPerformed
        if (txtCodigoCurso.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay un código establecido", "Código vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        curso.setCodCurso(Integer.parseInt(txtCodigoCurso.getText()));
        cursoDAO.eliminarCurso(curso);
        cargarCursos();
    }//GEN-LAST:event_btnEliminarCursoActionPerformed

    private void btnLimpiarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCursosActionPerformed
        limpiarCurso();
    }//GEN-LAST:event_btnLimpiarCursosActionPerformed

    private void tblCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursosMouseClicked
        if (tblCursos.getSelectedRow() != -1) {
            int fila = tblCursos.getSelectedRow();
            txtCodigoCurso.setText(tblCursos.getValueAt(fila, 0).toString());
            txtAsignatura.setText(tblCursos.getValueAt(fila, 1).toString());
            txtCiclo.setText(tblCursos.getValueAt(fila, 2).toString());
            txtCreditos.setText(tblCursos.getValueAt(fila, 3).toString());
            txtHoras.setText(tblCursos.getValueAt(fila, 4).toString());
        }
    }//GEN-LAST:event_tblCursosMouseClicked

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarAlumno;
    private javax.swing.JButton btnEliminarCurso;
    private javax.swing.JButton btnLimpiarAlumnos;
    private javax.swing.JButton btnLimpiarCursos;
    private javax.swing.JButton btnModificarAlumno;
    private javax.swing.JButton btnModificarCurso;
    private javax.swing.JButton btnRegistrarAlumno;
    private javax.swing.JButton btnRegistrarCurso;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane panelMantenimiento;
    private javax.swing.JPanel pnlAlumnos;
    private javax.swing.JPanel pnlCursos;
    private static javax.swing.JTable tblAlumnos;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCiclo;
    private javax.swing.JTextField txtCodigoAlumno;
    private javax.swing.JTextField txtCodigoCurso;
    private javax.swing.JTextField txtCreditos;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
