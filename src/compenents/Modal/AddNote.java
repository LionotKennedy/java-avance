package compenents.Modal;

import compenents.Message.add;
import compenents.Message.adderror;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;

public class AddNote extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    static String Stat;

    add ADD = new add();
    adderror ADDERROR = new adderror();

    public AddNote() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = connexionDB.connexion.connex;
        instant = false;
    }

//  *********  ACT MEDECINS *********
    public boolean isInstant() {
        return instant;
    }
//  *********  ENDING ACT *********

    private boolean isValidNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void messageSuccess() {
        ADD.setVisible(true);
        Animator animator = new Animator(4000); // Durée de l'animation (500ms)
        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                // en fonction de l'avancement de l'animation, par exemple :
                ADD.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
            }

            @Override
            public void end() {
                // Fermer la fenêtre après la fin de l'animation
                ADD.dispose();
            }
        });

        animator.start();
    }

    private void messageError() {
        ADDERROR.setVisible(true);
        Animator animator = new Animator(8000); // Durée de l'animation (500ms)
        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                // en fonction de l'avancement de l'animation, par exemple :
                ADDERROR.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
            }

            @Override
            public void end() {
                // Fermer la fenêtre après la fin de l'animation
                ADDERROR.dispose();
            }
        });

        animator.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContenaireModal = new components.panel.PanelShadow();
        name = new components.controls_2.TextField();
        math = new components.controls_2.TextField();
        physi = new components.controls_2.TextField();
        cancelBtn = new components.controls.ButtonOutLine();
        addComf = new components.controls.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        ContenaireModal.setShadowOpacity(1.0F);

        name.setLabelText("Nom");
        name.setLineColor(new java.awt.Color(16, 7, 112));

        math.setLabelText("Mathématique");
        math.setLineColor(new java.awt.Color(16, 7, 112));

        physi.setLabelText("Physique");
        physi.setLineColor(new java.awt.Color(16, 7, 112));

        cancelBtn.setBackground(new java.awt.Color(16, 7, 112));
        cancelBtn.setForeground(new java.awt.Color(16, 7, 112));
        cancelBtn.setText("Annuler");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        addComf.setBackground(new java.awt.Color(16, 7, 112));
        addComf.setForeground(new java.awt.Color(255, 255, 255));
        addComf.setText("Enregistrer");
        addComf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComfActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajout de note");

        javax.swing.GroupLayout ContenaireModalLayout = new javax.swing.GroupLayout(ContenaireModal);
        ContenaireModal.setLayout(ContenaireModalLayout);
        ContenaireModalLayout.setHorizontalGroup(
            ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenaireModalLayout.createSequentialGroup()
                .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenaireModalLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(math, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(physi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ContenaireModalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addComf, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(ContenaireModalLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContenaireModalLayout.setVerticalGroup(
            ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenaireModalLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(math, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(physi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addComf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenaireModal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenaireModal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//  *********  COMF NOTE *********
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed
//  *********  ENDING NOTE *********

//  *********  CANCEL NOTE *********
    private void addComfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComfActionPerformed
        String note_1 = math.getText().trim();
        String note_2 = physi.getText().trim();
        String nom = name.getText();

        if (nom.isEmpty()) {
            name.setHelperText("Veuillez remplir le champ nom.");
            name.grabFocus();
            name.setLineColor(Color.red);
        } else if (note_1.isEmpty()) {
            math.setHelperText("Veuillez remplir le champ note de mathématiques.");
            math.grabFocus();
            name.setLineColor(Color.red);
        } else if (note_2.isEmpty()) {
            physi.setHelperText("Veuillez remplir le champ note de physique.");
            physi.grabFocus();
            name.setLineColor(Color.red);
        } else {
            if (!isValidNumber(note_1)) {
//                math.setBackground(Color.PINK);
                math.setHelperText("Veuillez entrer un nombre valide pour la note de mathématiques.");
                math.grabFocus();
                name.setLineColor(Color.red);
//                JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre valide pour la note de mathématiques.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidNumber(note_2)) {
                physi.setBackground(Color.PINK);
                physi.setHelperText("Veuillez entrer un nombre valide pour la note de physique.");
                physi.grabFocus();
                name.setLineColor(Color.red);
//                JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre valide pour la note de physique.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
//            String note_1 = math.getText();
//            String note_2 = physi.getText();
                double noteMath = Double.parseDouble(note_1);
                double notePhysi = Double.parseDouble(note_2);
//            double noteMath = Double.parseDouble(note_1);
//            double notePhysi = Double.parseDouble(note_2);

                if (noteMath < 0 || noteMath > 20 || notePhysi < 0 || notePhysi > 20) {
//                    JOptionPane.showMessageDialog(this, "Les notes doivent être comprises entre 0 et 20.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                    messageError();
                    return;
                }
                double moyen = (noteMath + notePhysi) / 2;
                System.out.println(moyen);
//             String Stat = (moyen >= 10) ? "Admis" : "Redoublant";

                if (moyen >= 10) {
                    Stat = "Admis";
                    System.out.println(Stat);
                } else {
                    Stat = "Redoublant";
                    System.out.println(Stat);
                }
                System.out.println(name.getText());
                System.out.println(noteMath);
                System.out.println(notePhysi);

                String request = "INSERT INTO etudiants (nom,note_math,note_phys,moyenne,stauts) VALUES (?,?,?,?,?)";

                prepare = con.prepareStatement(request/*,Statement.RETURN_GENERATED_KEYS*/);
                prepare.setString(1, name.getText());
                prepare.setDouble(2, noteMath);
                prepare.setDouble(3, notePhysi);
                prepare.setDouble(4, moyen);
                prepare.setString(5, Stat);
                prepare.execute();
                messageSuccess();
                instant = true;
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(AddNote.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_addComfActionPerformed
//  *********  ENDING NOTE *********

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new AddNote().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.panel.PanelShadow ContenaireModal;
    private components.controls.Button addComf;
    private components.controls.ButtonOutLine cancelBtn;
    private javax.swing.JLabel jLabel1;
    private components.controls_2.TextField math;
    private components.controls_2.TextField name;
    private components.controls_2.TextField physi;
    // End of variables declaration//GEN-END:variables
}
