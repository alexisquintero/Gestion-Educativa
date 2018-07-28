package Excepciones;

public class InscripcionHorarioRepetidaException extends ApplicationException{
    public InscripcionHorarioRepetidaException() {
        this.message = "Ya está inscripto a esta materia en este horario";
    }

    public InscripcionHorarioRepetidaException(Throwable cause) {
        super(cause);
        this.message = "Ya está inscripto a esta materia en este horario";
    }
    
    public InscripcionHorarioRepetidaException(String message, Throwable cause) {
        super(message, cause);
    }  
    
    public InscripcionHorarioRepetidaException(String message) {
        super(message);
    }
}
