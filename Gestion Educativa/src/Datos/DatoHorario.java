/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Horario;
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
public class DatoHorario extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Horario horario = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Horario WHERE ( id_horario = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		horario = new Horario(rsl.getInt("id_horario"),rsl.getString("dia"), 
                    rsl.getTime("horario_inicio"), rsl.getTime("horario_fin"),
                    rsl.getInt("id_comision"), rsl.getInt("id_materia"));
			
            }
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Horario", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return horario;
    }
    
    @Override
    public int newObject(entidad horario) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Horario(dia, horario_inicio, "
                    + "horario_fin, id_comision, id_materia) VALUES (?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Horario)horario).dia);
            pstm.setTime(2, ((Horario)horario).horarioInicio);
            pstm.setTime(3, ((Horario)horario).horarioFin);
            pstm.setInt(4, ((Horario)horario).comision.idComision);
            pstm.setInt(5, ((Horario)horario).materia.idMateria);
            
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
            Logger.getLogger(DatoHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al crear Horario", e);
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
        
        ArrayList<entidad> horarios = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Horario";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Horario horario = new Horario(rsl.getInt("id_horario"),rsl.getString("dia"), 
                    rsl.getTime("horario_inicio"), rsl.getTime("horario_fin"),
                    rsl.getInt("id_comision"), rsl.getInt("id_materia"));
                    horarios.add(horario);
		}			
        }
        catch(ApplicationException | SQLException e){
            Logger.getLogger(DatoHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al buscar Horarios", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return horarios;
    }

    @Override
    public void modify(entidad horario) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Horario SET dia = ?, horario_inicio= ?, "
                    + "horario_fin = ?, id_comision = ?, id_materia = ? "
                    + "WHERE ( id_horario = " + ((Horario)horario).idHorario + ")" ;
			
            pstm = myConn.prepareStatement(query);
				            
            pstm.setString(1, ((Horario)horario).dia);
            pstm.setTime(2, ((Horario)horario).horarioInicio);
            pstm.setTime(3, ((Horario)horario).horarioFin);
            pstm.setInt(4, ((Horario)horario).comision.idComision);
            pstm.setInt(5, ((Horario)horario).materia.idMateria);
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al modificar Horario", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Horario WHERE (id_horario = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
        } catch (ApplicationException | SQLException e) {
            Logger.getLogger(DatoHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationException("Error al eliminar Horario", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
