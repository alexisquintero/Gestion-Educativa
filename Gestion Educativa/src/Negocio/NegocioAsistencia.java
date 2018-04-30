package Negocio;

import Datos.DatoAsistencia;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

public class NegocioAsistencia extends negocio{

    public NegocioAsistencia(){
        datos = new DatoAsistencia();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        //return datos.getOne(((Asistencia)e).idAsistencia); 
        return null;
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("La Asistencia ya existe");
        }       
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        //datos.delete(((Asistencia)e).idAsistencia);
    }
}
