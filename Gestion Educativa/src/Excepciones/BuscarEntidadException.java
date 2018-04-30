package Excepciones;

public class BuscarEntidadException extends ApplicationException{
    
    public BuscarEntidadException() {
        this.message = "Error al buscar Entidad";
    }

    public BuscarEntidadException(Throwable cause) {
        super(cause);
        this.message = "Error al buscar Entidad";
    }
    
    public BuscarEntidadException(String message, Throwable cause) {
        super(message, cause);
    }  
}
