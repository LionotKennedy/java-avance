package pages;

import components.event.EventMenu;
import components.form.form_1;
import components.form.form_2;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class page extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static String dataProject;

    public page() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = connexionDB.connexion.connex;
        
        EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    showForm(new form_1());
                    System.out.println("0");
                } else if (index == 1) {
                    showForm(new form_2());
                    System.out.println("1");
                } else {
                    System.out.println("4");
                    LoginOut();
                }
            }
        };
        menu1.initMenu(event);
        showForm(new form_1());
    }

    private void showForm(Component com) {
        contenair.removeAll();
        contenair.add(com);
        contenair.revalidate();
        contenair.repaint();
    }

    public void LoginOut() {
        if (JOptionPane.showConfirmDialog(null, "Attention vous voulez vraiment quitter ?",
                "Deconnexion", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

        } else {
            JOptionPane.showMessageDialog(null, "Veullez selectionner l'employe");
            return;
        }
    }
    
    
    
    
    

//  *********  STATISTIC NOTE *********
//    public void StatisticData() {
//        DisplayMax();
//        DisplayMin();
//        DisplayNbAdmis();
//        DisplayNbRedoublants();
//    }
//  *********  ENDING MEDECINS *********

//  *********  RECUPERATION MEDECINS *********
//    public void ControlsButton() {
//        UpdateBtn.setEnabled(false);
//        DeleteNote.setEnabled(false);
//    }
//  *********  ENDING MEDECINS *********

//  *********  RECUPERATION MEDECINS *********
//    public void ControlsButtonTrue() {
//        UpdateBtn.setEnabled(true);
//        DeleteNote.setEnabled(true);
//    }
//  *********  ENDING MEDECINS *********

//  *********  RECUPERATION MEDECINS *********
//    public void Recuperation() {
//        try {
//            int row = TableDeNote.getSelectedRow();
//            if (row != -1) { // Vérifier si une ligne est sélectionnée
//                page.dataProject = (TableDeNote.getModel().getValueAt(row, 0).toString());
//                // Reste du code de récupération des données
//                String request = "SELECT * FROM etudiants WHERE numEt='" + dataProject + "' ";
//                prepare = con.prepareStatement(request);
//                resul = prepare.executeQuery();
//
//                if (resul.next()) {
//                    String R1 = resul.getString("numEt");
//                    System.out.println(R1);
//                    String R2 = resul.getString("nom");
//                    System.out.println(R2);
//                    String R3 = resul.getString("note_math");
//                    System.out.println(R3);
//                    String R4 = resul.getString("note_phys");
//                    System.out.println(R4);
//                }
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//  *********  ENDING MEDECINS *********

//  *********  DISPLAY PATIENTS *********
//    public final void DisplayNote() {
//        try {
//            String request = "SELECT numEt AS \"NUMERO\",nom AS \"NOM\",note_math AS \"NOTE MATHEMATIQUE\",note_phys AS \"NOTE PHYSIQUE\",moyenne AS \"MOYENNE\",stauts AS \"OBSERVATION\" FROM etudiants ORDER BY numEt ASC";
//            prepare = con.prepareStatement(request);
//            resul = prepare.executeQuery();
//            TableDeNote.setModel(DbUtils.resultSetToTableModel(resul));
//        } catch (SQLException ex) {
//            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  *********  ENDING MEDECINS *********

//  *********  RECUPERATION MEDECINS *********
    public String GetTableResult() {
        return dataProject;
    }
//  *********  ENDING MEDECINS *********

//  *********  DISPLAY NOTE MAX *********
//    public final void DisplayMax() {
//        try {
//            String request = "SELECT MAX(moyenne) as max_moyen FROM etudiants";
//            prepare = con.prepareStatement(request);
//            resul = prepare.executeQuery();
//
//            if (resul.next()) {
//                Max = resul.getString("max_moyen");
//                if (Max == null) {
//                    Max = "0";
//
//                }
//                MaxNote.setText(Max);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  *********  ENDING NOTE *********

//  *********  DISPLAY NOTE MIN *********
//    public final void DisplayMin() {
//        try {
//            String request = "SELECT MIN(moyenne) as max_moyen FROM etudiants";
//            prepare = con.prepareStatement(request);
//            resul = prepare.executeQuery();
//
//            if (resul.next()) {
//                Min = resul.getString("max_moyen");
//                if (Min == null) {
//                    Min = "0";
//
//                }
//                MinNote.setText(Min);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  *********  ENDING NOTE *********

//  *********  DISPLAY NOTE ADIMS *********
//    public final void DisplayNbAdmis() {
//        try {
//            String request = "SELECT COUNT(*) as nombre_admis FROM etudiants WHERE stauts = 'Admis' ";
//            prepare = con.prepareStatement(request);
//            resul = prepare.executeQuery();
//
//            if (resul.next()) {
//                admisNombre = resul.getString("nombre_admis");
//                if (admisNombre == null) {
//                    admisNombre = "0";
//
//                }
//                AdmisNombre.setText(admisNombre);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  *********  ENDING NOTE *********

    //  *********  DISPLAY NOTE REDOUBLANTS *********
//    public final void DisplayNbRedoublants() {
//        try {
//            String request = "SELECT COUNT(*) as nombre_admis FROM etudiants WHERE stauts = 'Redoublant' ";
//            prepare = con.prepareStatement(request);
//            resul = prepare.executeQuery();
//
//            if (resul.next()) {
//                redoublantNombre = resul.getString("nombre_admis");
//                if (redoublantNombre == null) {
//                    redoublantNombre = "0";
//
//                }
//                RedoublantNombre.setText(redoublantNombre);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  *********  ENDING NOTE *********

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new components.panel.PanelShadow();
        header1 = new components.Menu.Header();
        menu1 = new components.Menu.Menu();
        contenair = new components.panel.PanelShadow();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(0, 0, 0));
        panelShadow1.setPreferredSize(new java.awt.Dimension(1295, 700));

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        contenair.setBackground(new java.awt.Color(204, 255, 51));
        contenair.setPreferredSize(new java.awt.Dimension(1057, 660));
        contenair.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(contenair, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 1379, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new page().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.panel.PanelShadow contenair;
    private components.Menu.Header header1;
    private components.Menu.Menu menu1;
    private components.panel.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
