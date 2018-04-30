package Excepciones;

public class CrearEntidadException extends ApplicationException{
    
    public CrearEntidadException() {
        this.message = "Error al crear Entidad";
    }

    public CrearEntidadException(Throwable cause) {
        super(cause);
        this.message = "Error al crear Entidad";
    }
    
    public CrearEntidadException(String message, Throwable cause) {
        super(message, cause);
    }  
}
