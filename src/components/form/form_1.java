package components.form;

import components.card.ModelCard;
import components.statistique.chart.ModelChart;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class form_1 extends javax.swing.JPanel {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static String nombre_total;
    static String nombre_admis;
    static String nombre_redoublant;

    public form_1() {
        initComponents();
        con = connexionDB.connexion.connex;
        setOpaque(false);
        init();
        allFunction();
        GetAllValues();
    }

    private void init() {
        chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        chart.start();
    }

    private void allFunction() {
        GetNomberStudent();
        GetNomberStudentAdmis();
        GetNomberStudentRedoublant();
    }

    private void GetNomberStudent() {
        if (con != null) {
            try {
                // Votre code de préparation de requête et d'exécution ici

                String requete = "SELECT COUNT(*) as nombre_etudiant FROM etudiants";
                prepare = con.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    nombre_total = resul.getString("nombre_etudiant");
                    if (nombre_total == null) {
                        nombre_total = "0";
                    }
                    System.out.println(nombre_total);
//                    totalProjet.setxt(R1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    private void GetNomberStudentAdmis() {
        if (con != null) {
            try {
                // Votre code de préparation de requête et d'exécution ici
                String Status = "Admis";
                String requete = "SELECT COUNT(*) as nombre_etudiant_admis FROM etudiants WHERE stauts = '" + Status + "'";
                prepare = con.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    nombre_admis = resul.getString("nombre_etudiant_admis");
                    if (nombre_admis == null) {
                        nombre_admis = "0";
                    }
                    System.out.println(nombre_admis);
//                    totalProjet.setxt(R1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    private void GetNomberStudentRedoublant() {
        if (con != null) {
            try {
                // Votre code de préparation de requête et d'exécution ici
                String Status = "Redoublant";
                String requete = "SELECT COUNT(*) as nombre_etudiant_redoublant FROM etudiants WHERE stauts = '" + Status + "'";
                prepare = con.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    nombre_redoublant = resul.getString("nombre_etudiant_redoublant");
                    if (nombre_redoublant == null) {
                        nombre_redoublant = "0";
                    }
                    System.out.println(nombre_redoublant);
//                    totalProjet.setxt(R1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    private void GetAllValues() {
        card1.setData(new ModelCard(null, null, null, nombre_total + " Etudiant(s)", "Effectif total d'etudiant(s)"));
        card2.setData(new ModelCard(null, null, null, nombre_admis + " Admis", "Nombre effectif admis."));
        card3.setData(new ModelCard(null, null, null, nombre_redoublant + " Redoublant(s)", "Nombre effectif redoublant."));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new components.panel.PanelShadow();
        card1 = new components.card.Card();
        card2 = new components.card.Card();
        card3 = new components.card.Card();
        PanelChart = new components.panel.PanelShadow();
        chart = new components.statistique.chart.Chart();

        panelShadow1.setBackground(new java.awt.Color(153, 0, 0));

        card1.setColor1(new java.awt.Color(16, 212, 210));
        card1.setColor2(new java.awt.Color(0, 91, 234));
        card1.setIcon(javaswingdev.GoogleMaterialDesignIcon.PERSON);

        card2.setColor1(new java.awt.Color(20, 232, 97));
        card2.setColor2(new java.awt.Color(25, 150, 31));
        card2.setDescription("Nombre total des etudiants admis");
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.SCHOOL);

        card3.setColor1(new java.awt.Color(211, 135, 130));
        card3.setColor2(new java.awt.Color(255, 25, 0));
        card3.setDescription("Nombre total des etudiants redoublants");

        javax.swing.GroupLayout PanelChartLayout = new javax.swing.GroupLayout(PanelChart);
        PanelChart.setLayout(PanelChartLayout);
        PanelChartLayout.setHorizontalGroup(
            PanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChartLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelChartLayout.setVerticalGroup(
            PanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChartLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(PanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.panel.PanelShadow PanelChart;
    private components.card.Card card1;
    private components.card.Card card2;
    private components.card.Card card3;
    private components.statistique.chart.Chart chart;
    private components.panel.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
