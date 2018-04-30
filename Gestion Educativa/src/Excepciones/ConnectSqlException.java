package Excepciones;

public class ConnectSqlException extends ApplicationException{  
    
    public ConnectSqlException() {
        this.message = "Error al conectarse a la base de datos";
    }

    public ConnectSqlException(Throwable cause) {
        super(cause);
        this.message = "Error al conectarse a la base de datos";
    }
    
    public ConnectSqlException(String message, Throwable cause) {
        super(message, cause);
    }  
}
