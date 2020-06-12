package Test;

import DAO.ConsultationDAO;
import DAO.PatientDAO;
import DAO.UtilisateurDAO;
import entities.Consultation;
import entities.Patient;
import entities.Utilisateur;
import java.time.LocalDate;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hassan
 */
public class Tests {
    UtilisateurDAO dao = new UtilisateurDAO();
    Utilisateur user = new Utilisateur();
    Patient patient = new Patient();
    PatientDAO patientDAO = new PatientDAO();
    ConsultationDAO consultationDAO = new ConsultationDAO();
    
    public Tests() {
    }
    @Test
    public void insertUserTest(){
        Utilisateur user = new Utilisateur();
        user.setNom("Suarez");
        user.setPrenom("Luis");
        user.setPseudo("Luis");
        user.setMdp("azerty");
        user.setIdProfil(1);
        user.setIdService(1);
        user.setIdSpecialite(1);
        int added = dao.insert(user);
       Assert.assertEquals(1, added);
        
    }
   
    @Test
    public void SelectOneUserTest(){
        String pseudo = "Norbert";
        String mdp = "123456789";
        user = dao.findByLogin(pseudo, mdp);
        Assert.assertNotNull(user);
        
    }
    
   @Test
   public void insertPatientTest(){
       patient.setNom("Jallot");
       patient.setPrenom("Luc");
       patient.setNss(1750133444444l);
       //patient.setDateDeCreation(("2020-11-04"));
       int affected = 0;
       affected = patientDAO.insert(patient);
       Assert.assertEquals(affected, 1);
       System.out.println("************* Fin de test *************");
   }
   
   @Test
   public void selectConsultationsTest(){
       List<Consultation> liste = new ArrayList();
       liste = consultationDAO.selectAll();
       boolean notFound = liste.isEmpty();
       Assert.assertFalse(notFound);
   }

    
}
