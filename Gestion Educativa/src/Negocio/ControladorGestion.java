/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.*;
import Excepciones.ApplicationException;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class ControladorGestion {
    //Logins
    public Administrador loginAdministrador(String usuario, String contrasenia) throws ApplicationException {
        Administrador administrador;

        NegocioAdministrador negocio = new NegocioAdministrador();
        administrador = (Administrador)negocio.login(usuario, contrasenia);

        return administrador;
    }
    
    public Alumno loginAlumno(String usuario, String contrasenia) throws ApplicationException{
        Alumno alumno;

        NegocioAlumno negocio = new NegocioAlumno();
        alumno = (Alumno)negocio.login(usuario, contrasenia);

        return alumno;
    }
    
    public ArrayList<entidad> buscarCarreras() throws ApplicationException{ 
        return new NegocioCarrera().buscar();      
    }
    
    public void modificarCarrera(entidad e) throws ApplicationException{
        new NegocioCarrera().modificar(e);
    }
    
    public int crearCarrera(entidad e) throws ApplicationException{
        return new NegocioCarrera().nuevo(e);
    }
    
    public void eliminarCarrera(entidad e) throws ApplicationException{
        new NegocioCarrera().eliminar(e);
    } 
    
    public ArrayList<entidad> buscarMaterias() throws ApplicationException{
        return new NegocioMateria().buscar();
    }
    
    public ArrayList<entidad> buscarModeradores() throws ApplicationException{
        return new NegocioModerador().buscar();
    }
    
    public void eliminarModerador(entidad e) throws ApplicationException{
        new NegocioModerador().eliminar(e);
    } 
    
    public int crearModerador(entidad e) throws ApplicationException{
        return new NegocioModerador().nuevo(e);
    }
    
    public void modificarModerador(entidad e) throws ApplicationException{
        new NegocioModerador().modificar(e);
    }
    
    public ArrayList<entidad> buscarDocentes() throws ApplicationException{
        return new NegocioDocente().buscar();
    }
    
    public void eliminarDocente(entidad e) throws ApplicationException{
        new NegocioDocente().eliminar(e);
    } 
    
    public int crearDocente(entidad e) throws ApplicationException{
        return new NegocioDocente().nuevo(e);
    }
    
    public void modificarDocente(entidad e) throws ApplicationException{
        new NegocioDocente().modificar(e);
    }
      
    public int crearMateria(entidad e) throws ApplicationException{
        return new NegocioMateria().nuevo(e);
    }
    
    public void modificarMateria(entidad e) throws ApplicationException{
        new NegocioMateria().modificar(e);
    }
    
    public void eliminarMateria(entidad e) throws ApplicationException{
        new NegocioMateria().eliminar(e);
    } 
}

