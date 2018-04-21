/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Menu.MenuAdministrador;
import java.io.IOException;
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
@WebServlet(name = "CarreraAM", urlPatterns = {"/CarreraAM"})
public class CarreraAM extends Servlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Carrera carrera = (Entidades.Carrera)session.getAttribute("carrera"); 
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        carrera.setNombre(nNombre);     
        String nDescripcion = request.getParameter("descripcion");
        nDescripcion = null == nDescripcion ? "" : nDescripcion;
        carrera.setDescripcion(nDescripcion);               
        session.setAttribute("carrera", carrera); 
        
        try{
            if(carrera.getIdCarrera() == 0){
                if("".equals(carrera.getNombre()) || "".equals(carrera.getDescripcion())){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    carrera.setIdCarrera(controlador.crearCarrera(carrera));
                    session.setAttribute("carrera", carrera); 
                }
            }else{
                controlador.modificarCarrera(carrera);
            }
        } catch(ApplicationException ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
        }
       
        response.sendRedirect("MenuAdministrador?redirect=Carrera");
    }
}
