package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;


public class Main extends javax.swing.JFrame {

    public Main() {
    initComponents();
    
    // Cambiar el layout del background
    background.setLayout(new BorderLayout(0, 0)); // 0,0 = sin gaps
    background.removeAll();
    background.add(menu, BorderLayout.WEST);
    background.add(contenido, BorderLayout.CENTER);
    
    contenido.setLayout(new BorderLayout());
    showJPanel(new Principal());
}

    private void showJPanel(JPanel p) {
    p.setSize(contenido.getWidth(), contenido.getHeight());
    contenido.removeAll();
    contenido.setLayout(new BorderLayout());
    contenido.add(p, BorderLayout.CENTER);
    contenido.revalidate();
    contenido.repaint();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        btnPrincipal = new javax.swing.JPanel();
        txtPrincipal = new javax.swing.JLabel();
        btnMantenimiento = new javax.swing.JPanel();
        txtMantenimiento = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JPanel();
        txtRegistro = new javax.swing.JLabel();
        btnConsulta = new javax.swing.JPanel();
        txtConsulta = new javax.swing.JLabel();
        btnReportes = new javax.swing.JPanel();
        txtReportes = new javax.swing.JLabel();
        btnCreditos = new javax.swing.JPanel();
        txtCreditos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(10, 31, 71));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("AcadSys");

        btnPrincipal.setBackground(new java.awt.Color(10, 31, 71));

        txtPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        txtPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/principal.png"))); // NOI18N
        txtPrincipal.setText("PRINCIPAL");
        txtPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrincipalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPrincipalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnPrincipalLayout = new javax.swing.GroupLayout(btnPrincipal);
        btnPrincipal.setLayout(btnPrincipalLayout);
        btnPrincipalLayout.setHorizontalGroup(
            btnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnPrincipalLayout.setVerticalGroup(
            btnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        btnMantenimiento.setBackground(new java.awt.Color(10, 31, 71));

        txtMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        txtMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/mantenimiento.png"))); // NOI18N
        txtMantenimiento.setText("MANTENIMIENTO");
        txtMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMantenimientoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtMantenimientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtMantenimientoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnMantenimientoLayout = new javax.swing.GroupLayout(btnMantenimiento);
        btnMantenimiento.setLayout(btnMantenimientoLayout);
        btnMantenimientoLayout.setHorizontalGroup(
            btnMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );
        btnMantenimientoLayout.setVerticalGroup(
            btnMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        btnRegistro.setBackground(new java.awt.Color(10, 31, 71));

        txtRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/registro.png"))); // NOI18N
        txtRegistro.setText("REGISTRO");
        txtRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRegistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtRegistroMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnRegistroLayout = new javax.swing.GroupLayout(btnRegistro);
        btnRegistro.setLayout(btnRegistroLayout);
        btnRegistroLayout.setHorizontalGroup(
            btnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnRegistroLayout.setVerticalGroup(
            btnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        btnConsulta.setBackground(new java.awt.Color(10, 31, 71));

        txtConsulta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtConsulta.setForeground(new java.awt.Color(255, 255, 255));
        txtConsulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/consulta.png"))); // NOI18N
        txtConsulta.setText("CONSULTA");
        txtConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtConsultaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnConsultaLayout = new javax.swing.GroupLayout(btnConsulta);
        btnConsulta.setLayout(btnConsultaLayout);
        btnConsultaLayout.setHorizontalGroup(
            btnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnConsultaLayout.setVerticalGroup(
            btnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        btnReportes.setBackground(new java.awt.Color(10, 31, 71));

        txtReportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtReportes.setForeground(new java.awt.Color(255, 255, 255));
        txtReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/reporte.png"))); // NOI18N
        txtReportes.setText("REPORTES");
        txtReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtReportesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnReportesLayout = new javax.swing.GroupLayout(btnReportes);
        btnReportes.setLayout(btnReportesLayout);
        btnReportesLayout.setHorizontalGroup(
            btnReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnReportesLayout.setVerticalGroup(
            btnReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCreditos.setBackground(new java.awt.Color(10, 31, 71));

        txtCreditos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCreditos.setForeground(new java.awt.Color(255, 255, 255));
        txtCreditos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/creditos.png"))); // NOI18N
        txtCreditos.setText("CREDITOS");
        txtCreditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCreditosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCreditosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCreditosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCreditosLayout = new javax.swing.GroupLayout(btnCreditos);
        btnCreditos.setLayout(btnCreditosLayout);
        btnCreditosLayout.setHorizontalGroup(
            btnCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCreditosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnCreditosLayout.setVerticalGroup(
            btnCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCreditosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Util/imagenes/logo.png"))); // NOI18N

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(titulo))
                .addGap(79, 79, 79))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setPreferredSize(new java.awt.Dimension(730, 0));

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrincipalMouseEntered
        btnPrincipal.setBackground(new Color(18, 58, 125));
    }//GEN-LAST:event_txtPrincipalMouseEntered

    private void txtPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrincipalMouseExited
        btnPrincipal.setBackground(new Color(10, 31, 71));
    }//GEN-LAST:event_txtPrincipalMouseExited

    private void txtPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrincipalMouseClicked
        showJPanel(new Principal());
    }//GEN-LAST:event_txtPrincipalMouseClicked

    private void txtMantenimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMantenimientoMouseEntered
        btnMantenimiento.setBackground(new Color(18, 58, 125));
    }//GEN-LAST:event_txtMantenimientoMouseEntered

    private void txtMantenimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMantenimientoMouseExited
        btnMantenimiento.setBackground(new Color(10, 31, 71));
    }//GEN-LAST:event_txtMantenimientoMouseExited

    private void txtMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMantenimientoMouseClicked
        showJPanel(new Mantenimiento());
    }//GEN-LAST:event_txtMantenimientoMouseClicked

    private void txtRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistroMouseEntered
        btnRegistro.setBackground(new Color(18, 58, 125));
    }//GEN-LAST:event_txtRegistroMouseEntered

    private void txtRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistroMouseExited
        btnRegistro.setBackground(new Color(10, 31, 71));
    }//GEN-LAST:event_txtRegistroMouseExited

    private void txtConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConsultaMouseEntered
        btnConsulta.setBackground(new Color(18, 58, 125));
    }//GEN-LAST:event_txtConsultaMouseEntered

    private void txtConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConsultaMouseExited
        btnConsulta.setBackground(new Color(10, 31, 71));
    }//GEN-LAST:event_txtConsultaMouseExited

    private void txtReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtReportesMouseEntered
        btnReportes.setBackground(new Color(18, 58, 125));
    }//GEN-LAST:event_txtReportesMouseEntered

    private void txtReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtReportesMouseExited
        btnReportes.setBackground(new Color(10, 31, 71));
    }//GEN-LAST:event_txtReportesMouseExited

    private void txtRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistroMouseClicked
        showJPanel(new Registro());
    }//GEN-LAST:event_txtRegistroMouseClicked

    private void txtConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConsultaMouseClicked
        showJPanel(new Consulta());
    }//GEN-LAST:event_txtConsultaMouseClicked

    private void txtReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtReportesMouseClicked
        showJPanel(new Reporte());
    }//GEN-LAST:event_txtReportesMouseClicked

    private void txtCreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCreditosMouseClicked
        showJPanel(new Creditos());
    }//GEN-LAST:event_txtCreditosMouseClicked

    private void txtCreditosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCreditosMouseEntered
         btnCreditos.setBackground(new Color(18, 58, 125));
    }//GEN-LAST:event_txtCreditosMouseEntered

    private void txtCreditosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCreditosMouseExited
          btnCreditos.setBackground(new Color(10, 31, 71));
    }//GEN-LAST:event_txtCreditosMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel btnConsulta;
    private javax.swing.JPanel btnCreditos;
    private javax.swing.JPanel btnMantenimiento;
    private javax.swing.JPanel btnPrincipal;
    private javax.swing.JPanel btnRegistro;
    private javax.swing.JPanel btnReportes;
    private javax.swing.JPanel contenido;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtConsulta;
    private javax.swing.JLabel txtCreditos;
    private javax.swing.JLabel txtMantenimiento;
    private javax.swing.JLabel txtPrincipal;
    private javax.swing.JLabel txtRegistro;
    private javax.swing.JLabel txtReportes;
    // End of variables declaration//GEN-END:variables
}
