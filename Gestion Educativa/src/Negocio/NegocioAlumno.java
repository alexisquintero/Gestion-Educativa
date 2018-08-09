package Negocio;

import Datos.DatoAlumno;
import Entidades.Alumno;
import Entidades.Carrera;
import Entidades.Final;
import Entidades.Horario;
import Entidades.InscripcionFinal;
import Entidades.InscripcionHorario;
import Entidades.Materia;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.CamposLoginVaciosException;
import Excepciones.CamposVaciosException;
import Excepciones.EntidadExistenteException;
import Otros.Reglamento;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NegocioAlumno extends negocio{

    public NegocioAlumno(){
        datos = new DatoAlumno();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        return datos.getOne(((Alumno)e).getIdAlumno()); 
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (buscar(e) != null) {
            throw new EntidadExistenteException("El Alumno ya existe");
        }       
        Entidades.Alumno alumno = (Entidades.Alumno)e;
        if("".equals(alumno.getNombre()) || "".equals(alumno.getApellido()) 
            || "".equals(alumno.getTelefono()) || "".equals(alumno.getEmail())
            || "".equals(alumno.getDireccion()) || "".equals(alumno.getLegajo())
            || "descripcion".equals(alumno.getCarrera().getDescripcion())){
            throw new CamposVaciosException();
        }
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        Entidades.Alumno alumno = (Entidades.Alumno)e;
        if("".equals(alumno.getNombre()) || "".equals(alumno.getApellido()) 
            || "".equals(alumno.getTelefono()) || "".equals(alumno.getEmail())
            || "".equals(alumno.getDireccion()) || "".equals(alumno.getLegajo())
            || "descripcion".equals(alumno.getCarrera().getDescripcion())){
            throw new CamposVaciosException();
        }
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        datos.delete(((Alumno)e).getIdAlumno());
    }
    
    public entidad login(String usuario, String contrasenia) throws ApplicationException{
        if("".equals(usuario) || "".equals(contrasenia)) throw new CamposLoginVaciosException();
        return ((DatoAlumno)datos).login(usuario, contrasenia);
    }
    
    public List<Materia> materiasInscripcion(Alumno alumno) throws ApplicationException{
        //Obtengo la carrera del alumno
        Carrera carrera = (Carrera)new NegocioCarrera().
                        buscar(alumno.getCarrera());
        //Obtengo las materias de la carrera
        List<Materia> materiasCarrera = 
            (List<Materia>)(List<?>) carrera.getMaterias();
        //Obtengo todas las materias
        List<Materia> todasMaterias = 
            (List<Materia>)(List<?>)new NegocioMateria().buscar();
        //Obtengo las materias de la carrera con todos los datos
        List<Materia> materias = todasMaterias.stream()
            .filter(tm -> materiasCarrera.stream()
                .anyMatch(mc -> mc.getIdMateria() == tm.getIdMateria()))
                .collect(Collectors.toList());
        //Obtengo las materias aprobadas del alumno
        List<Materia> materiasAprobadas = this.getMateriasAprobadas(alumno);
        //Resto las materias aprobadas a las de la carrera
        List<Materia> materiasDisponibles = materias.stream().
            filter(m -> materiasAprobadas.stream()
                .noneMatch(ma -> ma.getIdMateria() == m.getIdMateria()))
                .collect(Collectors.toList());
        //Controlo que estén aprobadas las correlativas
        List<Materia> materiasInscripcion = new ArrayList();
        for (Materia materiaDisponible : materiasDisponibles) {
            List<Materia> correlativas = 
                (List<Materia>)(List<?>)materiaDisponible.
                    getCorrelativasAprobadas();
            int cont = 0;
            for (Materia correlativa : correlativas) {
                if(materiasAprobadas.stream().
                    anyMatch(ma -> ma.getIdMateria() == correlativa.getIdMateria())) {
                    cont += 1;
                }
            }
            if(cont == correlativas.size()){
                materiasInscripcion.add(materiaDisponible);
            }
        }
        return materiasInscripcion;
    }
    
    public List<Materia> materiasFinalesInscripcion(Alumno alumno) throws ApplicationException{
        //Obtengo las inscripciones del alumno
        List<InscripcionHorario> InscripcionesHorario = new NegocioInscripcionHorario().
            inscripcionesAlumno(alumno);
        //Obtengo todos los horarios
        List<Horario> horarios = 
            (List<Horario>)(List<?>) new NegocioHorario().buscar();
        //Obtengo los horarios del alumno
        List<Horario> horariosAlumno = horarios.stream().
            filter(h -> InscripcionesHorario.stream().
                anyMatch(i -> i.getHorario().getIdHorario() == h.getIdHorario())).
                collect(Collectors.toList());
        //Obtengo la carrera del alumno
        Carrera carrera = (Carrera)new NegocioCarrera().
                        buscar(alumno.getCarrera());
        //Obtengo las materias de la carrera
        List<Materia> materias = 
            (List<Materia>)(List<?>) carrera.getMaterias();
        //Obtengo las materias a las que el alumno está inscripto
        List<Materia> materiasInscriptas = materias.stream().
            filter(m -> horariosAlumno.stream().
                anyMatch(ha -> ha.getMateria().getIdMateria() == m.getIdMateria())).
                collect(Collectors.toList());
        //Obtengo las inscripciones a finales
        List<InscripcionFinal> inscripcionesFinal = 
            new NegocioInscripcionFinal().inscripcionesAlumno(alumno);
        //Obtengo los finales
        List<Final> finales = 
            (List<Final>)(List<?>) new NegocioFinal().buscar();
        //Obtengo los finales inscripctos y aprobados
        List<Final> finalesAprobados = finales.stream().
            filter(f -> inscripcionesFinal.stream().
                anyMatch(iF -> iF.getObjFinal().getIdFinal() == f.getIdFinal() &&
                    iF.getNotaFinal() >= Reglamento.notaAprobado)).
                collect(Collectors.toList());
        //Obtengo las materias con finales aprobados
        List<Materia> materiasAprobadas = materias.stream().
            filter(m -> finalesAprobados.stream().
                anyMatch(fa -> fa.getMateria().getIdMateria() == m.getIdMateria())).
                collect(Collectors.toList());
        //Resto las materias con finales aprobados de las materias inscriptas
        List<Materia> materiasDisponibles = materiasInscriptas.stream().
            filter(mi -> materiasAprobadas.stream().
                noneMatch(ma -> ma.getIdMateria() == mi.getIdMateria())).
                collect(Collectors.toList());
        return materiasDisponibles;
    }
    
    public List<Materia> getMateriasAprobadas(Alumno alumno) throws ApplicationException{
        ArrayList<entidad> materiasAprobadas = new ArrayList<>();
        List<InscripcionFinal> inscripcionesFinales = 
            (List<InscripcionFinal>)(List<?>) new NegocioInscripcionFinal().
                buscar();
        List<InscripcionFinal> inscripcionesFinalesAlumno = 
            inscripcionesFinales.stream().
                filter(i -> i.getAlumno().getIdAlumno() == alumno.getIdAlumno()).
                collect(Collectors.toList());
        List<InscripcionFinal> inscripcionesFinalesAprobadas = 
            inscripcionesFinalesAlumno.stream().
                filter(i -> i.getNotaFinal() >= Reglamento.notaAprobado).
                collect(Collectors.toList());
        NegocioFinal negocioFinal = new NegocioFinal();
        NegocioMateria negocioMateria = new NegocioMateria();
        List<Final> finales = new ArrayList<>();
        List<Materia> materias = new ArrayList<>();

        for (InscripcionFinal inscripcion : inscripcionesFinalesAprobadas) {
            finales.add((Final)negocioFinal.buscar(inscripcion.getObjFinal()));
        }
        for (Final final1 : finales) {
            materias.add((Materia)negocioMateria.buscar(final1.getMateria()));
        }

        return materias;
    }
}
