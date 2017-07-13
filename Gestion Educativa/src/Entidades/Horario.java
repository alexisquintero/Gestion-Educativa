/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class Horario extends entidad{
    public String dia;
    public Time horaInicio;
    public Time horaFin;
    public ArrayList<Alumno> alumnos;
}
