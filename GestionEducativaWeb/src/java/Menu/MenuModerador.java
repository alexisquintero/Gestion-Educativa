package Menu;

import Entidad.ServletM;
import Entidades.Alumno;
import Entidades.Final;
import Entidades.Materia;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MenuModerador extends ServletM {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);

        Enumeraciones.MenuModeradorOpciones redirect = 
                Enumeraciones.MenuModeradorOpciones.
                        valueOf(request.getParameter("redirect"));
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Alumno: {
                try {
                    List<entidad> alumnos = controlador.buscarAlumnos();
                    session.setAttribute("alumnos", alumnos);
                    for (entidad alumno : alumnos) {
                        ((Entidades.Alumno)alumno).
                        setCarrera((Entidades.Carrera)controlador.
                        buscarCarrera(((Entidades.Alumno)alumno).getCarrera()));
                    }
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/Alumno.jsp");break;
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
            }
            case Docente:
                {
                    try {
                        List<entidad> docentes = controlador.buscarDocentes();
                        session.setAttribute("docentes", docentes);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/Docente.jsp");break;
                    } catch (ApplicationException ex) {
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
                    }
                } 
            case Comision: {
                try {
                    List<entidad> comisiones = controlador.buscarComision();
                    session.setAttribute("comisiones", comisiones);
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/Comision.jsp");break;
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
            }    
            case NotaPromedioFinal: {
                try {
                    Map<Final, Float> promedioFinales = 
                        controlador.notaPromedioFinales();
                    session.setAttribute("promedioFinales", promedioFinales);
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/NotaPromedioFinal.jsp");break;
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
            }
            case NotaPromedioAlumno: {
                try {
                    Map<Alumno, Float> promedioAlumnos = 
                        controlador.notaPromedioAlumnos();
                    session.setAttribute("promedioAlumnos", promedioAlumnos);
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/NotaPromedioAlumno.jsp");break;
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
            }
            case CantidadAlumnosMateria: {
                try {
                    Map<Materia, Integer> materiasAlumnos = 
                        controlador.cantidadAlumnosMaterias();
                    session.setAttribute("materiasAlumnos", materiasAlumnos);
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/CantidadAlumnosMateria.jsp");break;
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
            }
            default:
                response.sendRedirect("LoginModerador.jsp"); return;
        }
        dispatcher.forward(request, response);
    }
}
