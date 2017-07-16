/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;


import Datos.DatoParcial;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Parcial;
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
        DatoParcial datoParcial = new DatoParcial();
        try {
            Parcial parcial = new Parcial(0, "Descripcion", Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.MIN), Time.valueOf(LocalTime.MIN), 1);
            datoParcial.newObject(parcial);
            
            ArrayList<entidad> parciales = datoParcial.getAll();
            
            parcial = (Parcial)datoParcial.getOne(1);
            
            parcial.descripcion = "DescripcionModificada";
            datoParcial.modify(parcial);
             
            datoParcial.delete(1);
            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
