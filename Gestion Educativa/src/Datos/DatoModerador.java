/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Moderador;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Supervisor
 */
public class DatoModerador extends dato{

    @Override
    public entidad getOne(int id) throws ApplicationException {
        Moderador moderador = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Moderador WHERE ( id_Moderador = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		moderador = new Moderador(rsl.getInt("id_Moderador"), rsl.getInt("id_administrador"),rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoModerador.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Moderador", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return moderador;
    }

    @Override
    public int newObject(entidad moderador) throws ApplicationException {
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Moderador(nombre, apellido, telefono, "
                    + "email, direccion, legajo, usuario, clave, id_administrador) "
                    + "VALUES (?,?,?,?,?,?,?,?, ?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Moderador)moderador).nombre);
            pstm.setString(2, ((Moderador)moderador).apellido);
            pstm.setString(3, ((Moderador)moderador).telefono);
            pstm.setString(4, ((Moderador)moderador).email);
            pstm.setString(5, ((Moderador)moderador).direccion);
            pstm.setString(6, ((Moderador)moderador).legajo);
            pstm.setString(7, ((Moderador)moderador).usuario);
            pstm.setString(8, ((Moderador)moderador).clave);
            pstm.setInt(9, ((Moderador)moderador).administrador.idAdministrador);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
                       
            rsl = pstm.getGeneratedKeys();  //Obtiene el id autogenerado
            if (rsl.next()) {
                id = rsl.getInt(1);  
            }              
                     	             
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoModerador.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear Moderador", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }

    @Override
    public ArrayList<entidad> getAll() throws ApplicationException {
        ArrayList<entidad> moderadores = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Moderador";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Moderador moderador = new Moderador(rsl.getInt("id_moderador"), rsl.getInt("id_administrador"), 
                            rsl.getString("nombre"), rsl.getString("apellido"), rsl.getString("telefono"), 
                            rsl.getString("email"), rsl.getString("direccion"), rsl.getString("legajo"), 
                            rsl.getString("usuario"), rsl.getString("clave"));
                    moderadores.add(moderador);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoModerador.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Moderadores", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return moderadores;
    }

    @Override
    public void modify(entidad moderador) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Moderador SET nombre = ?, apellido = ?, "
                    + "telefono = ?, email = ?, direccion = ?, legajo = ?, "
                    + "usuario = ?, clave  = ? , id_administrador = ? "
                    + "WHERE ( id_moderador = " + String.valueOf(((Moderador)moderador).idModerador) + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Moderador)moderador).nombre);
            pstm.setString(2, ((Moderador)moderador).apellido);
            pstm.setString(3, ((Moderador)moderador).telefono);
            pstm.setString(4, ((Moderador)moderador).email);
            pstm.setString(5, ((Moderador)moderador).direccion);
            pstm.setString(6, ((Moderador)moderador).legajo);
            pstm.setString(7, ((Moderador)moderador).usuario);
            pstm.setString(8, ((Moderador)moderador).clave);
            pstm.setInt(9, ((Moderador)moderador).administrador.idAdministrador);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoModerador.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar Moderador", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }            
    }   

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Moderador WHERE (id_moderador = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoModerador.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar Moderador", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}


