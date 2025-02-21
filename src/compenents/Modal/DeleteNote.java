package compenents.Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import pages.page;

public final class DeleteNote extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;
    
    static String ID;

    public DeleteNote() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = connexionDB.connexion.connex;
        RecuperationData();
        instant = false;
    }

//  *********  RECUPERATION NOTE *********
    public void RecuperationData() {
        try {
            page information = new page();
            information.Recuperation();
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM etudiants WHERE numEt ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {

                ID = resul.getString("numEt");
                Data.setText(ID);
                System.out.println(ID);

            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DeleteNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
//  *********  ENDING ACT *********

//  *********  ACT NOTE *********
    public boolean isInstant() {
        return instant;
    }
//  *********  ENDING ACT *********

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContenaireDelete = new components.controls.PanelRound();
        ComfDelete = new components.controls.ButtonOutLine();
        Cancel = new components.controls.ButtonOutLine();
        jLabel1 = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComfDelete.setBackground(new java.awt.Color(204, 0, 0));
        ComfDelete.setText("OK");
        ComfDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComfDeleteActionPerformed(evt);
            }
        });

        Cancel.setBackground(new java.awt.Color(102, 102, 102));
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Are you sure to delete this data : ");

        Data.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ContenaireDeleteLayout = new javax.swing.GroupLayout(ContenaireDelete);
        ContenaireDelete.setLayout(ContenaireDeleteLayout);
        ContenaireDeleteLayout.setHorizontalGroup(
            ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ContenaireDeleteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                    .addGroup(ContenaireDeleteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(ComfDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        ContenaireDeleteLayout.setVerticalGroup(
            ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireDeleteLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ContenaireDeleteLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComfDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenaireDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenaireDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//  *********  CANCEL NOTE *********    
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed
//  *********  ENDING NOTE *********
  
//  *********  COMF NOTE *********  
    private void ComfDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComfDeleteActionPerformed
        System.out.println(ID);
         if (ID.length() != 0) {
            try {
                String request = "DELETE FROM etudiants WHERE numEt = '" + ID + "'";
                prepare = con.prepareStatement(request);
                prepare.execute();
                this.hide();
                instant = true;
                this.dispose();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DeleteNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ComfDeleteActionPerformed
//  *********  ENDING NOTE *********
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new DeleteNote().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.controls.ButtonOutLine Cancel;
    private components.controls.ButtonOutLine ComfDelete;
    private components.controls.PanelRound Contenaire;
    private components.controls.PanelRound ContenaireDelete;
    private javax.swing.JLabel Data;
    private components.controls.ButtonOutLine annulerSup;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
