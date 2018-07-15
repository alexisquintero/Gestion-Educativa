package Excepciones;

public class CantidadInscriptosComisionException extends ApplicationException{
    
    public CantidadInscriptosComisionException() {
        this.message = 
            "Error al determinar la cantidad de inscriptos en la comision";
    }

    public CantidadInscriptosComisionException(Throwable cause) {
        super(cause);
        this.message = 
            "Error al determinar la cantidad de inscriptos en la comision";
    }
    
    public CantidadInscriptosComisionException(String message, Throwable cause) {
        super(message, cause);
    } 
}
