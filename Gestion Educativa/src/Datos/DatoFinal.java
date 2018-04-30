package Datos;

import Entidades.Final;
import Entidades.entidad;
import Excepciones.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatoFinal extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Final objFinal = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Final WHERE ( id_final = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		objFinal = new Final(rsl.getInt("id_final"),rsl.getDate("fecha"), 
                    rsl.getTime("horario_inicio"), rsl.getTime("horario_fin"), 
                    rsl.getString("aula"), rsl.getInt("id_materia"));
			
            }
        }
        catch( SQLException e){
            throw new BuscarEntidadException("Error al buscar Final", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return objFinal;
    }
    
    @Override
    public int newObject(entidad objFinal) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Final(fecha, horario_inicio, horario_fin, "
                    + "aula, id_materia) VALUES (?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setDate(1, ((Final)objFinal).getFecha());
            pstm.setTime(2, ((Final)objFinal).getHorarioInicio());
            pstm.setTime(3, ((Final)objFinal).getHorarioFin());
            pstm.setString(4, ((Final)objFinal).getAula());
            pstm.setInt(5, ((Final)objFinal).getMateria().getIdMateria());
            
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
            throw new CrearEntidadException("Error al crear Final", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }
    
    @Override
    public ArrayList<entidad> getAll() throws ApplicationException{
        
        ArrayList<entidad> finales = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Final";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Final objFinal = new Final(rsl.getInt("id_final"),rsl.getDate("fecha"), 
                    rsl.getTime("horario_inicio"), rsl.getTime("horario_fin"), 
                    rsl.getString("aula"), rsl.getInt("id_materia"));
                    finales.add(objFinal);
		}			
        }
        catch( SQLException e){
            throw new BuscarEntidadesException("Error al buscar Finales", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return finales;
    }

    @Override
    public void modify(entidad objFinal) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Final SET fecha = ?, horario_inicio = ?, "
                    + "horario_fin = ?, aula = ?, id_materia = ? "
                    + "WHERE ( id_final = " + ((Final)objFinal).getIdFinal() + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setDate(1, ((Final)objFinal).getFecha());
            pstm.setTime(2, ((Final)objFinal).getHorarioInicio());
            pstm.setTime(3, ((Final)objFinal).getHorarioFin());
            pstm.setString(4, ((Final)objFinal).getAula());
            pstm.setInt(5, ((Final)objFinal).getMateria().getIdMateria());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            throw new ModificarEntidadException("Error al modificar Final", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Final WHERE (id_final = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            throw new EliminarEntidadException("Error al eliminar Final", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
