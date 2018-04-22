/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class Materia extends entidad{

    /**
     * @return the correlativasRegulares
     */
    public ArrayList<entidad> getCorrelativasRegulares() {
        return correlativasRegulares;
    }

    /**
     * @param correlativasRegulares the correlativasRegulares to set
     */
    public void setCorrelativasRegulares(ArrayList<entidad> correlativasRegulares) {
        this.correlativasRegulares = correlativasRegulares;
    }

    /**
     * @return the idMateria
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * @param idMateria the idMateria to set
     */
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the anio
     */
    public Date getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Date anio) {
        this.anio = anio;
    }

    /**
     * @return the electiva
     */
    public boolean isElectiva() {
        return electiva;
    }

    /**
     * @param electiva the electiva to set
     */
    public void setElectiva(boolean electiva) {
        this.electiva = electiva;
    }

    /**
     * @return the horasSemana
     */
    public int getHorasSemana() {
        return horasSemana;
    }

    /**
     * @param horasSemana the horasSemana to set
     */
    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    /**
     * @return the administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the correlativas
     */
    public ArrayList<entidad> getCorrelativasAprobadas() {
        return correlativasAprobadas;
    }

    /**
     * @param correlativasAprobadas the correlativasAprobadas    to set
     */
    public void setCorrelativasAprobadas(ArrayList<entidad> correlativasAprobadas) {
        this.correlativasAprobadas = correlativasAprobadas;
    }

    /**
     * @return the finales
     */
    public ArrayList<Final> getFinales() {
        return finales;
    }

    /**
     * @param finales the finales to set
     */
    public void setFinales(ArrayList<Final> finales) {
        this.finales = finales;
    }

    /**
     * 
     * @param idMateria
     * @param nombre
     * @param descripcion
     * @param anio
     * @param electiva
     * @param horasSemana 
     * @param idAdministrador 
     */
    public Materia(int idMateria, String nombre, String descripcion, Date anio, boolean electiva, int horasSemana, int idAdministrador) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anio = anio;
        this.electiva = electiva;
        this.horasSemana = horasSemana;
        this.administrador = new Administrador();
        this.administrador.setIdAdministrador(idAdministrador);
    }
    private int idMateria;
    private String nombre;
    private String descripcion;
    private Date anio;
    private boolean electiva;
    private int horasSemana;
    private Administrador administrador;
    private ArrayList<entidad> correlativasAprobadas;
    private ArrayList<entidad> correlativasRegulares;
    private ArrayList<Final> finales;

    Materia() {
       this.idMateria = 0;
        this.nombre = "nombre";
        this.descripcion = "descripcion";
        this.anio = Date.valueOf(LocalDate.MIN);
        this.electiva = false;
        this.horasSemana = 0;
        this.administrador = new Administrador(); 
        this.correlativasAprobadas = new ArrayList<>();
        this.correlativasRegulares = new ArrayList<>();
    }
}
