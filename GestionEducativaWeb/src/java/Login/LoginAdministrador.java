package Login;

import Entidad.Servlet;
import Entidades.Persona;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Excepciones.ApplicationException;
import Excepciones.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class LoginAdministrador extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
             
        HttpSession session = request.getSession();       
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            session.setAttribute("error", e1.getMessage());
            RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
            dispatcher.forward(request, response); return;
        }      
        
        Persona persona = null;
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/MenuAdministrador.jsp");
        try{
            persona = controlador.
                    loginAdministrador(
                            request.getParameter("usuario"), 
                            request.getParameter("password"));
        }catch (LoginException le){
            session.setAttribute("error", le.getMessage());
            dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");       	
        }catch(ApplicationException e){              
            session.setAttribute("error", e.getMessage());
            dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
            dispatcher.forward(request, response); return;
        }       
        
        session.setAttribute("ControladorGestion", controlador);
        session.setAttribute("usuario", persona);     
        
        dispatcher.forward(request, response);			            
    }
}
