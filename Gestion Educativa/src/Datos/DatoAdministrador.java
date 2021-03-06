package Datos;

import Entidades.Administrador;
import Entidades.entidad;
import Excepciones.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatoAdministrador extends dato{
    
    @Override
    public entidad getOne(int id) throws ApplicationException{
        Administrador administrador = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Administrador WHERE ( id_administrador = " + id + " )";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		administrador = new Administrador(rsl.getInt("id_administrador"),rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
			
            }
        }
        catch(SQLException e){
            throw new BuscarEntidadException("Error al buscar Administrador", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }        
        return administrador;
    }
    
    @Override
    public int newObject(entidad administrador) throws ApplicationException{
        int id = 0;
        try{
            myConn = Sql.Connect(); 
            String query = "INSERT INTO Administrador(nombre, apellido, telefono, "
                    + "email, direccion, legajo, usuario, clave) VALUES (?,?,?,?,?,?,?,?)";
            pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 
            pstm.setString(1, ((Administrador)administrador).getNombre());
            pstm.setString(2, ((Administrador)administrador).getApellido());
            pstm.setString(3, ((Administrador)administrador).getTelefono());
            pstm.setString(4, ((Administrador)administrador).getEmail());
            pstm.setString(5, ((Administrador)administrador).getDireccion());
            pstm.setString(6, ((Administrador)administrador).getLegajo());
            pstm.setString(7, ((Administrador)administrador).getUsuario());
            pstm.setString(8, ((Administrador)administrador).getClave());
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException();
            }
                       
            rsl = pstm.getGeneratedKeys();  //Obtiene el id autogenerado
            if (rsl.next()) {
                id = rsl.getInt(1);  
            }              
                     	             
        }
        catch(SQLException e){
            throw new CrearEntidadException("Error al crear Administrador", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);
        }
        return id;
    }
    
    @Override
    public ArrayList<entidad> getAll() throws ApplicationException{
        
        ArrayList<entidad> administradores = new ArrayList<>();
        
        try{
            myConn = Sql.Connect();
            String query = "SELECT * FROM Administrador";
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
            
            rsl = stm.executeQuery(query);
		while(rsl.next()){
                    Administrador administrador = new Administrador(rsl.getInt("id_administrador"), rsl.getString("nombre"),
                            rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                            rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
                    administradores.add(administrador);
		}			
        }
        catch(SQLException e){
            throw new BuscarEntidadesException("Error al buscar Administradores", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);    
        }        
        return administradores;
    }

    @Override
    public void modify(entidad administrador) throws ApplicationException{
        try {
            myConn = Sql.Connect();
            String query = "UPDATE Administrador SET nombre = ?, apellido = ?, "
                    + "telefono = ?, email = ?, direccion = ?, legajo = ?, "
                    + "usuario = ?, clave  = ? "
                    + "WHERE ( id_administrador = " + ((Administrador)administrador).getIdAdministrador() + ")" ;
			
            pstm = myConn.prepareStatement(query);
				
            pstm.setString(1, ((Administrador)administrador).getNombre());
            pstm.setString(2, ((Administrador)administrador).getApellido());
            pstm.setString(3, ((Administrador)administrador).getTelefono());
            pstm.setString(4, ((Administrador)administrador).getEmail());
            pstm.setString(5, ((Administrador)administrador).getDireccion());
            pstm.setString(6, ((Administrador)administrador).getLegajo());
            pstm.setString(7, ((Administrador)administrador).getUsuario());
            pstm.setString(8, ((Administrador)administrador).getClave());
			 
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException();
            }
        } catch (SQLException e) {
            throw new ModificarEntidadException("Error al modificar Administrador", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }          

    @Override
    public void delete(int id) throws ApplicationException {
        try {
            myConn = Sql.Connect();
            String query = "DELETE FROM Administrador WHERE (id_administrador = ? )";
            
            pstm = myConn.prepareStatement(query); 
            pstm.setInt(1, id);
            
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new RowsAffectedException();
            }
        } catch (SQLException e) {
            throw new EliminarEntidadException("Error al eliminar Administrador", e);
        }
        finally {
            Sql.Close(rsl, stm, myConn);    
        }
    }
    
    public entidad login(String usuario, String contrasenia) throws ApplicationException{
        Administrador administrador = null;
        try{
            myConn = Sql.Connect(); 
            String query = "SELECT * FROM Administrador WHERE "
                    + "( usuario = '" + usuario + "' AND clave = '" + contrasenia + "')";
            
            pstm = myConn.prepareStatement(query);
            stm = myConn.createStatement();
			 
            rsl = stm.executeQuery(query);
            while(rsl.next()){
		administrador = new Administrador(rsl.getInt("id_administrador"),rsl.getString("nombre"), 
                    rsl.getString("apellido"), rsl.getString("telefono"), rsl.getString("email"), rsl.getString("direccion"),
                    rsl.getString("legajo"), rsl.getString("usuario"), rsl.getString("clave"));
			
            }
        }
        catch(SQLException e){
            throw new LoginException("Error al realizar el login de Administrador", e);
        }
        finally{
            Sql.Close(rsl, stm, myConn);      
        }
        if(administrador == null) throw new LoginException();
        return administrador;
    }
}
