/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
     * @param administrador
     * @param correlativas
     * @param finales 
     */
    public Materia(int idMateria, String nombre, String descripcion, Date año, boolean electiva, int horasSemana, Administrador administrador, ArrayList<Materia> correlativas, ArrayList<Final> finales) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.año = año;
        this.electiva = electiva;
        this.horasSemana = horasSemana;
        this.administrador = administrador;
        this.correlativas = correlativas;
        this.finales = finales;
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
}
