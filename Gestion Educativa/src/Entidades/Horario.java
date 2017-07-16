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
public class Horario extends entidad{

    /**
     * 
     * @param idHorario
     * @param dia
     * @param horaInicio
     * @param horaFin 
     */
    public Horario(int idHorario, String dia, Time horaInicio, Time horaFin) {
        this.idHorario = idHorario;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public int idHorario;
    public String dia;
    public Time horaInicio;
    public Time horaFin;
    public ArrayList<InscripcionHorario> inscripciones;
    public ArrayList<Docente> docentes;
    public ArrayList<Parcial> parciales;
    public ArrayList<Asistencia> asistencias;

    Horario() {
        this.idHorario = 0;
        this.dia = "Dia";
        this.horaInicio = Time.valueOf(LocalTime.MIN);
        this.horaFin = Time.valueOf(LocalTime.MIN);
    }
}
