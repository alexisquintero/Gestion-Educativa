package Excepciones;

public class ModificarEntidadException extends ApplicationException{  
    
    public ModificarEntidadException() {
        this.message = "Error al modificar Entidad";
    }

    public ModificarEntidadException(Throwable cause) {
        super(cause);
        this.message = "Error al modificar Entidad";
    }
    
    public ModificarEntidadException(String message, Throwable cause) {
        super(message, cause);
    }     
}
