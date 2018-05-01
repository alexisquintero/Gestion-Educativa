package Negocio;

import Datos.DatoCarrera;
import Datos.DatoMateria;
import Entidades.Carrera;
import Entidades.Materia;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposVaciosException;
import Excepciones.EntidadExistenteException;
import Excepciones.MateriaRepetidaException;
import java.util.ArrayList;
import java.util.List;

public class NegocioCarrera extends negocio{

    public NegocioCarrera(){
        datos = new DatoCarrera();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{
        return (Carrera)datos.getOne(((Carrera)e).getIdCarrera()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("La Carrera ya existe");
        }       
        Entidades.Carrera carrera = (Entidades.Carrera)e;
        if("".equals(carrera.getNombre()) || "".equals(carrera.getDescripcion())){
            throw new CamposVaciosException();
        }
        List<Entidades.Materia> materias = 
                (ArrayList<Entidades.Materia>)(ArrayList<?>)carrera.getMaterias();
        for (Materia materia : materias) {
            long count = materias.stream()
                .filter(m -> m.getIdMateria() == materia.getIdMateria())
                .count();
            if(count > 1){
                throw new MateriaRepetidaException();
            }
        }
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        Entidades.Carrera carrera = (Entidades.Carrera)e;
        if("".equals(carrera.getNombre()) || "".equals(carrera.getDescripcion())){
            throw new CamposVaciosException();
        }
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Carrera)e).getIdCarrera());
    }
}
