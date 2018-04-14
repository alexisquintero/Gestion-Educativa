/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatoAlumno;
import Entidades.Alumno;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class NegocioAlumno extends negocio{

    public NegocioAlumno(){
        datos = new DatoAlumno();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Alumno)e).getIdAlumno()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) == null) {
            throw new EntidadExistenteException("El Alumno ya existe");
        }       
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Alumno)e).getIdAlumno());
    }
    
    public entidad login(String usuario, String contrasenia) throws ApplicationException{
        return ((DatoAlumno)datos).login(usuario, contrasenia);
    }
}
