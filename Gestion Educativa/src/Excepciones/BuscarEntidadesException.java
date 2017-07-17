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
public class BuscarEntidadesException extends ApplicationException{
    
    public BuscarEntidadesException() {
        this.message = "Error al buscar Entidades";
    }

    public BuscarEntidadesException(Throwable cause) {
        super(cause);
        this.message = "Error al buscar Entidades";
    }
    
    public BuscarEntidadesException(String message, Throwable cause) {
        super(message, cause);
    }  
}
