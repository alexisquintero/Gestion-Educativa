/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;


import Datos.DatoAlumno;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Alumno;
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
        DatoAlumno da = new DatoAlumno();
        try {
            Alumno alumno = new Alumno(0, 1, 1, "Alumno", "Netbeans", "telefono", "email", "direccion", "legajo", "usuario", "clave");
            da.newObject(alumno);
            
            ArrayList<entidad> alumnos = da.getAll();
            
            alumno = (Alumno)da.getOne(1);
            
            alumno.nombre = "AlumnoModificado";
            da.modify(alumno);
             
            da.delete(1);
            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
