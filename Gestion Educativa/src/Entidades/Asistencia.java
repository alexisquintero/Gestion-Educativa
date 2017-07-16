/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;



/**
 *
 * @author Supervisor
 */
public class Asistencia extends entidad{

    /**
     * 
     * @param fecha
     * @param presencia
     * @param idBedel
     * @param idAlumno 
     */
    public Asistencia(Date fecha, boolean presencia, int idBedel, int idAlumno) {
        this.fecha = fecha;
        this.presencia = presencia;
        this.bedel = new Bedel();
        this.bedel.idBedel = idBedel; 
        this.alumno = new Alumno();
        this.alumno.idAlumno = idAlumno;
    }
    public Date fecha;
    public boolean presencia;
    public Bedel bedel;
    public Alumno alumno;
}
