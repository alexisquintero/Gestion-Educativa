package Excepciones;

public abstract class ApplicationException extends Exception {       
	
    protected static final long serialVersionUID = 1L;
    protected String message;
    protected Throwable cause;
		
    @Override
    public String getMessage()
    {
        return message;
    }
		
    @Override
    public Throwable getCause()
    {
        return cause;
    }
		
    public ApplicationException(String message, Throwable cause)
    {
        this.message=message;
	this.cause=cause;
    }
    
    public ApplicationException(Throwable cause) {
        this.cause = cause;
        this.message = cause.getMessage();
    }
    
    public ApplicationException() {
    }
    
    public ApplicationException(String message)
    {
        this.message=message;
    }
}
