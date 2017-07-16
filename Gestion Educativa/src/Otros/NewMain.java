/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;


import Datos.DatoHorario;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Horario;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Supervisor
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatoHorario datoHorario = new DatoHorario();
        try {
            Horario horario = new Horario(0, "Dia", Time.valueOf(LocalTime.now()), Time.valueOf(LocalTime.now()), 1, 1);
            datoHorario.newObject(horario);
            
            ArrayList<entidad> horarios = datoHorario.getAll();
            
            horario = (Horario)datoHorario.getOne(1);
            
            horario.dia = "diaMod";
            datoHorario.modify(horario);
             
            datoHorario.delete(1);
            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
