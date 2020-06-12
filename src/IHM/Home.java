package IHM;

import DAO.UtilisateurDAO;
import entities.Utilisateur;
import javax.swing.*;

/**
 * @author hassan
 */
public class Home extends javax.swing.JFrame {

    //instanciation du DAO utilisateur
    UtilisateurDAO dao = new UtilisateurDAO();
    //instanciation d'un nouvel utilisateur
    Utilisateur utilisateur = new Utilisateur();
    
    //int userId = utilisateur.getId();

    public Home() {
        initComponents();
    }

   /* public int getUserId() {
        return userId;
    }*/
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabelTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonValider = new javax.swing.JButton();
        jLabelIdentification = new javax.swing.JLabel();
        jLabelPseudo = new javax.swing.JLabel();
        jLabelMdp = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();
        jPasswordFieldMdp = new javax.swing.JPasswordField();
        jTextFieldPseudo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelMessage = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 153, 153));
        jLabelTitle.setText("GESTION D'HOPITAL");

        jButtonValider.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jLabelIdentification.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelIdentification.setText("Identifiez-vous :");

        jLabelPseudo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabelPseudo.setText("Votre pseudo :");

        jLabelMdp.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabelMdp.setText("Votre mot de passe :");

        jButtonReset.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButtonReset.setText("Réeinitialiser");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonQuitter.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabelMessage)
                        .addGap(543, 543, 543)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMdp)
                                    .addComponent(jLabelPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordFieldMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38)
                        .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelIdentification)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPseudo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMdp))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabelMessage))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        // quitter la page d'identification
        this.dispose();
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // Réeinitialiser les champs
        jTextFieldPseudo.setText("");
        jPasswordFieldMdp.setText("");

    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        // récupération de la saisie
        //si les champs sont vides, affichage d'une boite de dialogue avec message 

        String pseudo = jTextFieldPseudo.getText();
        String password = jPasswordFieldMdp.getText();

        if (pseudo.length() == 0 || password.length() == 0) {

            JOptionPane.showMessageDialog(null, "Tous les champs doivent être renseignés", "Erreur d'authentification", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                //appel de la mêthode FindByPseudo du DAO utilisateur
                utilisateur = dao.findByLogin(pseudo, password);
                System.out.println(utilisateur);
                //si utilisateur introuvable => on affiche une boite de dialogue avec un message d'erreur 
                if (utilisateur == null) {
                    //JOptionPane.showMessageDialog(null, "Identifiant introuvable !", "Erreur d'authentification", JOptionPane.ERROR_MESSAGE);
                } else {
                    //si l'utilisateur n'est pas vide, on verifie le profil 
                    //les profils disponibles : 1-medecin, 2-infirmier, 3-agent administratif, 4-technicien, 5-admin
                    int profil = utilisateur.getIdProfil();
                    if (profil == 1) {
                        //redirection vers page Medecin
                        MedecinIHM medecin = new MedecinIHM();
                        medecin.setVisible(true);
                        this.dispose();
                        System.out.println(profil);

                    }
                    /*if (profil == 2) {
                        //redirection vers page Infirmier
                        InfirmierIHM infirmier = new InfirmierIHM();
                        infirmier.setVisible(true);
                        this.dispose();
                        System.out.println(profil);

                    }*/
                    if (profil == 3) {
                        //redirection vers page Agent administartif
                        AgentIHM agent = new AgentIHM();
                        agent.setVisible(true);
                        this.dispose();
                        System.out.println(profil);

                    }
                    if (profil == 4) {
                        //redirection vers page Technicien
                        TechnicienIHM technicien = new TechnicienIHM();
                        technicien.setVisible(true);
                        this.dispose();
                        System.out.println(profil);

                    }
                    if (profil == 5) {
                        //redirection vers page Admin
                        AdminIHM admin = new AdminIHM();
                        admin.setVisible(true);
                        this.dispose();
                        System.out.println(profil);

                    }

                }

            } catch (Exception e) {
                System.out.println("Erreur de connexion à la base de données !");
            }
        }

    }//GEN-LAST:event_jButtonValiderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().pack();
                new Home().setExtendedState(Home.MAXIMIZED_BOTH);
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelIdentification;
    private javax.swing.JLabel jLabelMdp;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelPseudo;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldMdp;
    private javax.swing.JTextField jTextFieldPseudo;
    // End of variables declaration//GEN-END:variables
}
