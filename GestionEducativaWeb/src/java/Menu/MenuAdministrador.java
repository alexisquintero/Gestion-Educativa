/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidades.Persona;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Negocio.ControladorGestion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Otros.Enumeraciones.MenuAdministradorOpciones;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
@WebServlet(name = "MenuAdministrador", urlPatterns = {"/MenuAdministrador"})
public class MenuAdministrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Persona usuario = null;
        HttpSession session = request.getSession();
        usuario = (Persona)session.getAttribute("usuario");
        ControladorGestion controlador = 
        (ControladorGestion)session.getAttribute("ControladorGestion");
              
        if(usuario == null) {response.sendError(401, "Login required"); return;}
        
        MenuAdministradorOpciones redirect = 
                MenuAdministradorOpciones.
                        valueOf(request.getParameter("redirect"));
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");    
        switch (redirect) {
            case Carrera: 
                {
                    try {
                        List<entidad> carreras = controlador.buscarCarreras();
                        session.setAttribute("carreras", carreras);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/Carrera.jsp");break;
                    } catch (ApplicationException ex) {
                        Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                }              
            case Moderador: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Moderador.jsp");break;
            case Docente: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Docente.jsp");break;
            case Materia: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Materia.jsp");break;                            
            default:
                response.sendRedirect("LoginAlumno.jsp");
        }
        dispatcher.forward(request, response);
    }
}
