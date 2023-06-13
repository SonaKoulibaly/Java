package views;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.Fabrique;
import core.Fonction;
import model.Antecedant;
import model.Medecin;
import model.Patient;
import model.Rv;
import model.Specialiste;
import model.Statut;
import service.IAntecedantService;
import service.IMedecinService;
import service.IPatientService;
import service.IRvService;
import service.ISpecialisteService;
import service.MedecinService;
import service.PatientService;

public class App {

    public static void main(String[] args) throws Exception {
       
        Scanner clavier=new Scanner(System.in);

        int choix;
        //Dependance faible
        ISpecialisteService specialisteService =Fabrique.getSpecialisteService();
        IAntecedantService antecedantService =Fabrique.getAntecedantService();
        IMedecinService medecinService = Fabrique.getMedecinService();
        IPatientService patientService = Fabrique.getPatientService();
        IRvService rvService = Fabrique.getRvService();

        do {
            System.out.println("1-Spécialités");
            System.out.println("2-Antécedants");
            System.out.println("3-Rendez-vous");
            System.out.println("4-Quitter!");
            System.out.println("faites votre choix:");
            choix= clavier.nextInt();
            clavier.nextLine();
            switch (choix) {
                case 1:
                    int choixSpecialite;
                    do {
                        System.out.println("SPECIALITES");
                        System.out.println("1-Ajouter");
                        System.out.println("2-Modifier");
                        System.out.println("3-Lister");
                        System.out.println("4-Supprimer");
                        System.out.println("5-Quitter!");
                        System.out.println("faites votre choix:");
                        choixSpecialite = clavier.nextInt();
                        clavier.nextLine();
                        if(choixSpecialite==1){
                            System.out.println("Option Ajouter");
                            System.out.println("Veuillez Saisir le libelle");
                            String libelle= clavier.nextLine();
                            Specialiste sp =new Specialiste(libelle);
                            specialisteService.ajouter(sp);
                            System.out.println("Une Specialité a été ajoutée");
                        }
                        else if(choixSpecialite==2){
                            System.out.println("Option Modifier");
                            System.out.println("Veuillez Saisir le libelle de la spécialité à modifier");
                            String libelle= clavier.nextLine();
                            Specialiste sp = specialisteService.rechercherParLibelle(libelle);
                            if(sp!=null){
                                System.out.println("Veuillez Saisir le nouveau libelle");
                                libelle= clavier.nextLine();
                                sp.setLibelle(libelle);
                                specialisteService.modifier(sp); 
                                System.out.println("Une Specialité a été modifiée");
                            }else{
                                System.out.println("Specialité non trouvée");
                            }
                        
                        }
                        else if(choixSpecialite==3){
                            System.out.println("Option Lister");
                            List<Specialiste> sps = specialisteService.lister();
                            for (Specialiste specialiste : sps) {
                                System.out.println(specialiste);
                            }
                        }
                        else if(choixSpecialite==4){
                            System.out.println("Option Supprimer");  
                            System.out.println("veuillez saisir id de la specialité");
                            int id= clavier.nextInt();
                            Specialiste sp = specialisteService.rechercherParId(id);
                            if(sp!=null){
                                System.out.println("une specialité a été supprimée");
                            
                                specialisteService.supprimer(sp); 
                            }else{
                                System.out.println("Specialité non trouvée");
                            }
                        }
                    } while (choixSpecialite!=5);     
                    break;
                case 2:

                int choixAntecedant;
                do {
                    System.out.println("ANTECEDANT");
                    System.out.println("1-Ajouter");
                    System.out.println("2-Modifier");
                    System.out.println("3-Lister");
                    System.out.println("4-Supprimer");
                    System.out.println("5-Quitter!");
                    System.out.println("faites votre choix:");
                    choixAntecedant = clavier.nextInt();
                    clavier.nextLine();
                    if(choixAntecedant==1){
                        System.out.println("Option Ajouter");
                        System.out.println(" Saisir le libelle");
                        String libelle= clavier.nextLine();
                        Antecedant an =new Antecedant(libelle);
                        antecedantService.ajouter(an);
                        System.out.println("Un Antecedant a été ajoutée");
                    }
                    else if(choixAntecedant==2){
                        System.out.println("Option Modifier");
                        System.out.println(" Saisir le libelle de Antecedant à modifier");
                        String libelle= clavier.nextLine();
                        Antecedant an = antecedantService.rechercherParLibelle(libelle);
                        if(an!=null){
                            System.out.println(" Saisir le nouveau libelle");
                            libelle= clavier.nextLine();
                            an.setLibelle(libelle);
                            antecedantService.modifier(an); 
                            System.out.println("Un Antecedant a été modifiée");
                            
                        }else{
                            System.out.println("Antecedant non trouvée");
                        }
                    
                    }
                    else if(choixAntecedant==3){
                        System.out.println("Option Lister");
                        List<Antecedant> ans = antecedantService.lister();
                        for (Antecedant antecedant : ans) {
                            System.out.println(antecedant);
                        }
                    }
                    else if(choixAntecedant==4){
                        System.out.println("Option Supprimer");  
                        System.out.println("veuillez saisir id de Antecedant");
                        int id= clavier.nextInt();
                        Antecedant an = antecedantService.rechercherParId(id);
                        if(an!=null){
                            System.out.println("un Antecedant a été supprimer");
                        
                            antecedantService.supprimer(an); 
                        }else{
                            System.out.println("Antecedant non trouvée");
                        }
                    }
                } while (choixAntecedant!=5);     
                    break;
                case 3:
                int choixRv;
                do {
                    System.out.println("RENDEZ_VOUS");
                    System.out.println("1-ENREGISTRER RV");
                    System.out.println("2-Valider RV");
                    System.out.println("3-Lister RV");
                    System.out.println("4-Annuler");
                    System.out.println("5-Quitter!");
                    System.out.println("faites votre choix:");
                    choixRv = clavier.nextInt();
                    clavier.nextLine();
                    if(choixRv==1){
                        System.out.println("Option  Ajouter");
                        System.out.println(" Saisir la date");
                        String dateString = clavier.nextLine();
                        //convertion de la date en java.util
                        java.util.Date dateUtil = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                        //convertir la date java.util en java.sql
                        Date date = new Date(dateUtil.getTime());
                        System.out.println(" Saisir heuredb");
                        String heuredb= clavier.nextLine();
                        System.out.println(" Saisir heurefin");
                        String heurefin= clavier.nextLine();
                        System.out.println(" Saisir le nci du medecin");
                        String nci= clavier.nextLine();
                        Medecin m = medecinService.rechercherParNci(nci);
                        if(m==null){
                            System.out.println(" Medecin non trouvée");
                            System.out.println(" creation du nouveau medecin");
                            System.out.println(" Saisir le nom");
                            String nom=clavier.nextLine();
                            System.out.println(" Saisir le prenom");
                            String prenom=clavier.nextLine();
                            System.out.println(" Saisir le telephone");
                            String telephone=clavier.nextLine();
                            m=new Medecin(nom, prenom, telephone, nci) ;                                                      
                            medecinService.ajouter(m); 
                             m = medecinService.rechercherParNci(nci);

                            System.out.println("Un Medecin a été ajoutée");
                            
                        }
                        System.out.println(" Saisir le numero du patient");
                        String numero= clavier.nextLine();
                        Patient p = patientService.rechercherParNumero(numero);
                        if(p==null){
                            System.out.println(" Patient non trouvée");
                            System.out.println(" creation du nouveau patient");
                            System.out.println(" Saisir le nom");
                            String nom=clavier.nextLine();
                            System.out.println(" Saisir le prenom");
                            String prenom=clavier.nextLine();
                            System.out.println(" Saisir le telephone");
                            String telephone=clavier.nextLine();
                            p=new Patient(nom, prenom, telephone);                                                  
                            patientService.ajouter(p); 
                            int num=(patientService.lister()).size();
                            numero="PAT"+num;
                             p = patientService.rechercherParNumero(numero);
                            System.out.println("Un patient a été ajoutée");
                            
                        }System.out.println(p);
                        Rv rv =new Rv(date, heuredb, heurefin, m, p);
                        rvService.ajouter(rv);
                        System.out.println("Un RV a été ajoutée");
                                            }
                    else if(choixRv==2){
                        System.out.println("Option validé");
                        System.out.println(" Saisir le numero");
                        String numero= clavier.nextLine();
                        Rv rv= rvService.rechercherParNumero(numero);
                        if(rv!=null && rv. getStatut()==Statut.Pasvalider ){
                            rv.setStatut(Statut.Valider);
                            rvService.modifier(rv); 
                            System.out.println("Un RV a été validée");
                            
                        }else{
                            System.out.println("RV non trouvée ou impossible de valider3");
                        }
                    
                    }
                    else if(choixRv==3){
                        int choixLister;
                        do {
                        System.out.println("Option Lister");
                        System.out.println("1-RV Valider");
                        System.out.println("2-RV Pasvalider");
                        System.out.println("3-RV Annuler");
                        System.out.println("4-RV lister par Medecin");
                        System.out.println("5-RV lister par Patient");
                        System.out.println("6-Quitter!");
                        System.out.println("faites votre choix:");
                        choixLister = clavier.nextInt();
                        clavier.nextLine();
                        if(choixLister==1){
                            List<Rv> rvs = rvService.lister(Statut.Valider);
                            for (Rv rv : rvs) {
                                System.out.println(rv);
                            }
                        }
                        else if(choixLister==2){
                            List<Rv> rvs = rvService.lister(Statut.Pasvalider);
                            for (Rv rv : rvs) {
                                System.out.println(rv);
                            }
                        }
                        else if(choixLister==3){
                            List<Rv> rvs = rvService.lister(Statut.Annuler);
                            for (Rv rv : rvs) {
                                System.out.println(rv);
                            }
                        }
                        else if(choixLister==4){
                            System.out.println(" Saisir le nci du medecin");
                            String nci= clavier.nextLine();
                            Medecin m = medecinService.rechercherParNci(nci);
                            if(m!=null){
                                //lister par nci
                                List<Rv> rvs = rvService.lister(m);
                                for (Rv rv : rvs) {
                                    System.out.println(rv);
                                }
                            }
                        }
                        
                        else if(choixLister==5){
                            System.out.println(" Saisir le numero du patient");
                            String numero= clavier.nextLine();
                            Patient p = patientService.rechercherParNumero(numero);
                            if(p!=null){
                                //lister par numero
                                List<Rv> rvs = rvService.lister(p);
                                for (Rv rv : rvs) {
                                    System.out.println(rv);
                                }
                            }
                        }
                        } while (choixLister!=6);
                    }
                    else if(choixRv==4){
                        System.out.println("Option Annuler");  
                        System.out.println(" Saisir le numero");
                        String numero= clavier.nextLine();
                        Rv rv= rvService.rechercherParNumero(numero);
                        if(rv!=null && rv.getStatut()==Statut.Pasvalider ){
                            rv.setStatut(Statut.Annuler);
                            rvService.modifier(rv); 
                            System.out.println("Un RV a été annulé");
                            
                        }else{
                            System.out.println("RV non trouvé ou impossible d'annuler");
                        }
                    }
                } while (choixRv!=5);     

                    
                    break;
                default:
                    break;
            }

        } while (choix!=4);
        

    }
}