package Menu;

import Entidad.Servlet;
import Entidades.Alumno;
import Entidades.Materia;
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
                        List<Materia> materiasInsc = controlador.
                            buscarMateriasInscripcion(((Alumno)usuario));
                        session.setAttribute("materiasInsc", materiasInsc);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/InscripcionMateria.jsp");break;
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
                        List<Materia> materiasFin = controlador.
                            buscarMateriasInscripcionFinal(((Alumno)usuario));
                        session.setAttribute("materiasFin", materiasFin);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/InscripcionFinal.jsp");break;
                    } catch (ApplicationException ex) {
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
                    }
                }
                case NotaPromedio: 
                {
                    try {
                        float nota = controlador.
                            notaPromedioAlumno(((Alumno)usuario));
                        session.setAttribute("nota", nota);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/NotaPromedio.jsp");break;
                    } catch (ApplicationException ex) {
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
                    }
                }
            default:
                response.sendRedirect("LoginAlumno.jsp");
        }
        dispatcher.forward(request, response);
    }
}
