package compenents.Modal;

import compenents.Message.delete;
import components.form.form_2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;

public final class DeleteNote extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    static String ID;

    delete DELETE = new delete();

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
            form_2 information = new form_2();
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

    private void messageSuccess() {
        DELETE.setVisible(true);
        Animator animator = new Animator(4000); // Durée de l'animation (500ms)
        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                // en fonction de l'avancement de l'animation, par exemple :
                DELETE.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
            }

            @Override
            public void end() {
                // Fermer la fenêtre après la fin de l'animation
                DELETE.dispose();
            }
        });

        animator.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContenaireDelete = new components.panel.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        Cancel = new components.controls.ButtonOutLine();
        ComfDelete = new components.controls.ButtonOutLine();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText(" Êtes-vous sûr de vouloir supprimer le ? :");

        Data.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Cancel.setBackground(new java.awt.Color(102, 102, 102));
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        ComfDelete.setBackground(new java.awt.Color(204, 0, 0));
        ComfDelete.setForeground(new java.awt.Color(204, 0, 0));
        ComfDelete.setText("OK");
        ComfDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComfDeleteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Suppression de note");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/icon/1.gif"))); // NOI18N

        javax.swing.GroupLayout ContenaireDeleteLayout = new javax.swing.GroupLayout(ContenaireDelete);
        ContenaireDelete.setLayout(ContenaireDeleteLayout);
        ContenaireDeleteLayout.setHorizontalGroup(
            ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireDeleteLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ComfDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(ContenaireDeleteLayout.createSequentialGroup()
                .addGroup(ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenaireDeleteLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenaireDeleteLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContenaireDeleteLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        ContenaireDeleteLayout.setVerticalGroup(
            ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenaireDeleteLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(ContenaireDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComfDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenaireDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenaireDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                messageSuccess();
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
    private components.panel.PanelShadow ContenaireDelete;
    private javax.swing.JLabel Data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
