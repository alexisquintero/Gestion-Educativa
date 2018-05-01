package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Otros.Enumeraciones.CarreraAction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Carrera", urlPatterns = {"/Carrera"})
public class Carrera extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        CarreraAction redirect = 
                CarreraAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Carrera> carreras = new ArrayList();
        Entidades.Carrera carrera = new Entidades.Carrera(0, "", "", 
            ((Entidades.Administrador)usuario).getIdAdministrador(), null);
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            carreras = (List<Entidades.Carrera>)session.
                getAttribute("carreras");
            carrera = carreras.stream().
                filter(c -> c.getIdCarrera() == id).findFirst().get();                 
        }              
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarCarrera(carrera);
                    carreras = (List<Entidades.Carrera>)(List<?>)controlador.buscarCarreras();                       
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                session.setAttribute("carreras", carreras);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Carrera.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp"); 
                    carrera = new Entidades.
                        Carrera(0, "", "", 
                        ((Entidades.Administrador)usuario).getIdAdministrador(), null);
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        
        session.setAttribute("carrera", carrera);
        dispatcher.forward(request, response);
    }  
}
