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
     * @param idModerador
     */
    public Comision(int idComision, String aula, int cupo, int idModerador) {
        this.idComision = idComision;
        this.aula = aula;
        this.cupo = cupo;
        this.moderador = new Moderador();
        this.moderador.idModerador = idModerador;
    }
    public int idComision;
    public String aula;
    public int cupo;
    public Moderador moderador;
    public ArrayList<Horario> horarios; 
}
