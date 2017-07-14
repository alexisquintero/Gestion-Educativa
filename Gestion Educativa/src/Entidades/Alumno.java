/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class Alumno extends Persona{
    public int idAlumno;
    public Moderador moderador;
    public Carrera carrera;
    public ArrayList<Comision> comisiones;
    public ArrayList<Inscripcion> inscripciones;

    /**
     * 
     * @param idAlumno
     * @param moderador
     * @param carrera
     * @param comisiones
     * @param inscripciones
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Alumno(int idAlumno, Moderador moderador, Carrera carrera, ArrayList<Comision> comisiones, ArrayList<Inscripcion> inscripciones, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idAlumno = idAlumno;
        this.moderador = moderador;
        this.carrera = carrera;
        this.comisiones = comisiones;
        this.inscripciones = inscripciones;
    }

}
