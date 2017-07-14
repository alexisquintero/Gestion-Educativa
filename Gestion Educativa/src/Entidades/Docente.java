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

    public Docente(String cargo, Moderador moderador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.cargo = cargo;
        this.moderador = moderador;
    }
    public int idDocente;
    public String cargo;
    public Moderador moderador;
}
