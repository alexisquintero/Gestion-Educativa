/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Administrador;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class DatoAdministrador extends dato{

    @Override
    public void modify(entidad administrador) throws ApplicationException{
        try{
            
        }
        catch(Exception e){
            
        }
        finally{
            
        }
    }       

    /**
     *
     * @return
     * @throws ApplicationException
     */
    @Override
    public ArrayList<entidad> getAll() throws ApplicationException{
        
        ArrayList<entidad> administradores = new ArrayList<>();
        
        try{
            myConn = MySQL.Connect();
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
        catch(Exception e){
            e.printStackTrace();
            throw new ApplicationException("Error al buscar Administradores", e);
        }
        finally{
            
        }
        
        return administradores;
    }

    @Override
    public int newObject(entidad administrador) throws ApplicationException{
        int id = 0;
        try{
            
        }
        catch(Exception e){
            
        }
        finally{
            
        }
        return id;
    }

    @Override
    public entidad getOne(int id) throws ApplicationException{
        Administrador administrador = null;
        try{
            
        }
        catch(Exception e){
            
        }
        finally{
            
        }
        return administrador;
    }
    
}
