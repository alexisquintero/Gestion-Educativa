package Entidades;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Final extends entidad{

    /**
     * @return the idFinal
     */
    public int getIdFinal() {
        return idFinal;
    }

    /**
     * @param idFinal the idFinal to set
     */
    public void setIdFinal(int idFinal) {
        this.idFinal = idFinal;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
     * @return the aula
     */
    public String getAula() {
        return aula;
    }

    /**
     * @param aula the aula to set
     */
    public void setAula(String aula) {
        this.aula = aula;
    }

    /**
     * @return the inscripciones
     */
    public ArrayList<InscripcionFinal> getInscripciones() {
        return inscripciones;
    }

    /**
     * @param inscripciones the inscripciones to set
     */
    public void setInscripciones(ArrayList<InscripcionFinal> inscripciones) {
        this.inscripciones = inscripciones;
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
     * @param idFinal
     * @param fecha
     * @param horarioInicio
     * @param horarioFin
     * @param aula 
     * @param idMateria 
     */
    public Final(int idFinal, Date fecha, Time horarioInicio, Time horarioFin, String aula, int idMateria) {
        this.idFinal = idFinal;
        this.fecha = fecha;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.aula = aula;
        this.materia = new Materia();
        this.materia.setIdMateria(idMateria);
        this.inscripciones = new ArrayList();
    }
    private int idFinal;
    private Date fecha;
    private Time horarioInicio;
    private Time horarioFin;
    private String aula;
    private ArrayList<InscripcionFinal> inscripciones;
    private Materia materia;

    Final() {
        this.idFinal = 0;
        this.fecha = Date.valueOf(LocalDate.MIN);
        this.horarioInicio = Time.valueOf(LocalTime.MIN);
        this.horarioFin = Time.valueOf(LocalTime.MIN);
        this.aula = "aula";
        this.materia = new Materia();
        this.inscripciones = new ArrayList();
    }
}
