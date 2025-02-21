
import connexionDB.connexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import pages.page;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenaire = new javax.swing.JPanel();
        connexionBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        connexionBTN.setText("connexion");
        connexionBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connexionBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContenaireLayout = new javax.swing.GroupLayout(Contenaire);
        Contenaire.setLayout(ContenaireLayout);
        ContenaireLayout.setHorizontalGroup(
            ContenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(connexionBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        ContenaireLayout.setVerticalGroup(
            ContenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireLayout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(connexionBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Contenaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Contenaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connexionBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connexionBTNActionPerformed
        page pagex = new page();
        pagex.setVisible(true);
        this.hide();
    }//GEN-LAST:event_connexionBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            connexion.LoadConnexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenaire;
    private javax.swing.JButton connexionBTN;
    // End of variables declaration//GEN-END:variables
}
