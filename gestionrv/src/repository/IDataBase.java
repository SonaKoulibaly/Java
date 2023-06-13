package repository;

import java.sql.Connection;

public interface IDataBase {
    
    public Connection ouvrirConnexion();

    public void fermerConnexion(Connection con);
}
