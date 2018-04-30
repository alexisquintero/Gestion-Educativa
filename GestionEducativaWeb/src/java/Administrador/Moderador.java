package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Moderador extends Servlet {  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
               
        Enumeraciones.ModeradorAction redirect = 
                Enumeraciones.ModeradorAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Moderador> moderadores = null;
        Entidades.Moderador moderador = new Entidades.
            Moderador(0, ((Entidades.Administrador)usuario).getIdAdministrador(),
                    "", "", "", "", "", "", "", "");
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
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                session.setAttribute("moderadores", moderadores);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Moderador.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ModeradorAM.jsp");
                    moderador = new Entidades.
                        Moderador(0, ((Entidades.Administrador)usuario).getIdAdministrador(),
                                "", "", "", "", "", "", "", "");
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp");
        }
        
        session.setAttribute("moderador", moderador);
        dispatcher.forward(request, response);
    }
}
