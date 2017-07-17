/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Supervisor
 */
public class ModificarEntidadException extends ApplicationException{  
    
    public ModificarEntidadException() {
        this.message = "Error al modificar Entidad";
    }

    public ModificarEntidadException(Throwable cause) {
        super(cause);
        this.message = "Error al modificar Entidad";
    }
    
    public ModificarEntidadException(String message, Throwable cause) {
        super(message, cause);
    }     
}
