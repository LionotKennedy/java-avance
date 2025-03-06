package components.form;

import compenents.Modal.AddNote;
import compenents.Modal.DeleteNote;
import compenents.Modal.UpdateNote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public final class form_2 extends javax.swing.JPanel {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static String dataProject;
    static String Max;
    static String Min;
    static String admisNombre;
    static String redoublantNombre;

    public form_2() {
        initComponents();
        con = connexionDB.connexion.connex;
        DisplayNote();
        init();
        StatisticData();
        ControlsButton();
    }

    private void init() {
        TableDeNote.fixTable(jScrollPane2);
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
                form_2.dataProject = (TableDeNote.getModel().getValueAt(row, 0).toString());
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
            Logger.getLogger(form_2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(form_2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(form_2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(form_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  *********  ENDING NOTE *********

//  *********  DISPLAY NOTE *********
    public final void DisplayNote() {
        try {
            String request = "SELECT numEt AS \"NUMERO\",nom AS \"NOM\",note_math AS \"NOTE MATHEMATIQUE\",note_phys AS \"NOTE PHYSIQUE\",moyenne AS \"MOYENNE\",stauts AS \"OBSERVATION\" FROM etudiants ORDER BY numEt ASC";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            TableDeNote.setModel(DbUtils.resultSetToTableModel(resul));
        } catch (SQLException ex) {
            Logger.getLogger(form_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  *********  ENDING NOTE *********

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new components.panel.PanelShadow();
        searchData = new components.controls_2.TextField();
        addBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        DeleteNote = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        MaxNote = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MinNote = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AdmisNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RedoublantNombre = new javax.swing.JLabel();
        roundPanel1 = new components.table_2.roundPanel.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDeNote = new components.table_2.Table();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 0));
        setPreferredSize(new java.awt.Dimension(1071, 636));

        panelShadow1.setBackground(new java.awt.Color(0, 153, 204));

        searchData.setLabelText("Recherche");
        searchData.setLineColor(new java.awt.Color(16, 7, 112));
        searchData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchDataKeyReleased(evt);
            }
        });

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/icon/add.png"))); // NOI18N
        addBtn.setBorder(null);
        addBtn.setContentAreaFilled(false);
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/icon/edit.png"))); // NOI18N
        UpdateBtn.setBorder(null);
        UpdateBtn.setContentAreaFilled(false);
        UpdateBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        DeleteNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/icon/delete.png"))); // NOI18N
        DeleteNote.setBorder(null);
        DeleteNote.setContentAreaFilled(false);
        DeleteNote.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DeleteNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteNoteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Maximum :");

        MaxNote.setBackground(new java.awt.Color(51, 255, 255));
        MaxNote.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Minimum :");

        MinNote.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Admis : ");

        AdmisNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Redoublants :");

        RedoublantNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        TableDeNote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        TableDeNote.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TableDeNote.setSelectionBackground(new java.awt.Color(16, 7, 112));
        TableDeNote.setShowGrid(true);
        TableDeNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDeNoteMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableDeNoteMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TableDeNote);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/icon/search.png"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaxNote, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MinNote, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdmisNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RedoublantNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteNote)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addBtn)))
                .addGap(20, 20, 20))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeleteNote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaxNote, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinNote, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdmisNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RedoublantNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchDataKeyReleased
        try {
            String search = searchData.getText().trim().toLowerCase();
            String search2 = searchData.getText().trim().toLowerCase();

            System.out.println(search);
            String request = "SELECT numEt AS \"NUMERO\",nom AS \"NOM\",note_math AS \"NOTE MATHEMATIQUE\",note_phys AS \"NOTE PHYSIQUE\",moyenne AS \"MOYENNE\",stauts AS \"OBSERVATION\" FROM etudiants WHERE CAST(numEt AS VARCHAR) LIKE ? OR LOWER(nom) LIKE ?";
            //            String request = "SELECT numEt AS \"NUMERO\",nom AS \"NOM\",note_math AS \"NOTE MATHEMATIQUE\",note_phys AS \"NOTE PHYSIQUE\",moyenne AS \"MOYENNE\",stauts AS \"OBSERVATION\" FROM etudiants WHERE stauts = '"+ search2 +"' LIKE ? OR LOWER(nom) LIKE ?";
            prepare = con.prepareStatement(request);
            prepare.setString(1, "%" + search + "%");
            //            prepare.setDouble(1, "%" + Rech + "%");
            //             prepare.setInt(1, "%" + Rech + "%");
            prepare.setString(2, "%" + search2 + "%");
            resul = prepare.executeQuery();
            TableDeNote.setModel(DbUtils.resultSetToTableModel(resul));
        } catch (SQLException ex) {
            Logger.getLogger(form_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchDataKeyReleased

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdmisNombre;
    private javax.swing.JButton DeleteNote;
    private javax.swing.JLabel MaxNote;
    private javax.swing.JLabel MinNote;
    private javax.swing.JLabel RedoublantNombre;
    private components.table_2.Table TableDeNote;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private components.panel.PanelShadow panelShadow1;
    private components.table_2.roundPanel.RoundPanel roundPanel1;
    private components.controls_2.TextField searchData;
    // End of variables declaration//GEN-END:variables
}
