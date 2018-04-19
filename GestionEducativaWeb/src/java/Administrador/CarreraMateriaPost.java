/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Negocio.ControladorGestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
public class CarreraMateriaPost extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Entidades.Administrador usuario = null;       
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        usuario = (Entidades.Administrador)session.getAttribute("usuario");
        ControladorGestion controlador = 
                (ControladorGestion)session.getAttribute("ControladorGestion");
        
        if(usuario == null) {response.sendError(401, "Login required"); return;}
        
        Entidades.Carrera carrera = (Entidades.Carrera)session.getAttribute("carrera"); 
        
        String[] ids = request.getParameterValues("id");       
        
        RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp"); 
        if(ids == null){ dispatcher.forward(request, response); return; }
       
        ArrayList<Entidades.Materia> materiasDisponible = 
        (ArrayList<Entidades.Materia>)session.getAttribute("materiasDisponible");
        
        //TODO: Agregar las materiasDisponibles cuyos id están en ids a la carrera en sesion
    }
}
