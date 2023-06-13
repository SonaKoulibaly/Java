package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Patient;

public class PatientRepository implements IPatientRepository {
    private IDataBase mySql;
 
    public PatientRepository(IDataBase mySql) {
        this.mySql = mySql;
    }

    @Override
    public void add(Patient p) {
        //je recupere tous les patients dans la base de donnees grace au findAll
        List<Patient> ps= findAll();
        //je compte le nombre de patient existant 
        int num = ps.size()+1;
        //enfin je mets le format de numero et le numero correspond au nbre de patient qui existe dans la base de donnees
        String numero = "PAT"+num;
        //Hydratation du  numero
        p.setNumero(numero);
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="INSERT INTO `user` (`id`,`nom`,`prenom`,`telephone`,`nci`,`numero`,`role`) "
            +" VALUES (NULL,'"+p.getNom()+"','"+p.getPrenom()+"','"+p.getTelephone()+"',NULL,'"+p.getNumero()+"','"+p.getRole()+"');";
    
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
    public List<Patient> findAll() {
       
        List<Patient> ps= new ArrayList<>();

        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From user where role like 'Patient' ";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              while(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un sp

                //Ajout de la sp dans la liste 
                Patient p= new Patient();
                p.setId(rs.getInt ("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setTelephone(rs.getString("telephone"));
                p.setNumero(rs.getString ("numero"));
                ps.add(p);

              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }

        return ps;
        
    }

    @Override
    public void update(Patient obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Patient obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Patient findByNumero(String numero) {
        Patient p = null;
        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From user where numero like '"+numero+"%'";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              if(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un sp

                //Ajout de la p dans la liste 
                p= new Patient();
                p.setId(rs.getInt ("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setTelephone(rs.getString("telephone"));
                p.setNumero(rs.getString ("numero"));
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }
        return p;
        
    }
    
       
    
    
}
