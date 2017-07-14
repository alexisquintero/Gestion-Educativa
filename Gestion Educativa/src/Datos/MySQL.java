/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.ApplicationException;

/**
 *
 * @author Supervisor
 */
public class MySQL {
    private static MySQL instance = null;

    public static MySQL getInstance() 
    {
	if(instance == null) 
        {
            instance = new MySQL();
        }		
        return instance;		
    }
	 
    public static Connection Connect() throws ApplicationException
    {   

    Connection conn = null;
			
    String url = "jdbc:sqlserver://localhost:1433;databaseName=GestionEducativa";
    String user = "Java";
    String password = "Java";
//TODO: Usar la url, user y password desde un .ini
		 
    try 
    {	
        conn = DriverManager.getConnection(url, user, password);
    }
    catch (SQLException e) 
    {
        e.printStackTrace();
	throw new ApplicationException("Error al conectarse a la base de datos", e);
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
        catch (Exception e) 
        {
            e.printStackTrace();
            throw new ApplicationException("Error al cerrar la conexión a la base de datos", e);
        }
    }
}
