package Excepciones;

public class FinalesFinalException extends ApplicationException{
    
    public FinalesFinalException() {
        this.message = 
            "Error al buscar los finales de un final";
    }

    public FinalesFinalException(Throwable cause) {
        super(cause);
        this.message = 
            "Error al buscar los finales de un final";
    }
    
    public FinalesFinalException(String message, Throwable cause) {
        super(message, cause);
    }
}
