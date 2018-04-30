package Negocio;

import Datos.DatoBedel;
import Entidades.Bedel;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposVaciosException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

public class NegocioBedel extends negocio{

    public NegocioBedel(){
        datos = new DatoBedel();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Bedel)e).getIdBedel()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("El Bedel ya existe");
        }       
        Entidades.Bedel bedel = (Entidades.Bedel)e;
        if("".equals(bedel.getNombre()) || "".equals(bedel.getApellido()) 
            || "".equals(bedel.getTelefono()) || "".equals(bedel.getEmail())
            || "".equals(bedel.getDireccion()) || "".equals(bedel.getLegajo())){
            throw new CamposVaciosException();
        }
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        Entidades.Bedel bedel = (Entidades.Bedel)e;
        if("".equals(bedel.getNombre()) || "".equals(bedel.getApellido()) 
            || "".equals(bedel.getTelefono()) || "".equals(bedel.getEmail())
            || "".equals(bedel.getDireccion()) || "".equals(bedel.getLegajo())){
            throw new CamposVaciosException();
        }
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Bedel)e).getIdBedel());
    }
}
