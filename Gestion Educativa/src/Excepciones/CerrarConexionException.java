package Excepciones;

public class CerrarConexionException extends ApplicationException{  
    
    public CerrarConexionException() {
        this.message = "Error al cerrar la conexión a la base de datos";
    }

    public CerrarConexionException(Throwable cause) {
        super(cause);
        this.message = "Error al cerrar la conexión a la base de datos";
    }
    
    public CerrarConexionException(String message, Throwable cause) {
        super(message, cause);
    }  
}
