/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Time;
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
        this.comision.idComision = idComision;
        this.materia = new Materia();
        this.materia.idMateria = idMateria;
    }
    public int idHorario;
    public String dia;
    public Time horarioInicio;
    public Time horarioFin;
    public ArrayList<InscripcionHorario> inscripciones;
    public ArrayList<Docente> docentes;
    public ArrayList<Parcial> parciales;
    public ArrayList<Asistencia> asistencias;
    public Comision comision;
    public Materia materia;

    Horario() {
        this.idHorario = 0;
        this.dia = "Dia";
        this.horarioInicio = Time.valueOf(LocalTime.MIN);
        this.horarioFin = Time.valueOf(LocalTime.MIN);
        this.comision = new Comision();
        this.materia = new Materia();
    }
}
