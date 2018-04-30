package Datos;

import Entidades.Horario;
import Entidades.Materia;
import Entidades.entidad;
import Excepciones.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        catch( SQLException e){
            throw new BuscarEntidadException("Error al buscar Horario", e);
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
	 
            pstm.setString(1, ((Horario)horario).getDia());
            pstm.setTime(2, ((Horario)horario).getHorarioInicio());
            pstm.setTime(3, ((Horario)horario).getHorarioFin());
            pstm.setInt(4, ((Horario)horario).getComision().getIdComision());
            pstm.setInt(5, ((Horario)horario).getMateria().getIdMateria());
            
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
            throw new CrearEntidadException("Error al crear Horario", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }
    
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
        catch( SQLException e){
            throw new BuscarEntidadesException("Error al buscar Horarios", e);
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
                    + "WHERE ( id_horario = " + ((Horario)horario).getIdHorario() + ")" ;
			
            pstm = myConn.prepareStatement(query);
				            
            pstm.setString(1, ((Horario)horario).getDia());
            pstm.setTime(2, ((Horario)horario).getHorarioInicio());
            pstm.setTime(3, ((Horario)horario).getHorarioFin());
            pstm.setInt(4, ((Horario)horario).getComision().getIdComision());
            pstm.setInt(5, ((Horario)horario).getMateria().getIdMateria());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            throw new ModificarEntidadException("Error al modificar Horario", e);
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
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            throw new EliminarEntidadException("Error al eliminar Horario", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
    
    public ArrayList<entidad> getOneHorario(int id) throws ApplicationException{
        ArrayList<entidad> horarios = new ArrayList();
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Horario WHERE ( id_comision = " + id + " )";
            
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
        catch( SQLException e){
            throw new BuscarEntidadException("Error al buscar Horario", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        
        DatoMateria datoMateria = new DatoMateria();
        for (entidad horario : horarios) {
            int idMateria = ((Horario)horario).getMateria().getIdMateria();
            ((Horario)horario).setMateria((Materia)datoMateria.getOne(idMateria));
        }
        return horarios;
    }
    
    public void deleteComision(int id, Connection myConn) throws ApplicationException {
        try {
            String query = "DELETE FROM Horario WHERE (id_comision = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

        } catch ( SQLException e) {
            throw new EliminarEntidadException("Error al eliminar Horarios de la Comision", e);
        }
    }
}
