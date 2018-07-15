package Excepciones;

public class HorariosAlumnoException extends ApplicationException{
    
    public HorariosAlumnoException() {
        this.message = 
            "Error al buscar los horarios de un alumno";
    }

    public HorariosAlumnoException(Throwable cause) {
        super(cause);
        this.message = 
            "Error al buscar los horarios de un alumno";
    }
    
    public HorariosAlumnoException(String message, Throwable cause) {
        super(message, cause);
    } 
}
