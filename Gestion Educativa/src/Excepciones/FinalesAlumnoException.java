package Excepciones;

public class FinalesAlumnoException extends ApplicationException{
    
    public FinalesAlumnoException() {
        this.message = 
            "Error al buscar los finales de un alumno";
    }

    public FinalesAlumnoException(Throwable cause) {
        super(cause);
        this.message = 
            "Error al buscar los finales de un alumno";
    }
    
    public FinalesAlumnoException(String message, Throwable cause) {
        super(message, cause);
    } 
}
