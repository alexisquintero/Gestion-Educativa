/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Comision;
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
public class DatoComision extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Comision comision = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Comision WHERE ( id_comision = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		comision = new Comision(rsl.getInt("id_comision"),rsl.getString("aula"), 
                    rsl.getInt("cupo"), rsl.getInt("id_moderador"));
			
            }
        }
        catch( SQLException e){
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadException("Error al buscar Comision", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        
        if(null != comision){
            DatoHorario datoHorario = new DatoHorario();
            comision.setHorarios(datoHorario.getOneHorario(comision.getIdComision()));
        }
        
        return comision;
    }
    
    @Override
    public int newObject(entidad comision) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Comision(aula, cupo, id_moderador) "
                    + "VALUES (?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Comision)comision).getAula());
            pstm.setInt(2, ((Comision)comision).getCupo());
            pstm.setInt(3, ((Comision)comision).getModerador().getIdModerador());
            
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
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new CrearEntidadException("Error al crear Comision", e);
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
        
        ArrayList<entidad> comisiones = new ArrayList<>();
        
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Comision";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Comision comision = new Comision(rsl.getInt("id_comision"),rsl.getString("aula"), 
                        rsl.getInt("cupo"), rsl.getInt("id_moderador"));
                    comisiones.add(comision);
		}			
        }
        catch( SQLException e){
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new BuscarEntidadesException("Error al buscar Comisiones", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }      
        DatoHorario datoHorario = new DatoHorario();
        for (entidad comision : comisiones) {
            ((Comision)comision)
                .setHorarios(datoHorario.getOneHorario(
                    ((Comision)comision).getIdComision()));    
        }
        return comisiones;
    }

    @Override
    public void modify(entidad comision) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Comision SET aula = ?, cupo = ?, "
                    + "id_moderador = ? "
                    + "WHERE ( id_comision = " + ((Comision)comision).getIdComision() + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Comision)comision).getAula());
            pstm.setInt(2, ((Comision)comision).getCupo());
            pstm.setInt(3, ((Comision)comision).getModerador().getIdModerador());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
            
            DatoHorario datoHorario = new DatoHorario();
            datoHorario.deleteComision(((Comision)comision).getIdComision(), myConn);
        } catch ( SQLException e) {
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarEntidadException("Error al modificar Comision", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
        DatoHorario datoHorario = new DatoHorario();
        for (entidad horario : ((Comision)comision).getHorarios()) {
            datoHorario.newObject(horario);
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Comision WHERE (id_comision = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
            
            DatoHorario datoHorario = new DatoHorario();
            datoHorario.deleteComision(id, myConn);
        } catch ( SQLException e) {
            Logger.getLogger(DatoComision.class.getName()).log(Level.SEVERE, null, e);
            throw new EliminarEntidadException("Error al eliminar Comision", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
