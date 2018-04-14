/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class Parcial extends entidad{

    /**
     * @return the idParcial
     */
    public int getIdParcial() {
        return idParcial;
    }

    /**
     * @param idParcial the idParcial to set
     */
    public void setIdParcial(int idParcial) {
        this.idParcial = idParcial;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     * @return the notas
     */
    public ArrayList<NotaParcial> getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(ArrayList<NotaParcial> notas) {
        this.notas = notas;
    }

    /**
     * @return the horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
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
     * 
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
    }
    private int idParcial;
    private String descripcion;
    private Date fecha;
    private Time horarioInicio;
    private Time horarioFin;
    private ArrayList<NotaParcial> notas;
    private Horario horario;
}
