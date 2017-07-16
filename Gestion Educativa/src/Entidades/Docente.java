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
public class Docente extends Persona{

    /**
     * 
     * @param idDocente
     * @param cargo
     * @param idModerador
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Docente(int idDocente, String cargo, int idModerador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idDocente = idDocente;
        this.cargo = cargo;
        this.moderador = new Moderador();
        this.moderador.idModerador = idModerador;
    }

    /**
     * 
     * @param idDocente
     * @param idModerador
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Docente(int idDocente, int idModerador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idDocente = idDocente;
        this.moderador = new Moderador();
        this.moderador.idModerador = idModerador;
    }
    public int idDocente;
    public String cargo;
    public Moderador moderador;
}
