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
        this.horario.idHorario = idHorario;
    }
    public int idParcial;
    public String descripcion;
    public Date fecha;
    public Time horarioInicio;
    public Time horarioFin;
    public ArrayList<NotaParcial> notas;
    public Horario horario;
}
