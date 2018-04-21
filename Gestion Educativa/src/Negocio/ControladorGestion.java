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
}

/**
 * Para crear una entidad ->                nuevoEntidad(Entidad e);
 * Para modificar una entidad ->            modificarEntidad(Entidad e);
 * Para buscar una o varias entidades ->    buscarEntidad([Entidad e]);
 * Para eliminar una entidad ->             eliminarEntidad(Entidad e);
 */
