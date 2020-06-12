package IHM;

import DAO.ConsultationDAO;
import DAO.ConsultationDetailsDAO;
import DAO.PathologieDAO;
import DAO.PatientDAO;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import connection.SingleConnection;
import entities.Consultation;
import entities.ConsultationDetails;
import entities.Pathologie;
import entities.Patient;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hassan
 */
public class MedecinIHM extends javax.swing.JFrame {

    //instanciation DAO pathologie
    PathologieDAO dao = new PathologieDAO();
    PatientDAO patientDAO = new PatientDAO();
    ConsultationDAO consultationDAO = new ConsultationDAO();
    ConsultationDetailsDAO detailsDAO = new ConsultationDetailsDAO();
    ConsultationDetails details = new ConsultationDetails();
    /**
     * Creates new form MedecinIHM
     */
    public MedecinIHM() {
        initComponents();
        //appel de la méthode pour remplir la jComboBox
        remplirJComboBox();
        remplirJtableDetails();
    }
    
    //remplir la jtable 
    public void remplirJtableDetails(){
        List<ConsultationDetails> liste = new ArrayList();
        liste = detailsDAO.getDetails();
        DefaultTableModel defaultModel = (DefaultTableModel) jTableConsultations.getModel();
        Object[] ligne = new Object[4];
        for(int i = 0; i < liste.size(); i++){
            ligne[0] = liste.get(i).getNss();
            ligne[1] = liste.get(i).getNom();
            ligne[2] = liste.get(i).getNomPathologie();
            ligne[3] = liste.get(i).getDateDeCreation();
            defaultModel.addRow(ligne);
        }
    }

    //la methode permet de remplir la Jcombo des pathologies
    public void remplirJComboBox() {
        List<Pathologie> liste = new ArrayList();
        liste = dao.seletAll();
        if (liste != null) {
            //boucle sur la liste des résultats et ajout dans la combobox
            for (Pathologie item : liste) {
                jComboBoxPathologie.addItem(item.getId() + " :: " + item.getNomPathologie());
            }
        }

    }

    //la mêthode qui permet d'ajouter une consultation 
    public int addConsultation() {
        int added = 0;
        //récupération de la pathologie de la jcombobx
        String pathologies = (String) jComboBoxPathologie.getSelectedItem();
        String[] selectedPathologie = pathologies.split("::");
        int idPathologie = parseInt(selectedPathologie[0].trim());

        //int idUtilisateur = home.getUserId();
        //récupération de la date du jour
        String date = (getDate()).trim();
        LocalDate currentDate = LocalDate.parse(date);
        //récupération du NSS du patient sous forme de String
        String nss = jFormattedTextFieldNss.getText();
        //conversion en type Long
        long patientNss = Long.parseLong(nss);
        System.out.println(patientNss);
        System.out.println(date);
        System.out.println(currentDate);
        Patient patient = patientDAO.selectOne(patientNss);
        System.out.println(patient.getNom());
        if (patient != null) {
            int idPatient = patient.getId();
            System.out.println(idPatient);
            //si le patient existe , donc on crée une nouvelle consultation
            try {
                Consultation consultation = new Consultation();
                //consultation.setIdUtilisateur(idUtilisateur);
                consultation.setIdPatient(idPatient);
                consultation.setIdPathologie(idPathologie);
                consultation.setDateDeCreation(currentDate);
                System.out.println(consultation.toString());
                consultationDAO.insert(consultation);
                //on vide les champs
                jFormattedTextFieldNss.setText("");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            jLabelMessage.setText("Patient introuvable ");
        }
        return added;
    }

    //la methode qui retourne la date du jour
    public String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /*public java.util.Date currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = new java.util.Date(System.currentTimeMillis());
        return date;
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jButtonPathologies = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelNss = new javax.swing.JLabel();
        jLabelPathologie = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jComboBoxPathologie = new javax.swing.JComboBox<>();
        jLabelMessage = new javax.swing.JLabel();
        jFormattedTextFieldNss = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultations = new javax.swing.JTable();
        jLabelConsultations = new javax.swing.JLabel();
        jButtonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medecins");

        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelTitle.setText("Espace medecins");

        jButtonPathologies.setText("Gestion des pathologies");
        jButtonPathologies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPathologiesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Ajouter une nouvelle consultation");

        jLabelNss.setText("N° sécurité sociale du patient :");

        jLabelPathologie.setText("Pathologie :");

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jButtonReset.setText("Rééinitialiser");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldNss.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTableConsultations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nss", "Nom", "Prénom", "Date de création"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableConsultations);
        if (jTableConsultations.getColumnModel().getColumnCount() > 0) {
            jTableConsultations.getColumnModel().getColumn(0).setResizable(false);
            jTableConsultations.getColumnModel().getColumn(1).setResizable(false);
            jTableConsultations.getColumnModel().getColumn(2).setResizable(false);
            jTableConsultations.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabelConsultations.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelConsultations.setText("Liste des consultations");

        jButtonQuitter.setText("Quitter");
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(297, 297, 297)
                                    .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonPathologies, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(45, 45, 45)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabelConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNss, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(246, 246, 246))
                            .addComponent(jFormattedTextFieldNss, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabelPathologie, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxPathologie, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButtonPathologies)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldNss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNss, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPathologie, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPathologie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonValider)
                    .addComponent(jButtonQuitter))
                .addGap(18, 18, 18)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jLabelConsultations)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // vider les champs
        jFormattedTextFieldNss.setText("");
        jComboBoxPathologie.setSelectedItem("autre");
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        // Validation de la saisie
        String nss = jFormattedTextFieldNss.getText();
        if (nss.length() < 13) {
            jLabelMessage.setText("Veuillez saisir un NSS valide !");
        } else {
            addConsultation();
            jLabelMessage.setText("Une nouvelle consultation a été enregistrée");
            //remplirJtableDetails();
        }

    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonPathologiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPathologiesActionPerformed
        //Redirection vers gestion pathologies
        PathologiesIHM pathologie = new PathologiesIHM();
        pathologie.setVisible(true);
    }//GEN-LAST:event_jButtonPathologiesActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        // retour à la page de connexion
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonQuitterActionPerformed

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
            java.util.logging.Logger.getLogger(MedecinIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedecinIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedecinIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedecinIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedecinIHM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPathologies;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxPathologie;
    private javax.swing.JFormattedTextField jFormattedTextFieldNss;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelConsultations;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelNss;
    private javax.swing.JLabel jLabelPathologie;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsultations;
    // End of variables declaration//GEN-END:variables
}
