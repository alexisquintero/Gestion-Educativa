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
public class Final extends entidad{

    /**
     * 
     * @param idFinal
     * @param fecha
     * @param horaInicio
     * @param horaFin
     * @param aula
     * @param inscripciones 
     */
    public Final(int idFinal, Date fecha, Time horaInicio, Time horaFin, String aula, ArrayList<InscripcionFinal> inscripciones) {
        this.idFinal = idFinal;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aula = aula;
        this.inscripciones = inscripciones;
    }
    public int idFinal;
    public Date fecha;
    public Time horaInicio;
    public Time horaFin;
    public String aula;
    public ArrayList<InscripcionFinal> inscripciones;
}
