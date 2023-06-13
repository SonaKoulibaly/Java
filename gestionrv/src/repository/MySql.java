package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql implements IDataBase {

    @Override
    public Connection  ouvrirConnexion() {
        // TODO Auto-generated method 
        Connection conn = null;
        try {
            //changement du Driver,chargement des classes de jdbc;
            Class.forName("com.mysql.jdbc.Driver");
            //connection a la base de donnee;
             conn=
            DriverManager
            .getConnection("jdbc:mysql://localhost:3306/gestion_rendez_vous",
             "root",
            "");



        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de changement du Driver");
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de Connexion");
        }
        return conn;

    }

    @Override
    public void fermerConnexion(Connection con) {
        // TODO Auto-generated method stub
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de fermeture de la base de données");
        }
    }
    
}
