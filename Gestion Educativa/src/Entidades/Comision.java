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
     * 
     * @param idComision
     * @param aula
     * @param cupo
     * @param moderador
     * @param materia
     * @param horarios
     * @param parciales 
     */
    public Comision(int idComision, String aula, int cupo, Moderador moderador, Materia materia, ArrayList<Horario> horarios, ArrayList<Parcial> parciales) {
        this.idComision = idComision;
        this.aula = aula;
        this.cupo = cupo;
        this.moderador = moderador;
        this.materia = materia;
        this.horarios = horarios;
        this.parciales = parciales;
    }
    public int idComision;
    public String aula;
    public int cupo;
    public Moderador moderador;
    public Materia materia;
    public ArrayList<Horario> horarios;
    public ArrayList<Parcial> parciales;   
}
