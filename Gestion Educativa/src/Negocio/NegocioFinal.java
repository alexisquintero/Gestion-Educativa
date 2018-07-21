package Negocio;

import Datos.DatoFinal;
import Entidades.Final;
import Entidades.Materia;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NegocioFinal extends negocio{

    public NegocioFinal(){
        datos = new DatoFinal();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Final)e).getIdFinal()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("El Final ya existe");
        }       
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Final)e).getIdFinal());
    }
    
    public List<Final> finalesMateria(Materia materia)throws ApplicationException{
        //Obtengo los finales
        List<Final> finales = (List<Final>) (List<?>) this.buscar();
        //Filtro para obtener sólo los de la materia
        List<Final> finalesMateria = finales.stream().
            filter(f -> f.getMateria().getIdMateria() == materia.getIdMateria()).
            collect(Collectors.toList());
        return finalesMateria;
    }
}
