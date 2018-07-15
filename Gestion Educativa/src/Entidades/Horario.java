package Entidades;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class Horario extends entidad{

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(Time horarioFin) {
        this.horarioFin = horarioFin;
    }

    public ArrayList<InscripcionHorario> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<InscripcionHorario> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public ArrayList<Parcial> getParciales() {
        return parciales;
    }

    public void setParciales(ArrayList<Parcial> parciales) {
        this.parciales = parciales;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(ArrayList<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * @param idHorario
     * @param dia
     * @param horarioInicio
     * @param horarioFin 
     * @param idComision 
     * @param idMateria 
     */
    public Horario(int idHorario, String dia, Time horarioInicio, Time horarioFin, int idComision, int idMateria) {
        this.idHorario = idHorario;
        this.dia = dia;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.comision = new Comision();
        this.comision.setIdComision(idComision);
        this.materia = new Materia();
        this.materia.setIdMateria(idMateria);
        this.asistencias = new ArrayList();
        this.docentes = new ArrayList();
        this.inscripciones = new ArrayList();
        this.parciales = new ArrayList();
    }
    private int idHorario;
    private String dia;
    private Time horarioInicio;
    private Time horarioFin;
    private ArrayList<InscripcionHorario> inscripciones;
    private ArrayList<Docente> docentes;
    private ArrayList<Parcial> parciales;
    private ArrayList<Asistencia> asistencias;
    private Comision comision;
    private Materia materia;

    Horario() {
        this.idHorario = 0;
        this.dia = "Dia";
        this.horarioInicio = Time.valueOf(LocalTime.MIN);
        this.horarioFin = Time.valueOf(LocalTime.MIN);
        this.comision = new Comision();
        this.materia = new Materia();
        this.asistencias = new ArrayList();
        this.docentes = new ArrayList();
        this.inscripciones = new ArrayList();
        this.parciales = new ArrayList();
    }
}
