/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;


import Datos.DatoInscripcionHorario;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.InscripcionHorario;
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
        DatoInscripcionHorario datoInscripcionHorario = new DatoInscripcionHorario();
        try {
            InscripcionHorario InscripcionHorario = new InscripcionHorario(Date.valueOf(LocalDate.now()), 1, 1);
            datoInscripcionHorario.newObject(InscripcionHorario);
            
            ArrayList<entidad> InscripcionHorarioes = datoInscripcionHorario.getAll();
            
            //InscripcionHorario = (InscripcionHorario)datoInscripcionHorario.getOne(1);
            
            //InscripcionHorario.presencia= false;
            //datoInscripcionHorario.modify(InscripcionHorario);
             
            datoInscripcionHorario.delete(1);
            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
