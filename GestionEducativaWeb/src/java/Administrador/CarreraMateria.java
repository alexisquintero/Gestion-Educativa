package Administrador;

import Entidad.Servlet;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CarreraMateria", urlPatterns = {"/CarreraMateria"})
public class CarreraMateria extends Servlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Enumeraciones.CarreraMateria redirect = 
                Enumeraciones.CarreraMateria.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Materia> materias = new ArrayList();
        Entidades.Carrera carrera = (Entidades.Carrera)session.getAttribute("carrera");
        RequestDispatcher dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/Error.jsp");

        List<Entidades.Materia> materiasExistentes = 
                (List<Entidades.Materia>)(List<?>)carrera.getMaterias(); 
              
        switch (redirect) {
            case Agregar: 
                try {
                    materias = (List<Entidades.Materia>)
                            (List<?>)controlador.buscarMaterias();
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                }
                
                List<Entidades.Materia> materiasDisponible = new ArrayList(); 
                if(materiasExistentes.isEmpty()){
                    materiasDisponible = materias;
                }
                else {
                    if(!materias.isEmpty()){
                    materiasDisponible = 
                            materias.stream().
                            filter(m -> materiasExistentes.stream().
                                    noneMatch(me -> me.getIdMateria() == m.getIdMateria())).
                                    collect(Collectors.toList());         
                    } 
                }
                session.setAttribute("materiasDisponible", materiasDisponible);                
                dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/CarreraMateria.jsp");                  
                break;
            case Eliminar: 
                int id = Integer.parseInt(request.getParameter("id"));
                List<Entidades.Materia> materiasExistentesEliminada = 
                        materiasExistentes.stream().filter(m -> m.getIdMateria() != id).
                                collect(Collectors.toList());
                ArrayList<entidad> nMaterias = new ArrayList<>(materiasExistentesEliminada);
                carrera.setMaterias(nMaterias);
                session.setAttribute("carrera", carrera);  
                dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/CarreraAM.jsp");
                break;
            default:
                response.sendRedirect("LoginAlumno.jsp");;
        }       
        dispatcher.forward(request, response);
    }
}
