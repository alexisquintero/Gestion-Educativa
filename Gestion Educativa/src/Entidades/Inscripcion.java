/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Supervisor
 */
public class Inscripcion extends entidad{

    /**
     * 
     * @param fecha
     * @param notaPractica
     * @param notaTeoria
     * @param notaFinal
     * @param presencia
     * @param alumno 
     */
    public Inscripcion(Date fecha, int notaPractica, int notaTeoria, int notaFinal, boolean presencia, Alumno alumno) {
        this.fecha = fecha;
        this.notaPractica = notaPractica;
        this.notaTeoria = notaTeoria;
        this.notaFinal = notaFinal;
        this.presencia = presencia;
        this.alumno = alumno;
    }
    public Date fecha;
    public int notaPractica;
    public int notaTeoria;
    public int notaFinal;
    public boolean presencia;
    public Alumno alumno;
}
