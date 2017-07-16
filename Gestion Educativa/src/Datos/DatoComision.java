/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Comision;
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
public class DatoComision extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Comision comision = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Comision WHERE ( id_comision = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		comision = new Comision(rsl.getInt("id_comision"),rsl.getString("aula"), 
                    rsl.getInt("cupo"), rsl.getInt("id_moderador"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Comision", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return comision;
    }
    
    @Override
    public int newObject(entidad comision) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Comision(aula, cupo, id_moderador) "
                    + "VALUES (?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Comision)comision).aula);
            pstm.setInt(2, ((Comision)comision).cupo);
            pstm.setInt(3, ((Comision)comision).moderador.idModerador);
            
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
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear Comision", e);
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
        
        ArrayList<entidad> comisiones = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Comision";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Comision comision = new Comision(rsl.getInt("id_comision"),rsl.getString("aula"), 
                        rsl.getInt("cupo"), rsl.getInt("id_moderador"));
                    comisiones.add(comision);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Comisiones", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return comisiones;
    }

    @Override
    public void modify(entidad comision) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Comision SET aula = ?, cupo = ?, "
                    + "id_moderador = ? "
                    + "WHERE ( id_comision = " + ((Comision)comision).idComision + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Comision)comision).aula);
            pstm.setInt(2, ((Comision)comision).cupo);
            pstm.setInt(3, ((Comision)comision).moderador.idModerador);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar Comision", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Comision WHERE (id_comision = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar Comision", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
