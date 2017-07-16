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
public class Final extends entidad{

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
        this.materia.idMateria = idMateria;
    }
    public int idFinal;
    public Date fecha;
    public Time horarioInicio;
    public Time horarioFin;
    public String aula;
    public ArrayList<InscripcionFinal> inscripciones;
    public Materia materia;

    Final() {
        this.idFinal = 0;
        this.fecha = Date.valueOf(LocalDate.MIN);
        this.horarioInicio = Time.valueOf(LocalTime.MIN);
        this.horarioFin = Time.valueOf(LocalTime.MIN);
        this.aula = "aula";
        this.materia = new Materia();
    }
}
