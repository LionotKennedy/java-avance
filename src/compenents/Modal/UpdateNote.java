package compenents.Modal;

import compenents.Message.adderror;
import compenents.Message.update;
import components.form.form_2;
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

public final class UpdateNote extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    static String ID;
    static String Stat;

    update UPDATE = new update();
    adderror ADDERROR = new adderror();

    public UpdateNote() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = connexionDB.connexion.connex;
        instant = false;
        RecuperationData();
    }
//  *********  ACT NOTE *********

    public boolean isInstant() {
        return instant;
    }
//  *********  ENDING ACT *********

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
                System.out.println(ID);

                String A2 = resul.getString("nom");
                name.setText(A2);
                System.out.println(A2);

                String A3 = resul.getString("note_math");
                math.setText(A3);
                System.out.println(A3);

                String A4 = resul.getString("note_phys");
                physi.setText(A4);
                System.out.println(A4);

                String A5 = resul.getString("moyenne");
                System.out.println(A5);

                String A6 = resul.getString("stauts");
                System.out.println(A6);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateNote.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        UPDATE.setVisible(true);
        Animator animator = new Animator(4000); // Durée de l'animation (500ms)
        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                // en fonction de l'avancement de l'animation, par exemple :
                UPDATE.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
            }

            @Override
            public void end() {
                // Fermer la fenêtre après la fin de l'animation
                UPDATE.dispose();
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
        addComf = new components.controls.Button();
        cancelBtn = new components.controls.ButtonOutLine();
        physi = new components.controls_2.TextField();
        math = new components.controls_2.TextField();
        name = new components.controls_2.TextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        addComf.setBackground(new java.awt.Color(16, 7, 112));
        addComf.setForeground(new java.awt.Color(255, 255, 255));
        addComf.setText("Enregistrer");
        addComf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComfActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(16, 7, 112));
        cancelBtn.setForeground(new java.awt.Color(16, 7, 112));
        cancelBtn.setText("Annuler");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        physi.setLabelText("Physique");
        physi.setLineColor(new java.awt.Color(16, 7, 112));

        math.setLabelText("Mathématique");
        math.setLineColor(new java.awt.Color(16, 7, 112));

        name.setLabelText("Nom");
        name.setLineColor(new java.awt.Color(16, 7, 112));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mise à jour de note");

        javax.swing.GroupLayout ContenaireModalLayout = new javax.swing.GroupLayout(ContenaireModal);
        ContenaireModal.setLayout(ContenaireModalLayout);
        ContenaireModalLayout.setHorizontalGroup(
            ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenaireModalLayout.createSequentialGroup()
                .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ContenaireModalLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(math, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(physi, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ContenaireModalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(addComf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireModalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        ContenaireModalLayout.setVerticalGroup(
            ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireModalLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(physi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addComf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenaireModal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ContenaireModal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//  *********  COMF NOTE *********
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
                math.setHelperText("Veuillez entrer un nombre valide pour la note de mathématiques.");
                math.grabFocus();
                name.setLineColor(Color.red);
                return;
            }

            if (!isValidNumber(note_2)) {
                physi.setBackground(Color.PINK);
                physi.setHelperText("Veuillez entrer un nombre valide pour la note de physique.");
                physi.grabFocus();
                name.setLineColor(Color.red);
                return;
            }
            try {
                String A1 = name.getText();
                double noteMath = Double.parseDouble(note_1);
                double notePhysi = Double.parseDouble(note_2);

                if (noteMath < 0 || noteMath > 20 || notePhysi < 0 || notePhysi > 20) {
                    messageError();
                    return;
                }
                double moyen = (noteMath + notePhysi) / 2;
                System.out.println(moyen);

                if (moyen >= 10) {
                    Stat = "Admis";
                    System.out.println(Stat);
                } else {
                    Stat = "Redoublant";
                    System.out.println(Stat);
                }
                System.out.println(ID);
                System.out.println(A1);
                System.out.println(noteMath);
                System.out.println(notePhysi);

                String requete = "UPDATE etudiants SET nom='" + A1 + "', note_math='" + noteMath + "', note_phys='" + notePhysi + "', moyenne='" + moyen + "', stauts='" + Stat + "' WHERE numEt='" + ID + "' ";
                prepare = con.prepareStatement(requete);
                prepare.execute();
                this.hide();
                messageSuccess();
                instant = true;
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UpdateNote.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_addComfActionPerformed
//  *********  ENDING NOTE *********

//  *********  CANCEL NOTE *********
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.hide();
        instant = true;
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed
//  *********  ENDING NOTE *********

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new UpdateNote().setVisible(true);
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
