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
    public String nombre;
    public int cupo;
    public Moderador moderador;
    public ArrayList<ComisionMateria> materias;
}
