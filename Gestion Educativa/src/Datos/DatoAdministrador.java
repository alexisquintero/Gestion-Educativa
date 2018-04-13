/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Administrador;
import Entidades.entidad;
import Excepciones.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Supervisor
 */
public class DatoAdministrador extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Administrador administrador = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Administrador WHERE ( id_administrador = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		administrador = new Administrador(rsl.getInt("id_administrador"),rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
			
            }
        }
        catch(SQLException e){
            Logger.getLogger(DatoAdministrador.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadException("Error al buscar Administrador", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }        
        return administrador;
    }
    
    @Override
    public int newObject(entidad administrador) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Administrador(nombre, apellido, telefono, "
                    + "email, direccion, legajo, usuario, clave) VALUES (?,?,?,?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Administrador)administrador).nombre);
            pstm.setString(2, ((Administrador)administrador).apellido);
            pstm.setString(3, ((Administrador)administrador).telefono);
            pstm.setString(4, ((Administrador)administrador).email);
            pstm.setString(5, ((Administrador)administrador).direccion);
            pstm.setString(6, ((Administrador)administrador).legajo);
            pstm.setString(7, ((Administrador)administrador).usuario);
            pstm.setString(8, ((Administrador)administrador).clave);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException();
            }
                       
            rsl = pstm.getGeneratedKeys();  //Obtiene el id autogenerado
            if (rsl.next()) {
                id = rsl.getInt(1);  
            }              
                     	             
        }
        catch(SQLException e){
            Logger.getLogger(DatoAdministrador.class.getName()).log(Level.SEVERE, null, e);
            throw new CrearEntidadException("Error al crear Administrador", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }
    
        /**
     *
     * @return
     * @throws ApplicationException
     */
    @Override
    public ArrayList<entidad> getAll() throws ApplicationException{
        
        ArrayList<entidad> administradores = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Administrador";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Administrador administrador = new Administrador(rsl.getInt("id_administrador"), rsl.getString("nombre"),
                            rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                            rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
                    administradores.add(administrador);
		}			
        }
        catch(SQLException e){
            Logger.getLogger(DatoAdministrador.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Administradores", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return administradores;
    }

    @Override
    public void modify(entidad administrador) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Administrador SET nombre = ?, apellido = ?, "
                    + "telefono = ?, email = ?, direccion = ?, legajo = ?, "
                    + "usuario = ?, clave  = ? "
                    + "WHERE ( id_administrador = " + ((Administrador)administrador).idAdministrador + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Administrador)administrador).nombre);
            pstm.setString(2, ((Administrador)administrador).apellido);
            pstm.setString(3, ((Administrador)administrador).telefono);
            pstm.setString(4, ((Administrador)administrador).email);
            pstm.setString(5, ((Administrador)administrador).direccion);
            pstm.setString(6, ((Administrador)administrador).legajo);
            pstm.setString(7, ((Administrador)administrador).usuario);
            pstm.setString(8, ((Administrador)administrador).clave);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException();
            }
        } catch (SQLException e) {
            Logger.getLogger(DatoAdministrador.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarEntidadException("Error al modificar Administrador", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Administrador WHERE (id_administrador = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException();
            }
        } catch (SQLException e) {
            Logger.getLogger(DatoAdministrador.class.getName()).log(Level.SEVERE, null, e);
            throw new EliminarEntidadException("Error al eliminar Administrador", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
    
    public entidad login(String usuario, String contrasenia) throws ApplicationException{
        Administrador administrador = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Administrador WHERE "
                    + "( usuario = '" + usuario + "' AND clave = '" + contrasenia + "')";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		administrador = new Administrador(rsl.getInt("id_administrador"),rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
			
            }
        }
        catch(SQLException e){
            Logger.getLogger(DatoAdministrador.class.getName()).log(Level.SEVERE, null, e);
            throw new LoginException("Error al realizar el login de Administrador", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        if(administrador == null) throw new LoginException();
        return administrador;
    }
}
