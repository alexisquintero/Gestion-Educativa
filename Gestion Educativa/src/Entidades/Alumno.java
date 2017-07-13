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
public class Alumno extends Persona{
    public int idAlumno;
    public Moderador moderador;
    public Carrera carrera;
    public ArrayList<Comision> comisiones;
    public ArrayList<Inscripcion> inscripciones;
}
