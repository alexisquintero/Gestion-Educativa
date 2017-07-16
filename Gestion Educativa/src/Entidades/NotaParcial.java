/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Supervisor
 */
public class NotaParcial extends entidad{

    /**
     * 
     * @param nota
     * @param presencia
     * @param idAlumno
     * @param idParcial 
     */
    public NotaParcial(String nota, boolean presencia, int idAlumno, int idParcial) {
        this.nota = nota;
        this.presencia = presencia;
        this.alumno = new Alumno();
        this.alumno.idAlumno = idAlumno;
        this.parcial = new Parcial();
        this.parcial.idParcial = idParcial;
    }
    public String nota;
    public boolean presencia;
    public Alumno alumno;
    public Parcial parcial;
}
