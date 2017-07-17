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
public class ConnectSqlException extends ApplicationException{  
    
    public ConnectSqlException() {
        this.message = "Error al conectarse a la base de datos";
    }

    public ConnectSqlException(Throwable cause) {
        super(cause);
        this.message = "Error al conectarse a la base de datos";
    }
    
    public ConnectSqlException(String message, Throwable cause) {
        super(message, cause);
    }  
}
