/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Negocio.ControladorGestion;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
public class Moderador extends Servlet {  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Entidades.Administrador usuario = null;
        HttpSession session = request.getSession();
        usuario = (Entidades.Administrador)session.getAttribute("usuario");
        ControladorGestion controlador = 
        (ControladorGestion)session.getAttribute("ControladorGestion");
        
        if(usuario == null) {response.sendError(401, "Login required"); return;}
        
        Enumeraciones.ModeradorAction redirect = 
                Enumeraciones.ModeradorAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Moderador> moderadores = null;
        Entidades.Moderador moderador = new Entidades.
                Moderador(0, usuario.getIdAdministrador(), "", "", "", "", "", "", "", "");
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            moderadores = (List<Entidades.Moderador>)session.
                getAttribute("moderadores");
            moderador = moderadores.stream().
                filter(c -> c.getIdModerador()== id).findFirst().get();                 
        }    
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ModeradorAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarModerador(moderador);
                    moderadores = (List<Entidades.Moderador>)(List<?>)controlador.buscarModeradores();                       
                } catch (ApplicationException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("moderadores", moderadores);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Moderadores.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ModeradorAM.jsp");
                    moderador = new Entidades.
                        Moderador(0, usuario.getIdAdministrador(), "", "", "", "", "", "", "", "");
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp");
        }
        
        session.setAttribute("moderador", moderador);
        dispatcher.forward(request, response);
    }
}
