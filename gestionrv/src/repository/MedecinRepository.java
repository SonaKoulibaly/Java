package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Medecin;

public class MedecinRepository implements IMedecinRepository{
    private IDataBase mySql;
 
    public MedecinRepository(IDataBase mySql) {
        this.mySql = mySql;
    }


    @Override
    public void add(Medecin m) {
         
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="INSERT INTO `user` (`id`,`nom`,`prenom`,`telephone`,`nci`,`numero`,`role`) "
            +" VALUES (NULL,'"+m.getNom()+"','"+m.getPrenom()+"','"+m.getTelephone()+"','"+m.getNci()+"',NULL,'"+m.getRole()+"');";
    
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
    public List<Medecin> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Medecin obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Medecin obj) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public Medecin findByNci(String nci) {
        Medecin m = null;
        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From user where nci like '"+nci+"%'";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              if(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un sp

                //Ajout de la sp dans la liste 
                m= new Medecin();
                m.setId(rs.getInt ("id"));
                m.setNom(rs.getString("nom"));
                m.setPrenom(rs.getString("prenom"));
                m.setTelephone(rs.getString("telephone"));
                m.setNci(rs.getString ("nci"));
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }
        return m;
        
    }
    
}
