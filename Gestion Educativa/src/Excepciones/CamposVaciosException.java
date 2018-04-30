package Excepciones;

public class CamposVaciosException extends ApplicationException{
    public CamposVaciosException() {
        this.message = "Faltan completar uno o varios campos";
    }

    public CamposVaciosException(Throwable cause) {
        super(cause);
        this.message = "Faltan completar uno o varios campos";
    }
    
    public CamposVaciosException(String message, Throwable cause) {
        super(message, cause);
    }  
    
    public CamposVaciosException(String message) {
        super(message);
    }  
}
