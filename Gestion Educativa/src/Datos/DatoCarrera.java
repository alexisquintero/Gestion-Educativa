package Datos;

import Entidades.Carrera;
import Entidades.entidad;
import Excepciones.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatoCarrera extends dato{

    @Override
    public entidad getOne(int id) throws ApplicationException {
        Carrera carrera = null;
        DatoMateria datoMateria = new DatoMateria();
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Carrera WHERE ( id_carrera = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		carrera = new Carrera(rsl.getInt("id_carrera"),rsl.getString("nombre"), 
                    rsl.getString("descripcion"), rsl.getInt("id_administrador"),
                    datoMateria.materiasCarrera(id, myConn));			
            }
        }
        catch( SQLException e){
            throw new BuscarEntidadException("Error al buscar Carrera", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return carrera;
    }

    @Override
    public int newObject(entidad carrera) throws ApplicationException {
        int id = 0;
        DatoMateria datoMateria = new DatoMateria();
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Carrera(nombre, descripcion, id_administrador) "
                    + "VALUES (?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Carrera)carrera).getNombre());
            pstm.setString(2, ((Carrera)carrera).getDescripcion());
            pstm.setInt(3, ((Carrera)carrera).getAdministrador().getIdAdministrador());
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
                       
            rsl = pstm.getGeneratedKeys();  //Obtiene el id autogenerado
            if (rsl.next()) {
                id = rsl.getInt(1);  
            }              
            datoMateria.guardarMateriasCarrera(((Carrera)carrera).getIdCarrera(), 
                ((Carrera)carrera).getMaterias(), myConn);
        }
        catch( SQLException e){
            throw new CrearEntidadException("Error al crear Carrera", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }

    @Override
    public ArrayList<entidad> getAll() throws ApplicationException {
        ArrayList<entidad> carreras = new ArrayList<>();
        DatoMateria datoMateria = new DatoMateria();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Carrera";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    int id = rsl.getInt("id_carrera");
                    Carrera carrera = new Carrera(id,rsl.getString("nombre"), 
                        rsl.getString("descripcion"), rsl.getInt("id_administrador"),
                        datoMateria.materiasCarrera(id, myConn));
                    carreras.add(carrera);
		}	   
        }
        catch( SQLException e){
            throw new BuscarEntidadesException("Error al buscar Carreras", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return carreras;
    }

    @Override
    public void modify(entidad carrera) throws ApplicationException {
        DatoMateria datoMateria = new DatoMateria();
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Carrera SET nombre = ?, descripcion = ?, "
                    + "id_administrador = ? "
                    + "WHERE ( id_carrera = " + ((Carrera)carrera).getIdCarrera() + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Carrera)carrera).getNombre());
            pstm.setString(2, ((Carrera)carrera).getDescripcion());
            pstm.setInt(3, ((Carrera)carrera).getAdministrador().getIdAdministrador());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
            
            datoMateria.guardarMateriasCarrera(((Carrera)carrera).getIdCarrera(), 
                    ((Carrera)carrera).getMaterias(), myConn);
        } catch ( SQLException e) {
            throw new ModificarEntidadException("Error al modificar Carrera", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }

    @Override
    public void delete(int id) throws ApplicationException {
        //DatoMateria datoMateria = new DatoMateria();
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Carrera WHERE (id_carrera = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
            
            //datoMateria.eliminarMateriasCarrera(id, myConn);
        } catch ( SQLException e) {
            throw new EliminarEntidadException("Error al eliminar Carrera", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}	   
