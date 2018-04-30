package Excepciones;

public class EliminarEntidadException extends ApplicationException{  
    
    public EliminarEntidadException() {
        this.message = "Error al eliminar Entidad";
    }

    public EliminarEntidadException(Throwable cause) {
        super(cause);
        this.message = "Error al eliminar Entidad";
    }
    
    public EliminarEntidadException(String message, Throwable cause) {
        super(message, cause);
    }  
    
}
