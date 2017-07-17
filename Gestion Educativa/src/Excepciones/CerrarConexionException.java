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
public class CerrarConexionException extends ApplicationException{  
    
    public CerrarConexionException() {
        this.message = "Error al cerrar la conexión a la base de datos";
    }

    public CerrarConexionException(Throwable cause) {
        super(cause);
        this.message = "Error al cerrar la conexión a la base de datos";
    }
    
    public CerrarConexionException(String message, Throwable cause) {
        super(message, cause);
    }  
}
