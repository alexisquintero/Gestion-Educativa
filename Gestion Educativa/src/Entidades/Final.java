package Entidades;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Final extends entidad{

    public int getIdFinal() {
        return idFinal;
    }

    public void setIdFinal(int idFinal) {
        this.idFinal = idFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public ArrayList<InscripcionFinal> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<InscripcionFinal> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
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
