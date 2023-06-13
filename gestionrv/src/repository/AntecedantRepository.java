package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Antecedant;

public class AntecedantRepository implements IAntecedantRepository{
    private IDataBase mySql;

    public AntecedantRepository(IDataBase mySql) {
        this.mySql = mySql;
    }

    @Override
    public void add(Antecedant an) {
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="INSERT INTO `antecedant` (`id`,`libelle`) "
            +" VALUES (NULL,'"+an.getLibelle()+"');";
    
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
    public List<Antecedant> findAll() {
       List<Antecedant> ans= new ArrayList<>();

        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From antecedant ";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              while(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un sp

                //Ajout de la an dans la liste 
                Antecedant an= new Antecedant();
                an.setId(rs.getInt("id"));
                an.setLibelle(rs.getString("libelle"));
                ans.add(an);
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }

        return ans;
        
    }

    @Override
    public void update(Antecedant an) {
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="UPDATE `antecedant` SET `libelle` = '"+an.getLibelle()+"' WHERE `antecedant`.`id` = "+an.getId()+";";
    
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
    public void delete(Antecedant an) {
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="DELETE FROM `antecedant` Where id = "+an.getId()+";";
    
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
    public Antecedant findByLibelle(String libelle) {
        Antecedant an = null;
        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From antecedant where libelle like '"+libelle+"%'";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              if(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un sp

                //Ajout de la sp dans la liste 
                an= new Antecedant();
                an.setId(rs.getInt("id"));
                an.setLibelle(rs.getString("libelle"));
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }
        return an;
    }

    @Override
    public Antecedant findById(int id) {
        Antecedant an = null;
        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From antecedant where id ="+id;
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              if(rs.next()){

                //on recupere une ligne du resultSET qui correspond en un sp
               
                an= new Antecedant();
                an.setId(rs.getInt("id"));
                an.setLibelle(rs.getString("libelle"));
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }
        return an;
}
}