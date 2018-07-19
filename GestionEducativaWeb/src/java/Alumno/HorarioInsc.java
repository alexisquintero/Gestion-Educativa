package Alumno;

import Entidad.Servlet;
import Entidades.Horario;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HorarioInsc extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Enumeraciones.HorarioInscAction redirect = 
                Enumeraciones.HorarioInscAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Horario> horarios = 
            (List<Horario>)session.getAttribute("horarios");
        Entidades.Horario horario = null;
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            horario = horarios.stream().
                filter(h -> h.getIdHorario() == id).
                findAny().get();
        }
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Inscribir:
                try {
                    controlador.inscribirHorario(horario, (Entidades.Alumno)usuario);
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/MateriaInsc.jsp"); break;
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        dispatcher.forward(request, response);
    }
}
