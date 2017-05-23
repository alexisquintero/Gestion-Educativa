/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Supervisor
 */
public class ApplicationException extends Exception {
	
    private static final long serialVersionUID = 1L;
    private String message;
    private Throwable cause;
		
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

}
