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
     * @return the idDocente
     */
    public int getIdDocente() {
        return idDocente;
    }

    /**
     * @param idDocente the idDocente to set
     */
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    /**
     * @return the moderador
     */
    public Moderador getModerador() {
        return moderador;
    }

    /**
     * @param moderador the moderador to set
     */
    public void setModerador(Moderador moderador) {
        this.moderador = moderador;
    }

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
    public Docente(int idDocente, int idModerador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idDocente = idDocente;
        this.moderador = new Moderador();
        this.moderador.setIdModerador(idModerador);
    }
    
    private int idDocente;
    private Moderador moderador;
}
