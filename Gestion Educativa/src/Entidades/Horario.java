/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Time;
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
}
