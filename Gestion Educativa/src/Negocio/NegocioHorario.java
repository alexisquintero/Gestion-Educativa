package Negocio;

import Datos.DatoHorario;
import Datos.DatoInscripcionHorario;
import Entidades.Comision;
import Entidades.Horario;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

public class NegocioHorario extends negocio{

    public NegocioHorario(){
        datos = new DatoHorario();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Horario)e).getIdHorario()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("El Horario ya existe");
        }       
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Horario)e).getIdHorario());
    }
    
        
    public int cantidadInscriptos(Horario horario) throws ApplicationException{
        return new DatoInscripcionHorario().
            cantidadInscriptosComision(horario.getIdHorario());
    }
}
