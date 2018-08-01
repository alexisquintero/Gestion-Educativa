package Excepciones;

public class CamposLoginVaciosException  extends ApplicationException{
    public CamposLoginVaciosException() {
        this.message = "Faltan completar uno o varios campos del login";
    }

    public CamposLoginVaciosException(Throwable cause) {
        super(cause);
        this.message = "Faltan completar uno o varios campos del login";
    }
    
    public CamposLoginVaciosException(String message, Throwable cause) {
        super(message, cause);
    }  
    
    public CamposLoginVaciosException(String message) {
        super(message);
    }
}
