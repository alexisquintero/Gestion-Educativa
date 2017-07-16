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
public class InscripcionFinal extends entidad{

    /**
     * 
     * @param fecha
     * @param notaPractica
     * @param notaTeoria
     * @param notaFinal
     * @param presencia
     * @param idAlumno 
     * @param idFinal 
     */
    public InscripcionFinal(Date fecha, int notaPractica, int notaTeoria, int notaFinal, boolean presencia, int idAlumno, int idFinal) {
        this.fecha = fecha;
        this.notaPractica = notaPractica;
        this.notaTeoria = notaTeoria;
        this.notaFinal = notaFinal;
        this.presencia = presencia;
        this.alumno = new Alumno();
        this.alumno.idAlumno = idAlumno;
        this.objFinal = new Final();
        this.objFinal.idFinal = idFinal;
    }
    public Date fecha;
    public int notaPractica;
    public int notaTeoria;
    public int notaFinal;
    public boolean presencia;
    public Alumno alumno;
    public Final objFinal;
}
