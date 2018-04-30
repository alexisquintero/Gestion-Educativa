package Moderador;

import Entidad.ServletM;
import Excepciones.ApplicationException;
import Otros.Enumeraciones.DocenteAction;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Docente extends ServletM {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        DocenteAction redirect = 
                DocenteAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Docente> docentes = null;
        Entidades.Docente docente = new Entidades.
            Docente(0, ((Entidades.Moderador)usuario).getIdModerador(), 
                    "", "", "", "", "", "", "", "");
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            docentes = (List<Entidades.Docente>)session.
                getAttribute("docentes");
            docente = docentes.stream().
                filter(c -> c.getIdDocente() == id).findFirst().get();                 
        }
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/DocenteAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarDocente(docente);
                    docentes = (List<Entidades.Docente>)(List<?>)controlador.buscarDocentes();                       
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                session.setAttribute("docentes", docentes);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Docente.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/DocenteAM.jsp");
                    docente = new Entidades.
                        Docente(0, ((Entidades.Moderador)usuario).getIdModerador(), 
                    "", "", "", "", "", "", "", "");
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp");
        }
        
        session.setAttribute("docente", docente);
        dispatcher.forward(request, response);
    }
}
