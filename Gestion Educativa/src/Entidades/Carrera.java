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
     * @param administrador
     * @param materias 
     */
    public Carrera(int idCarrera, String nombre, String descripcion, Administrador administrador, ArrayList<Materia> materias) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.administrador = administrador;
        this.materias = materias;
    }
    public int idCarrera;
    public String nombre;
    public String descripcion;
    public Administrador administrador;
    public ArrayList<Materia> materias;
}
