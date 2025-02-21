package pages;

import compenents.Modal.AddNote;
import compenents.Modal.DeleteNote;
import compenents.Modal.UpdateNote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;

public final class page extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static String dataProject;
    static String Max;
    static String Min;
    static String admisNombre;
    static String redoublantNombre;

    public page() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = connexionDB.connexion.connex;
        DisplayNote();
        ControlsButton();
        StatisticData();
    }

    //  *********  STATISTIC NOTE *********
    public void StatisticData() {
        DisplayMax();
        DisplayMin();
        DisplayNbAdmis();
        DisplayNbRedoublants();
    }
//  *********  ENDING MEDECINS *********

//  *********  RECUPERATION MEDECINS *********
    public void ControlsButton() {
        UpdateBtn.setEnabled(false);
        DeleteNote.setEnabled(false);
    }
//  *********  ENDING MEDECINS *********

//  *********  RECUPERATION MEDECINS *********
    public void ControlsButtonTrue() {
        UpdateBtn.setEnabled(true);
        DeleteNote.setEnabled(true);
    }
//  *********  ENDING MEDECINS *********

//  *********  RECUPERATION MEDECINS *********
    public void Recuperation() {
        try {
            int row = TableDeNote.getSelectedRow();
            if (row != -1) { // Vérifier si une ligne est sélectionnée
                page.dataProject = (TableDeNote.getModel().getValueAt(row, 0).toString());
                // Reste du code de récupération des données
                String request = "SELECT * FROM etudiants WHERE numEt='" + dataProject + "' ";
                prepare = con.prepareStatement(request);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("numEt");
                    System.out.println(R1);
                    String R2 = resul.getString("nom");
                    System.out.println(R2);
                    String R3 = resul.getString("note_math");
                    System.out.println(R3);
                    String R4 = resul.getString("note_phys");
                    System.out.println(R4);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
//  *********  ENDING MEDECINS *********

//  *********  DISPLAY PATIENTS *********
    public final void DisplayNote() {
        try {
            String request = "SELECT numEt AS \"NUMERO\",nom AS \"NOM\",note_math AS \"NOTE MATHEMATIQUE\",note_phys AS \"NOTE PHYSIQUE\",moyenne AS \"MOYENNE\",stauts AS \"OBSERVATION\" FROM etudiants ORDER BY numEt ASC";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            TableDeNote.setModel(DbUtils.resultSetToTableModel(resul));
        } catch (SQLException ex) {
            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  *********  ENDING MEDECINS *********

    //  *********  RECUPERATION MEDECINS *********
    public String GetTableResult() {
        return dataProject;
    }
//  *********  ENDING MEDECINS *********

//  *********  DISPLAY NOTE MAX *********
    public final void DisplayMax() {
        try {
            String request = "SELECT MAX(moyenne) as max_moyen FROM etudiants";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();

            if (resul.next()) {
                Max = resul.getString("max_moyen");
                if (Max == null) {
                    Max = "0";

                }
                MaxNote.setText(Max);
            }
        } catch (SQLException ex) {
            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  *********  ENDING NOTE *********

//  *********  DISPLAY NOTE MIN *********
    public final void DisplayMin() {
        try {
            String request = "SELECT MIN(moyenne) as max_moyen FROM etudiants";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();

            if (resul.next()) {
                Min = resul.getString("max_moyen");
                if (Min == null) {
                    Min = "0";

                }
                MinNote.setText(Min);
            }
        } catch (SQLException ex) {
            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  *********  ENDING NOTE *********

//  *********  DISPLAY NOTE ADIMS *********
    public final void DisplayNbAdmis() {
        try {
            String request = "SELECT COUNT(*) as nombre_admis FROM etudiants WHERE stauts = 'Admis' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();

            if (resul.next()) {
                admisNombre = resul.getString("nombre_admis");
                if (admisNombre == null) {
                    admisNombre = "0";

                }
                AdmisNombre.setText(admisNombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  *********  ENDING NOTE *********

    //  *********  DISPLAY NOTE REDOUBLANTS *********
    public final void DisplayNbRedoublants() {
        try {
            String request = "SELECT COUNT(*) as nombre_admis FROM etudiants WHERE stauts = 'Redoublant' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();

            if (resul.next()) {
                redoublantNombre = resul.getString("nombre_admis");
                if (redoublantNombre == null) {
                    redoublantNombre = "0";

                }
                RedoublantNombre.setText(redoublantNombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  *********  ENDING NOTE *********

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenaire = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDeNote = new components.Table.Table();
        DeleteNote = new javax.swing.JButton();
        MaxNote = new javax.swing.JLabel();
        MinNote = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AdmisNombre = new javax.swing.JLabel();
        RedoublantNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        searchData = new components.controls_2.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenaire.setBackground(new java.awt.Color(255, 51, 51));

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        TableDeNote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6 "
            }
        ));
        TableDeNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDeNoteMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableDeNoteMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TableDeNote);

        DeleteNote.setText("Delete");
        DeleteNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteNoteActionPerformed(evt);
            }
        });

        MaxNote.setBackground(new java.awt.Color(51, 255, 255));
        MaxNote.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        MinNote.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Admis : ");

        AdmisNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        RedoublantNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Redoublants :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Minimum :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Maximum :");

        searchData.setLabelText("Recherche");
        searchData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchDataKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout contenaireLayout = new javax.swing.GroupLayout(contenaire);
        contenaire.setLayout(contenaireLayout);
        contenaireLayout.setHorizontalGroup(
            contenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenaireLayout.createSequentialGroup()
                .addGroup(contenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(contenaireLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(contenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                            .addComponent(searchData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(contenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(UpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(DeleteNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(contenaireLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaxNote, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(MinNote, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdmisNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RedoublantNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        contenaireLayout.setVerticalGroup(
            contenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenaireLayout.createSequentialGroup()
                .addGroup(contenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenaireLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenaireLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(contenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenaireLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(DeleteNote, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenaireLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(contenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MaxNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MinNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(AdmisNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RedoublantNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//  *********  CLICK TABLE NOTE *********
    private void TableDeNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDeNoteMouseClicked
        Recuperation();
    }//GEN-LAST:event_TableDeNoteMouseClicked
//  *********  ENDING NOTE *********

//  *********  TABLE NOTE *********
    private void TableDeNoteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDeNoteMouseReleased
        ControlsButtonTrue();
    }//GEN-LAST:event_TableDeNoteMouseReleased
//  *********  ENDING NOTE *********

//  *********  ADD NOTE *********
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        AddNote addNote = new AddNote();
        addNote.setVisible(true);
        addNote.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (addNote.isInstant()) {
                    DisplayNote();
                    ControlsButton();
                    StatisticData();
                }
            }
        });
    }//GEN-LAST:event_addBtnActionPerformed
//  *********  ENDING NOTE *********

//  *********  UPDATE NOTE *********
    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        UpdateNote updateNote = new UpdateNote();
        updateNote.setVisible(true);
        updateNote.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (updateNote.isInstant()) {
                    DisplayNote();
                    ControlsButton();
                    StatisticData();
                }
            }
        });
    }//GEN-LAST:event_UpdateBtnActionPerformed
//  *********  ENDING NOTE *********

//  *********  DELETE NOTE *********    
    private void DeleteNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteNoteActionPerformed
        DeleteNote deleteNote = new DeleteNote();
        deleteNote.setVisible(true);
        deleteNote.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (deleteNote.isInstant()) {
                    DisplayNote();
                    ControlsButton();
                    StatisticData();
                }
            }
        });
    }//GEN-LAST:event_DeleteNoteActionPerformed
//  *********  ENDING NOTE *********

//  *********  SEARCH NOTE *********
    private void searchDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchDataKeyReleased
        try {
            String search = searchData.getText().trim().toLowerCase();
            String search2 = searchData.getText().trim().toLowerCase();

//            int Rech = Integer.parseInt(search2);
//            double Rech = Double.parseDouble(search2);
            System.out.println(search);
            String request = "SELECT numEt AS \"NUMERO\",nom AS \"NOM\",note_math AS \"NOTE MATHEMATIQUE\",note_phys AS \"NOTE PHYSIQUE\",moyenne AS \"MOYENNE\",stauts AS \"OBSERVATION\" FROM etudiants WHERE LOWER(stauts) LIKE ? OR LOWER(nom) LIKE ?";
//            String request = "SELECT numEt AS \"NUMERO\",nom AS \"NOM\",note_math AS \"NOTE MATHEMATIQUE\",note_phys AS \"NOTE PHYSIQUE\",moyenne AS \"MOYENNE\",stauts AS \"OBSERVATION\" FROM etudiants WHERE stauts = '"+ search2 +"' LIKE ? OR LOWER(nom) LIKE ?";
            prepare = con.prepareStatement(request);
            prepare.setString(1, "%" + search + "%");
//            prepare.setDouble(1, "%" + Rech + "%");
//             prepare.setInt(1, "%" + Rech + "%");
            prepare.setString(2, "%" + search + "%");
            resul = prepare.executeQuery();
            TableDeNote.setModel(DbUtils.resultSetToTableModel(resul));
        } catch (SQLException ex) {
            Logger.getLogger(page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchDataKeyReleased
//  *********  ENDING NOTE *********

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new page().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdmisNombre;
    private javax.swing.JButton DeleteNote;
    private javax.swing.JLabel MaxNote;
    private javax.swing.JLabel MinNote;
    private javax.swing.JLabel RedoublantNombre;
    private components.Table.Table TableDeNote;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel contenaire;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private components.controls_2.TextField searchData;
    // End of variables declaration//GEN-END:variables
}
