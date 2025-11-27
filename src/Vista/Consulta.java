package Vista;

import DAO.AlumnoDAO;
import DAO.CursoDAO;
import DAO.MatriculaDAO;
import DAO.RetiroDAO;
import javax.swing.table.DefaultTableModel;

public class Consulta extends javax.swing.JPanel {

    public Consulta() {
        initComponents();
        cargartablaAlumno();
        cargartablaCurso();
        cargartablaMatricula();
        cargartablaRetiro();
    }
    AlumnoDAO alumDAO = new AlumnoDAO();
    CursoDAO curDAO = new CursoDAO();
    MatriculaDAO matDAO = new MatriculaDAO();
    RetiroDAO retDAO = new RetiroDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCodAlumno = new javax.swing.JTextField();
        btnBuscarAlumno = new javax.swing.JButton();
        btnTodosAlumnos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodCurso = new javax.swing.JTextField();
        btnBuscarCurso = new javax.swing.JButton();
        btnTodosCursos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMatricula = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtNumMatricula = new javax.swing.JTextField();
        btnBuscarMatricula = new javax.swing.JButton();
        btnTodosMatricula = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaRetiro = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtNumRetiro = new javax.swing.JTextField();
        btnBuscarRetiro = new javax.swing.JToggleButton();
        btnTodosRetiro = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(178, 223, 244));

        jTabbedPane2.setBackground(new java.awt.Color(221, 235, 250));
        jTabbedPane2.setForeground(new java.awt.Color(10, 31, 71));

        jPanel3.setBackground(new java.awt.Color(178, 223, 244));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "codAlumno", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado", "codCurso", "Asignatura", "Ciclo", "Creditos", "Horas"
            }
        ));
        tablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaAlumno);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 680, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese código del alumnos:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtCodAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodAlumnoActionPerformed(evt);
            }
        });
        jPanel3.add(txtCodAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, -1));

        btnBuscarAlumno.setBackground(new java.awt.Color(91, 168, 209));
        btnBuscarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarAlumno.setText("Buscar");
        btnBuscarAlumno.setBorder(null);
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnoActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 80, 28));

        btnTodosAlumnos.setBackground(new java.awt.Color(167, 159, 239));
        btnTodosAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnTodosAlumnos.setText("Todos");
        btnTodosAlumnos.setBorder(null);
        btnTodosAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosAlumnosActionPerformed(evt);
            }
        });
        jPanel3.add(btnTodosAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 80, 28));

        jTabbedPane2.addTab("Alumnos", jPanel3);

        jPanel4.setBackground(new java.awt.Color(178, 223, 244));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codCurso", "Asignatura", "Ciclo", "Créditos", "Horas"
            }
        ));
        tablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCursosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCursos);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 131, 680, 450));
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 28, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ingrese código del Curso:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        txtCodCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodCursoActionPerformed(evt);
            }
        });
        jPanel4.add(txtCodCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 310, -1));

        btnBuscarCurso.setBackground(new java.awt.Color(91, 168, 209));
        btnBuscarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCurso.setText("Buscar");
        btnBuscarCurso.setBorder(null);
        btnBuscarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCursoActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 80, 30));

        btnTodosCursos.setBackground(new java.awt.Color(167, 159, 239));
        btnTodosCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnTodosCursos.setText("Todos");
        btnTodosCursos.setBorder(null);
        btnTodosCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosCursosActionPerformed(evt);
            }
        });
        jPanel4.add(btnTodosCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 80, 30));

        jTabbedPane2.addTab("Cursos", jPanel4);

        jPanel1.setBackground(new java.awt.Color(178, 223, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "numMat", "codAlu", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "codCur", "Asignatura", "Ciclo", "Créditos", "Horas"
            }
        ));
        tablaMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMatriculaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaMatricula);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 700, 450));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ingrese número de Matrícula");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 230, 22));

        txtNumMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 310, -1));

        btnBuscarMatricula.setBackground(new java.awt.Color(91, 168, 209));
        btnBuscarMatricula.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarMatricula.setText("Buscar");
        btnBuscarMatricula.setBorder(null);
        btnBuscarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 80, 28));

        btnTodosMatricula.setBackground(new java.awt.Color(167, 159, 239));
        btnTodosMatricula.setForeground(new java.awt.Color(255, 255, 255));
        btnTodosMatricula.setText("Todos");
        btnTodosMatricula.setBorder(null);
        btnTodosMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTodosMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 80, 28));

        jTabbedPane2.addTab("Matricula", jPanel1);

        jPanel2.setBackground(new java.awt.Color(178, 223, 244));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaRetiro.setBackground(new java.awt.Color(255, 255, 255));
        tablaRetiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "numRet", "numMat", "codAlu", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "codCur", "Asignatura", "Ciclo", "Créditos", "Horas"
            }
        ));
        tablaRetiro.setGridColor(new java.awt.Color(204, 204, 204));
        tablaRetiro.setSelectionBackground(new java.awt.Color(10, 31, 71));
        tablaRetiro.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaRetiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRetiroMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaRetiro);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 700, 420));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ingrese número de Retiro:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 210, -1));

        txtNumRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumRetiroActionPerformed(evt);
            }
        });
        jPanel2.add(txtNumRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 260, -1));

        btnBuscarRetiro.setBackground(new java.awt.Color(91, 168, 209));
        btnBuscarRetiro.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarRetiro.setText("Buscar");
        btnBuscarRetiro.setBorder(null);
        btnBuscarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRetiroActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 80, 28));

        btnTodosRetiro.setBackground(new java.awt.Color(167, 159, 239));
        btnTodosRetiro.setForeground(new java.awt.Color(255, 255, 255));
        btnTodosRetiro.setText("Todos");
        btnTodosRetiro.setBorder(null);
        btnTodosRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosRetiroActionPerformed(evt);
            }
        });
        jPanel2.add(btnTodosRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 80, 28));

        jTabbedPane2.addTab("Retiros", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodAlumnoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();
        String codAlumn = txtCodAlumno.getText().trim();
        alumDAO.cargarAlumnos(modelo, codAlumn);
    }//GEN-LAST:event_txtCodAlumnoActionPerformed

    private void txtCodCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodCursoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaCursos.getModel();
        String codAlumn = txtCodCurso.getText().trim();
        curDAO.cargarCursos(modelo, codAlumn);
    }//GEN-LAST:event_txtCodCursoActionPerformed

    private void txtNumMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumMatriculaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaMatricula.getModel();
        String numMatricula = txtNumMatricula.getText().trim();
        matDAO.cargarMatriculas(modelo, numMatricula);
    }//GEN-LAST:event_txtNumMatriculaActionPerformed

    private void btnBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();
        String codAlumn = txtCodAlumno.getText().trim();
        alumDAO.cargarAlumnos(modelo, codAlumn);
    }//GEN-LAST:event_btnBuscarAlumnoActionPerformed

    private void btnTodosAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosAlumnosActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();
        alumDAO.cargarAlumnos(modelo, "");
        txtCodAlumno.setText("");
    }//GEN-LAST:event_btnTodosAlumnosActionPerformed

    private void btnBuscarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCursoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaCursos.getModel();
        String codAlumn = txtCodCurso.getText().trim();
        curDAO.cargarCursos(modelo, codAlumn);
    }//GEN-LAST:event_btnBuscarCursoActionPerformed

    private void btnTodosCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosCursosActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaCursos.getModel();
        curDAO.cargarCursos(modelo, "");
        txtCodCurso.setText("");
    }//GEN-LAST:event_btnTodosCursosActionPerformed

    private void btnBuscarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMatriculaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaMatricula.getModel();
        String numMatricula = txtNumMatricula.getText().trim();
        matDAO.cargarMatriculas(modelo, numMatricula);
    }//GEN-LAST:event_btnBuscarMatriculaActionPerformed

    private void btnTodosMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosMatriculaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaMatricula.getModel();
        matDAO.cargarMatriculas(modelo, "");
        txtNumMatricula.setText("");
    }//GEN-LAST:event_btnTodosMatriculaActionPerformed

    private void txtNumRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumRetiroActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaRetiro.getModel();
        String codretiro = txtNumRetiro.getText().trim();
        retDAO.buscarRetiros(modelo, codretiro);
    }//GEN-LAST:event_txtNumRetiroActionPerformed

    private void btnBuscarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRetiroActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaRetiro.getModel();
        String numRetiro = txtNumRetiro.getText().trim();
        retDAO.buscarRetiros(modelo, numRetiro);
    }//GEN-LAST:event_btnBuscarRetiroActionPerformed

    private void btnTodosRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosRetiroActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaRetiro.getModel();
        retDAO.buscarRetiros(modelo, "");
        txtNumRetiro.setText("");
    }//GEN-LAST:event_btnTodosRetiroActionPerformed

    private void tablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnoMouseClicked
        int fila = tablaAlumno.getSelectedRow();
        int filaConvert = tablaAlumno.convertRowIndexToModel(fila);
        String codAlumno = tablaAlumno.getModel().getValueAt(filaConvert, 0).toString();
        txtCodAlumno.setText(codAlumno);
    }//GEN-LAST:event_tablaAlumnoMouseClicked

    private void tablaCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCursosMouseClicked
        int fila = tablaCursos.getSelectedRow();
        int filaConvert = tablaCursos.convertRowIndexToModel(fila);
        String codCurso = tablaCursos.getModel().getValueAt(filaConvert, 0).toString();
        txtCodCurso.setText(codCurso);
    }//GEN-LAST:event_tablaCursosMouseClicked

    private void tablaMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMatriculaMouseClicked
        int fila = tablaMatricula.getSelectedRow();
        int filaConvert = tablaMatricula.convertRowIndexToModel(fila);
        String numMatricula = tablaMatricula.getModel().getValueAt(filaConvert, 0).toString();
        txtNumMatricula.setText(numMatricula);
    }//GEN-LAST:event_tablaMatriculaMouseClicked

    private void tablaRetiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRetiroMouseClicked
        int fila = tablaRetiro.getSelectedRow();
        int filaConvert = tablaRetiro.convertRowIndexToModel(fila);
        String numMatricula = tablaRetiro.getModel().getValueAt(filaConvert, 0).toString();
        txtNumRetiro.setText(numMatricula);
    }//GEN-LAST:event_tablaRetiroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnBuscarCurso;
    private javax.swing.JButton btnBuscarMatricula;
    private javax.swing.JToggleButton btnBuscarRetiro;
    private javax.swing.JButton btnTodosAlumnos;
    private javax.swing.JButton btnTodosCursos;
    private javax.swing.JButton btnTodosMatricula;
    private javax.swing.JToggleButton btnTodosRetiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tablaAlumno;
    private javax.swing.JTable tablaCursos;
    private javax.swing.JTable tablaMatricula;
    private javax.swing.JTable tablaRetiro;
    private javax.swing.JTextField txtCodAlumno;
    private javax.swing.JTextField txtCodCurso;
    private javax.swing.JTextField txtNumMatricula;
    private javax.swing.JTextField txtNumRetiro;
    // End of variables declaration//GEN-END:variables

    private void cargartablaAlumno() {
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();
        alumDAO.cargarAlumnos(modelo, "");
    }

    private void cargartablaCurso() {
        DefaultTableModel modelo = (DefaultTableModel) tablaCursos.getModel();
        curDAO.cargarCursos(modelo, "");
    }

    private void cargartablaMatricula() {
        DefaultTableModel modelo = (DefaultTableModel) tablaMatricula.getModel();
        matDAO.cargarMatriculas(modelo, "");
    }

    private void cargartablaRetiro() {
        DefaultTableModel modelo = (DefaultTableModel) tablaRetiro.getModel();
        retDAO.buscarRetiros(modelo, "");

    }
}
