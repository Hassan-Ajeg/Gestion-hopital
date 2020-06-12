package IHM;

import DAO.PatientDAO;
import entities.Patient;
import static java.lang.Long.parseLong;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author hassan
 */
public class AgentIHM extends javax.swing.JFrame {

    DefaultListModel model = new DefaultListModel();
    PatientDAO patientDAO = new PatientDAO();
    Patient patient = new Patient();

    /**
     * Creates new form AgentIHM
     */
    public AgentIHM() {
        initComponents();
        remplirJlistPatients();
    }

    //réinitialiser les champs 
    public void reset() {
        jTextFieldNom.setText("");
        jTextFieldPrenom.setText("");
        jFormattedTextFieldNss.setText("");
    }

    //la methode qui retourne la date du jour
    public String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    //methode pour remplir la liste des patients
    public void remplirJlistPatients() {
        jListPatients.setModel(model);
        try {
            List<Patient> liste = new ArrayList();
            liste = patientDAO.selectAll();
            System.out.println(liste.isEmpty());
            for (Patient patient : liste) {
                System.out.println(patient.getNom());
                model.addElement(patient.getNss() + "  --  " + patient.getNom() + "  --  " + patient.getPrenom());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAgent = new javax.swing.JPanel();
        jButtonQuitter = new javax.swing.JButton();
        jLabelAjoutPatient = new javax.swing.JLabel();
        jLabelNss = new javax.swing.JLabel();
        jFormattedTextFieldNss = new javax.swing.JFormattedTextField();
        jLabelNom = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jLabelPrenom = new javax.swing.JLabel();
        jTextFieldPrenom = new javax.swing.JTextField();
        jButtonValider = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPatients = new javax.swing.JList<>();
        jLabelListPatients = new javax.swing.JLabel();
        jLabelMessage = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonActualiser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Espace agent adminstratif");

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabelAjoutPatient.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelAjoutPatient.setText("Enregistrer un patient ");

        jLabelNss.setText("N° sécurité sociale :");

        try {
            jFormattedTextFieldNss.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelNom.setText("Nom :");

        jLabelPrenom.setText("Prénom :");

        jButtonValider.setText("Ajouter");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 153, 153));
        jLabelTitle.setText("Espace agent administratif");

        jListPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPatientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListPatients);

        jLabelListPatients.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelListPatients.setText("Liste des patients");

        jButtonReset.setText("Réinitialiser");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonActualiser.setText("Actualiser");
        jButtonActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAgentLayout = new javax.swing.GroupLayout(jPanelAgent);
        jPanelAgent.setLayout(jPanelAgentLayout);
        jPanelAgentLayout.setHorizontalGroup(
            jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgentLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAgentLayout.createSequentialGroup()
                        .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAgentLayout.createSequentialGroup()
                                .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelNom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelNss, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabelPrenom))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFormattedTextFieldNss)
                                    .addComponent(jTextFieldNom)
                                    .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                            .addGroup(jPanelAgentLayout.createSequentialGroup()
                                .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(jPanelAgentLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabelAjoutPatient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelListPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(jPanelAgentLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanelAgentLayout.createSequentialGroup()
                .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAgentLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAgentLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAgentLayout.setVerticalGroup(
            jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAjoutPatient)
                    .addComponent(jLabelListPatients))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAgentLayout.createSequentialGroup()
                        .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNom)
                            .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrenom)
                            .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldNss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNss))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonValider)
                            .addComponent(jButtonSupprimer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReset)
                            .addComponent(jButtonActualiser)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonQuitter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPatientsMouseClicked
        // ajout de l'event "mouse clicked" sur la liste
        //récupération de l'élément selectionné et remplissage des champs 
        String selected = jListPatients.getSelectedValue();
        String[] selectedElement = selected.split("--");
        String nss = (selectedElement[0].trim());
        String nom = (selectedElement[1].trim());
        String prenom = (selectedElement[2].trim());
        //Long patientNss = parseLong(nss);
        jTextFieldNom.setText(nom);
        jTextFieldPrenom.setText(prenom);
        jFormattedTextFieldNss.setText(nss);

    }//GEN-LAST:event_jListPatientsMouseClicked

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        // ajout et modification d'un patient
        String nom = jTextFieldNom.getText();
        String prenom = jTextFieldPrenom.getText();
        Long nss = parseLong(jFormattedTextFieldNss.getText());
        //récupération de la date du jour
        String date = (getDate()).trim();
        LocalDate currentDate = LocalDate.parse(date);

        if (nom == null || prenom == null || jFormattedTextFieldNss.getText().length() < 13) {
            JOptionPane.showMessageDialog(null, "Tous les champs doivent être renseignés", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                patient.setNom(nom);
                patient.setPrenom(prenom);
                patient.setNss(nss);
                patient.setDateDeCreation(currentDate);
                patientDAO.insert(patient);
                jLabelMessage.setText("un patient a été ajouté avec succès");
                reset();

            } catch (Exception e) {
                jLabelMessage.setText("Le patient n'a pas été enregistré");
            }
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        //réintilaiser les champs en appelant la methode
        reset();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // supprimer un patient
        int index = jListPatients.getSelectedIndex();
        model.removeElementAt(index);
        int affected = patientDAO.delete(parseLong(jFormattedTextFieldNss.getText()));
        reset();
        
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jButtonActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualiserActionPerformed
        //recharger la jlist
        model.removeAllElements();
        remplirJlistPatients();
    }//GEN-LAST:event_jButtonActualiserActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        // quitter la page agent et redirection vers la page Home
        Home home = new Home();
        home.setVisible(true);
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
            java.util.logging.Logger.getLogger(AgentIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgentIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgentIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgentIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgentIHM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualiser;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JFormattedTextField jFormattedTextFieldNss;
    private javax.swing.JLabel jLabelAjoutPatient;
    private javax.swing.JLabel jLabelListPatients;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelNss;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListPatients;
    private javax.swing.JPanel jPanelAgent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPrenom;
    // End of variables declaration//GEN-END:variables
}
