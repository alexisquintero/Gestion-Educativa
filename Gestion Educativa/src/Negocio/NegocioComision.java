package Negocio;

import Datos.DatoComision;
import Entidades.Comision;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposVaciosException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

public class NegocioComision extends negocio{

    public NegocioComision(){
        datos = new DatoComision();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{
        return datos.getOne(((Comision)e).getIdComision());
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("La Comision ya existe");
        }       
        Entidades.Comision comision = (Entidades.Comision)e;
        if("".equals(comision.getAula()) || 0 == comision.getCupo()){
            throw new CamposVaciosException();
        }
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        Entidades.Comision comision = (Entidades.Comision)e;
        if("".equals(comision.getAula()) || 0 == comision.getCupo()){
            throw new CamposVaciosException();
        }
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Comision)e).getIdComision());
    }
}
