/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Final;
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
public class DatoFinal extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Final objFinal = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Final WHERE ( id_final = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		objFinal = new Final(rsl.getInt("id_final"),rsl.getDate("fecha"), 
                    rsl.getTime("hora_inicio"), rsl.getTime("hora_fin"), rsl.getString("aula"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Final", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return objFinal;
    }
    
    @Override
    public int newObject(entidad objFinal) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Final(nombre, apellido, telefono, "
                    + "email, direccion, legajo, usuario, clave) VALUES (?,?,?,?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Final)objFinal).nombre);
            pstm.setString(2, ((Final)objFinal).apellido);
            pstm.setString(3, ((Final)objFinal).telefono);
            pstm.setString(4, ((Final)objFinal).email);
            pstm.setString(5, ((Final)objFinal).direccion);
            pstm.setString(6, ((Final)objFinal).legajo);
            pstm.setString(7, ((Final)objFinal).usuario);
            pstm.setString(8, ((Final)objFinal).clave);
            
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
            Logger.getLogger(DatoFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear Final", e);
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
        
        ArrayList<entidad> finales = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Final";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Final objFinal = new Final(rsl.getInt("id_final"), rsl.getString("nombre"),
                            rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                            rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
                    finales.add(objFinal);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Finales", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return finales;
    }

    @Override
    public void modify(entidad objFinal) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Final SET nombre = ?, apellido = ?, "
                    + "telefono = ?, email = ?, direccion = ?, legajo = ?, "
                    + "usuario = ?, clave  = ? "
                    + "WHERE ( id_final = " + ((Final)objFinal).idFinal + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Final)objFinal).nombre);
            pstm.setString(2, ((Final)objFinal).apellido);
            pstm.setString(3, ((Final)objFinal).telefono);
            pstm.setString(4, ((Final)objFinal).email);
            pstm.setString(5, ((Final)objFinal).direccion);
            pstm.setString(6, ((Final)objFinal).legajo);
            pstm.setString(7, ((Final)objFinal).usuario);
            pstm.setString(8, ((Final)objFinal).clave);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar Final", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Final WHERE (id_final = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar Final", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
