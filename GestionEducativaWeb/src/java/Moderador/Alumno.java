package Moderador;

import Entidad.ServletM;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Alumno extends ServletM {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Enumeraciones.AlumnoAction redirect = 
                Enumeraciones.AlumnoAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Alumno> alumnos = new ArrayList();
        Entidades.Alumno alumno = new Entidades.Alumno(0, 
            ((Entidades.Moderador)usuario).getIdModerador(), 0, "", 
            "", "", "", "", "", "", "");
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            alumnos = (List<Entidades.Alumno>)session.
                getAttribute("alumnos");
            alumno = alumnos.stream().
                filter(c -> c.getIdAlumno() == id).findFirst().get();                           
        } 
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/AlumnoAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarAlumno(alumno);
                    alumnos = (List<Entidades.Alumno>)(List<?>)controlador.buscarAlumnos();                       
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                session.setAttribute("alumnos", alumnos);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Alumno.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/AlumnoAM.jsp"); 
                    alumno = new Entidades.Alumno(0, 
                        ((Entidades.Moderador)usuario).getIdModerador(),
                        0, "", "", "", "", "", "", "", "");
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        
        session.setAttribute("alumno", alumno);
        dispatcher.forward(request, response);
    }
}
