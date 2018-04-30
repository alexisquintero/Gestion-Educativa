package Excepciones;

public class CorrelativaRegularException extends ApplicationException{
    public CorrelativaRegularException() {
        this.message = "Una materia no puede ser su misma correlativa regular";
    }

    public CorrelativaRegularException(Throwable cause) {
        super(cause);
        this.message = "Una materia no puede ser su misma correlativa regular";
    }
    
    public CorrelativaRegularException(String message, Throwable cause) {
        super(message, cause);
    }  
    
    public CorrelativaRegularException(String message) {
        super(message);
    }
}
