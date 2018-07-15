package Negocio;

import Datos.DatoInscripcionHorario;
import Entidades.Alumno;
import Entidades.InscripcionHorario;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;
import java.util.List;

public class NegocioInscripcionHorario extends negocio{

    public NegocioInscripcionHorario(){
        datos = new DatoInscripcionHorario();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        //return datos.getOne(((InscripcionHorario)e).idInscripcionHorario); 
        return null;
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("La InscripcionHorario ya existe");
        }       
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        //datos.delete(((InscripcionHorario)e).idInscripcionHorario);
    }
    
    public List<InscripcionHorario> inscripcionesAlumno(Alumno alumno) throws ApplicationException{
        return ((DatoInscripcionHorario)datos).getHorariosAlumno(alumno);
    }
} 
