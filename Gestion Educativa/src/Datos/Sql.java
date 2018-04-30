package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.*;

public class Sql {
    private static Sql instance = null;

    public static Sql getInstance() 
    {
	if(instance == null) 
        {
            instance = new Sql();
        }		
        return instance;		
    }
	 
    public static Connection Connect() throws ApplicationException
    {   

    Connection conn = null;
	
    //Local
    String url = "jdbc:sqlserver://localhost:1433;databaseName=GestionEducativa";
    String user = "Java";
    String password = "Java";
    //TODO: Usar la url, user y password desde un .ini/.properties
    
    String connString = "jdbc:sqlserver://gestioneducativa.database.windows.net:1433;"
        + "database=GestionEducativa;"
        + "user=Java@gestioneducativa;"
        + "password=GEAzure1;"
        + "encrypt=true;"
        + "trustServerCertificate=false;"
        + "hostNameInCertificate=*.database.windows.net;"
        + "loginTimeout=30;";
		 
    try 
    {	
        conn = DriverManager.getConnection(connString); //Azure
        //conn = DriverManager.getConnection(url, user, password);  //Local
    }
    catch (SQLException e) 
    {
	throw new ConnectSqlException(e);
    }

        return conn;
    }

	 
    public static void Close(ResultSet resultSet, Statement statement, Connection connect) throws ApplicationException
    {
        try 
        {
            if (resultSet != null) 
            {
                resultSet.close();
            }
            if (statement != null) 
            {
                statement.close();
            }
            if (connect != null) 
            {
                connect.close();
            }
        } 
        catch (SQLException e) 
        {
            throw new CerrarConexionException(e);
        }
    }
}
