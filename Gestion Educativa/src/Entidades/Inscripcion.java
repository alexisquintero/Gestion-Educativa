/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Supervisor
 */
public class Inscripcion extends entidad{
    public Date fecha;
    public int notaPractica;
    public int notaTeoria;
    public int notaFinal;
    public boolean presencia;
    public Alumno alumno;
}
