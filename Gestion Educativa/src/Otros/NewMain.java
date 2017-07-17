/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;


import Datos.DatoNotaParcial;
import Entidades.entidad;
import Excepciones.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.NotaParcial;
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
        DatoNotaParcial datoNotaParcial = new DatoNotaParcial();
        try {
            NotaParcial notaParcial = new NotaParcial(6, true, 1, 1);
            datoNotaParcial.newObject(notaParcial);
            
            ArrayList<entidad> notaParciales = datoNotaParcial.getAll();
            
            //notaParcial = (NotaParcial)datoNotaParcial.getOne(1);
            
            notaParcial.nota = 5;
            datoNotaParcial.modify(notaParcial);
             
            //datoNotaParcial.delete(1);
            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
