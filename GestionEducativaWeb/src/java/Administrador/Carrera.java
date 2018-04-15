/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Entidades.Persona;
import Negocio.ControladorGestion;
import Otros.Enumeraciones.CarreraAction;
import java.io.IOException;
import java.util.ArrayList;
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Entidades.Administrador usuario = null;
        HttpSession session = request.getSession();
        usuario = (Entidades.Administrador)session.getAttribute("usuario");
        ControladorGestion controlador = 
        (ControladorGestion)session.getAttribute("ControladorGestion");
              
        if(usuario == null) {response.sendError(401, "Login required"); return;}
        
        CarreraAction redirect = 
                CarreraAction.
                        valueOf(request.getParameter("redirect"));
        
        ArrayList<Entidades.Carrera> carreras = null;
        Entidades.Carrera carrera = new Entidades.Carrera(0, "", "", usuario.getIdAdministrador(), null);
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            carreras = (ArrayList<Entidades.Carrera>)session.
                getAttribute("carreras");
            carrera = carreras.stream().
                filter(c -> c.getIdCarrera() == id).findFirst().get();                 
        }
        session.setAttribute("carrera", carrera);  
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp"); break;
            case Eliminar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ConfirmarEliminar.jsp"); break;
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp"); break;
            default:
                response.sendRedirect("LoginAlumno.jsp");
        }
        dispatcher.forward(request, response);
    }  
}
