package Negocio;

import Datos.DatoAlumno;
import Entidades.Alumno;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposVaciosException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

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
        if (buscar(e) != null) {
            throw new EntidadExistenteException("El Alumno ya existe");
        }       
        Entidades.Alumno alumno = (Entidades.Alumno)e;
        if("".equals(alumno.getNombre()) || "".equals(alumno.getApellido()) 
            || "".equals(alumno.getTelefono()) || "".equals(alumno.getEmail())
            || "".equals(alumno.getDireccion()) || "".equals(alumno.getLegajo())
            || "descripcion".equals(alumno.getCarrera().getDescripcion())){
            throw new CamposVaciosException();
        }
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        Entidades.Alumno alumno = (Entidades.Alumno)e;
        if("".equals(alumno.getNombre()) || "".equals(alumno.getApellido()) 
            || "".equals(alumno.getTelefono()) || "".equals(alumno.getEmail())
            || "".equals(alumno.getDireccion()) || "".equals(alumno.getLegajo())
            || "descripcion".equals(alumno.getCarrera().getDescripcion())){
            throw new CamposVaciosException();
        }
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
