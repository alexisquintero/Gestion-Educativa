/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.InscripcionHorario;
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
public class DatoInscripcionHorario extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        InscripcionHorario inscripcionHorario = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Inscripcion_Horario WHERE ( id_inscripcionHorario = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		inscripcionHorario = new InscripcionHorario(rsl.getDate("fecha"),rsl.getInt("id_horario"), 
                    rsl.getInt("id_alumno"));
			
            }
        }
        catch( SQLException e){
            Logger.getLogger(DatoInscripcionHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadException("Error al buscar InscripcionHorario", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return inscripcionHorario;
    }
    
    @Override
    public int newObject(entidad inscripcionHorario) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Inscripcion_Horario(fecha, id_horario, id_alumno) "
                    + "VALUES (?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setDate(1, ((InscripcionHorario)inscripcionHorario).getFecha());
            pstm.setInt(2, ((InscripcionHorario)inscripcionHorario).getHorario().getIdHorario());
            pstm.setInt(3, ((InscripcionHorario)inscripcionHorario).getAlumno().getIdAlumno());
            
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
            Logger.getLogger(DatoInscripcionHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new CrearEntidadException("Error al crear InscripcionHorario", e);
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
        
        ArrayList<entidad> inscripcionHorarios = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Inscripcion_Horario";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    InscripcionHorario inscripcionHorario = new InscripcionHorario(rsl.getDate("fecha"),rsl.getInt("id_horario"), 
                    rsl.getInt("id_alumno"));
                    inscripcionHorarios.add(inscripcionHorario);
		}			
        }
        catch( SQLException e){
            Logger.getLogger(DatoInscripcionHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar InscripcionHorarios", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return inscripcionHorarios;
    }

    @Override
    public void modify(entidad inscripcionHorario) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Inscripcion_Horario SET fecha = ?, id_horario = ?, "
                    + "id_alumno = ? "
                    + "WHERE ( id_inscripcionHorario = ? )" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setDate(1, ((InscripcionHorario)inscripcionHorario).getFecha());
            pstm.setInt(2, ((InscripcionHorario)inscripcionHorario).getHorario().getIdHorario());
            pstm.setInt(3, ((InscripcionHorario)inscripcionHorario).getAlumno().getIdAlumno());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            Logger.getLogger(DatoInscripcionHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarEntidadException("Error al modificar InscripcionHorario", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Inscripcion_Horario WHERE (id_inscripcionHorario = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            Logger.getLogger(DatoInscripcionHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new EliminarEntidadException("Error al eliminar InscripcionHorario", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
