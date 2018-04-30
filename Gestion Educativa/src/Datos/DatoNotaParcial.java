package Datos;

import Entidades.NotaParcial;
import Entidades.entidad;
import Excepciones.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatoNotaParcial extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        NotaParcial notaParcial = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Parcial_Alumno WHERE ( id_parcial = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		notaParcial = new NotaParcial(rsl.getInt("nota"), 
                    rsl.getBoolean("presencia"), rsl.getInt("id_alumno"), rsl.getInt("id_parcial"));
			
            }
        }
        catch( SQLException e){
            throw new BuscarEntidadException("Error al buscar NotaParcial", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        return notaParcial;
    }
    
    @Override
    public int newObject(entidad notaParcial) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Parcial_Alumno(nota, presencia, id_alumno, "
                    + "id_parcial) VALUES (?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setInt(1, ((NotaParcial)notaParcial).getNota());
            pstm.setBoolean(2, ((NotaParcial)notaParcial).isPresencia());
            pstm.setInt(3, ((NotaParcial)notaParcial).getAlumno().getIdAlumno());
            pstm.setInt(4, ((NotaParcial)notaParcial).getParcial().getIdParcial());
            
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
            throw new CrearEntidadException("Error al crear NotaParcial", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }
    
    @Override
    public ArrayList<entidad> getAll() throws ApplicationException{
        
        ArrayList<entidad> notaParciales = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Parcial_Alumno";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    NotaParcial notaParcial = new NotaParcial(rsl.getInt("nota"), 
                    rsl.getBoolean("presencia"), rsl.getInt("id_alumno"), rsl.getInt("id_parcial"));
                    notaParciales.add(notaParcial);
		}			
        }
        catch( SQLException e){
            throw new BuscarEntidadesException("Error al buscar NotaParciales", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return notaParciales;
    }

    @Override
    public void modify(entidad notaParcial) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Parcial_Alumno SET nota = ?, presencia = ? "
                    + "WHERE ( id_parcial = ? AND id_alumno = ?)" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setInt(1, ((NotaParcial)notaParcial).getNota());
            pstm.setBoolean(2, ((NotaParcial)notaParcial).isPresencia());            
            pstm.setInt(3, ((NotaParcial)notaParcial).getParcial().getIdParcial());
            pstm.setInt(4, ((NotaParcial)notaParcial).getAlumno().getIdAlumno());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            throw new ModificarEntidadException("Error al modificar NotaParcial", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM NotaParcial WHERE (id_notaParcial = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException(); 
            }
        } catch ( SQLException e) {
            throw new EliminarEntidadException("Error al eliminar NotaParcial", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
}
