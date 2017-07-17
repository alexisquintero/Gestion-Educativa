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
public class EliminarEntidadException extends ApplicationException{  
    
    public EliminarEntidadException() {
        this.message = "Error al eliminar Entidad";
    }

    public EliminarEntidadException(Throwable cause) {
        super(cause);
        this.message = "Error al eliminar Entidad";
    }
    
    public EliminarEntidadException(String message, Throwable cause) {
        super(message, cause);
    }  
    
}
