package Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Reporte extends javax.swing.JPanel {

    // Gráfico 1: Cantidad de Alumnos por Estado
    private void mostrarGrafico1() {

        String url = "jdbc:mysql://localhost:3306/proyecto_algoritmos";
        String usuario = "root";
        String clave = "bbc9117";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection con = DriverManager.getConnection(url, usuario, clave)) {

            String sql = "SELECT Estado, COUNT(*) AS cantidad FROM Alumno GROUP BY Estado";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Mapeo de estados
            String[] estados = {"Registrado", "Matriculado", "Retirado"};

            while (rs.next()) {
                int estado = rs.getInt("Estado");
                int cantidad = rs.getInt("cantidad");

                // Evitar errores por valores fuera del 0-2
                String nombreEstado = (estado >= 0 && estado <= 2) ? estados[estado] : "Desconocido";

                dataset.addValue(cantidad, "Alumnos", nombreEstado);
            }

            // Crear el gráfico
            JFreeChart chart = ChartFactory.createBarChart(
                    "Cantidad de Alumnos por Estado",
                    "Estado",
                    "Cantidad",
                    dataset
            );

            CategoryPlot plot = chart.getCategoryPlot();

            // Renderer personalizado para los colores
            org.jfree.chart.renderer.category.BarRenderer renderer = new org.jfree.chart.renderer.category.BarRenderer() {

                private final java.awt.Color[] colores = new java.awt.Color[]{
                    new java.awt.Color(79, 129, 189), // Registrado
                    new java.awt.Color(155, 187, 89), // Matriculado
                    new java.awt.Color(192, 80, 77) // Retirado
                };

                @Override
                public java.awt.Paint getItemPaint(int row, int column) {
                    return colores[column % colores.length];
                }
            };

            // Etiquetas encima
            renderer.setDefaultItemLabelGenerator(new org.jfree.chart.labels.StandardCategoryItemLabelGenerator());
            renderer.setDefaultItemLabelsVisible(true);
            renderer.setDefaultItemLabelFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
            renderer.setDefaultPositiveItemLabelPosition(
                    new org.jfree.chart.labels.ItemLabelPosition(
                            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE12,
                            org.jfree.chart.ui.TextAnchor.CENTER
                    )
            );

            plot.setRenderer(renderer);
            plot.setOutlineVisible(false);
            plot.setBackgroundPaint(java.awt.Color.WHITE);
            plot.setRangeGridlinePaint(java.awt.Color.LIGHT_GRAY);

            // Panel
            ChartPanel panel = new ChartPanel(chart);
            panel.setPreferredSize(new java.awt.Dimension(600, 400));

            panelGrafico1.removeAll();
            panelGrafico1.setLayout(new java.awt.BorderLayout());
            panelGrafico1.add(panel, java.awt.BorderLayout.CENTER);
            panelGrafico1.validate();
            panelGrafico1.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Gráfico 2: Alumnos con Matrícula Vigente (Estado = 1)
    private void mostrarGrafico2() {
        String url = "jdbc:mysql://localhost:3306/proyecto_algoritmos";
        String usuario = "root";
        String clave = "bbc9117";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection con = DriverManager.getConnection(url, usuario, clave)) {

            // Obtener alumnos con estado = 1 (matriculados)
            String sql = "SELECT Nombres, Apellidos, DNI, Edad FROM Alumno WHERE Estado = 1 ORDER BY Apellidos, Nombres";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int count = 0;
            while (rs.next()) {
                String nombres = rs.getString("Nombres");
                String apellidos = rs.getString("Apellidos");
                String dni = rs.getString("DNI");
                int edad = rs.getInt("Edad");

                // Crear etiqueta con nombre completo
                String nombreCompleto = apellidos + ", " + nombres;

                // Agregamos una barra por cada alumno mostrando su edad
                dataset.addValue(edad, "Edad", nombreCompleto);
                count++;
            }

            if (count == 0) {
                JOptionPane.showMessageDialog(null, "No hay alumnos con matrícula vigente");
                return;
            }

            // Crear gráfico
            JFreeChart chart = ChartFactory.createBarChart(
                    "Alumnos con Matrícula Vigente (Estado = 1)",
                    "Alumnos",
                    "Edad",
                    dataset
            );

            CategoryPlot plot = chart.getCategoryPlot();

            // Renderer personalizado con colores diferentes
            org.jfree.chart.renderer.category.BarRenderer renderer
                    = new org.jfree.chart.renderer.category.BarRenderer() {

                // Colores distintos por barra
                java.awt.Color[] colores = {
                    new java.awt.Color(155, 187, 89), // Verde
                    new java.awt.Color(79, 129, 189), // Azul
                    new java.awt.Color(192, 80, 77), // Rojo
                    new java.awt.Color(247, 150, 70), // Naranja
                    new java.awt.Color(112, 48, 160), // Violeta
                    new java.awt.Color(75, 172, 195), // Celeste
                    new java.awt.Color(255, 192, 0) // Amarillo
                };

                @Override
                public java.awt.Paint getItemPaint(int row, int column) {
                    return colores[column % colores.length];
                }
            };

            // Mostrar etiquetas sobre las barras
            renderer.setDefaultItemLabelGenerator(new org.jfree.chart.labels.StandardCategoryItemLabelGenerator());
            renderer.setDefaultItemLabelsVisible(true);
            renderer.setDefaultItemLabelFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 10));
            renderer.setDefaultPositiveItemLabelPosition(
                    new org.jfree.chart.labels.ItemLabelPosition(
                            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE12,
                            org.jfree.chart.ui.TextAnchor.CENTER
                    )
            );

            plot.setRenderer(renderer);
            plot.setOutlineVisible(false);
            plot.setBackgroundPaint(java.awt.Color.WHITE);
            plot.setRangeGridlinePaint(java.awt.Color.LIGHT_GRAY);

            // Rotar etiquetas del eje X para mejor legibilidad
            org.jfree.chart.axis.CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setCategoryLabelPositions(org.jfree.chart.axis.CategoryLabelPositions.UP_45);

            // Panel
            ChartPanel panel = new ChartPanel(chart);
            panel.setPreferredSize(new java.awt.Dimension(700, 450));

            panel.setDomainZoomable(false);
            panel.setRangeZoomable(false);

            panelGrafico2.removeAll();
            panelGrafico2.setLayout(new java.awt.BorderLayout());
            panelGrafico2.add(panel, java.awt.BorderLayout.CENTER);
            panelGrafico2.validate();
            panelGrafico2.repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar gráfico 2: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Gráfico 3: Alumnos Matriculados por Curso
    private void mostrarGrafico3() {
        String url = "jdbc:mysql://localhost:3306/proyecto_algoritmos";
        String usuario = "root";
        String clave = "bbc9117";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection con = DriverManager.getConnection(url, usuario, clave)) {

            // Obtener alumnos matriculados con el curso correspondiente
            String sql = """
            SELECT a.Nombres, a.Apellidos, c.Asignatura, c.Ciclo
            FROM Alumno a
            INNER JOIN Matricula m ON a.codAlumno = m.codAlumno
            INNER JOIN Curso c ON m.codCurso = c.codCurso
            WHERE a.Estado = 1
            ORDER BY c.Asignatura, a.Apellidos, a.Nombres
        """;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int count = 0;
            while (rs.next()) {
                String nombres = rs.getString("Nombres");
                String apellidos = rs.getString("Apellidos");
                String asignatura = rs.getString("Asignatura");
                int ciclo = rs.getInt("Ciclo");

                // Crear etiqueta con nombre completo del alumno
                String nombreCompleto = apellidos + ", " + nombres;

                // Agregamos una barra por cada alumno, agrupada por curso
                // El valor será el ciclo del curso para visualización
                dataset.addValue(ciclo, asignatura, nombreCompleto);
                count++;
            }

            if (count == 0) {
                JOptionPane.showMessageDialog(null, "No hay alumnos matriculados en cursos");
                return;
            }

            // Crear gráfico
            JFreeChart chart = ChartFactory.createBarChart(
                    "Alumnos Matriculados por Curso",
                    "Alumnos",
                    "Ciclo del Curso",
                    dataset
            );

            CategoryPlot plot = chart.getCategoryPlot();

            // Renderer personalizado
            org.jfree.chart.renderer.category.BarRenderer renderer
                    = new org.jfree.chart.renderer.category.BarRenderer();

            // Grosor real de barras (clave)
            renderer.setMaximumBarWidth(1.50); // Permitir barras anchas
            renderer.setItemMargin(0.0);       // Sin separación entre barras

            // Quitar el gran margen entre categorías
            plot.getDomainAxis().setCategoryMargin(0.05);

            // Aplicar renderer
            plot.setRenderer(renderer);

            // Colores variados para cada curso
            java.awt.Color[] colores = {
                new java.awt.Color(79, 129, 189),
                new java.awt.Color(155, 187, 89),
                new java.awt.Color(192, 80, 77),
                new java.awt.Color(128, 100, 162),
                new java.awt.Color(75, 172, 195),
                new java.awt.Color(247, 150, 70),
                new java.awt.Color(146, 208, 80),
                new java.awt.Color(255, 192, 0),
                new java.awt.Color(112, 48, 160),
                new java.awt.Color(0, 176, 240)
            };

            // Asignar colores por serie (cursos)
            for (int i = 0; i < dataset.getRowCount(); i++) {
                renderer.setSeriesPaint(i, colores[i % colores.length]);
            }

            // Etiquetas arriba de las barras
            renderer.setDefaultItemLabelGenerator(new org.jfree.chart.labels.StandardCategoryItemLabelGenerator());
            renderer.setDefaultItemLabelsVisible(true);
            renderer.setDefaultItemLabelFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 9));
            renderer.setDefaultPositiveItemLabelPosition(
                    new org.jfree.chart.labels.ItemLabelPosition(
                            org.jfree.chart.labels.ItemLabelAnchor.OUTSIDE12,
                            org.jfree.chart.ui.TextAnchor.CENTER
                    )
            );

            plot.setOutlineVisible(false);
            plot.setBackgroundPaint(java.awt.Color.WHITE);
            plot.setRangeGridlinePaint(java.awt.Color.LIGHT_GRAY);

            // Rotar etiquetas del eje X para mejor lectura
            org.jfree.chart.axis.CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setCategoryLabelPositions(org.jfree.chart.axis.CategoryLabelPositions.UP_45);
            domainAxis.setMaximumCategoryLabelLines(2);

            // Panel
            ChartPanel panel = new ChartPanel(chart);
            panel.setPreferredSize(new java.awt.Dimension(700, 450));

            panel.setDomainZoomable(false);
            panel.setRangeZoomable(false);

            panelGrafico3.removeAll();
            panelGrafico3.setLayout(new java.awt.BorderLayout());
            panelGrafico3.add(panel, java.awt.BorderLayout.CENTER);
            panelGrafico3.validate();
            panelGrafico3.repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar gráfico 3: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Reporte() {
        initComponents();
        mostrarGrafico1();
        mostrarGrafico2();
        mostrarGrafico3();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        grafico1 = new javax.swing.JPanel();
        panelGrafico1 = new javax.swing.JPanel();
        grafico2 = new javax.swing.JPanel();
        panelGrafico2 = new javax.swing.JPanel();
        grafico3 = new javax.swing.JPanel();
        panelGrafico3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(178, 223, 244));

        javax.swing.GroupLayout panelGrafico1Layout = new javax.swing.GroupLayout(panelGrafico1);
        panelGrafico1.setLayout(panelGrafico1Layout);
        panelGrafico1Layout.setHorizontalGroup(
            panelGrafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        panelGrafico1Layout.setVerticalGroup(
            panelGrafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout grafico1Layout = new javax.swing.GroupLayout(grafico1);
        grafico1.setLayout(grafico1Layout);
        grafico1Layout.setHorizontalGroup(
            grafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrafico1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        grafico1Layout.setVerticalGroup(
            grafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrafico1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gráfico 1", grafico1);

        javax.swing.GroupLayout panelGrafico2Layout = new javax.swing.GroupLayout(panelGrafico2);
        panelGrafico2.setLayout(panelGrafico2Layout);
        panelGrafico2Layout.setHorizontalGroup(
            panelGrafico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        panelGrafico2Layout.setVerticalGroup(
            panelGrafico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout grafico2Layout = new javax.swing.GroupLayout(grafico2);
        grafico2.setLayout(grafico2Layout);
        grafico2Layout.setHorizontalGroup(
            grafico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrafico2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        grafico2Layout.setVerticalGroup(
            grafico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrafico2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gráfico 2", grafico2);

        javax.swing.GroupLayout panelGrafico3Layout = new javax.swing.GroupLayout(panelGrafico3);
        panelGrafico3.setLayout(panelGrafico3Layout);
        panelGrafico3Layout.setHorizontalGroup(
            panelGrafico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        panelGrafico3Layout.setVerticalGroup(
            panelGrafico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout grafico3Layout = new javax.swing.GroupLayout(grafico3);
        grafico3.setLayout(grafico3Layout);
        grafico3Layout.setHorizontalGroup(
            grafico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrafico3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        grafico3Layout.setVerticalGroup(
            grafico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrafico3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gráfico 3", grafico3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel grafico1;
    private javax.swing.JPanel grafico2;
    private javax.swing.JPanel grafico3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelGrafico1;
    private javax.swing.JPanel panelGrafico2;
    private javax.swing.JPanel panelGrafico3;
    // End of variables declaration//GEN-END:variables
}
