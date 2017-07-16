/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.NotaParcial;
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
public class DatoNotaParcial extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        NotaParcial notaParcial = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Parcial_Alumno WHERE ( id_parcial = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		notaParcial = new NotaParcial(rsl.getInt("nota"), 
                    rsl.getBoolean("presencia"), rsl.getInt("id_alumno"), rsl.getInt("id_parcial"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoNotaParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar NotaParcial", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return notaParcial;
    }
    
    @Override
    public int newObject(entidad notaParcial) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Parcial_Alumno(nota, presencia, id_alumno, "
                    + "id_parcial) VALUES (?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setInt(1, ((NotaParcial)notaParcial).nota);
            pstm.setBoolean(2, ((NotaParcial)notaParcial).presencia);
            pstm.setInt(3, ((NotaParcial)notaParcial).alumno.idAlumno);
            pstm.setInt(4, ((NotaParcial)notaParcial).parcial.idParcial);
            
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
            Logger.getLogger(DatoNotaParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear NotaParcial", e);
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
        
        ArrayList<entidad> notaParciales = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Parcial_Alumno";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    NotaParcial notaParcial = new NotaParcial(rsl.getInt("nota"), 
                    rsl.getBoolean("presencia"), rsl.getInt("id_alumno"), rsl.getInt("id_parcial"));
                    notaParciales.add(notaParcial);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoNotaParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar NotaParciales", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return notaParciales;
    }

    @Override
    public void modify(entidad notaParcial) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Parcial_Alumno SET nota = ?, presencia = ? "
                    + "WHERE ( id_parcial = ? AND id_alumno = ?)" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setInt(1, ((NotaParcial)notaParcial).nota);
            pstm.setBoolean(2, ((NotaParcial)notaParcial).presencia);            
            pstm.setInt(3, ((NotaParcial)notaParcial).parcial.idParcial);
            pstm.setInt(4, ((NotaParcial)notaParcial).alumno.idAlumno);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoNotaParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar NotaParcial", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM NotaParcial WHERE (id_notaParcial = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoNotaParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar NotaParcial", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
