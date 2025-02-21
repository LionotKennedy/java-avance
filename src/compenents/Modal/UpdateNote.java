package compenents.Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import pages.page;

public final class UpdateNote extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    static String ID;
    static String Stat;

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
            page information = new page();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContenaireModal = new javax.swing.JPanel();
        addComf = new components.controls.Button();
        cancelBtn = new components.controls.ButtonOutLine();
        name = new components.controls_2.TextField();
        math = new components.controls_2.TextField();
        physi = new components.controls_2.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addComf.setBackground(new java.awt.Color(0, 153, 204));
        addComf.setText("Modifier");
        addComf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComfActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        name.setLabelText("Nom");

        math.setLabelText("Mathématique");

        physi.setLabelText("Physique");

        javax.swing.GroupLayout ContenaireModalLayout = new javax.swing.GroupLayout(ContenaireModal);
        ContenaireModal.setLayout(ContenaireModalLayout);
        ContenaireModalLayout.setHorizontalGroup(
            ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireModalLayout.createSequentialGroup()
                .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ContenaireModalLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addComf, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ContenaireModalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(physi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(math, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContenaireModalLayout.setVerticalGroup(
            ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenaireModalLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(physi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addGroup(ContenaireModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addComf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenaireModal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenaireModal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//  *********  COMF NOTE *********
    private void addComfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComfActionPerformed

        try {
            String A1 = name.getText();
            String note_1 = math.getText();
            String note_2 = physi.getText();
            double noteMath = Double.parseDouble(note_1);
            double notePhysi = Double.parseDouble(note_2);
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
            instant = true;
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateNote.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_addComfActionPerformed
//  *********  ENDING NOTE *********

//  *********  CANCEL NOTE *********
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed

//        try {
//            String note_1 = math.getText();
//            String note_2 = physi.getText();
//
//            double noteMath = Double.parseDouble(note_1);
//            double notePhysi = Double.parseDouble(note_2);
//            System.out.println(name.getText());
//            System.out.println(noteMath);
//            System.out.println(notePhysi);
//
//            String request = "INSERT INTO etudiants (nom,note_math,note_phys) VALUES (?,?,?)";
//
//            prepare = con.prepareStatement(request/*,Statement.RETURN_GENERATED_KEYS*/);
//            prepare.setString(1, name.getText());
//            prepare.setDouble(2, noteMath);
//            prepare.setDouble(3, notePhysi);
//            prepare.execute();
//            instant = true;
//            this.dispose();
//        } catch (SQLException ex) {
//            Logger.getLogger(AddNote.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
    private javax.swing.JPanel ContenaireModal;
    private components.controls.Button addComf;
    private components.controls.ButtonOutLine cancelBtn;
    private components.controls_2.TextField math;
    private components.controls_2.TextField name;
    private components.controls_2.TextField physi;
    // End of variables declaration//GEN-END:variables
}
