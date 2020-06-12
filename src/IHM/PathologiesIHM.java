package IHM;

import DAO.PathologieDAO;
import entities.Pathologie;
import java.util.*;
import javax.swing.DefaultListModel;

/**
 *
 * @author hassan
 */
public class PathologiesIHM extends javax.swing.JFrame {
    
    PathologieDAO pathologieDAO = new PathologieDAO();
    DefaultListModel model = new DefaultListModel();

    /**
     * Creates new form PathologiesIHM
     */
    public PathologiesIHM() {
        initComponents();
        //appel de la methode et remplissage au démarrage de la page
        remplirJList();
    }

    //cette methode permet d'afficher les pathologies dans la Jlist
    public void remplirJList(){
        
        jListPathologies.setModel(model);
        try{
            List<Pathologie> liste = new ArrayList();
            liste = pathologieDAO.seletAll();
            for(Pathologie item : liste){
                model.addElement(item.getId() +" - " +item.getNomPathologie());
            }
            
        }catch(Exception e){
            System.out.println("Erreur de connexion à la base de données !");
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPathologie = new javax.swing.JTextField();
        jButtonValider = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPathologies = new javax.swing.JList<>();
        jLabelListePathologies = new javax.swing.JLabel();
        jButtonQuitter = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jButtonSupprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PATHOLOGIES");

        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 153, 153));
        jLabelTitle.setText("Gestion des pathologies");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("Ajouter une pathologie :");

        jTextFieldPathologie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPathologieActionPerformed(evt);
            }
        });

        jButtonValider.setText("Ajouter");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jListPathologies.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jListPathologies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPathologiesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListPathologies);

        jLabelListePathologies.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelListePathologies.setForeground(new java.awt.Color(51, 51, 0));
        jLabelListePathologies.setText("Liste des pathologies");

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabelMessage.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(199, 199, 199)
                        .addComponent(jLabelListePathologies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(185, 185, 185))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPathologie, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelListePathologies, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldPathologie, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPathologieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPathologieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPathologieActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        // fermer la page et retourner à la page medecin
        MedecinIHM medecinIHM = new MedecinIHM();
        medecinIHM.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        //ajout d'une nouvelle pathologie
        int added = 0;
        String nomPathologie = jTextFieldPathologie.getText();
        if(nomPathologie.length() > 2){
            try{
                Pathologie pathologie = new Pathologie();
                pathologie.setNomPathologie(nomPathologie);
                PathologieDAO dao = new PathologieDAO();
                added = dao.insert(pathologie);
                jLabelMessage.setText("Une nouvelle pathologie a été ajouté ");
                remplirJList();
                jTextFieldPathologie.setText("");
                
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            jLabelMessage.setText("Merci de saisir un nom de pathologie valide ");
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jListPathologiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPathologiesMouseClicked
        // ajout de l'event "click" sur la jList
        String selected = jListPathologies.getSelectedValue().toString();
        jTextFieldPathologie.setText(selected);
    }//GEN-LAST:event_jListPathologiesMouseClicked

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // suppression d'un élement de la liste
        int index = jListPathologies.getSelectedIndex();
        model.removeElementAt(index);
        jTextFieldPathologie.setText("");
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

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
            java.util.logging.Logger.getLogger(PathologiesIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PathologiesIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PathologiesIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PathologiesIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PathologiesIHM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelListePathologies;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListPathologies;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldPathologie;
    // End of variables declaration//GEN-END:variables
}
