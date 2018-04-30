package Entidades;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class Horario extends entidad{

    /**
     * @return the idHorario
     */
    public int getIdHorario() {
        return idHorario;
    }

    /**
     * @param idHorario the idHorario to set
     */
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the horarioInicio
     */
    public Time getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * @param horarioInicio the horarioInicio to set
     */
    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * @return the horarioFin
     */
    public Time getHorarioFin() {
        return horarioFin;
    }

    /**
     * @param horarioFin the horarioFin to set
     */
    public void setHorarioFin(Time horarioFin) {
        this.horarioFin = horarioFin;
    }

    /**
     * @return the inscripciones
     */
    public ArrayList<InscripcionHorario> getInscripciones() {
        return inscripciones;
    }

    /**
     * @param inscripciones the inscripciones to set
     */
    public void setInscripciones(ArrayList<InscripcionHorario> inscripciones) {
        this.inscripciones = inscripciones;
    }

    /**
     * @return the docentes
     */
    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    /**
     * @param docentes the docentes to set
     */
    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    /**
     * @return the parciales
     */
    public ArrayList<Parcial> getParciales() {
        return parciales;
    }

    /**
     * @param parciales the parciales to set
     */
    public void setParciales(ArrayList<Parcial> parciales) {
        this.parciales = parciales;
    }

    /**
     * @return the asistencias
     */
    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    /**
     * @param asistencias the asistencias to set
     */
    public void setAsistencias(ArrayList<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    /**
     * @return the comision
     */
    public Comision getComision() {
        return comision;
    }

    /**
     * @param comision the comision to set
     */
    public void setComision(Comision comision) {
        this.comision = comision;
    }

    /**
     * @return the materia
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * 
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
    }
}
