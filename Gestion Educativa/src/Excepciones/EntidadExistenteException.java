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

    public void setMessage(String message) {
        this.message = message;
    }
    
    public EntidadExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
