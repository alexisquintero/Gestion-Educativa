/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Carrera;
import Entidades.Materia;
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
public class DatoCarrera extends dato{

    @Override
    public entidad getOne(int id) throws ApplicationException {
        Carrera carrera = null;
        DatoMateria datoMateria = new DatoMateria();
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Carrera WHERE ( id_carrera = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		carrera = new Carrera(rsl.getInt("id_carrera"),rsl.getString("nombre"), 
                    rsl.getString("descripcion"), rsl.getInt("id_administrador"),
                    datoMateria.materiasCarrera(id, myConn));			
            }
        }
        catch( SQLException e){
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadException("Error al buscar Carrera", e);
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
	 
            pstm.setString(1, ((Carrera)carrera).getNombre());
            pstm.setString(2, ((Carrera)carrera).getDescripcion());
            pstm.setInt(3, ((Carrera)carrera).getAdministrador().getIdAdministrador());
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
                       
            rsl = pstm.getGeneratedKeys();  //Obtiene el id autogenerado
            if (rsl.next()) {
                id = rsl.getInt(1);  
            }              
                     	             
        }
        catch( SQLException e){
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new CrearEntidadException("Error al crear Carrera", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }

    @Override
    public ArrayList<entidad> getAll() throws ApplicationException {
        ArrayList<entidad> carreras = new ArrayList<>();
        DatoMateria datoMateria = new DatoMateria();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Carrera";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Carrera carrera = new Carrera(rsl.getInt("id_carrera"),rsl.getString("nombre"), 
                        rsl.getString("descripcion"), rsl.getInt("id_administrador"),
                        datoMateria.materiasCarrera(rsl.getInt("id_carrera"), myConn));
                    carreras.add(carrera);
		}			
        }
        catch( SQLException e){
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Carreras", e);
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
                    + "WHERE ( id_carrera = " + ((Carrera)carrera).getIdCarrera() + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Carrera)carrera).getNombre());
            pstm.setString(2, ((Carrera)carrera).getDescripcion());
            pstm.setInt(3, ((Carrera)carrera).getIdCarrera());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarEntidadException("Error al modificar Carrera", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Carrera WHERE (id_carrera = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            Logger.getLogger(DatoCarrera.class.getName()).log(Level.SEVERE, null, e);
            throw new EliminarEntidadException("Error al eliminar Carrera", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
    
}
