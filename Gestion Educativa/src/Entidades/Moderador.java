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
public class Moderador extends Persona{

    public Moderador(int idModerador, Administrador administrador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idModerador = idModerador;
        this.administrador = administrador;
    }
    public int idModerador;
    public Administrador administrador;
}
