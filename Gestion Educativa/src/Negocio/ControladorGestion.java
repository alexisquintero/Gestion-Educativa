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
    
    public void modificarCarrera(entidad carrera) throws ApplicationException{
        new NegocioCarrera().modificar(carrera);
    }
    
    public int crearCarrera(entidad carrera) throws ApplicationException{
        return new NegocioCarrera().nuevo(carrera);
    }
    
    public ArrayList<entidad> buscarMaterias() throws ApplicationException{
        return new NegocioMateria().buscar();
    }
}

/**
 * Para crear una entidad ->                nuevoEntidad(Entidad e);
 * Para modificar una entidad ->            modificarEntidad(Entidad e);
 * Para buscar una o varias entidades ->    buscarEntidad([Entidad e]);
 * Para eliminar una entidad ->             eliminarEntidad(Entidad e);
 */
