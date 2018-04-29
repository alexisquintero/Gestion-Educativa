/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidad.Servlet;
import Entidades.entidad;
import Excepciones.ApplicationException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
public class MenuAdministrador extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);

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
            case Moderador: 
                {
                    try {
                        List<entidad> moderadores = controlador.buscarModeradores();
                        session.setAttribute("moderadores", moderadores);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/Moderador.jsp");break;
                    } catch (ApplicationException ex) {
                        Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                }                        
            case Materia:
                {
                    try {
                        List<entidad> materias = controlador.buscarMaterias();
                        session.setAttribute("materias", materias);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/Materia.jsp");break;
                    } catch (ApplicationException ex) {
                        Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                }      
            case Bedel: {
                try {
                    List<entidad> bedeles = controlador.buscarBedel();
                    session.setAttribute("bedeles", bedeles);
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/Bedel.jsp");break;
                } catch (ApplicationException ex) {
                    Logger.getLogger(MenuAdministrador.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        dispatcher.forward(request, response);
    }
}
