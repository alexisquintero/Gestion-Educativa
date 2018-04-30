package Moderador;

import Entidad.ServletM;
import Excepciones.ApplicationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AlumnoCarrera extends ServletM {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        int id = Integer.parseInt(request.getParameter("id"));

        RequestDispatcher dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/Error.jsp");        
        try {
            List<Entidades.Carrera> carreras = (List<Entidades.Carrera>)
                            (List<?>)controlador.buscarCarreras();
            carreras = carreras.stream().
                filter(c -> c.getIdCarrera() != id).collect(Collectors.toList());
            session.setAttribute("carreras", carreras);
            dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/AlumnoCarrera.jsp"); 
        } catch (ApplicationException ex) {
            session.setAttribute("error", ex.getMessage());
            dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
            dispatcher.forward(request, response); return;
        }
        dispatcher.forward(request, response); 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        String sId = request.getParameter("idCarrera");
        if(null == sId){
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/AlumnoCarrera.jsp"); 
                    dispatcher.forward(request, response); return;
        }
        int id = Integer.parseInt(sId);
        List<Entidades.Carrera> carreras = 
                (List<Entidades.Carrera>)session.getAttribute("carreras");
        Entidades.Carrera carrera = carreras.stream().
                filter(c -> c.getIdCarrera() == id).findFirst().get();
        Entidades.Alumno alumno = (Entidades.Alumno)session.getAttribute("alumno");
        alumno.setCarrera(carrera);
        session.setAttribute("alumno", alumno);
        
        RequestDispatcher dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/AlumnoAM.jsp"); 
        dispatcher.forward(request, response);
    }
}
