package Excepciones;

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
