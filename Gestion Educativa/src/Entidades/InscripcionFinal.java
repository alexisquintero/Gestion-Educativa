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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the notaPractica
     */
    public int getNotaPractica() {
        return notaPractica;
    }

    /**
     * @param notaPractica the notaPractica to set
     */
    public void setNotaPractica(int notaPractica) {
        this.notaPractica = notaPractica;
    }

    /**
     * @return the notaTeoria
     */
    public int getNotaTeoria() {
        return notaTeoria;
    }

    /**
     * @param notaTeoria the notaTeoria to set
     */
    public void setNotaTeoria(int notaTeoria) {
        this.notaTeoria = notaTeoria;
    }

    /**
     * @return the notaFinal
     */
    public int getNotaFinal() {
        return notaFinal;
    }

    /**
     * @param notaFinal the notaFinal to set
     */
    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    /**
     * @return the presencia
     */
    public boolean isPresencia() {
        return presencia;
    }

    /**
     * @param presencia the presencia to set
     */
    public void setPresencia(boolean presencia) {
        this.presencia = presencia;
    }

    /**
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the objFinal
     */
    public Final getObjFinal() {
        return objFinal;
    }

    /**
     * @param objFinal the objFinal to set
     */
    public void setObjFinal(Final objFinal) {
        this.objFinal = objFinal;
    }

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
        this.alumno.setIdAlumno(idAlumno);
        this.objFinal = new Final();
        this.objFinal.setIdFinal(idFinal);
    }
    private Date fecha;
    private int notaPractica;
    private int notaTeoria;
    private int notaFinal;
    private boolean presencia;
    private Alumno alumno;
    private Final objFinal;
}
