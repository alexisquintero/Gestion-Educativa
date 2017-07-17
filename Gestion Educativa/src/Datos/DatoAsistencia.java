/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Asistencia;
import Entidades.entidad;
import Excepciones.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Supervisor
 */
public class DatoAsistencia extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{  //No funciona y no hay razón para hacerlo funcionar
        Asistencia asistencia = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Asistencia WHERE ( id_asistencia = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		asistencia = new Asistencia(rsl.getDate("fecha"),rsl.getBoolean("presencia"), 
                    rsl.getInt("id_bedel"), rsl.getInt("id_alumno"));
			
            }
        }
        catch( SQLException e){
            Logger.getLogger(DatoAsistencia.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadException("Error al buscar Asistencia", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return asistencia;
    }
    
    @Override
    public int newObject(entidad asistencia) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Asistencia(fecha, presencia, id_bedel, "
                    + "id_alumno, id_horario) VALUES (?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setDate(1, ((Asistencia)asistencia).fecha);
            pstm.setBoolean(2, ((Asistencia)asistencia).presencia);
            pstm.setInt(3, ((Asistencia)asistencia).bedel.idBedel);
            pstm.setInt(4, ((Asistencia)asistencia).alumno.idAlumno);
            pstm.setInt(5, ((Asistencia)asistencia).horario.idHorario);
            
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
            Logger.getLogger(DatoAsistencia.class.getName()).log(Level.SEVERE, null, e);
            throw new CrearEntidadException("Error al crear Asistencia", e);
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
        
        ArrayList<entidad> asistencias = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Asistencia";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Asistencia asistencia = new Asistencia(rsl.getDate("fecha"),rsl.getBoolean("presencia"), 
                    rsl.getInt("id_bedel"), rsl.getInt("id_alumno"), rsl.getInt("id_horario"));
                    asistencias.add(asistencia);
		}			
        }
        catch( SQLException e){
            Logger.getLogger(DatoAsistencia.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Asistencias", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return asistencias;
    }

    @Override
    public void modify(entidad asistencia) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Asistencia SET fecha = ?, presencia = ?, "
                    + "id_bedel = ?, id_alumno = ? , id_horario = ? "
                    + "WHERE ( fecha = ? AND id_alumno = ?)" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setDate(1, (Date) ((Asistencia)asistencia).fecha);
            pstm.setBoolean(2, ((Asistencia)asistencia).presencia);
            pstm.setInt(3, ((Asistencia)asistencia).bedel.idBedel);
            pstm.setInt(4, ((Asistencia)asistencia).alumno.idAlumno);
            pstm.setInt(5, ((Asistencia)asistencia).horario.idHorario);
            pstm.setDate(6, (Date) ((Asistencia)asistencia).fecha);
            pstm.setInt(7, ((Asistencia)asistencia).alumno.idAlumno);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            Logger.getLogger(DatoAsistencia.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarEntidadException("Error al modificar Asistencia", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {    //No funciona y no hay razón para hacerlo funcionar
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Asistencia WHERE (id_asistencia = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            Logger.getLogger(DatoAsistencia.class.getName()).log(Level.SEVERE, null, e);
            throw new EliminarEntidadException("Error al eliminar Asistencia", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
