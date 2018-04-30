package Excepciones;

public class CorrelativaAprobadaException extends ApplicationException{
    public CorrelativaAprobadaException() {
        this.message = "Una materia no puede ser su misma correlativa aprobada";
    }

    public CorrelativaAprobadaException(Throwable cause) {
        super(cause);
        this.message = "Una materia no puede ser su misma correlativa aprobada";
    }
    
    public CorrelativaAprobadaException(String message, Throwable cause) {
        super(message, cause);
    }  
    
    public CorrelativaAprobadaException(String message) {
        super(message);
    }
}
