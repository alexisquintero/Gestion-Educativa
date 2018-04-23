/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Entidad.Servlet;
import Entidades.Persona;
import Excepciones.ApplicationException;
import Excepciones.LoginException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
public class LoginModerador extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();      
        HttpSession session = request.getSession();       
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            out.println(e1.getMessage());
        }      
        
        Persona persona = null;
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/MenuModerador.jsp");
        try{
            persona = controlador.
                    loginModerador(
                            request.getParameter("usuario"), 
                            request.getParameter("password"));
        }catch (LoginException le){
            session.setAttribute("error", le.getMessage());
            dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");       	
        }catch(ApplicationException e){              
            out.println(e.getMessage());
        }       
        
        session.setAttribute("ControladorGestion", controlador);
        session.setAttribute("usuario", persona);     
        
        dispatcher.forward(request, response);
        
    }
}
