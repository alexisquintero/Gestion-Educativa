/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Administrador;
import Entidades.Carrera;
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
public class DatoCarrera extends dato{

    @Override
    public entidad getOne(int id) throws ApplicationException {
        Carrera carrera = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Carrera WHERE ( id_carrera = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		carrera = new Carrera(rsl.getInt("id_carrera"),rsl.getString("nombre"), 
                    rsl.getString("descripcion"), rsl.getInt("id_administrador"));			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Carrera", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return carrera;
    }

    @Override
    public int newObject(entidad carrera) throws ApplicationException {
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Carrera(nombre, descripcion, id_administrador) "
                    + "VALUES (?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Carrera)carrera).nombre);
            pstm.setString(2, ((Carrera)carrera).descripcion);
            pstm.setInt(3, ((Carrera)carrera).administrador.idAdministrador);
            
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
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear Carrera", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }

    @Override
    public ArrayList<entidad> getAll() throws ApplicationException {
        ArrayList<entidad> carreras = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Carrera";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Carrera carrera = new Carrera(rsl.getInt("id_carrera"),rsl.getString("nombre"), 
                        rsl.getString("descripcion"), rsl.getInt("id_administrador"));
                    carreras.add(carrera);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Carreras", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return carreras;
    }

    @Override
    public void modify(entidad carrera) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Carrera SET nombre = ?, descripcion = ?, "
                    + "id_administrador = ? "
                    + "WHERE ( id_carrera = " + String.valueOf(((Carrera)carrera).idCarrera) + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Carrera)carrera).nombre);
            pstm.setString(2, ((Carrera)carrera).descripcion);
            pstm.setInt(3, ((Carrera)carrera).idCarrera);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar Carrera", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
    
}
