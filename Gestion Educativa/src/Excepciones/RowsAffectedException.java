package Excepciones;

public class RowsAffectedException extends ApplicationException{  
    
    public RowsAffectedException() {
        this.message = "No se actualizó ninguna fila en la base de datos";
    }

    public RowsAffectedException(Throwable cause) {
        super(cause);
        this.message = "No se actualizó ninguna fila en la base de datos";
    }
    
    public RowsAffectedException(String message, Throwable cause) {
        super(message, cause);
    }  
}
