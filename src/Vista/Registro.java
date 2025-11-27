package Vista;

import DAO.MatriculaDAO;
import DAO.RetiroDAO;
import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Matricula;
import Modelo.Retiro;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Registro extends javax.swing.JPanel {

    public Registro() {
    initComponents();

    cargarComboAlumnos();
    cargarComboCurso();
    cargarComboAlumnosRetiro();
    cargarComboCursoRetiro();
    cargarTablaMatricula();
    cargarTablaRetiro();
    }

    MatriculaDAO matDAO = new MatriculaDAO();
    RetiroDAO retDAO = new RetiroDAO();

    Alumno alumno = new Alumno();
    Curso curso = new Curso();

    Matricula matricula = new Matricula();
    Retiro retiro = new Retiro();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatricula = new javax.swing.JTable();
        btnEliminarMatricula = new javax.swing.JButton();
        btnModificarMatricula = new javax.swing.JButton();
        btnRegistrarMatricula = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumMatricula = new javax.swing.JTextField();
        cbxAlumnoMatricula = new javax.swing.JComboBox<>();
        cbxCursoMatricula = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumRetiro = new javax.swing.JTextField();
        cbxAlumnoRetiro = new javax.swing.JComboBox<>();
        cbxCursoRetiro = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRetiro = new javax.swing.JTable();
        btnInsertarRetiro = new javax.swing.JButton();
        btnModificarRetiro = new javax.swing.JButton();
        btnEliminarRetiro = new javax.swing.JButton();
        btnVerMatriculas = new javax.swing.JButton();
        btnVerRetirados = new javax.swing.JButton();
        txtMostrarElegido = new javax.swing.JLabel();

        setBackground(new java.awt.Color(178, 223, 244));

        jTabbedPane1.setBackground(new java.awt.Color(221, 235, 250));
        jTabbedPane1.setForeground(new java.awt.Color(10, 31, 71));

        jPanel1.setBackground(new java.awt.Color(178, 223, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMatricula.setBackground(new java.awt.Color(255, 255, 255));
        tblMatricula.setForeground(new java.awt.Color(0, 0, 0));
        tblMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "numMat", "codAlu", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "codCur", "Asignatura", "Ciclo", "Creditos", "Horas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblMatricula.setGridColor(new java.awt.Color(204, 204, 204));
        tblMatricula.setSelectionBackground(new java.awt.Color(10, 31, 71));
        tblMatricula.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMatriculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMatricula);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 660, 340));

        btnEliminarMatricula.setBackground(new java.awt.Color(220, 53, 69));
        btnEliminarMatricula.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarMatricula.setText("Eliminar");
        btnEliminarMatricula.setBorder(null);
        btnEliminarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 115, 30));

        btnModificarMatricula.setBackground(new java.awt.Color(255, 193, 7));
        btnModificarMatricula.setForeground(new java.awt.Color(0, 0, 0));
        btnModificarMatricula.setText("Modificar");
        btnModificarMatricula.setBorder(null);
        btnModificarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 115, 28));

        btnRegistrarMatricula.setBackground(new java.awt.Color(40, 167, 69));
        btnRegistrarMatricula.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarMatricula.setText("Ingresar");
        btnRegistrarMatricula.setBorder(null);
        btnRegistrarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 115, 29));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Número de Matricula:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Codigo de alumno: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Codigo de Curso:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 105, -1));

        txtNumMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 173, -1));

        cbxAlumnoMatricula.setForeground(new java.awt.Color(255, 255, 255));
        cbxAlumnoMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlumnoMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(cbxAlumnoMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 173, -1));

        cbxCursoMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(cbxCursoMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 173, -1));

        jTabbedPane1.addTab("Matriculas", jPanel1);

        jPanel2.setBackground(new java.awt.Color(178, 223, 244));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Número de retiro:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Código de alumno:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Codido de curso:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, -1));

        txtNumRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumRetiroActionPerformed(evt);
            }
        });
        jPanel2.add(txtNumRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 184, -1));

        cbxAlumnoRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlumnoRetiroActionPerformed(evt);
            }
        });
        jPanel2.add(cbxAlumnoRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 184, -1));

        jPanel2.add(cbxCursoRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 184, -1));

        tblRetiro.setBackground(new java.awt.Color(255, 255, 255));
        tblRetiro.setForeground(new java.awt.Color(0, 0, 0));
        tblRetiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "numMat", "codAlu", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "codCur", "Asignatura", "Ciclo", "Créditos", "Horas"
            }
        ));
        tblRetiro.setGridColor(new java.awt.Color(204, 204, 204));
        tblRetiro.setSelectionBackground(new java.awt.Color(10, 31, 71));
        tblRetiro.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblRetiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRetiroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRetiro);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 670, 320));

        btnInsertarRetiro.setBackground(new java.awt.Color(40, 167, 69));
        btnInsertarRetiro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsertarRetiro.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarRetiro.setText("Insertar");
        btnInsertarRetiro.setBorder(null);
        btnInsertarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarRetiroActionPerformed(evt);
            }
        });
        jPanel2.add(btnInsertarRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 110, 30));

        btnModificarRetiro.setBackground(new java.awt.Color(255, 193, 7));
        btnModificarRetiro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificarRetiro.setForeground(new java.awt.Color(0, 0, 0));
        btnModificarRetiro.setText("Modificar");
        btnModificarRetiro.setBorder(null);
        btnModificarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRetiroActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificarRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 110, 30));

        btnEliminarRetiro.setBackground(new java.awt.Color(220, 53, 69));
        btnEliminarRetiro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarRetiro.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarRetiro.setText("Eliminar");
        btnEliminarRetiro.setBorder(null);
        btnEliminarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRetiroActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 110, 30));

        btnVerMatriculas.setBackground(new java.awt.Color(33, 150, 243));
        btnVerMatriculas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerMatriculas.setForeground(new java.awt.Color(255, 255, 255));
        btnVerMatriculas.setText("Matriculados");
        btnVerMatriculas.setToolTipText("");
        btnVerMatriculas.setBorder(null);
        btnVerMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMatriculasActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerMatriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 102, 30));

        btnVerRetirados.setBackground(new java.awt.Color(251, 140, 0));
        btnVerRetirados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerRetirados.setForeground(new java.awt.Color(0, 0, 0));
        btnVerRetirados.setText("Retirados");
        btnVerRetirados.setBorder(null);
        btnVerRetirados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRetiradosActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerRetirados, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 100, 30));

        txtMostrarElegido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtMostrarElegido.setText("Alumnos Retirados");
        jPanel2.add(txtMostrarElegido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 309, -1));

        jTabbedPane1.addTab("Retiros", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAlumnoMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumnoMatriculaActionPerformed

    }//GEN-LAST:event_cbxAlumnoMatriculaActionPerformed

    private void txtNumMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumMatriculaActionPerformed

    }//GEN-LAST:event_txtNumMatriculaActionPerformed

    private void btnRegistrarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMatriculaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblMatricula.getModel();
        Alumno selectA = (Alumno) cbxAlumnoMatricula.getSelectedItem();
        int codAlumno = selectA.getCodAlumno();

        Curso selectC = (Curso) cbxCursoMatricula.getSelectedItem();
        int codCurso = selectC.getCodCurso();

        alumno.setCodAlumno(codAlumno);
        curso.setCodCurso(codCurso);
        matDAO.insertarMatricula(alumno, curso);

        matDAO.cargarMatriculas(modelo, "");
    }//GEN-LAST:event_btnRegistrarMatriculaActionPerformed

    private void btnModificarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMatriculaActionPerformed
        if (txtNumMatricula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay un número de matricula establecido", "Número vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblMatricula.getModel();

        Alumno selectA = (Alumno) cbxAlumnoMatricula.getSelectedItem();
        int codAlumno = selectA.getCodAlumno();

        Curso selectC = (Curso) cbxCursoMatricula.getSelectedItem();
        int codCurso = selectC.getCodCurso();

        String numMat = txtNumMatricula.getText();
        int numMatricula = Integer.parseInt(numMat);

        alumno.setCodAlumno(codAlumno);
        curso.setCodCurso(codCurso);
        matricula.setNumMatricula(numMatricula);

        matDAO.modificarMatricula(alumno, curso, matricula);

        matDAO.cargarMatriculas(modelo, "");
    }//GEN-LAST:event_btnModificarMatriculaActionPerformed

    private void btnEliminarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMatriculaActionPerformed
        if (txtNumMatricula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay un número de matricula establecido", "Número vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblMatricula.getModel();

        Alumno selectA = (Alumno) cbxAlumnoMatricula.getSelectedItem();
        int codAlumno = selectA.getCodAlumno();

        String numMat = txtNumMatricula.getText();
        int numMatricula = Integer.parseInt(numMat);

        alumno.setCodAlumno(codAlumno);
        matricula.setNumMatricula(numMatricula);
        matDAO.eliminarMatricula(alumno, matricula);

        matDAO.cargarMatriculas(modelo, "");
    }//GEN-LAST:event_btnEliminarMatriculaActionPerformed

    private void tblMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMatriculaMouseClicked
        int fila = tblMatricula.getSelectedRow();

        int filaConvert = tblMatricula.convertRowIndexToModel(fila);

        String numMatricula = tblMatricula.getModel().getValueAt(filaConvert, 0).toString();
        int codAlumn = Integer.parseInt(tblMatricula.getModel().getValueAt(filaConvert, 1).toString());
        int codCurso = Integer.parseInt(tblMatricula.getModel().getValueAt(filaConvert, 7).toString());

        txtNumMatricula.setText(numMatricula);

        // Para elegir el Alumno en el Combo Box
        for (int i = 0; i < cbxAlumnoMatricula.getItemCount(); i++) {
            Alumno a = (Alumno) cbxAlumnoMatricula.getItemAt(i);

            if (a.getCodAlumno() == codAlumn) {
                cbxAlumnoMatricula.setSelectedIndex(i);
                break;
            }
        }

        // Para elegir el Curso en el Combo Box
        for (int i = 0; i < cbxCursoMatricula.getItemCount(); i++) {
            Curso c = (Curso) cbxCursoMatricula.getItemAt(i);

            if (c.getCodCurso() == codCurso) {
                cbxCursoMatricula.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tblMatriculaMouseClicked

    private void btnVerMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMatriculasActionPerformed
        // Ver tabla de matriculados
        DefaultTableModel modelo = (DefaultTableModel) tblRetiro.getModel();
        matDAO.cargarMatriculas(modelo, "");
        txtMostrarElegido.setText("Alumnos Matriculados:");
    }//GEN-LAST:event_btnVerMatriculasActionPerformed

    private void btnVerRetiradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRetiradosActionPerformed
        // Ver tabla de retirados
        DefaultTableModel modelo = (DefaultTableModel) tblRetiro.getModel();
        retDAO.cargarRetiros(modelo, "");
        txtMostrarElegido.setText("Alumnos Retirados:");
    }//GEN-LAST:event_btnVerRetiradosActionPerformed

    private void cbxAlumnoRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumnoRetiroActionPerformed
        // combo cobx 2 alumnos
    }//GEN-LAST:event_cbxAlumnoRetiroActionPerformed

    private void cbxCursoMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCursoMatriculaActionPerformed

    private void tblRetiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRetiroMouseClicked
        int fila = tblRetiro.getSelectedRow();

        int filaConvert = tblRetiro.convertRowIndexToModel(fila);

        String numMatricula = tblRetiro.getModel().getValueAt(filaConvert, 0).toString();
        int codAlumn = Integer.parseInt(tblRetiro.getModel().getValueAt(filaConvert, 1).toString());
        int codCurso = Integer.parseInt(tblRetiro.getModel().getValueAt(filaConvert, 7).toString());

        txtNumRetiro.setText(numMatricula);

        // Para elegir el Alumno en el Combo Box
        for (int i = 0; i < cbxAlumnoRetiro.getItemCount(); i++) {
            Alumno a = (Alumno) cbxAlumnoRetiro.getItemAt(i);

            if (a.getCodAlumno() == codAlumn) {
                cbxAlumnoRetiro.setSelectedIndex(i);
                break;
            }
        }

        // Para elegir el Curso en el Combo Box
        for (int i = 0; i < cbxCursoRetiro.getItemCount(); i++) {
            Curso c = (Curso) cbxCursoRetiro.getItemAt(i);

            if (c.getCodCurso() == codCurso) {
                cbxCursoRetiro.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tblRetiroMouseClicked

    private void btnInsertarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarRetiroActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblRetiro.getModel();
        // Aca está pasando la matricula desde el txt de Retiro
        String numMatricula = txtNumRetiro.getText().trim();

        if (numMatricula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un número de matrícula", "Dato requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            matricula.setNumMatricula(Integer.parseInt(numMatricula));
            retDAO.InsertarRetiro(matricula);

            // Recargar tabla de retiros
            retDAO.cargarRetiros(modelo, "");
            txtMostrarElegido.setText("Alumnos Retirados:");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de matrícula no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarRetiroActionPerformed

    private void btnModificarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRetiroActionPerformed
        if (txtNumRetiro.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay un número de matrícula/retiro establecido", "Número vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblRetiro.getModel();

        Alumno selectA = (Alumno) cbxAlumnoRetiro.getSelectedItem();
        if (selectA == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un alumno", "Dato requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Curso selectC = (Curso) cbxCursoRetiro.getSelectedItem();
        if (selectC == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un curso", "Dato requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int numMatricula = Integer.parseInt(txtNumRetiro.getText().trim());

            alumno.setCodAlumno(selectA.getCodAlumno());
            curso.setCodCurso(selectC.getCodCurso());
            matricula.setNumMatricula(numMatricula);

            // Modificar datos relacionados a la matrícula retirada
            retDAO.modificarRetiro(alumno, curso, matricula);

            // Recargar tabla de retiros
            retDAO.cargarRetiros(modelo, "");
            txtMostrarElegido.setText("Alumnos Retirados:");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de matrícula no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarRetiroActionPerformed

    private void btnEliminarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRetiroActionPerformed
        if (txtNumRetiro.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay un número de matrícula/retito establecido", "Número vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int rpta = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar el retiro?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (rpta != JOptionPane.YES_OPTION) {
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblRetiro.getModel();

        Alumno selectA = (Alumno) cbxAlumnoRetiro.getSelectedItem();
        if (selectA == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un alumno", "Dato requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int numMatricula = Integer.parseInt(txtNumRetiro.getText().trim());

            alumno.setCodAlumno(selectA.getCodAlumno());
            matricula.setNumMatricula(numMatricula);

            retDAO.eliminarRetiro(alumno, matricula);

            // Recargar tabla de retiros
            retDAO.cargarRetiros(modelo, "");
            txtMostrarElegido.setText("Alumnos Retirados:");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de matrícula no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarRetiroActionPerformed

    private void txtNumRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumRetiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumRetiroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarMatricula;
    private javax.swing.JButton btnEliminarRetiro;
    private javax.swing.JButton btnInsertarRetiro;
    private javax.swing.JButton btnModificarMatricula;
    private javax.swing.JButton btnModificarRetiro;
    private javax.swing.JButton btnRegistrarMatricula;
    private javax.swing.JButton btnVerMatriculas;
    private javax.swing.JButton btnVerRetirados;
    private javax.swing.JComboBox<Alumno> cbxAlumnoMatricula;
    private javax.swing.JComboBox<Object> cbxAlumnoRetiro;
    private javax.swing.JComboBox<Curso> cbxCursoMatricula;
    private javax.swing.JComboBox<Object> cbxCursoRetiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblMatricula;
    private javax.swing.JTable tblRetiro;
    private javax.swing.JLabel txtMostrarElegido;
    private javax.swing.JTextField txtNumMatricula;
    private javax.swing.JTextField txtNumRetiro;
    // End of variables declaration//GEN-END:variables

    private void cargarComboAlumnos() {
        for (Alumno a : matDAO.cargarComboAlumnos()) {
            cbxAlumnoMatricula.addItem(a);
        }
    }

    private void cargarComboCurso() {
        for (Curso c : matDAO.cargarComboCurso()) {
            cbxCursoMatricula.addItem(c);
        }
    }

    private void cargarTablaMatricula() {
        DefaultTableModel modelo = (DefaultTableModel) tblMatricula.getModel();
        matDAO.cargarMatriculas(modelo, "");
    }

    private void cargarTablaRetiro() {
        DefaultTableModel modelo = (DefaultTableModel) tblRetiro.getModel();
        retDAO.cargarRetiros(modelo, "");
    }

    private void cargarComboAlumnosRetiro() {
        for (Alumno a : retDAO.cargarComboAlumnos()) {
            cbxAlumnoRetiro.addItem(a);
        }

    }

    private void cargarComboCursoRetiro() {
        for (Curso c : retDAO.cargarComboCurso()) {
            cbxCursoRetiro.addItem(c);

        }
    }
}
