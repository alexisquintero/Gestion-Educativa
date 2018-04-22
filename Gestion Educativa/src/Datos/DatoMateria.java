/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Materia;
import Entidades.entidad;
import Excepciones.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Supervisor
 */
public class DatoMateria extends dato{

    @Override
    public entidad getOne(int id) throws ApplicationException {
        Materia materia = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Materia WHERE ( id_materia = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		materia = new Materia(rsl.getInt("id_materia"),rsl.getString("nombre"), 
                    rsl.getString("descripcion"), rsl.getDate("anio"), rsl.getBoolean("electiva"),
                    rsl.getInt("horas_semana"), rsl.getInt("id_administrador"));
		materia.setCorrelativasAprobadas(getCorrelativasAprobadas(materia, myConn));
                materia.setCorrelativasRegulares(getCorrelativasRegulares(materia, myConn));	
            }
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadException("Error al buscar Materia", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return materia;
    }

    @Override
    public int newObject(entidad materia) throws ApplicationException {
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Materia(nombre, descripcion, anio, "
                    + "electiva, horas_semana, id_administrador) VALUES (?,?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Materia)materia).getNombre());
            pstm.setString(2, ((Materia)materia).getDescripcion());
            pstm.setDate(3, ((Materia)materia).getAnio());
            pstm.setBoolean(4, ((Materia)materia).isElectiva());
            pstm.setInt(5, ((Materia)materia).getHorasSemana());
            pstm.setInt(6, ((Materia)materia).getAdministrador().getIdAdministrador());
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
                       
            rsl = pstm.getGeneratedKeys();  //Obtiene el id autogenerado
            if (rsl.next()) {
                id = rsl.getInt(1);  
            }              
            
            this.guardarCorrelativasAprobadas(id, ((Materia)materia).getCorrelativasAprobadas(), myConn);
            this.guardarCorrelativasRegulares(id, ((Materia)materia).getCorrelativasRegulares(), myConn);
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new CrearEntidadException("Error al crear Materia", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }

    @Override
    public ArrayList<entidad> getAll() throws ApplicationException {
        ArrayList<entidad> materias = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Materia";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Materia materia = new Materia(rsl.getInt("id_materia"), rsl.getString("nombre"),
                            rsl.getString("descripcion"), rsl.getDate("anio"), rsl.getBoolean("electiva"), 
                            rsl.getInt("horas_semana"), rsl.getInt("id_administrador"));
                    
                    materias.add(materia);
		}	
            for (entidad materia : materias) {
                ((Materia)materia).
                    setCorrelativasAprobadas(getCorrelativasAprobadas(materia, myConn));
                ((Materia)materia).
                    setCorrelativasRegulares(getCorrelativasRegulares(materia, myConn));
            }
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Materias", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return materias;
    }

    @Override
    public void modify(entidad materia) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Materia SET nombre = ?, descripcion = ?, "
                    + "anio = ?, electiva = ?, horas_semana = ?, id_administrador = ? "
                    + "WHERE ( id_materia = " + ((Materia)materia).getIdMateria() + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Materia)materia).getNombre());
            pstm.setString(2, ((Materia)materia).getDescripcion());
            pstm.setDate(3, ((Materia)materia).getAnio());
            pstm.setBoolean(4, ((Materia)materia).isElectiva());
            pstm.setInt(5, ((Materia)materia).getHorasSemana());
            pstm.setInt(6, ((Materia)materia).getAdministrador().getIdAdministrador());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
            
            eliminarCorrelativas(((Materia)materia).getIdMateria(), myConn);
            this.guardarCorrelativasAprobadas(((Materia)materia).getIdMateria(),
                    ((Materia)materia).getCorrelativasAprobadas(), myConn);
            this.guardarCorrelativasRegulares(((Materia)materia).getIdMateria(),
                    ((Materia)materia).getCorrelativasRegulares(), myConn);
        } catch ( SQLException e) {
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarEntidadException("Error al modificar Materia", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Materia WHERE (id_materia = ? )";
            
            pstm = myConn.prepareStatement(query);             
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
            this.eliminarCorrelativas(id, myConn);
        } catch ( SQLException e) {
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new EliminarEntidadException("Error al eliminar Materia", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
    
    public ArrayList<entidad> materiasCarrera(int id, Connection myConn) throws ApplicationException {
        ArrayList<entidad> materias = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM Materia m INNER JOIN Carrera_Materia ca "
                    + "ON m.id_materia = ca.id_materia "
                    + "WHERE id_carrera = " + id;
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Materia materia = new Materia(rsl.getInt("id_materia"), rsl.getString("nombre"),
                            rsl.getString("descripcion"), rsl.getDate("anio"), rsl.getBoolean("electiva"), 
                            rsl.getInt("horas_semana"), rsl.getInt("id_administrador"));                   
                    materias.add(materia);
		}			
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Materias de la Carrera", e);
        }       
        return materias;
    }
    
    public void guardarMateriasCarrera(int idCarrera, ArrayList<entidad> materias, Connection myConn) throws ApplicationException {       
        ArrayList<Materia> nMaterias = (ArrayList<Materia>)(ArrayList<?>)materias;
        
        try{
            eliminarMateriasCarrera(idCarrera, myConn);
            
            for (Materia nMateria : nMaterias) {
                String query = "INSERT INTO Carrera_Materia(id_carrera, id_materia)"
                        + " VALUES (?, ?)";
                pstm = myConn.prepareStatement(query);
               
                pstm.setInt(1, idCarrera);
                pstm.setInt(2, nMateria.getIdMateria());
                
                pstm.executeUpdate();
            }			
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al actualizar Materias de la Carrera", e);
        }      
    }
    
    public void eliminarMateriasCarrera(int idCarrera, Connection myConn) throws ApplicationException {       
        try{
            String query = "DELETE FROM Carrera_Materia "
                    + "WHERE (id_carrera = ?)";

            pstm = myConn.prepareStatement(query);

            pstm.setInt(1, idCarrera);

            pstm.executeUpdate();           			
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al eliminar Materias de la Carrera", e);
        }   
    }
    
    public ArrayList<entidad> getCorrelativasAprobadas(entidad materia, Connection myConn) throws ApplicationException {
        ArrayList<entidad> aprobadas = new ArrayList<>();
        int id = ((Materia)materia).getIdMateria();
        
        try{
            String query = "SELECT * FROM Correlativa c INNER JOIN Materia m "
                    + "ON c.id_materia_correlativa = m.id_materia "
                    + "WHERE (c.id_materia = " + id + ") AND "
                    + "(c.tipo_correlativa = '" + "Aprobada" + "')";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Materia m = new Materia(rsl.getInt("id_materia_correlativa"), rsl.getString("nombre"),
                            rsl.getString("descripcion"), rsl.getDate("anio"), rsl.getBoolean("electiva"), 
                            rsl.getInt("horas_semana"), rsl.getInt("id_administrador"));
                    aprobadas.add(m);
		}			
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Materias Correlativas Aprobadas de la Materia", e);
        }
      
        return aprobadas;
    }
    
    public ArrayList<entidad> getCorrelativasRegulares(entidad materia, Connection myConn) throws ApplicationException {
        ArrayList<entidad> regulares = new ArrayList<>();
        int id = ((Materia)materia).getIdMateria();
        
        try{
            String query = "SELECT * FROM Correlativa c INNER JOIN Materia m "
                    + "ON c.id_materia_correlativa = m.id_materia "
                    + "WHERE (c.id_materia = " + id + ") AND "
                    + "(c.tipo_correlativa = '" + "Regular" + "')";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Materia m = new Materia(rsl.getInt("id_materia_correlativa"), rsl.getString("nombre"),
                            rsl.getString("descripcion"), rsl.getDate("anio"), rsl.getBoolean("electiva"), 
                            rsl.getInt("horas_semana"), rsl.getInt("id_administrador"));
                    regulares.add(m);
		}			
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Materias Correlativas Aprobadas de la Materia", e);
        }
        return regulares;
    }
    
    public void eliminarCorrelativas(int id, Connection myConn) throws ApplicationException {
        try{
            String query = "DELETE FROM Correlativa "
                    + "WHERE (id_materia = ?)";

            pstm = myConn.prepareStatement(query);

            pstm.setInt(1, id);

            pstm.executeUpdate();           			
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al eliminar Correlativas de la Materia", e);
        }
    }
    
    public void guardarCorrelativasAprobadas(int id, ArrayList<entidad> aprobadas, Connection myConn) throws ApplicationException {
        ArrayList<Materia> ap = (ArrayList<Materia>)(ArrayList<?>)aprobadas;
        
        try{
            
            for (Materia nMateria : ap) {
                String query = "INSERT INTO Correlativa(id_materia, "
                        + "id_materia_correlativa, tipo_correlativa)"
                        + " VALUES (?, ?, ?)";
                pstm = myConn.prepareStatement(query);
               
                pstm.setInt(1, id);
                pstm.setInt(2, nMateria.getIdMateria());
                pstm.setString(3, "Aprobada");
                
                pstm.executeUpdate();
            }			
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al actualizar Correlativas Aprobadas de la Materia", e);
        }
    }
    
    public void guardarCorrelativasRegulares(int id, ArrayList<entidad> regulares, Connection myConn) throws ApplicationException {
        ArrayList<Materia> re = (ArrayList<Materia>)(ArrayList<?>)regulares;
        
        try{        
            
            for (Materia nMateria : re) {
                String query = "INSERT INTO Correlativa(id_materia, "
                        + "id_materia_correlativa, tipo_correlativa)"
                        + " VALUES (?, ?, ?)";
                pstm = myConn.prepareStatement(query);
               
                pstm.setInt(1, id);
                pstm.setInt(2, nMateria.getIdMateria());
                pstm.setString(3, "Regular");
                
                pstm.executeUpdate();
            }			
        }
        catch( SQLException e){
            Logger.getLogger(DatoMateria.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al actualizar Correlativas Regulares de la Materia", e);
        }
    }
}
