/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;
import java.time.LocalDate;



/**
 *
 * @author Supervisor
 */
public class InscripcionHorario extends entidad{

    public InscripcionHorario() {
        this.fecha = Date.valueOf(LocalDate.MIN);
        this.horario = new Horario();
        this.alumno = new Alumno();
    }

    /**
     * 
     * @param fecha
     * @param idHorario
     * @param idAlumno 
     */
    public InscripcionHorario(Date fecha, int idHorario, int idAlumno) {
        this.fecha = fecha;
        this.horario = new Horario();
        this.horario.idHorario = idHorario;
        this.alumno = new Alumno();
        this.alumno.idAlumno = idAlumno;
    }
    public Date fecha;
    public Horario horario;
    public Alumno alumno;
}
