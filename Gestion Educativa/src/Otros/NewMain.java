/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;


import Datos.DatoAsistencia;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Asistencia;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Supervisor
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatoAsistencia da = new DatoAsistencia();
        try {
            Asistencia asistencia = new Asistencia(Date.valueOf(LocalDate.now()),false, 1, 1, 1);
            da.newObject(asistencia);
            
            ArrayList<entidad> asistencias = da.getAll();
            
            //asistencia = (Asistencia)da.getOne(1);
            
            asistencia.presencia = true;
            da.modify(asistencia);
             
           //da.delete(1);
            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
