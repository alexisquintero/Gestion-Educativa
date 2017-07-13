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
    public int idComision;
    public String aula;
    public int cupo;
    public Moderador moderador;
    public Materia materia;
    public ArrayList<Horario> horarios;
    public ArrayList<Parcial> parciales;   
}
