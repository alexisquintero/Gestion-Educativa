package Negocio;

import Datos.DatoModerador;
import Entidades.Moderador;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposVaciosException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

public class NegocioModerador extends negocio{

    public NegocioModerador(){
        datos = new DatoModerador();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Moderador)e).getIdModerador()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("El Moderador ya existe");
        }       
        Entidades.Moderador moderador = (Entidades.Moderador)e;
        if("".equals(moderador.getNombre()) || "".equals(moderador.getApellido()) 
            || "".equals(moderador.getTelefono()) || "".equals(moderador.getEmail())
            || "".equals(moderador.getDireccion()) || "".equals(moderador.getLegajo())){
            throw new CamposVaciosException();
        }
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        Entidades.Moderador moderador = (Entidades.Moderador)e;
        if("".equals(moderador.getNombre()) || "".equals(moderador.getApellido()) 
                || "".equals(moderador.getTelefono()) || "".equals(moderador.getEmail())
                || "".equals(moderador.getDireccion()) || "".equals(moderador.getLegajo())){
            throw new CamposVaciosException();
        }
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Moderador)e).getIdModerador());
    }
    
    public entidad login(String usuario, String contrasenia) throws ApplicationException{
        return ((DatoModerador)datos).login(usuario, contrasenia);
    }
}
