package Negocio;

import Datos.DatoDocente;
import Entidades.Docente;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposVaciosException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

public class NegocioDocente extends negocio{

    public NegocioDocente(){
        datos = new DatoDocente();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Docente)e).getIdDocente()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("El Docente ya existe");
        }       
        Entidades.Docente docente = (Entidades.Docente)e;
        if("".equals(docente.getNombre()) || "".equals(docente.getApellido()) 
                || "".equals(docente.getTelefono()) || "".equals(docente.getEmail())
                || "".equals(docente.getDireccion()) || "".equals(docente.getLegajo())){
            throw new CamposVaciosException();
        }
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        Entidades.Docente docente = (Entidades.Docente)e;
        if("".equals(docente.getNombre()) || "".equals(docente.getApellido()) 
                || "".equals(docente.getTelefono()) || "".equals(docente.getEmail())
                || "".equals(docente.getDireccion()) || "".equals(docente.getLegajo())){
            throw new CamposVaciosException();
        }
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Docente)e).getIdDocente());
    }
}
