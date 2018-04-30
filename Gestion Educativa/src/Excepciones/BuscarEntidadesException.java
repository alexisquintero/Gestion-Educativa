package Excepciones;

public class BuscarEntidadesException extends ApplicationException{
    
    public BuscarEntidadesException() {
        this.message = "Error al buscar Entidades";
    }

    public BuscarEntidadesException(Throwable cause) {
        super(cause);
        this.message = "Error al buscar Entidades";
    }
    
    public BuscarEntidadesException(String message, Throwable cause) {
        super(message, cause);
    }  
}
