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
public class Bedel extends Persona{

    /**
     * 
     * @param idBedel
     * @param idAdministrador
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Bedel(int idBedel, int idAdministrador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idBedel = idBedel;
        this.administrador = new Administrador();
        this.administrador.idAdministrador = idAdministrador;
    }
    public int idBedel;
    public Administrador administrador;

    Bedel() {
        super();
        this.idBedel = 0;
        this.administrador = new Administrador();
    }
}
