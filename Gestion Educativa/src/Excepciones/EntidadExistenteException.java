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
public class EntidadExistenteException extends ApplicationException{  

    public EntidadExistenteException() {
        this.message = "No se actualizó ninguna fila en la base de datos";
    }

    public EntidadExistenteException(Throwable cause) {
        super(cause);
        this.message = "No se actualizó ninguna fila en la base de datos";
    }
    
    public EntidadExistenteException(String message, Throwable cause) {
        super(message, cause);
    }  
    
    public EntidadExistenteException(String message) {
        super(message);
    }  
}
