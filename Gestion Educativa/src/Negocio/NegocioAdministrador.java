package Negocio;

import Datos.DatoAdministrador;
import Entidades.Administrador;
import Entidades.entidad;
import Excepciones.*;
import java.util.ArrayList;

public class NegocioAdministrador extends negocio{

    public NegocioAdministrador(){
        datos = new DatoAdministrador();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Administrador)e).getIdAdministrador()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("El Administrador ya existe");
        }       
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Administrador)e).getIdAdministrador());
    }
    
    public entidad login(String usuario, String contrasenia) throws ApplicationException{
        if("".equals(usuario) || "".equals(contrasenia)) throw new CamposLoginVaciosException();
        return ((DatoAdministrador)datos).login(usuario, contrasenia);
    }
}
