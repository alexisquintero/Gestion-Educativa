/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Parcial;
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
public class DatoParcial extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Parcial parcial = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Parcial WHERE ( id_parcial = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		parcial = new Parcial(rsl.getInt("id_parcial"),rsl.getString("descripcion"), 
                    rsl.getDate("fecha"), rsl.getTime("horario_inicio"), rsl.getTime("horario_fin"),
                    rsl.getInt("id_horario"));
			
            }
        }
        catch( SQLException e){
            Logger.getLogger(DatoParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadException("Error al buscar Parcial", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return parcial;
    }
    
    @Override
    public int newObject(entidad parcial) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Parcial(descripcion, fecha, horario_inicio, "
                    + "horario_fin, id_horario) VALUES (?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Parcial)parcial).getDescripcion());
            pstm.setDate(2, ((Parcial)parcial).getFecha());
            pstm.setTime(3, ((Parcial)parcial).getHorarioInicio());
            pstm.setTime(4, ((Parcial)parcial).getHorarioFin());
            pstm.setInt(5, ((Parcial)parcial).getHorario().getIdHorario());
            
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
            Logger.getLogger(DatoParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new CrearEntidadException("Error al crear Parcial", e);
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
        
        ArrayList<entidad> parciales = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Parcial";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Parcial parcial = new Parcial(rsl.getInt("id_parcial"),rsl.getString("descripcion"), 
                    rsl.getDate("fecha"), rsl.getTime("horario_inicio"), rsl.getTime("horario_fin"),
                    rsl.getInt("id_horario"));
                    parciales.add(parcial);
		}			
        }
        catch( SQLException e){
            Logger.getLogger(DatoParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Parciales", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return parciales;
    }

    @Override
    public void modify(entidad parcial) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Parcial SET descripcion = ?, fecha = ?, "
                    + "horario_inicio = ?, horario_fin = ?, id_horario = ? "
                    + "WHERE ( id_parcial = " + ((Parcial)parcial).getIdParcial() + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Parcial)parcial).getDescripcion());
            pstm.setDate(2, ((Parcial)parcial).getFecha());
            pstm.setTime(3, ((Parcial)parcial).getHorarioInicio());
            pstm.setTime(4, ((Parcial)parcial).getHorarioFin());
            pstm.setInt(5, ((Parcial)parcial).getHorario().getIdHorario());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            Logger.getLogger(DatoParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarEntidadException("Error al modificar Parcial", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Parcial WHERE (id_parcial = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            Logger.getLogger(DatoParcial.class.getName()).log(Level.SEVERE, null, e);
            throw new EliminarEntidadException("Error al eliminar Parcial", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
