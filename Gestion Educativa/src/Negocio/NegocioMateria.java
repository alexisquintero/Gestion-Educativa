package Negocio;

import Datos.DatoMateria;
import Entidades.Comision;
import Entidades.Horario;
import Entidades.InscripcionHorario;
import Entidades.Materia;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposVaciosException;
import Excepciones.CorrelativaAprobadaException;
import Excepciones.CorrelativaRegularAprobadaException;
import Excepciones.CorrelativaRegularException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    
    public List<Horario> materiaHorarios(Materia materia) throws ApplicationException{
        //Obtener todos los horarios
        List<Horario> horarios = (ArrayList<Horario>)(ArrayList<?>)
            new NegocioHorario().buscar();
        //Filtrar solo los horarios de la materia
        List<Horario> horariosMateria = horarios.stream().
            filter(h -> h.getMateria().getIdMateria() == materia.getIdMateria()).
            collect(Collectors.toList());
        //Controlar que tengan cupo disponible
            //Obtengo las comisiones
        List<Comision> comisiones = (ArrayList<Comision>)(ArrayList<?>)
            new NegocioComision().buscar();
        List<Horario> horariosConCupo = new ArrayList();
        for (Horario horario : horariosMateria) {
            //Obtengo el cupo
            int cupo = comisiones.stream().
                filter(c -> c.getIdComision() == horario.getComision().getIdComision()).
                collect(Collectors.toList()).get(0).getCupo();
            //Obtengo la cantidad de inscriptos a ese horario
            int cantidadInscriptos = 
                new NegocioHorario().cantidadInscriptos(horario);
            if(cantidadInscriptos < cupo) {
                horariosConCupo.add(horario);
            }
        }
        return horariosConCupo;
    }
    
    public Map<Materia, Integer> cantidadAlumnosMateria() throws ApplicationException{
        //Obtener todas las materias
        List<Materia> materias = 
            (ArrayList<Materia>)(ArrayList<?>)this.buscar();
        //Obtener todos los horarios
        List<Horario> horarios = 
            (ArrayList<Horario>)(ArrayList<?>) new NegocioHorario().buscar();
        //Obtener todas las inscripciones a horarios
        List<InscripcionHorario> inscripcionesHorarios = 
            (ArrayList<InscripcionHorario>)(ArrayList<?>) 
                new NegocioInscripcionHorario().buscar();
        //Contar las inscripciones por horario
        Map<Horario, Integer> inscripcionesHorario = new HashMap<>();
        for (Horario horario : horarios) {
            int cont = (int)inscripcionesHorarios.stream().
                filter(ih -> ih.getHorario().getIdHorario() == horario.getIdHorario()).
                    count();
            inscripcionesHorario.put(horario, cont);
        }
        //Contar las inscripciones a horarios por materia
        Map<Materia, Integer> inscripcionesMateria = new HashMap<>();
        for (Materia materia : materias) {
            //Obtengo los horarios que se corresponden con la materia
            Map<Horario, Integer> inscripcionesHorarioFiltrado = 
                inscripcionesHorario.entrySet().stream().
                    filter(ihf -> ihf.getKey().getMateria().getIdMateria() == 
                            materia.getIdMateria()).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            //Sumo la cantidad de inscriptos
            int sum = inscripcionesHorarioFiltrado
                .values().stream().mapToInt(Number::intValue).sum();
            //Agega un nuevo para materia -> cantidad
            inscripcionesMateria.put(materia, sum);
        }
        return inscripcionesMateria;
    }
}
