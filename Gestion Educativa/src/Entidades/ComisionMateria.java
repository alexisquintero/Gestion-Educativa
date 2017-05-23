/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class ComisionMateria extends entidad{
    public int idComisionMateria;
    public LocalTime horarioInicio;
    public LocalTime horarioFin;
    public ArrayList<ComisionMateriaAlumno> comisionMateriaAlumno;
}
