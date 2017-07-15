/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Bedel;
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
public class DatoBedel extends dato{

    @Override
    public entidad getOne(int id) throws ApplicationException {
        Bedel bedel = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Bedel WHERE ( id_bedel = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		bedel = new Bedel(rsl.getInt("id_bedel"), rsl.getInt("id_administrador"), rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoBedel.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Bedel", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return bedel;
    }

    @Override
    public int newObject(entidad bedel) throws ApplicationException {
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Bedel(nombre, apellido, telefono, "
                    + "email, direccion, legajo, usuario, clave, id_administrador) VALUES (?,?,?,?,?,?,?,?, ?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Bedel)bedel).nombre);
            pstm.setString(2, ((Bedel)bedel).apellido);
            pstm.setString(3, ((Bedel)bedel).telefono);
            pstm.setString(4, ((Bedel)bedel).email);
            pstm.setString(5, ((Bedel)bedel).direccion);
            pstm.setString(6, ((Bedel)bedel).legajo);
            pstm.setString(7, ((Bedel)bedel).usuario);
            pstm.setString(8, ((Bedel)bedel).clave);
            pstm.setInt(9, ((Bedel)bedel).administrador.idAdministrador);
            
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
            Logger.getLogger(DatoBedel.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear Bedel", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }

    @Override
    public ArrayList<entidad> getAll() throws ApplicationException {
        
        ArrayList<entidad> bedeles = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Bedel";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Bedel bedel = new Bedel(rsl.getInt("id_bedel"), rsl.getInt("id_administrador"), rsl.getString("nombre"),
                            rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                            rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
                    bedeles.add(bedel);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoBedel.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Bedeles", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return bedeles;
    }

    @Override
    public void modify(entidad bedel) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Bedel SET nombre = ?, apellido = ?, "
                    + "telefono = ?, email = ?, direccion = ?, legajo = ?, "
                    + "usuario = ?, clave  = ? , id_administrador = ? "
                    + "WHERE ( id_bedel = " + String.valueOf(((Bedel)bedel).idBedel) + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Bedel)bedel).nombre);
            pstm.setString(2, ((Bedel)bedel).apellido);
            pstm.setString(3, ((Bedel)bedel).telefono);
            pstm.setString(4, ((Bedel)bedel).email);
            pstm.setString(5, ((Bedel)bedel).direccion);
            pstm.setString(6, ((Bedel)bedel).legajo);
            pstm.setString(7, ((Bedel)bedel).usuario);
            pstm.setString(8, ((Bedel)bedel).clave);
            pstm.setInt(9, ((Bedel)bedel).administrador.idAdministrador);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoBedel.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar Bedel", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }         

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Bedel WHERE (id_bedel = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoBedel.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar Bedel", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
    

