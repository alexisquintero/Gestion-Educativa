/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Entidad.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.ControladorGestion;
import Entidades.Administrador;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
@WebServlet("/LoginAdministrador")
public class LoginAdministrador extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();       
        ControladorGestion controlador = new ControladorGestion();
        entidad persona = null;
        HttpSession session = request.getSession();
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            out.println(e1.getMessage());
        }   
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            out.println(e1.getMessage());
        }
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
            out.println(e.getMessage());
        }       
        
        session.setAttribute("ControladorGestion", controlador);
        session.setAttribute("usuario", persona);     
        
        dispatcher.forward(request, response);			
               
    }

}
