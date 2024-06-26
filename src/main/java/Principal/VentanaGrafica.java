/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

/**
 * @author isaac
 */
//import para la fecha

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import para la grafica
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


import javax.swing.*;


public class VentanaGrafica extends javax.swing.JFrame {

    /**
     * Creates new form VentanaVotar
     */
    public VentanaGrafica() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Lblfecha = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        Grafica = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(832, 507));
        setMinimumSize(new java.awt.Dimension(832, 507));
        setPreferredSize(new java.awt.Dimension(832, 507));
        setResizable(false);
        setSize(new java.awt.Dimension(832, 507));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de las votaciones");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 170, 19);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 33, 220, 40);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 180, 0);


        //Fecha
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText(formato.format(fecha));
        jPanel2.add(lblFecha);
        lblFecha.setBounds(70, 10, 110, 19);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(590, 0, 240, 30);

        Grafica.setBackground(new java.awt.Color(255, 255, 255));
        Grafica.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(null);

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblNombre);
        lblNombre.setBounds(30, 10, 0, 0);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Graficas");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(50, 10, 120, 19);

        Grafica.add(jPanel4);
        jPanel4.setBounds(320, 20, 260, 40);

        getContentPane().add(Grafica);
        Grafica.setBounds(20, 110, 520, 330);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver a votar");
        getContentPane().add(jButton1);
        jButton1.setBounds(580, 420, 190, 25);
        //boton para volver a votar
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Votar votar = new Votar();
                votar.setVisible(true);
                dispose();
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Mostrar Ganador", "Comparar ", "Todas las graficas", "Votos nulos"}));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(580, 170, 210, 25);

        //empieza en blanco el combobox
        jComboBox1.setSelectedIndex(-1);


        jComboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String item = (String) e.getItem();
                    if (item.equals("Mostrar Ganador")) {
                        // Crear la grafica de barras con los votos, obtiene los votos de contar
                        Contar contar = new Contar();
                        HashMap<String, Integer> votos = contar.getVotos();

                        // Encontrar el ganador
                        Map.Entry<String, Integer> maxEntry = null;
                        for (Map.Entry<String, Integer> entry : votos.entrySet()) {
                            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                                maxEntry = entry;
                            }
                        }

                        // Calcular el total de votos
                        int totalVotos = 0;
                        for (int voto : votos.values()) {
                            totalVotos += voto;
                        }

                        // Calcular el porcentaje de votos del ganador
                        double porcentajeVotosGanador = (double) maxEntry.getValue() / totalVotos * 100;

                        // Asociar los IDs de los candidatos con sus nombres
                        HashMap<String, String> nombresCandidatos = new HashMap<>();
                        nombresCandidatos.put("1", "Alfaro");
                        nombresCandidatos.put("2", "Muñito");
                        nombresCandidatos.put("3", "Maynez");

                        // Obtener el nombre del ganador usando su ID
                        String nombreGanador = nombresCandidatos.get(maxEntry.getKey());

                        // Crear la grafica de barras con solo el porcentaje de votos del ganador
                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        dataset.addValue(porcentajeVotosGanador, "Porcentaje de votos", nombreGanador);
                        JFreeChart chart = ChartFactory.createBarChart("Porcentaje de votos", "Candidato", "Porcentaje de votos", dataset);
                        // Cambiar el color de la gráfica del ganador a azul
                        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
                        renderer.setSeriesPaint(0, Color.BLUE);

                        // Hacer que la barra sea más delgada
                        renderer.setMaximumBarWidth(0.1); // Ajusta este valor según tus necesidades

                        ChartPanel panel = new ChartPanel(chart);
                        panel.setSize(Grafica.getWidth(), Grafica.getHeight());
                        panel.setBackground(Color.WHITE);
                        Grafica.removeAll();
                        Grafica.add(panel);
                        Grafica.revalidate();
                        Grafica.repaint();

                    } else if (item.equals("Comparar ")) {
                        Contar contar = new Contar();
                        HashMap<String, Integer> votos = contar.getVotos();

                        // Calcular el total de votos
                        int totalVotos = 0;
                        for (int voto : votos.values()) {
                            totalVotos += voto;
                        }

                        // Asociar los IDs de los candidatos con sus nombres
                        HashMap<String, String> nombresCandidatos = new HashMap<>();
                        nombresCandidatos.put("1", "Alfaro");
                        nombresCandidatos.put("2", "Muñito");
                        nombresCandidatos.put("3", "Maynez");

                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        for (Map.Entry<String, Integer> entry : votos.entrySet()) {
                            // Calcular el porcentaje de votos del candidato
                            double porcentajeVotos = (double) entry.getValue() / totalVotos * 100;

                            // Obtener el nombre del candidato usando su ID
                            String nombreCandidato = nombresCandidatos.get(entry.getKey());

                            dataset.addValue(porcentajeVotos, "Porcentaje de votos", nombreCandidato);
                        }
                        JFreeChart chart = ChartFactory.createBarChart("Porcentaje de votos", "Candidato", "Porcentaje de votos", dataset);
                        //le da diferente color a cada barra
                        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
                        renderer.setSeriesPaint(0, Color.BLUE);
                        renderer.setSeriesPaint(1, Color.RED);
                        renderer.setSeriesPaint(2, Color.GREEN);

                        // Hacer que las barras sean más delgadas
                        renderer.setMaximumBarWidth(0.1);
                        ChartPanel panel = new ChartPanel(chart);
                        panel.setSize(Grafica.getWidth(), Grafica.getHeight());
                        panel.setBackground(Color.WHITE);
                        Grafica.removeAll();
                        Grafica.add(panel);
                        Grafica.revalidate();
                        Grafica.repaint();

                    } else if (item.equals("Todas las graficas")) {
                        // Crear la grafica de barras con todos los votos de los candidatos y los votos nulos
                        Contar contar = new Contar();
                        HashMap<String, Integer> votos = contar.getVotos();
                        int votosNulos = contar.getVotosNulos();

                        // Calcular el total de votos
                        int totalVotos = votosNulos;
                        for (int voto : votos.values()) {
                            totalVotos += voto;
                        }

                        // Asociar los IDs de los candidatos con sus nombres
                        HashMap<String, String> nombresCandidatos = new HashMap<>();
                        nombresCandidatos.put("1", "Alfaro");
                        nombresCandidatos.put("2", "Muñito");
                        nombresCandidatos.put("3", "Maynez");

                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        for (Map.Entry<String, Integer> entry : votos.entrySet()) {
                            // Calcular el porcentaje de votos del candidato
                            double porcentajeVotos = (double) entry.getValue() / totalVotos * 100;

                            // Obtener el nombre del candidato usando su ID
                            String nombreCandidato = nombresCandidatos.get(entry.getKey());
                            dataset.addValue(porcentajeVotos, "Porcentaje de votos", nombreCandidato);
                        }
                        // Calcular el porcentaje de votos nulos
                        double porcentajeVotosNulos = (double) votosNulos / totalVotos * 100;
                        dataset.addValue(porcentajeVotosNulos, "Porcentaje de votos", "Votos nulos");

                        JFreeChart chart = ChartFactory.createBarChart("Porcentaje de votos", "Candidato", "Porcentaje de votos", dataset);

                        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();

                        // Cambiar el color de todas las barras a un color aleatorio
                        for (int i = 0; i < dataset.getRowCount(); i++) {
                            // Generar un color aleatorio
                            float r = (float) Math.random();
                            float g = (float) Math.random();
                            float b = (float) Math.random();
                            Color randomColor = new Color(r, g, b);

                            renderer.setSeriesPaint(i, randomColor);
                        }
                        // Hacer que las barras sean más delgadas
                        renderer.setMaximumBarWidth(0.1);

                        ChartPanel panel = new ChartPanel(chart);
                        panel.setSize(Grafica.getWidth(), Grafica.getHeight());
                        panel.setBackground(Color.WHITE);
                        Grafica.removeAll();
                        Grafica.add(panel);
                        Grafica.revalidate();
                        Grafica.repaint();


                    } else if (item.equals("Votos nulos")) {
                        // Crear la grafica de barras con los votos nulos
                        Contar contar = new Contar();
                        HashMap<String, Integer> votos = contar.getVotos();
                        int votosNulos = contar.getVotosNulos();

                        // Calcular el total de votos
                        int totalVotos = votosNulos;
                        for (int voto : votos.values()) {
                            totalVotos += voto;
                        }

                        // Calcular el porcentaje de votos nulos
                        double porcentajeVotosNulos = (double) votosNulos / totalVotos * 100;

                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        dataset.addValue(porcentajeVotosNulos, "Porcentaje de votos", "Votos nulos");
                        JFreeChart chart = ChartFactory.createBarChart("Porcentaje de votos", "Candidato", "Porcentaje de votos", dataset);
                        //hacer que la barra sea mas delgada
                        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
                        renderer.setMaximumBarWidth(0.1);
                        ChartPanel panel = new ChartPanel(chart);
                        panel.setSize(Grafica.getWidth(), Grafica.getHeight());
                        panel.setBackground(Color.WHITE);
                        Grafica.removeAll();
                        Grafica.add(panel);
                        Grafica.revalidate();
                        Grafica.repaint();


                    }
                }
            }
        });


        pack();
    }// </editor-fold>//GEN-END:initComponents


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(VentanaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Grafica;
    private javax.swing.JLabel Lblfecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
