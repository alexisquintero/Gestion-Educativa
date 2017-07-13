/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Supervisor
 */
public class Final extends entidad{
    public int idFinal;
    public Date fecha;
    public Time horaInicio;
    public Time horaFin;
    public String aula;
    public ArrayList<Inscripcion> inscripciones;
}
