package Negocio;

import Datos.DatoMateria;
import Entidades.Materia;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposVaciosException;
import Excepciones.CorrelativaAprobadaException;
import Excepciones.CorrelativaRegularAprobadaException;
import Excepciones.CorrelativaRegularException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

public class NegocioMateria extends negocio{

    public NegocioMateria(){
        datos = new DatoMateria();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Materia)e).getIdMateria()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) != null) {
            throw new EntidadExistenteException("La Materia ya existe");
        }       
        Entidades.Materia materia = (Entidades.Materia)e;
        if("".equals(materia.getNombre()) || "".equals(materia.getDescripcion())
            || 0 == materia.getHorasSemana()){
            throw new CamposVaciosException();
        }
        ArrayList<Entidades.Materia> materiasRegulares = 
            (ArrayList<Entidades.Materia>)(ArrayList<?>)materia.getCorrelativasRegulares();
        ArrayList<Entidades.Materia> materiasAprobadas = 
            (ArrayList<Entidades.Materia>)(ArrayList<?>)materia.getCorrelativasAprobadas();
        //Correlativa y regular a la vez
        for (Materia materiaAprobada : materiasAprobadas) {
            long count = materiasRegulares.stream()
                .filter(r -> r.getIdMateria() == materiaAprobada.getIdMateria())
                .count();
            if(count > 0){
                throw new CorrelativaRegularAprobadaException();
            }
        }
        //La misma materia es correlativa regular
        long countR = materiasRegulares.stream()
            .filter(m -> m.getIdMateria() == materia.getIdMateria())
            .count();
        if(countR > 0){
            throw new CorrelativaRegularException();
        }
        //La misma materia es correlativa aprobada
        long countA = materiasAprobadas.stream()
            .filter(a -> a.getIdMateria() == materia.getIdMateria())
            .count();
        if(countR > 0){
            throw new CorrelativaAprobadaException();
        }
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        Entidades.Materia materia = (Entidades.Materia)e;
        if("".equals(materia.getNombre()) || "".equals(materia.getDescripcion())
            || 0 == materia.getHorasSemana()){
            throw new CamposVaciosException();
        }
        ArrayList<Entidades.Materia> materiasRegulares = 
            (ArrayList<Entidades.Materia>)(ArrayList<?>)materia.getCorrelativasRegulares();
        ArrayList<Entidades.Materia> materiasAprobadas = 
            (ArrayList<Entidades.Materia>)(ArrayList<?>)materia.getCorrelativasAprobadas();
        //Correlativa y regular a la vez
        for (Materia materiaAprobada : materiasAprobadas) {
            long count = materiasRegulares.stream()
                .filter(r -> r.getIdMateria() == materiaAprobada.getIdMateria())
                .count();
            if(count > 0){
                throw new CorrelativaRegularAprobadaException();
            }
        }
        //La misma materia es correlativa regular
        long countR = materiasRegulares.stream()
            .filter(m -> m.getIdMateria() == materia.getIdMateria())
            .count();
        if(countR > 0){
            throw new CorrelativaRegularException();
        }
        //La misma materia es correlativa aprobada
        long countA = materiasAprobadas.stream()
            .filter(a -> a.getIdMateria() == materia.getIdMateria())
            .count();
        if(countR > 0){
            throw new CorrelativaAprobadaException();
        }
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Materia)e).getIdMateria());
    }
}
