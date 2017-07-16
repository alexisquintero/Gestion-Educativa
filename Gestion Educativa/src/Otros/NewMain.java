/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;


import Datos.DatoInscripcionFinal;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.InscripcionFinal;
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
        DatoInscripcionFinal datoInscripcionFinal = new DatoInscripcionFinal();
        try {
            InscripcionFinal InscripcionFinal = new InscripcionFinal(Date.valueOf(LocalDate.now()), 6, 6, 6, true, 1, 1);
            datoInscripcionFinal.newObject(InscripcionFinal);
            
            ArrayList<entidad> InscripcionFinales = datoInscripcionFinal.getAll();
            
            //InscripcionFinal = (InscripcionFinal)datoInscripcionFinal.getOne(1);
            
            InscripcionFinal.presencia= false;
            datoInscripcionFinal.modify(InscripcionFinal);
             
            //datoInscripcionFinal.delete(1);
            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
