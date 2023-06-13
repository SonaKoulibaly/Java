package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Specialiste;

public class SpecialisteRepository implements ISpecialisteRepository{
    private IDataBase mySql;
 
    public SpecialisteRepository(IDataBase mySql) {
        this.mySql = mySql;
    }

    @Override
    public void add(Specialiste sp) {
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="INSERT INTO `specialiste` (`id`,`libelle`) "
            +" VALUES (NULL,'"+sp.getLibelle()+"');";
    
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
    public List<Specialiste> findAll() {
       List<Specialiste> sps= new ArrayList<>();

        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From specialiste ";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              while(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un sp

                //Ajout de la sp dans la liste 
                Specialiste sp= new Specialiste();
                sp.setId(rs.getInt("id"));
                sp.setLibelle(rs.getString("libelle"));
                sps.add(sp);
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }

        return sps;
        
    }

    @Override
    public void update(Specialiste sp) {
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="UPDATE `specialiste` SET `libelle` = '"+sp.getLibelle()+"' WHERE `specialiste`.`id` = "+sp.getId()+";";
    
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
    public void delete(Specialiste sp) {
        try {
            Connection conn= mySql.ouvrirConnexion();
            String sql ="DELETE FROM `specialiste` Where id = "+sp.getId()+";";
    
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
    public Specialiste findByLibelle(String libelle) {
        Specialiste sp = null;
        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From specialiste where libelle like '"+libelle+"%'";
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              if(rs.next()){
                //on recupere une ligne du resultSET qui correspond en un sp

                //Ajout de la sp dans la liste 
                sp= new Specialiste();
                sp.setId(rs.getInt("id"));
                sp.setLibelle(rs.getString("libelle"));
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }
        return sp;
    }

    @Override
    public Specialiste findById(int id) {
        Specialiste sp = null;
        try {
            //changement du Driver,chargement des classes de jdbc
           Connection conn=mySql.ouvrirConnexion();
              String sql="SELECT * From specialiste where id ="+id;
              Statement stmt=conn.createStatement();
              ResultSet rs=stmt.executeQuery(sql);
              //Traitement de la requette
              if(rs.next()){

                //on recupere une ligne du resultSET qui correspond en un sp
               
                sp= new Specialiste();
                sp.setId(rs.getInt("id"));
                sp.setLibelle(rs.getString("libelle"));
              }
              //traitement de la requette
              
             mySql.fermerConnexion(conn);



           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }
        return sp;
        
    }    
}
