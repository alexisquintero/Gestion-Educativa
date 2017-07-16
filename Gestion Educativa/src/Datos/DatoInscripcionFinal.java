/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.InscripcionFinal;
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
public class DatoInscripcionFinal extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        InscripcionFinal inscripcionFinal = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Inscripcion_Final WHERE ( id_inscripcionFinal = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		inscripcionFinal = new InscripcionFinal(rsl.getDate("fecha_inscripcion"), 
                        rsl.getInt("nota_practica"), rsl.getInt("nota_teoria"), 
                        rsl.getInt("nota_final"), rsl.getBoolean("presencia"), 
                        rsl.getInt("id_alumno"), rsl.getInt("id_final"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoInscripcionFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar InscripcionFinal", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return inscripcionFinal;
    }
    
    @Override
    public int newObject(entidad inscripcionFinal) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Inscripcion_Final(fecha_inscripcion, nota_practica, "
                    + "nota_teoria, nota_final, presencia, id_alumno, id_final) VALUES (?,?,?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setDate(1, ((InscripcionFinal)inscripcionFinal).fecha);
            pstm.setInt(2, ((InscripcionFinal)inscripcionFinal).notaPractica);
            pstm.setInt(3, ((InscripcionFinal)inscripcionFinal).notaTeoria);
            pstm.setInt(4, ((InscripcionFinal)inscripcionFinal).notaFinal);
            pstm.setBoolean(5, ((InscripcionFinal)inscripcionFinal).presencia);
            pstm.setInt(6, ((InscripcionFinal)inscripcionFinal).alumno.idAlumno);
            pstm.setInt(7, ((InscripcionFinal)inscripcionFinal).objFinal.idFinal);
            
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
            Logger.getLogger(DatoInscripcionFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear InscripcionFinal", e);
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
        
        ArrayList<entidad> inscripcionFinales = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Inscripcion_Final";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    InscripcionFinal inscripcionFinal = new InscripcionFinal(rsl.getDate("fecha_inscripcion"), 
                        rsl.getInt("nota_practica"), rsl.getInt("nota_teoria"), 
                        rsl.getInt("nota_final"), rsl.getBoolean("presencia"), 
                        rsl.getInt("id_alumno"), rsl.getInt("id_final"));
                    inscripcionFinales.add(inscripcionFinal);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoInscripcionFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar InscripcionFinales", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return inscripcionFinales;
    }

    @Override
    public void modify(entidad inscripcionFinal) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Inscripcion_Final SET fecha_inscripcion = ?, nota_practica = ?, "
                    + "nota_teoria = ?, nota_final = ?, presencia = ?, id_alumno = ?, "
                    + "id_final = ? "
                    + "WHERE ( fecha_inscripcion = ? AND id_final = ? AND id_alumno = ? )" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setDate(1, ((InscripcionFinal)inscripcionFinal).fecha);
            pstm.setInt(2, ((InscripcionFinal)inscripcionFinal).notaPractica);
            pstm.setInt(3, ((InscripcionFinal)inscripcionFinal).notaTeoria);
            pstm.setInt(4, ((InscripcionFinal)inscripcionFinal).notaFinal);
            pstm.setBoolean(5, ((InscripcionFinal)inscripcionFinal).presencia);
            pstm.setInt(6, ((InscripcionFinal)inscripcionFinal).alumno.idAlumno);
            pstm.setInt(7, ((InscripcionFinal)inscripcionFinal).objFinal.idFinal);
            pstm.setDate(8, ((InscripcionFinal)inscripcionFinal).fecha);
            pstm.setInt(9, ((InscripcionFinal)inscripcionFinal).objFinal.idFinal);
            pstm.setInt(10, ((InscripcionFinal)inscripcionFinal).alumno.idAlumno);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoInscripcionFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar InscripcionFinal", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Inscripcion_Final WHERE (id_inscripcionFinal = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoInscripcionFinal.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar InscripcionFinal", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
