package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import core.Fonction;
import model.Medecin;
import model.Patient;
import model.Role;
import model.Rv;
import model.Statut;

public class RvRepository implements IRvRepository {

    private IDataBase mySql;
 
    public RvRepository(IDataBase mySql) {
        this.mySql = mySql;
    }

    @Override
    public void add(Rv rv) {
        //je recupere tous les rv dans la base de donnees 
        List<Rv> rvs= findAll();
        //je compte le nombre de rv existant 
        int num = rvs.size()+1;
        //enfin je mets le format de numero
        String numero = "RV"+num;
        //Hydratation du  numero
        rv.setNumero(numero);
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="INSERT INTO `rv` (`id`,`numero`,`date`,`heuredb`,`heurefin`,`statut`,`id_medecin`,`id_patient`) "
            +" VALUES (NULL,'"+rv.getNumero()+"','"+Fonction.formatDate(rv.getDate())+"','"+rv.getHeuredb()+"','"+rv.getHeurefin()+"','Pasvalider','"+rv.getMedecin().getId()+"','"+rv.getPatient().getId()+"');";
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            //Traitement de la requete           
            mySql.fermerConnexion(conn);
                 
                
           } catch (SQLException e) {
            // TODO Auto-generated catch block
             System.out.println("Erreur de Connexion");
           }         
        
    }

    @Override
    public List<Rv> findAll() {
        List<Rv> rvs= new ArrayList<>();

        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT rv.*, user_medecin.telephone as telephone_medecin, user_patient.telephone as telephone_patient, user_medecin.nci AS nci_medecin, user_medecin.nom AS nom_medecin, user_medecin.prenom AS prenom_medecin, user_patient.numero AS numero_patient, user_patient.nom AS nom_patient, user_patient.prenom AS prenom_patient FROM rv JOIN user AS user_medecin ON rv.id_medecin = user_medecin.id JOIN user AS user_patient ON rv.id_patient = user_patient.id";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              while(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un rv

                //Ajout de la rv dans la liste 
                Rv rv= new Rv();
                rv.setId(rs.getInt("id"));
                rv.setNumero(rs.getString("numero"));
                //convertion de la date en java.util
                java.util.Date dateUtil = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
                //convertir la date java.util en java.sql
                Date date = new Date(dateUtil.getTime());
                rv.setDate(date);
                rv.setHeuredb(rs.getString("heuredb"));
                rv.setHeurefin(rs.getString("heurefin"));
                if(rs.getString("statut").compareTo("Valider")==0){
                    rv.setStatut(Statut. Valider);
                }else if(rs.getString("statut").compareTo("Annuler")==0){
                    rv.setStatut(Statut.Annuler);
                }
                else {
                    rv.setStatut(Statut.Pasvalider);
                }
                     //creation du medecin  du rv;
                    Medecin medecin= new Medecin();
                    medecin.setId(rs.getInt("id_medecin"));
                    medecin.setNom(rs.getString("nom_medecin"));
                    medecin.setPrenom(rs.getString("prenom_medecin"));
                    medecin.setTelephone(rs.getString("telephone_medecin"));
                    medecin.setNci(rs.getString("nci_medecin"));
                    rv.setMedecin(medecin);
                     //creation  du patient du rv;
                 Patient patient= new Patient();
                 patient.setId(rs.getInt("id_patient"));
                 patient.setNom(rs.getString("nom_patient"));
                 patient.setPrenom(rs.getString("prenom_patient"));
                patient.setTelephone(rs.getString("telephone_patient"));
                patient.setNumero(rs.getString("numero_patient"));
                    rv.setPatient(patient);

                          
                
                rvs.add(rv);
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rvs;
        
      
    }

    @Override
    public void update(Rv rv) {
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="UPDATE `rv` SET `numero` = '"+rv.getNumero()+ "',  `date` = '"+Fonction.formatDate(rv.getDate()) +
             "' ,  `heuredb` = '"+rv.getHeuredb()+ "' ,  `heurefin` = '"+rv.getHeurefin()+ 
             "' ,  `statut` = '"+rv.getStatut().toString()+"' ,  `id_medecin` = "+rv.getMedecin().getId()+
             " ,  `id_patient` = "+rv.getPatient().getId()+" WHERE `rv`.`id` = "+rv.getId()+";";
    
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            //Traitement de la requete           
            mySql.fermerConnexion(conn);
                 
                
           } catch (SQLException e) {
            // TODO Auto-generated catch block
             System.out.println("Erreur de Connexion");
           }         
        
        
    }

    @Override
    public void delete(Rv obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Rv findByNumero(String numero) {
       Rv rv = null;
       try {
           //changement du Driver,chargement des classes de jdbc
          Connection conn=mySql.ouvrirConnexion();
          String sql="SELECT rv.*, user_medecin.telephone as telephone_medecin, user_patient.telephone as telephone_patient, user_medecin.nci AS nci_medecin, user_medecin.nom AS nom_medecin, user_medecin.prenom AS prenom_medecin, user_patient.numero AS numero_patient, user_patient.nom AS nom_patient, user_patient.prenom AS prenom_patient FROM rv JOIN user AS user_medecin ON rv.id_medecin = user_medecin.id JOIN user AS user_patient ON rv.id_patient = user_patient.id WHERE rv.numero = '"+numero+"'";             Statement stmt=conn.createStatement();
             ResultSet rs=stmt.executeQuery(sql);
             //Traitement de la requette
             if(rs.next()){
               //on recupere une ligne du resultSET qui correspond en un rv

               //Ajout de la rv dans la liste 
               rv= new Rv();
               rv.setId(rs.getInt("id"));
               rv.setNumero(rs.getString("numero"));
               //convertion de la date en java.util
               java.util.Date dateUtil = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
               //convertir la date java.util en java.sql
               Date date = new Date(dateUtil.getTime());
               rv.setDate(date);
               rv.setHeuredb(rs.getString("heuredb"));
               rv.setHeurefin(rs.getString("heurefin"));
               if(rs.getString("statut").compareTo("Valider")==0){
                   rv.setStatut(Statut. Valider);
               }else{
                   rv.setStatut(Statut.Pasvalider);
               }
                    //creation du medecin  du rv;
                   Medecin medecin= new Medecin();
                   medecin.setId(rs.getInt("id_medecin"));
                   medecin.setNom(rs.getString("nom_medecin"));
                   medecin.setPrenom(rs.getString("prenom_medecin"));
                   medecin.setTelephone(rs.getString("telephone_medecin"));
                   medecin.setNci(rs.getString("nci_medecin"));
                   rv.setMedecin(medecin);
                    //creation  du patient du rv;
                Patient patient= new Patient();
                patient.setId(rs.getInt("id_patient"));
                patient.setNom(rs.getString("nom_patient"));
                patient.setPrenom(rs.getString("prenom_patient"));
               patient.setTelephone(rs.getString("telephone_patient"));
               patient.setNumero(rs.getString("numero_patient"));
                   rv.setPatient(patient);
             }
             //traitement de la requette
             
            mySql.fermerConnexion(conn);



          
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           System.out.println("Erreur de Connexion");
       } catch (ParseException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
        return rv;
    }

    @Override
    public List<Rv> findByMedecin(Medecin m) {
       
        List<Rv> rvs= new ArrayList<>();

        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT rv.*, user_medecin.telephone as telephone_medecin, user_patient.telephone as telephone_patient, user_medecin.nci AS nci_medecin, user_medecin.nom AS nom_medecin, user_medecin.prenom AS prenom_medecin, user_patient.numero AS numero_patient, user_patient.nom AS nom_patient, user_patient.prenom AS prenom_patient FROM rv JOIN user AS user_medecin ON rv.id_medecin = user_medecin.id JOIN user AS user_patient ON rv.id_patient = user_patient.id where user_medecin.nci = '"+m.getNci()+"'";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              while(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un rv

                //Ajout de la rv dans la liste 
                Rv rv= new Rv();
                rv.setId(rs.getInt("id"));
                rv.setNumero(rs.getString("numero"));
                //convertion de la date en java.util
                java.util.Date dateUtil = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
                //convertir la date java.util en java.sql
                Date date = new Date(dateUtil.getTime());
                rv.setDate(date);
                rv.setHeuredb(rs.getString("heuredb"));
                rv.setHeurefin(rs.getString("heurefin"));
                if(rs.getString("statut").compareTo("Valider")==0){
                    rv.setStatut(Statut. Valider);
                }else if(rs.getString("statut").compareTo("Annuler")==0){
                    rv.setStatut(Statut.Annuler);
                }
                else {
                    rv.setStatut(Statut.Pasvalider);
                }
                     //creation du medecin  du rv;
                    Medecin medecin= new Medecin();
                    medecin.setId(rs.getInt("id_medecin"));
                    medecin.setNom(rs.getString("nom_medecin"));
                    medecin.setPrenom(rs.getString("prenom_medecin"));
                    medecin.setTelephone(rs.getString("telephone_medecin"));
                    medecin.setNci(rs.getString("nci_medecin"));
                    rv.setMedecin(medecin);
                     //creation  du patient du rv;
                 Patient patient= new Patient();
                 patient.setId(rs.getInt("id_patient"));
                 patient.setNom(rs.getString("nom_patient"));
                 patient.setPrenom(rs.getString("prenom_patient"));
                patient.setTelephone(rs.getString("telephone_patient"));
                patient.setNumero(rs.getString("numero_patient"));
                    rv.setPatient(patient);

                          
                
                rvs.add(rv);
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rvs;
    }

    @Override
    public List<Rv> findByPatient(Patient p) {
        List<Rv> rvs= new ArrayList<>();

        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT rv.*, user_medecin.telephone as telephone_medecin, user_patient.telephone as telephone_patient, user_medecin.nci AS nci_medecin, user_medecin.nom AS nom_medecin, user_medecin.prenom AS prenom_medecin, user_patient.numero AS numero_patient, user_patient.nom AS nom_patient, user_patient.prenom AS prenom_patient FROM rv JOIN user AS user_medecin ON rv.id_medecin = user_medecin.id JOIN user AS user_patient ON rv.id_patient = user_patient.id where user_patient.numero = '"+p.getNumero()+"'";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              while(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un rv

                //Ajout de la rv dans la liste 
                Rv rv= new Rv();
                rv.setId(rs.getInt("id"));
                rv.setNumero(rs.getString("numero"));
                //convertion de la date en java.util
                java.util.Date dateUtil = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
                //convertir la date java.util en java.sql
                Date date = new Date(dateUtil.getTime());
                rv.setDate(date);
                rv.setHeuredb(rs.getString("heuredb"));
                rv.setHeurefin(rs.getString("heurefin"));
                if(rs.getString("statut").compareTo("Valider")==0){
                    rv.setStatut(Statut. Valider);
                }else if(rs.getString("statut").compareTo("Annuler")==0){
                    rv.setStatut(Statut.Annuler);
                }
                else {
                    rv.setStatut(Statut.Pasvalider);
                }
                     //creation du medecin  du rv;
                    Medecin medecin= new Medecin();
                    medecin.setId(rs.getInt("id_medecin"));
                    medecin.setNom(rs.getString("nom_medecin"));
                    medecin.setPrenom(rs.getString("prenom_medecin"));
                    medecin.setTelephone(rs.getString("telephone_medecin"));
                    medecin.setNci(rs.getString("nci_medecin"));
                    rv.setMedecin(medecin);
                     //creation  du patient du rv;
                 Patient patient= new Patient();
                 patient.setId(rs.getInt("id_patient"));
                 patient.setNom(rs.getString("nom_patient"));
                 patient.setPrenom(rs.getString("prenom_patient"));
                patient.setTelephone(rs.getString("telephone_patient"));
                patient.setNumero(rs.getString("numero_patient"));
                    rv.setPatient(patient);

                          
                
                rvs.add(rv);
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rvs;
       
    }

    @Override
    public List<Rv> findByStatut(Statut statut) {
        List<Rv> rvs= new ArrayList<>();

        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT rv.*, user_medecin.telephone as telephone_medecin, user_patient.telephone as telephone_patient, user_medecin.nci AS nci_medecin, user_medecin.nom AS nom_medecin, user_medecin.prenom AS prenom_medecin, user_patient.numero AS numero_patient, user_patient.nom AS nom_patient, user_patient.prenom AS prenom_patient FROM rv JOIN user AS user_medecin ON rv.id_medecin = user_medecin.id JOIN user AS user_patient ON rv.id_patient = user_patient.id where rv.statut= '"+statut.toString()+"'";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              while(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un rv

                //Ajout de la rv dans la liste 
                Rv rv= new Rv();
                rv.setId(rs.getInt("id"));
                rv.setNumero(rs.getString("numero"));
                //convertion de la date en java.util
                java.util.Date dateUtil = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
                //convertir la date java.util en java.sql
                Date date = new Date(dateUtil.getTime());
                rv.setDate(date);
                rv.setHeuredb(rs.getString("heuredb"));
                rv.setHeurefin(rs.getString("heurefin"));
                if(rs.getString("statut").compareTo("Valider")==0){
                    rv.setStatut(Statut. Valider);
                }else if(rs.getString("statut").compareTo("Annuler")==0){
                    rv.setStatut(Statut.Annuler);
                }
                else {
                    rv.setStatut(Statut.Pasvalider);
                }
                     //creation du medecin  du rv;
                    Medecin medecin= new Medecin();
                    medecin.setId(rs.getInt("id_medecin"));
                    medecin.setNom(rs.getString("nom_medecin"));
                    medecin.setPrenom(rs.getString("prenom_medecin"));
                    medecin.setTelephone(rs.getString("telephone_medecin"));
                    medecin.setNci(rs.getString("nci_medecin"));
                    rv.setMedecin(medecin);
                     //creation  du patient du rv;
                 Patient patient= new Patient();
                 patient.setId(rs.getInt("id_patient"));
                 patient.setNom(rs.getString("nom_patient"));
                 patient.setPrenom(rs.getString("prenom_patient"));
                patient.setTelephone(rs.getString("telephone_patient"));
                patient.setNumero(rs.getString("numero_patient"));
                    rv.setPatient(patient);

                          
                
                rvs.add(rv);
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rvs;
       
    }
    
}
