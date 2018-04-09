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
public class LoginException extends ApplicationException{
    public LoginException() {
        this.message = "Usuario y/o contraseña incorrectos";
    }

    public LoginException(Throwable cause) {
        super(cause);
        this.message = "Usuario y/o contraseña incorrectos";
    }
    
    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }  
}
