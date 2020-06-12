package IHM;

import DAO.UtilisateurDAO;
import DAO.UtilisateurDetailsDAO;
import entities.Utilisateur;
import entities.UtilisateurDetails;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hassan
 */
public class ListeDesUtilisateurs extends javax.swing.JFrame {

    UtilisateurDetailsDAO userDetailsDAO = new UtilisateurDetailsDAO();
    

    public ListeDesUtilisateurs() {
        initComponents();

        remplirJtableUtilisateurs();
        
}
    //la methode pour remplir la table utilisateur 
    public void remplirJtableUtilisateurs() {
        List<UtilisateurDetails> liste = new ArrayList();
        liste =  userDetailsDAO.getUsersDetails();
        DefaultTableModel defaultModel = (DefaultTableModel) jTableUtilisateurs.getModel();
        Object[] ligne = new Object[4];
        for(int i = 0; i < liste.size(); i++){
            ligne[0] = liste.get(i).getNom();
            ligne[1] = liste.get(i).getPrenom();
            ligne[2] = liste.get(i).getPseudo();
            ligne[3] = liste.get(i).getProfil();
            defaultModel.addRow(ligne);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableUtilisateurs = new javax.swing.JTable();
        jButtonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 153, 153));
        jLabelTitle.setText("Liste des utilisateurs");

        jScrollPane3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jTableUtilisateurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prénom", "Pseudo", "Profil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUtilisateurs.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableUtilisateurs);
        if (jTableUtilisateurs.getColumnModel().getColumnCount() > 0) {
            jTableUtilisateurs.getColumnModel().getColumn(0).setResizable(false);
            jTableUtilisateurs.getColumnModel().getColumn(1).setResizable(false);
            jTableUtilisateurs.getColumnModel().getColumn(2).setResizable(false);
            jTableUtilisateurs.getColumnModel().getColumn(3).setResizable(false);
        }

        jButtonQuitter.setText("Page précedente");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(492, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(535, 535, 535))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonQuitter)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        // retour à la page admin
        AdminIHM admin = new AdminIHM();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonQuitterActionPerformed

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
            java.util.logging.Logger.getLogger(ListeDesUtilisateurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeDesUtilisateurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeDesUtilisateurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeDesUtilisateurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListeDesUtilisateurs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableUtilisateurs;
    // End of variables declaration//GEN-END:variables
}
