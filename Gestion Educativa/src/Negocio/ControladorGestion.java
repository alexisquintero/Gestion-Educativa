package Negocio;

import Entidades.*;
import Excepciones.ApplicationException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ControladorGestion {
    //Logins
    public Administrador loginAdministrador(String usuario, String contrasenia) throws ApplicationException {
        Administrador administrador;

        NegocioAdministrador negocio = new NegocioAdministrador();
        administrador = (Administrador)negocio.login(usuario, contrasenia);

        return administrador;
    }
    
    public Moderador loginModerador(String usuario, String contrasenia) throws ApplicationException {
        Moderador moderador;

        NegocioModerador negocio = new NegocioModerador();
        moderador = (Moderador)negocio.login(usuario, contrasenia);

        return moderador;
    }
    
    public Alumno loginAlumno(String usuario, String contrasenia) throws ApplicationException{
        Alumno alumno;

        NegocioAlumno negocio = new NegocioAlumno();
        alumno = (Alumno)negocio.login(usuario, contrasenia);

        return alumno;
    }
    
    public ArrayList<entidad> buscarCarreras() throws ApplicationException{ 
        return new NegocioCarrera().buscar();      
    }
    
    public void modificarCarrera(entidad e) throws ApplicationException{
        new NegocioCarrera().modificar(e);
    }
    
    public int crearCarrera(entidad e) throws ApplicationException{
        return new NegocioCarrera().nuevo(e);
    }
    
    public void eliminarCarrera(entidad e) throws ApplicationException{
        new NegocioCarrera().eliminar(e);
    } 
    
    public ArrayList<entidad> buscarMaterias() throws ApplicationException{
        return new NegocioMateria().buscar();
    }
    
    public ArrayList<entidad> buscarModeradores() throws ApplicationException{
        return new NegocioModerador().buscar();
    }
    
    public void eliminarModerador(entidad e) throws ApplicationException{
        new NegocioModerador().eliminar(e);
    } 
    
    public int crearModerador(entidad e) throws ApplicationException{
        return new NegocioModerador().nuevo(e);
    }
    
    public void modificarModerador(entidad e) throws ApplicationException{
        new NegocioModerador().modificar(e);
    }
    
    public ArrayList<entidad> buscarDocentes() throws ApplicationException{
        return new NegocioDocente().buscar();
    }
    
    public void eliminarDocente(entidad e) throws ApplicationException{
        new NegocioDocente().eliminar(e);
    } 
    
    public int crearDocente(entidad e) throws ApplicationException{
        return new NegocioDocente().nuevo(e);
    }
    
    public void modificarDocente(entidad e) throws ApplicationException{
        new NegocioDocente().modificar(e);
    }
      
    public int crearMateria(entidad e) throws ApplicationException{
        return new NegocioMateria().nuevo(e);
    }
    
    public void modificarMateria(entidad e) throws ApplicationException{
        new NegocioMateria().modificar(e);
    }
    
    public void eliminarMateria(entidad e) throws ApplicationException{
        new NegocioMateria().eliminar(e);
    } 
    
    public ArrayList<entidad> buscarAlumnos() throws ApplicationException{ 
        return new NegocioAlumno().buscar();      
    }
    
    public ArrayList<entidad> buscarComision() throws ApplicationException{ 
        return new NegocioComision().buscar();      
    }
    
    public void eliminarAlumno(entidad e) throws ApplicationException{
        new NegocioAlumno().eliminar(e);
    } 
    
    public int crearAlumno(entidad e) throws ApplicationException{
        return new NegocioAlumno().nuevo(e);
    }
    
    public void modificarAlumno(entidad e) throws ApplicationException{
        new NegocioAlumno().modificar(e);
    }
    
    public entidad buscarCarrera(entidad e) throws ApplicationException{
        return new NegocioCarrera().buscar(e);
    }
    
    public void eliminarComision(entidad e) throws ApplicationException{
        new NegocioComision().eliminar(e);
    } 
    
    public int crearComision(entidad e) throws ApplicationException{
        return new NegocioComision().nuevo(e);
    }
    
    public void modificarComision(entidad e) throws ApplicationException{
        new NegocioComision().modificar(e);
    }
    
    public ArrayList<entidad> buscarBedel() throws ApplicationException{
        return new NegocioBedel().buscar();
    }
    
    public void eliminarBedel(entidad e) throws ApplicationException{
        new NegocioBedel().eliminar(e);
    }
    
    public int crearBedel(entidad e) throws ApplicationException{
        return new NegocioBedel().nuevo(e);
    }
    
    public void modificarBedel(entidad e) throws ApplicationException{
        new NegocioBedel().modificar(e);
    }
    
    public List<Materia> buscarMateriasInscripcion(Alumno alumno) throws ApplicationException{
        return new NegocioAlumno().materiasInscripcion(alumno);
    }
    
    public List<Horario> buscarHorariosMaterias(Materia materia) throws ApplicationException{
        return new NegocioMateria().materiaHorarios(materia);
    }
    
    public void inscribirHorario(Horario horario, Alumno alumno) throws ApplicationException{
        InscripcionHorario inscripcionHorario = 
            new InscripcionHorario(Date.valueOf(LocalDate.now()), 
                horario.getIdHorario(), alumno.getIdAlumno());
        new NegocioInscripcionHorario().nuevo(inscripcionHorario);
    }
    
    public List<Materia> buscarMateriasInscripcionFinal(Alumno alumno) throws ApplicationException{
        return new NegocioAlumno().materiasFinalesInscripcion(alumno);
    }
    
    public List<Final> buscarFinalesInscripcion(Materia materia)throws ApplicationException{
        return new NegocioFinal().finalesMateria(materia);
    }
    
    public void inscribirFinal(Final final1, Alumno alumno) throws ApplicationException{
        InscripcionFinal inscripcionFinal = 
            new InscripcionFinal(Date.valueOf(LocalDate.now()), 0, 0, 0, false, 
                alumno.getIdAlumno(), final1.getIdFinal());
        new NegocioInscripcionFinal().nuevo(inscripcionFinal);
    }
    
    public float notaPromedioFinal(Final final1) throws ApplicationException{
        return new NegocioInscripcionFinal().notaPromedioFinal(final1);
    }
    
    public float notaPromedioAlumno(Alumno alumno) throws ApplicationException{
        return new NegocioInscripcionFinal().notaPromedioAlumno(alumno);
    }
    
    public Map<Materia, Integer> cantidadAlumnosMateria() throws ApplicationException{
        return new NegocioMateria().cantidadAlumnosMateria();
    }
    
    public ArrayList<entidad> buscarFinales() throws ApplicationException{
        return new NegocioFinal().buscar();
    }
}

