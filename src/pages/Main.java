package pages;

import compenents.Message.loginerror;
import connexionDB.connexion;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;

public class Main extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    loginerror LOGINERROR = new loginerror();

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = connexionDB.connexion.connex;
    }

    public boolean checkUser() {
        boolean action = true;
        if (txtUser.getText().trim().equals("")) {
            txtUser.setHelperText("Please input user name");
            action = false;
        }
        if (String.valueOf(txtPass.getPassword()).trim().equals("")) {
            txtPass.setHelperText("Please input password");
            action = false;
        }
        return action;
    }

    private void messageError() {
        LOGINERROR.setVisible(true);
        Animator animator = new Animator(5000); // Durée de l'animation (500ms)
        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                // en fonction de l'avancement de l'animation, par exemple :
                LOGINERROR.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
            }

            @Override
            public void end() {
                // Fermer la fenêtre après la fin de l'animation
                LOGINERROR.dispose();
            }
        });

        animator.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenaire = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new components.controls_2.TextField();
        txtPass = new components.controls_2.PasswordField();
        cmd = new components.controls_2.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SE CONNECTER");

        txtUser.setLabelText("Adresse email");
        txtUser.setLineColor(new java.awt.Color(16, 7, 112));

        txtPass.setLabelText("Mot de passe");
        txtPass.setLineColor(new java.awt.Color(16, 7, 112));

        cmd.setBackground(new java.awt.Color(16, 7, 112));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("CONNECTER");
        cmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContenaireLayout = new javax.swing.GroupLayout(Contenaire);
        Contenaire.setLayout(ContenaireLayout);
        ContenaireLayout.setHorizontalGroup(
            ContenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenaireLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(ContenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ContenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                        .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ContenaireLayout.setVerticalGroup(
            ContenaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenaireLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Contenaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Contenaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActionPerformed

        page pagex = new page();
        pagex.setVisible(true);
        this.hide();
        
//        String email = txtUser.getText().trim();
//        String password = new String(txtPass.getPassword());
//
//        email = txtUser.getText().trim();
//        password = new String(txtPass.getPassword());
//
//        // Basic validation
//        if (email.isEmpty()) {
//            txtUser.setHelperText("Veuillez remplir le champ email.");
//            txtUser.grabFocus();
//            txtUser.setLineColor(Color.red);
//        } else if (password.isEmpty()) {
//            txtPass.setHelperText("Veuillez remplir le champ mot de passe.");
//            txtPass.grabFocus();
//            txtPass.setLineColor(Color.red);
//        } else {
//
//            try {
//
//                String request = "SELECT userid, username, useremail FROM users WHERE useremail = '" + email + "' AND userpassword = '" + password + "' limit 1";
//                prepare = con.prepareStatement(request/*,Statement.RETURN_GENERATED_KEYS*/);
//                resul = prepare.executeQuery();
//                if (resul.next()) {
//                    page pagex = new page();
//                    pagex.setVisible(true);
//                    this.setVisible(false);
//                } else {
//                    messageError();
//                }
//
//            } catch (HeadlessException e) {
//                JOptionPane.showMessageDialog(this,
//                        "Error during login: " + e.getMessage(),
//                        "System Error",
//                        JOptionPane.ERROR_MESSAGE);
//            } catch (SQLException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

    }//GEN-LAST:event_cmdActionPerformed

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
    private components.controls_2.Button cmd;
    private javax.swing.JLabel jLabel1;
    private components.controls_2.PasswordField txtPass;
    private components.controls_2.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
