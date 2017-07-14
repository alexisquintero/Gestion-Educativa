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
     * @param alumno 
     */
    public NotaParcial(String nota, boolean presencia, Alumno alumno) {
        this.nota = nota;
        this.presencia = presencia;
        this.alumno = alumno;
    }
    public String nota;
    public boolean presencia;
    public Alumno alumno;
}
