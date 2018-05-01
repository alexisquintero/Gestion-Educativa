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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

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
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
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
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
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
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
                    }
                }      
            case Bedel: {
                try {
                    List<entidad> bedeles = controlador.buscarBedel();
                    session.setAttribute("bedeles", bedeles);
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/Bedel.jsp");break;
                } catch (ApplicationException ex) {
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
            }
            default:
                response.sendRedirect("LoginAdministrador.jsp"); return;
        }
        dispatcher.forward(request, response);
    }
}
