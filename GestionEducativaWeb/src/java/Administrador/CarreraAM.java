/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Menu.MenuAdministrador;
import Negocio.ControladorGestion;
import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        ControladorGestion controlador = 
                (ControladorGestion)session.getAttribute("ControladorGestion");
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            out.println(e1.getMessage());
        }
        
        Entidades.Carrera carrera = (Entidades.Carrera)session.getAttribute("carrera"); 
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        carrera.setNombre(nNombre);     
        String nDescripcion = request.getParameter("descripcion");
        nDescripcion = null == nDescripcion ? "" : nDescripcion;
        carrera.setDescripcion(nDescripcion);
        
        RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp");
        try{
            if(carrera.getIdCarrera() == 0){
                if("".equals(carrera.getNombre()) || "".equals(carrera.getDescripcion())){
                    dispatcher.forward(request, response); return;
                } else{
                    carrera.setIdCarrera(controlador.crearCarrera(carrera));
                }
            }else{
                controlador.modificarCarrera(carrera);
            }
        } catch(ApplicationException ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("carrera", carrera);       
        dispatcher.forward(request, response);
    }
}
