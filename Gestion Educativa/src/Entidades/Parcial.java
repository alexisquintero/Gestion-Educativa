/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Supervisor
 */
public class Parcial extends entidad{

    /**
     * 
     * @param idParcial
     * @param descripcion
     * @param fecha
     * @param horaInicio
     * @param horaFin
     * @param notas 
     */
    public Parcial(int idParcial, String descripcion, Date fecha, Time horaInicio, Time horaFin, ArrayList<NotaParcial> notas) {
        this.idParcial = idParcial;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.notas = notas;
    }
    public int idParcial;
    public String descripcion;
    public Date fecha;
    public Time horaInicio;
    public Time horaFin;
    public ArrayList<NotaParcial> notas;
}
