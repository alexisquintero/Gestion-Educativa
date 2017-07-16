/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Docente;
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
public class DatoDocente extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Docente docente = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Docente WHERE ( id_docente = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		docente = new Docente(rsl.getInt("id_docente"), rsl.getInt("id_moderador"), rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoDocente.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Docente", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return docente;
    }
    
    @Override
    public int newObject(entidad docente) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Docente(nombre, apellido, telefono, "
                    + "email, direccion, legajo, usuario, clave, id_moderador) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Docente)docente).nombre);
            pstm.setString(2, ((Docente)docente).apellido);
            pstm.setString(3, ((Docente)docente).telefono);
            pstm.setString(4, ((Docente)docente).email);
            pstm.setString(5, ((Docente)docente).direccion);
            pstm.setString(6, ((Docente)docente).legajo);
            pstm.setString(7, ((Docente)docente).usuario);
            pstm.setString(8, ((Docente)docente).clave);
            pstm.setInt(9, ((Docente)docente).moderador.idModerador);
            
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
            Logger.getLogger(DatoDocente.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear Docente", e);
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
        
        ArrayList<entidad> docentes = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Docente";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Docente docente = new Docente(rsl.getInt("id_docente"), rsl.getInt("id_moderador"), 
                            rsl.getString("nombre"), rsl.getString("apellido"), rsl.getString("telefono"), 
                            rsl.getString("email"), rsl.getString("direccion"),
                            rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
                    docentes.add(docente);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoDocente.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Docentees", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return docentes;
    }

    @Override
    public void modify(entidad docente) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Docente SET nombre = ?, apellido = ?, "
                    + "telefono = ?, email = ?, direccion = ?, legajo = ?, "
                    + "usuario = ?, clave  = ? , id_moderador = ? "
                    + "WHERE ( id_docente = " + ((Docente)docente).idDocente + ")" ; 
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Docente)docente).nombre);
            pstm.setString(2, ((Docente)docente).apellido);
            pstm.setString(3, ((Docente)docente).telefono);
            pstm.setString(4, ((Docente)docente).email);
            pstm.setString(5, ((Docente)docente).direccion);
            pstm.setString(6, ((Docente)docente).legajo);
            pstm.setString(7, ((Docente)docente).usuario);
            pstm.setString(8, ((Docente)docente).clave);
            pstm.setInt(9, ((Docente)docente).moderador.idModerador);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoDocente.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar Docente", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Docente WHERE (id_docente = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoDocente.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar Docente", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
