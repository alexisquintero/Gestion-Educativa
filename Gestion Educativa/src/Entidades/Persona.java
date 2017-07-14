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
public abstract class Persona extends entidad{

    public Persona() {
        this.nombre = "nombre";
        this.apellido = "apellido";
        this.telefono = "telefono";
        this.email = "email";
        this.direccion = "direccion";
        this.legajo = "legajo";
        this.usuario = "usuario";
        this.clave = "clave";
    }

    /**
     * 
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Persona(String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.legajo = legajo;
        this.usuario = usuario;
        this.clave = clave;
    }
    public String nombre;
    public String apellido;
    public String telefono;
    public String email;
    public String direccion;
    public String legajo;
    public String usuario;
    public String clave;
}
