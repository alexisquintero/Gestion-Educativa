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
public class Carrera extends entidad{

    /**
     * 
     * @param idCarrera
     * @param nombre
     * @param descripcion
     * @param idAdministrador
     */
    public Carrera(int idCarrera, String nombre, String descripcion, int idAdministrador) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.administrador = new Administrador();
        this.administrador.idAdministrador = idAdministrador;
    }
    public int idCarrera;
    public String nombre;
    public String descripcion;
    public Administrador administrador;
    public ArrayList<Materia> materias;

    Carrera() {
        this.idCarrera = 0;
        this.nombre = "nombre";
        this.descripcion = "descripcion";
        this.administrador = new Administrador();
    }
}
