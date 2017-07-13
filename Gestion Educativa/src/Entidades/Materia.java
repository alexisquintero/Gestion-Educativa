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
