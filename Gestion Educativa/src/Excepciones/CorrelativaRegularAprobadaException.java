package Excepciones;

public class CorrelativaRegularAprobadaException extends ApplicationException{
    public CorrelativaRegularAprobadaException() {
        this.message = "Una materia no puede ser correlativa regular y aprobada a la vez";
    }

    public CorrelativaRegularAprobadaException(Throwable cause) {
        super(cause);
        this.message = "Una materia no puede ser correlativa regular y aprobada a la vez";
    }
    
    public CorrelativaRegularAprobadaException(String message, Throwable cause) {
        super(message, cause);
    }  
    
    public CorrelativaRegularAprobadaException(String message) {
        super(message);
    }
}
