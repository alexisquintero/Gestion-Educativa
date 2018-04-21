/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Negocio.ControladorGestion;
import Otros.Enumeraciones.CarreraAction;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
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
        
        List<Entidades.Carrera> carreras = null;
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
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
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
                response.sendRedirect("LoginAlumno.jsp");
        }
        
        session.setAttribute("carrera", carrera);
        dispatcher.forward(request, response);
    }  
}
