package Entidades;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Parcial extends entidad{

    public int getIdParcial() {
        return idParcial;
    }

    public void setIdParcial(int idParcial) {
        this.idParcial = idParcial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public ArrayList<NotaParcial> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<NotaParcial> notas) {
        this.notas = notas;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Parcial() {
        this.idParcial = 0;
        this.descripcion = "descripcion";
        this.fecha = Date.valueOf(LocalDate.MIN);
        this.horarioInicio = Time.valueOf(LocalTime.MIN);
        this.horarioFin = Time.valueOf(LocalTime.MIN);
        this.horario = new Horario();
    }

    /**
     * @param idParcial
     * @param descripcion
     * @param fecha
     * @param horarioInicio
     * @param horarioFin
     * @param idHorario 
     */
    public Parcial(int idParcial, String descripcion, Date fecha, Time horarioInicio, Time horarioFin, int idHorario) {
        this.idParcial = idParcial;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.horario = new Horario();
        this.horario.setIdHorario(idHorario);
        this.notas = new ArrayList();
    }
    private int idParcial;
    private String descripcion;
    private Date fecha;
    private Time horarioInicio;
    private Time horarioFin;
    private ArrayList<NotaParcial> notas;
    private Horario horario;
}
