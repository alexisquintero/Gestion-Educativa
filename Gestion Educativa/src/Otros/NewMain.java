/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import Datos.DatoAdministrador;
import Datos.DatoBedel;
import Datos.DatoCarrera;
import Datos.DatoMateria;
import Datos.DatoModerador;
import Datos.DatoComision;
import Datos.DatoDocente;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Administrador;
import Entidades.Bedel;
import Entidades.Carrera;
import Entidades.Comision;
import Entidades.Docente;
import Entidades.Materia;
import Entidades.Moderador;
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
        /*
        DatoAdministrador da = new DatoAdministrador();
        DatoCarrera dc = new DatoCarrera();
        DatoMateria dm = new DatoMateria();
        DatoModerador dmo = new DatoModerador();
        DatoBedel db = new DatoBedel();
        DatoComision dco = new DatoComision();
        */
        DatoDocente dd = new DatoDocente();
        try {
            /*
            Administrador administrador = new Administrador(4,"AdministradorModificado", "Netbeans3", "telefono", "email", "direccion", "legajo", "usuario", "clave");
            da.modify(administrador);
            //da.newObject(administrador);
            Administrador administrador2 = (Administrador)da.getOne(4);
            
            ArrayList<entidad> administradores = da.getAll();
            System.out.println("Conectado");            

            Carrera carrera = new Carrera(0, "Carrera", "Primera", 1);
            dc.newObject(carrera);
            
            ArrayList<entidad> carreras = dc.getAll();
            
            carrera = (Carrera)dc.getOne(1);
            
            carrera.nombre = "CarreraModificada";
            dc.modify(carrera);
           
            Materia materia = new Materia(0, "Materia", "Tercera", Date.valueOf(LocalDate.now()), true, 4, 1);
            dm.newObject(materia);
            
            ArrayList<entidad> materias = dm.getAll();
            
            materia = (Materia)dm.getOne(1);
            
            materia.nombre = "MateriaModificada";
            dm.modify(materia);
            
            System.out.println("Conectado"); 
           
            Moderador moderador = new Moderador(0, 1, "Moderador", "Netbeans", "telefono", "email", "direccion", "legajo", "usuario", "clave");
            dmo.newObject(moderador);
            
            ArrayList<entidad> moderadores = dmo.getAll();
            
            moderador = (Moderador)dmo.getOne(1);
            
            moderador.nombre = "ModeradorModificada";
            dmo.modify(moderador);
            
            Bedel bedel = new Bedel(0, 1, "Bedel", "Netbeans", "telefono", "email", "direccion", "legajo", "usuario", "clave");
            db.newObject(bedel);
            
            ArrayList<entidad> bedeles = db.getAll();
            
            bedel = (Bedel)db.getOne(1);
            
            bedel.nombre = "BedelModificado";
            db.modify(bedel);
             
            db.delete(1);
            
            Comision comision = new Comision(0, "Aula", 10, 1);
            dco.newObject(comision);
            
            ArrayList<entidad> comisiones = dco.getAll();
            
            comision = (Comision)dco.getOne(1);
            
            comision.aula = "AulaMod";
            dco.modify(comision);
             
            dco.delete(1);
*/            
            Docente docente = new Docente(0, 1, "Docente", "Netbeans", "telefono", "email", "direccion", "legajo", "usuario", "clave");
            dd.newObject(docente);
            
            ArrayList<entidad> docentes = dd.getAll();
            
            docente = (Docente)dd.getOne(1);
            
            docente.nombre = "DocenteModificado";
            dd.modify(docente);
             
            dd.delete(1);
            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
