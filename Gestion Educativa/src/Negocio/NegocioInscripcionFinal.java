package Negocio;

import Datos.DatoInscripcionFinal;
import Entidades.Alumno;
import Entidades.InscripcionFinal;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;
import java.util.List;

public class NegocioInscripcionFinal extends negocio{

    public NegocioInscripcionFinal(){
        datos = new DatoInscripcionFinal();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        //return datos.getOne(((InscripcionFinal)e).idInscripcionFinal); 
        return null;
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("La InscripcionFinal ya existe");
        }       
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        //datos.delete(((InscripcionFinal)e).idInscripcionFinal);
    }
    
    public List<InscripcionFinal> inscripcionesAlumno(Alumno alumno) throws ApplicationException{
        return ((DatoInscripcionFinal)datos).getFinalesAlumno(alumno);
    }
}
