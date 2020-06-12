package IHM;

import DAO.MaterielDAO;
import DAO.ProfilDAO;
import DAO.ServiceDAO;
import DAO.SpecialiteDAO;
import DAO.UtilisateurDAO;
import connection.SingleConnection;
import entities.Profil;
import entities.Service;
import entities.Specialite;
import entities.Utilisateur;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author hassan
 */
public class AdminIHM extends javax.swing.JFrame {

    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    DefaultListModel model = new DefaultListModel();
    DefaultListModel modelService = new DefaultListModel();
    //instanciation des DAO utilisateurs / profils / services / Materiel
    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    ServiceDAO serviceDAO = new ServiceDAO();
    SpecialiteDAO specialiteDAO = new SpecialiteDAO();
    ProfilDAO profilDAO = new ProfilDAO();

    public AdminIHM() {
        initComponents();
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
        //appels de methodes pour remplir les listes déroulantes et les listes au démarrage de l'application  
        remplirJComboBoxProfil();
        remplirJComboBoxService();
        remplirJComboBoxSpecialite();
        remplirJlistProfils();
        remplirJlistServices();
        jPanelProfils.setVisible(false);
        jPanelServices.setVisible(false);

    }

    //la methode permet de remplir la Jcombobox Profils
    public void remplirJComboBoxProfil() {
        List<Profil> liste = new ArrayList();
        liste = profilDAO.selectAll();
        if (liste != null) {
            for (Profil profil : liste) {
                //jComboBoxProfil.addItem(profil.getId(), profil.getNomProfil());
                jComboBoxProfil.addItem(profil.getId() + " :: " + profil.getNomProfil());
            }
        }

    }

    //la methode qui permet de remplir la jcombobox Specialité
    public void remplirJComboBoxSpecialite() {
        List<Specialite> liste = new ArrayList();
        liste = specialiteDAO.selectAll();
        if (liste != null) {
            for (Specialite specialite : liste) {
                jComboBoxSpecialite.addItem(specialite.getId() + " :: " + specialite.getNomSpecialite());
            }
        }
    }

    //la methode qui permet de remplir la jcombobox Services
    public void remplirJComboBoxService() {
        List<Service> liste = new ArrayList();
        liste = serviceDAO.selectAll();
        if (liste != null) {
            for (Service service : liste) {
                jComboBoxService.addItem(service.getId() + " :: " + service.getNomService());
            }
        }
    }

    //la methode qui permet d'ajouter un utilisateur 
    public int addUser() {
        int added = 0;
        //récupération du profil de la jcombobx
        String profils = (String) jComboBoxProfil.getSelectedItem();
        String[] selectedProfil = profils.split("::");
        String profil = selectedProfil[0].trim();
        //récupération du service de la jcombobx
        String services = (String) jComboBoxService.getSelectedItem();
        String[] selectedService = services.split("::");
        String service = selectedService[0].trim();
        //récupération du specialité de la jcombobx
        String specialites = (String) jComboBoxSpecialite.getSelectedItem();
        String[] selectedSpecialite = specialites.split("::");
        String specialite = selectedSpecialite[0].trim();

        //création d'une insatnce d'Utilisateur
        Utilisateur utilisateur = new Utilisateur();
        //récupération de la saisie 
        utilisateur.setNom(jTextFieldNom.getText());
        utilisateur.setPrenom(jTextFieldPrenom.getText());
        utilisateur.setPseudo(jTextFieldPseudo.getText());
        utilisateur.setMdp(jPasswordFieldMdp.getText());
        utilisateur.setIdProfil(parseInt(profil));
        utilisateur.setIdService(parseInt(service));
        utilisateur.setIdSpecialite(parseInt(specialite));
        System.out.println(utilisateur);
        utilisateurDAO.insert(utilisateur);

        return added;

    }

    //méthode qui permet d'afficher les profils dans la jlist
    public void remplirJlistProfils() {
        jListProfils.setModel(model);
        try {
            List<Profil> liste = new ArrayList();
            liste = profilDAO.selectAll();
            for (Profil profil : liste) {
                model.addElement(profil.getNomProfil());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //remplir la liste des services
    public void remplirJlistServices() {
        jListServices.setModel(modelService);
        try {
            List<Service> liste = new ArrayList();
            liste = serviceDAO.selectAll();
            for (Service service : liste) {
                modelService.addElement(service.getNomService());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrameListeUtilisateurs = new javax.swing.JInternalFrame();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonUtilisateurs = new javax.swing.JButton();
        jButtonServices = new javax.swing.JButton();
        jButtonProfils = new javax.swing.JButton();
        jPanelAjout = new javax.swing.JPanel();
        jLabelAjout = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelPseudo = new javax.swing.JLabel();
        jLabelMdp = new javax.swing.JLabel();
        jLabelProfil = new javax.swing.JLabel();
        jLabelService = new javax.swing.JLabel();
        jLabelSpecialite = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jTextFieldPseudo = new javax.swing.JTextField();
        jPasswordFieldMdp = new javax.swing.JPasswordField();
        jComboBoxProfil = new javax.swing.JComboBox<>();
        jComboBoxService = new javax.swing.JComboBox<>();
        jComboBoxSpecialite = new javax.swing.JComboBox<>();
        jButtonQuitter = new javax.swing.JButton();
        jButtonValider = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jPanelProfils = new javax.swing.JPanel();
        jLabelAjoutProfil = new javax.swing.JLabel();
        jLabelListeProfils = new javax.swing.JLabel();
        jTextFieldProfil = new javax.swing.JTextField();
        jButtonAjoutProfil = new javax.swing.JButton();
        jButtonSupprimerProfil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProfils = new javax.swing.JList<>();
        jLabelProfilMessage = new javax.swing.JLabel();
        jButtonQuitterProfil = new javax.swing.JButton();
        jPanelServices = new javax.swing.JPanel();
        jLabelPanelService = new javax.swing.JLabel();
        jTextFieldService = new javax.swing.JTextField();
        jButtonAjouterService = new javax.swing.JButton();
        jButtonSupprimerService = new javax.swing.JButton();
        jLabelListeServices = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListServices = new javax.swing.JList<>();
        jButtonQuitterServices = new javax.swing.JButton();
        jLabelMessageServices = new javax.swing.JLabel();

        jInternalFrameListeUtilisateurs.setClosable(true);
        jInternalFrameListeUtilisateurs.setIconifiable(true);
        jInternalFrameListeUtilisateurs.setMaximizable(true);
        jInternalFrameListeUtilisateurs.setResizable(true);
        jInternalFrameListeUtilisateurs.setTitle("Liste des utilisateurs");
        jInternalFrameListeUtilisateurs.setVisible(true);

        javax.swing.GroupLayout jInternalFrameListeUtilisateursLayout = new javax.swing.GroupLayout(jInternalFrameListeUtilisateurs.getContentPane());
        jInternalFrameListeUtilisateurs.getContentPane().setLayout(jInternalFrameListeUtilisateursLayout);
        jInternalFrameListeUtilisateursLayout.setHorizontalGroup(
            jInternalFrameListeUtilisateursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
        jInternalFrameListeUtilisateursLayout.setVerticalGroup(
            jInternalFrameListeUtilisateursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administration");

        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 153, 204));
        jLabelTitle.setText("Espace administrateur");

        jButtonUtilisateurs.setText("Utilisateurs");
        jButtonUtilisateurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUtilisateursActionPerformed(evt);
            }
        });

        jButtonServices.setText("Services");
        jButtonServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServicesActionPerformed(evt);
            }
        });

        jButtonProfils.setText("Profils");
        jButtonProfils.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfilsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonUtilisateurs, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jButtonProfils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonServices, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButtonUtilisateurs)
                .addGap(29, 29, 29)
                .addComponent(jButtonServices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButtonProfils)
                .addGap(70, 70, 70))
        );

        jPanelAjout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelAjout.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabelAjout.setText("Ajouter un utilisateur");

        jLabelNom.setText("Nom :");

        jLabelPrenom.setText("Prénom :");

        jLabelPseudo.setText("Pseudo :");

        jLabelMdp.setText("Mot de passe :");

        jLabelProfil.setText("Profil :");

        jLabelService.setText("Service :");

        jLabelSpecialite.setText("Spécialité :");

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

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

        jLabelMessage.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelMessage.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanelAjoutLayout = new javax.swing.GroupLayout(jPanelAjout);
        jPanelAjout.setLayout(jPanelAjoutLayout);
        jPanelAjoutLayout.setHorizontalGroup(
            jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAjoutLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelAjoutLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAjoutLayout.createSequentialGroup()
                                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPrenom)
                                    .addComponent(jLabelPseudo)
                                    .addComponent(jLabelMdp)
                                    .addComponent(jLabelProfil)
                                    .addComponent(jLabelService)
                                    .addComponent(jLabelSpecialite))
                                .addGap(86, 86, 86)
                                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNom)
                                    .addComponent(jTextFieldPrenom)
                                    .addComponent(jTextFieldPseudo)
                                    .addComponent(jPasswordFieldMdp)
                                    .addComponent(jComboBoxProfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxService, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxSpecialite, 0, 195, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabelAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanelAjoutLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAjoutLayout.setVerticalGroup(
            jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAjoutLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelAjout)
                .addGap(18, 18, 18)
                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNom)
                            .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrenom)
                            .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPseudo)
                            .addComponent(jTextFieldPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMdp)
                            .addComponent(jPasswordFieldMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelProfil))
                    .addComponent(jComboBoxProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelService)
                    .addComponent(jComboBoxService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSpecialite)
                    .addComponent(jComboBoxSpecialite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonQuitter)
                    .addComponent(jButtonValider)
                    .addComponent(jButtonReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanelProfils.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabelAjoutProfil.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelAjoutProfil.setText("Ajouter un profil");

        jLabelListeProfils.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelListeProfils.setText("Liste des profils");

        jButtonAjoutProfil.setText("Ajouter");
        jButtonAjoutProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutProfilActionPerformed(evt);
            }
        });

        jButtonSupprimerProfil.setText("Supprimer");
        jButtonSupprimerProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerProfilActionPerformed(evt);
            }
        });

        jListProfils.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jListProfils.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProfilsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListProfils);

        jButtonQuitterProfil.setText("Quitter");
        jButtonQuitterProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterProfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProfilsLayout = new javax.swing.GroupLayout(jPanelProfils);
        jPanelProfils.setLayout(jPanelProfilsLayout);
        jPanelProfilsLayout.setHorizontalGroup(
            jPanelProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfilsLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSupprimerProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAjoutProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAjoutProfil, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jTextFieldProfil))
                .addGap(121, 121, 121)
                .addGroup(jPanelProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelListeProfils, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelProfilsLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabelProfilMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuitterProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanelProfilsLayout.setVerticalGroup(
            jPanelProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfilsLayout.createSequentialGroup()
                .addGroup(jPanelProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProfilsLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelAjoutProfil))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfilsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelListeProfils)))
                .addGap(18, 18, 18)
                .addGroup(jPanelProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelProfilsLayout.createSequentialGroup()
                        .addComponent(jTextFieldProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAjoutProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonSupprimerProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProfilsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jButtonQuitterProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanelProfilsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelProfilMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanelServices.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPanelService.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelPanelService.setText("Ajouter un service");

        jButtonAjouterService.setText("Ajouter");
        jButtonAjouterService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterServiceActionPerformed(evt);
            }
        });

        jButtonSupprimerService.setText("Supprimer");
        jButtonSupprimerService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerServiceActionPerformed(evt);
            }
        });

        jLabelListeServices.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelListeServices.setText("Liste des services");

        jListServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListServicesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListServices);

        jButtonQuitterServices.setText("Quitter");
        jButtonQuitterServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterServicesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelServicesLayout = new javax.swing.GroupLayout(jPanelServices);
        jPanelServices.setLayout(jPanelServicesLayout);
        jPanelServicesLayout.setHorizontalGroup(
            jPanelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServicesLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelServicesLayout.createSequentialGroup()
                        .addComponent(jLabelMessageServices, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonQuitterServices, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanelServicesLayout.createSequentialGroup()
                        .addGroup(jPanelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPanelService, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jTextFieldService)
                            .addComponent(jButtonAjouterService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSupprimerService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(141, 141, 141)
                        .addGroup(jPanelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelListeServices, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(60, Short.MAX_VALUE))))
        );
        jPanelServicesLayout.setVerticalGroup(
            jPanelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServicesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPanelService)
                    .addComponent(jLabelListeServices))
                .addGap(18, 18, 18)
                .addGroup(jPanelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelServicesLayout.createSequentialGroup()
                        .addComponent(jTextFieldService, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAjouterService, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSupprimerService, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanelServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonQuitterServices, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMessageServices, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelServices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProfils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAjout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(201, 201, 201))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jPanelProfils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        // quitter la page
        this.dispose();
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // rééinitialiser les champs
        jTextFieldNom.setText("");
        jTextFieldPrenom.setText("");
        jTextFieldPseudo.setText("");
        jPasswordFieldMdp.setText("");


    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        // validation de la saisie et l'ajout du nouvel utilisateur
        if (jTextFieldNom.getText().length() == 0 || jTextFieldPrenom.getText().length() == 0 || jTextFieldPseudo.getText().length() == 0 || jPasswordFieldMdp.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Tous les champs doivent être renseignés", "Erreur de saisie ", JOptionPane.ERROR_MESSAGE);
        } else {

            try {
                addUser();
                jLabelMessage.setText("Un nouvel utilisateur a été ajouté avec succès !");
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données", "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonUtilisateursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilisateursActionPerformed
        // afficher la liste des utilisateurs
        ListeDesUtilisateurs users = new ListeDesUtilisateurs();
        users.setVisible(true);
    }//GEN-LAST:event_jButtonUtilisateursActionPerformed

    private void jButtonProfilsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfilsActionPerformed
        //Affichage de la liste des profils

        jPanelAjout.setVisible(false);
        jPanelServices.setVisible(false);
        jPanelProfils.setVisible(true);

    }//GEN-LAST:event_jButtonProfilsActionPerformed

    private void jListProfilsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProfilsMouseClicked
        // ajout de l'event "mouse clicked" sur les elemnts de la liste
        //récupération de l'element selectionné
        //remplissage du champ
        String selected = jListProfils.getSelectedValue().toString();
        jTextFieldProfil.setText(selected);
    }//GEN-LAST:event_jListProfilsMouseClicked

    private void jButtonAjoutProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjoutProfilActionPerformed
        // ajouter un nouveau profil
        String nomProfil = jTextFieldProfil.getText();
        if (nomProfil.length() > 2) {
            try {
                Profil profil = new Profil();
                profil.setNomProfil(nomProfil);
                profilDAO.insert(profil);
                jLabelProfilMessage.setText("un nouveau profil a été ajouté");
                //remplirJlistProfils();
                jTextFieldProfil.setText("");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            jLabelProfilMessage.setText("Veuillez saisir un nom de profil valide !");
        }
    }//GEN-LAST:event_jButtonAjoutProfilActionPerformed

    private void jButtonSupprimerProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerProfilActionPerformed
        // supprimer un profil 
        int index = jListProfils.getSelectedIndex();
        model.removeElementAt(index);
        profilDAO.delete(jTextFieldProfil.getText());
        jTextFieldProfil.setText("");
        //remplirJlistProfils();

    }//GEN-LAST:event_jButtonSupprimerProfilActionPerformed

    private void jButtonQuitterProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterProfilActionPerformed
        //quitter le panel profil 
        jPanelAjout.setVisible(true);
        jPanelProfils.setVisible(false);
        jPanelServices.setVisible(false);
    }//GEN-LAST:event_jButtonQuitterProfilActionPerformed

    private void jButtonQuitterServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterServicesActionPerformed
        //quitter le panel services 
        jPanelAjout.setVisible(true);
        jPanelServices.setVisible(false);
        jPanelProfils.setVisible(false);
    }//GEN-LAST:event_jButtonQuitterServicesActionPerformed

    private void jListServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListServicesMouseClicked
        // Ajout de l'event "mousse click " sur la liste des services
        String selectedItem = jListServices.getSelectedValue().toString();
        jTextFieldService.setText(selectedItem);
    }//GEN-LAST:event_jListServicesMouseClicked

    private void jButtonSupprimerServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerServiceActionPerformed
        // supprimer un service selectionné dans la liste
        int index = jListServices.getSelectedIndex();
        modelService.removeElementAt(index);
        serviceDAO.delete(jTextFieldService.getText());
        jTextFieldService.setText("");
    }//GEN-LAST:event_jButtonSupprimerServiceActionPerformed

    private void jButtonAjouterServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterServiceActionPerformed
        // ajouter un service
        String nomService = jTextFieldService.getText();
        if (nomService.length() > 4) {
            try {
                Service service = new Service();
                service.setNomService(nomService);
                serviceDAO.insert(service);
                jLabelMessageServices.setText("Un nouveau service a été ajouté");
                //remplirJlistServices();
                jTextFieldService.setText("");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            jLabelMessageServices.setText("Veuillez saisir un nom de service valide !");
        }

    }//GEN-LAST:event_jButtonAjouterServiceActionPerformed

    private void jButtonServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServicesActionPerformed
        //Affichage de la liste des services

        jPanelAjout.setVisible(false);
        jPanelProfils.setVisible(false);
        jPanelServices.setVisible(true);
    }//GEN-LAST:event_jButtonServicesActionPerformed

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
            java.util.logging.Logger.getLogger(AdminIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminIHM().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjoutProfil;
    private javax.swing.JButton jButtonAjouterService;
    private javax.swing.JButton jButtonProfils;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonQuitterProfil;
    private javax.swing.JButton jButtonQuitterServices;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonServices;
    private javax.swing.JButton jButtonSupprimerProfil;
    private javax.swing.JButton jButtonSupprimerService;
    private javax.swing.JButton jButtonUtilisateurs;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxProfil;
    private javax.swing.JComboBox<String> jComboBoxService;
    private javax.swing.JComboBox<String> jComboBoxSpecialite;
    private javax.swing.JInternalFrame jInternalFrameListeUtilisateurs;
    private javax.swing.JLabel jLabelAjout;
    private javax.swing.JLabel jLabelAjoutProfil;
    private javax.swing.JLabel jLabelListeProfils;
    private javax.swing.JLabel jLabelListeServices;
    private javax.swing.JLabel jLabelMdp;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelMessageServices;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPanelService;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelProfil;
    private javax.swing.JLabel jLabelProfilMessage;
    private javax.swing.JLabel jLabelPseudo;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JLabel jLabelSpecialite;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListProfils;
    private javax.swing.JList<String> jListServices;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAjout;
    private javax.swing.JPanel jPanelProfils;
    private javax.swing.JPanel jPanelServices;
    private javax.swing.JPasswordField jPasswordFieldMdp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPrenom;
    private javax.swing.JTextField jTextFieldProfil;
    private javax.swing.JTextField jTextFieldPseudo;
    private javax.swing.JTextField jTextFieldService;
    // End of variables declaration//GEN-END:variables
}
