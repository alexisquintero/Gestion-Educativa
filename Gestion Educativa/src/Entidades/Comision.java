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
public class Comision extends entidad{

    /**
     * @return the idComision
     */
    public int getIdComision() {
        return idComision;
    }

    /**
     * @param idComision the idComision to set
     */
    public void setIdComision(int idComision) {
        this.idComision = idComision;
    }

    /**
     * @return the aula
     */
    public String getAula() {
        return aula;
    }

    /**
     * @param aula the aula to set
     */
    public void setAula(String aula) {
        this.aula = aula;
    }

    /**
     * @return the cupo
     */
    public int getCupo() {
        return cupo;
    }

    /**
     * @param cupo the cupo to set
     */
    public void setCupo(int cupo) {
        this.cupo = cupo;
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
     * @return the horarios
     */
    public ArrayList<entidad> getHorarios() {
        return horarios;
    }

    /**
     * @param horarios the horarios to set
     */
    public void setHorarios(ArrayList<entidad> horarios) {
        this.horarios = horarios;
    }

    /**
     * 
     * @param idComision
     * @param aula
     * @param cupo
     * @param idModerador
     */
    public Comision(int idComision, String aula, int cupo, int idModerador) {
        this.idComision = idComision;
        this.aula = aula;
        this.cupo = cupo;
        this.moderador = new Moderador();
        this.moderador.setIdModerador(idModerador);
        this.horarios = new ArrayList();
        this.parciales = new ArrayList();
    }
    private int idComision;
    private String aula;
    private int cupo;
    private Moderador moderador;
    private ArrayList<entidad> horarios; 
    private ArrayList<entidad> parciales;

    Comision() {
        this.idComision = 0;
        this.aula = "aula";
        this.cupo = 0;
        this.moderador = new Moderador();
        this.horarios = new ArrayList();
        this.parciales = new ArrayList();
    }

    /**
     * @return the parciales
     */
    public ArrayList<entidad> getParciales() {
        return parciales;
    }

    /**
     * @param parciales the parciales to set
     */
    public void setParciales(ArrayList<entidad> parciales) {
        this.parciales = parciales;
    }
}
