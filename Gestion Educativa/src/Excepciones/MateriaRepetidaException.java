package Excepciones;

public class MateriaRepetidaException extends ApplicationException{
    public MateriaRepetidaException() {
        this.message = "Por lo menos una materia se repite";
    }

    public MateriaRepetidaException(Throwable cause) {
        super(cause);
        this.message = "Por lo menos una materia se repite";
    }
    
    public MateriaRepetidaException(String message, Throwable cause) {
        super(message, cause);
    }  
    
    public MateriaRepetidaException(String message) {
        super(message);
    }
}
