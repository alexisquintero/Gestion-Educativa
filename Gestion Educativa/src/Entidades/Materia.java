/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Supervisor
 */
public class Materia extends entidad{

    /**
     * 
     * @param idMateria
     * @param nombre
     * @param descripcion
     * @param año
     * @param electiva
     * @param horasSemana 
     * @param idAdministrador 
     */
    public Materia(int idMateria, String nombre, String descripcion, Date año, boolean electiva, int horasSemana, int idAdministrador) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.año = año;
        this.electiva = electiva;
        this.horasSemana = horasSemana;
        this.administrador = new Administrador();
        this.administrador.idAdministrador = idAdministrador;
    }
    public int idMateria;
    public String nombre;
    public String descripcion;
    public Date año;
    public boolean electiva;
    public int horasSemana;
    public Administrador administrador;
    public ArrayList<Materia> correlativas;
    public ArrayList<Final> finales;

    Materia() {
       this.idMateria = 0;
        this.nombre = "nombre";
        this.descripcion = "descripcion";
        this.año = Date.from(Instant.EPOCH);
        this.electiva = false;
        this.horasSemana = 0;
        this.administrador = new Administrador(); 
    }
}
