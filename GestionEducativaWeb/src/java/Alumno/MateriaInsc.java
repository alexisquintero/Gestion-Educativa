package Alumno;

import Entidad.Servlet;
import Entidades.Horario;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import Otros.Enumeraciones.MateriaInscAction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MateriaInsc extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        MateriaInscAction redirect = 
                MateriaInscAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Horario> horarios = new ArrayList();
        Entidades.Materia materia = new Entidades.Materia(0, "", "", 
                Enumeraciones.Anios.Primero.toString(), false, 0,
                ((Entidades.Alumno)usuario).getIdAlumno());
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            materia.setIdMateria(id);
        }
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Inscribir:
                try {
                    horarios = controlador.buscarHorariosMaterias(materia);
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                session.setAttribute("horarios", horarios);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/HorariosInsc.jsp"); break;
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        dispatcher.forward(request, response);
    }
}
