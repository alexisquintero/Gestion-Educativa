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
    public ArrayList<InscripcionFinal> inscripciones;

    /**
     * 
     * @param idAlumno
     * @param idModerador
     * @param idCarrera
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Alumno(int idAlumno, int idModerador, int idCarrera, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idAlumno = idAlumno;
        this.moderador = new Moderador();
        this.moderador.idModerador = idModerador; 
        this.carrera = new Carrera();
        this.carrera.idCarrera = idCarrera;
    }

    Alumno() {
        super();
        this.idAlumno = 0;
        this.moderador = new Moderador();
        this.carrera = new Carrera();
    }

}
