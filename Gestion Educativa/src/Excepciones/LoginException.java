package Excepciones;

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
