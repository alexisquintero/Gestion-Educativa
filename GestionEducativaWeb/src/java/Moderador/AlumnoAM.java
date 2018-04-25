/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moderador;

import Entidad.ServletM;
import Excepciones.ApplicationException;
import Menu.MenuModerador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
public class AlumnoAM extends ServletM {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Alumno alumno = 
                (Entidades.Alumno)session.getAttribute("alumno");
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        alumno.setNombre(nNombre);
        String nApellido = request.getParameter("apellido");
        nApellido = null == nApellido ? "" : nApellido;
        alumno.setApellido(nApellido);
        String nTelefono = request.getParameter("telefono");
        nTelefono = null == nTelefono ? "" : nTelefono;
        alumno.setTelefono(nTelefono);
        String nEmail = request.getParameter("email");
        nEmail = null == nEmail ? "" : nEmail;
        alumno.setEmail(nEmail);
        String nDireccion = request.getParameter("direccion");
        nDireccion = null == nDireccion ? "" : nDireccion;
        alumno.setDireccion(nDireccion);
        String nLegajo = request.getParameter("legajo");
        nLegajo = null == nLegajo ? "" : nLegajo;
        alumno.setLegajo(nLegajo);
        
        try{
            if(alumno.getIdAlumno() == 0){
                if("".equals(alumno.getNombre()) || "".equals(alumno.getApellido()) 
                || "".equals(alumno.getTelefono()) || "".equals(alumno.getEmail())
                || "".equals(alumno.getDireccion()) || "".equals(alumno.getLegajo())){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/AlumnoAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    alumno.setIdAlumno(controlador.crearAlumno(alumno));
                }
            }else{
                controlador.modificarAlumno(alumno);
            }
        } catch(ApplicationException ex) {
            Logger.getLogger(MenuModerador.class.getName()).
                                log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("alumno", alumno); 
        response.sendRedirect("MenuModerador?redirect=Alumno");      
    }
}
