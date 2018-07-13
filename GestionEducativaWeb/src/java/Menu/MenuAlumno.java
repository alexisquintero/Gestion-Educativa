package Menu;

import Entidad.Servlet;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MenuAlumno extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        this.initialization(request, response, session);

        Enumeraciones.MenuAlumnoOpciones redirect = 
                Enumeraciones.MenuAlumnoOpciones.
                        valueOf(request.getParameter("redirect"));
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");   
        switch (redirect) {
            case InscripcionMateria: 
                {
                    try {
                        List<entidad> materiasInsc = controlador.buscarMateriasInscripcion();
                        session.setAttribute("materiasInsc", materiasInsc);
                    } catch (ApplicationException ex) {
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
                    }
                }
            case InscripcionFinal: 
                {
                    try {
                        List<entidad> materiasFin = controlador.buscarMateriasInscripcionFinal();
                        session.setAttribute("materiasFin", materiasFin);
                    } catch (ApplicationException ex) {
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
                    }
                }
            default:
                response.sendRedirect("LoginAdministrador.jsp");
        }
    }
}
