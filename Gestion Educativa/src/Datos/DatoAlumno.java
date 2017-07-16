/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Alumno;
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
public class DatoAlumno extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Alumno alumno = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Alumno WHERE ( id_alumno = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		alumno = new Alumno(rsl.getInt("id_alumno"), rsl.getInt("id_moderador"), 
                    rsl.getInt("id_carrera"), rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), 
                    rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoAlumno.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Alumno", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return alumno;
    }
    
    @Override
    public int newObject(entidad alumno) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Alumno(nombre, apellido, telefono, "
                    + "email, direccion, legajo, usuario, clave, id_moderador, id_carrera) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Alumno)alumno).nombre);
            pstm.setString(2, ((Alumno)alumno).apellido);
            pstm.setString(3, ((Alumno)alumno).telefono);
            pstm.setString(4, ((Alumno)alumno).email);
            pstm.setString(5, ((Alumno)alumno).direccion);
            pstm.setString(6, ((Alumno)alumno).legajo);
            pstm.setString(7, ((Alumno)alumno).usuario);
            pstm.setString(8, ((Alumno)alumno).clave);
            pstm.setInt(9, ((Alumno)alumno).moderador.idModerador);
            pstm.setInt(10, ((Alumno)alumno).carrera.idCarrera);
            
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
            Logger.getLogger(DatoAlumno.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear Alumno", e);
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
        
        ArrayList<entidad> alumnos = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Alumno";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Alumno alumno = new Alumno(rsl.getInt("id_alumno"), rsl.getInt("id_moderador"), 
                    rsl.getInt("id_carrera"), rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), 
                    rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
                    alumnos.add(alumno);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoAlumno.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Alumnoes", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return alumnos;
    }

    @Override
    public void modify(entidad alumno) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Alumno SET nombre = ?, apellido = ?, "
                    + "telefono = ?, email = ?, direccion = ?, legajo = ?, "
                    + "usuario = ?, clave  = ? , id_moderador = ?, id_carrera = ? "
                    + "WHERE ( id_alumno = " + ((Alumno)alumno).idAlumno + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Alumno)alumno).nombre);
            pstm.setString(2, ((Alumno)alumno).apellido);
            pstm.setString(3, ((Alumno)alumno).telefono);
            pstm.setString(4, ((Alumno)alumno).email);
            pstm.setString(5, ((Alumno)alumno).direccion);
            pstm.setString(6, ((Alumno)alumno).legajo);
            pstm.setString(7, ((Alumno)alumno).usuario);
            pstm.setString(8, ((Alumno)alumno).clave);
            pstm.setInt(9, ((Alumno)alumno).moderador.idModerador);
            pstm.setInt(10, ((Alumno)alumno).carrera.idCarrera);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoAlumno.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar Alumno", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Alumno WHERE (id_alumno = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoAlumno.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar Alumno", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
