/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moderador;

import Entidad.ServletM;
import Excepciones.ApplicationException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
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
            Logger.getLogger(AlumnoCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispatcher.forward(request, response); 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    
    }
}
