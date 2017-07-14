/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import Datos.DatoAdministrador;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Administrador;

/**
 *
 * @author Supervisor
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatoAdministrador da = new DatoAdministrador();
        try {
            Administrador administrador = new Administrador(4,"AdministradorModificado", "Netbeans3", "telefono", "email", "direccion", "legajo", "usuario", "clave");
            da.modify(administrador);
            //da.newObject(administrador);
            Administrador administrador2 = (Administrador)da.getOne(4);
            
            ArrayList<entidad> administradores = da.getAll();
            System.out.println("Conectado");            
        } catch (ApplicationException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
