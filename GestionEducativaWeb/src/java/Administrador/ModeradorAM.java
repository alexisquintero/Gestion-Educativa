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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
public class ModeradorAM extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Moderador moderador = 
                (Entidades.Moderador)session.getAttribute("moderador");
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        moderador.setNombre(nNombre);
        String nApellido = request.getParameter("apellido");
        nApellido = null == nApellido ? "" : nApellido;
        moderador.setApellido(nApellido);
        String nTelefono = request.getParameter("telefono");
        nTelefono = null == nTelefono ? "" : nTelefono;
        moderador.setTelefono(nTelefono);
        String nEmail = request.getParameter("email");
        nEmail = null == nEmail ? "" : nEmail;
        moderador.setEmail(nEmail);
        String nDireccion = request.getParameter("direccion");
        nDireccion = null == nDireccion ? "" : nDireccion;
        moderador.setDireccion(nDireccion);
        String nLegajo = request.getParameter("legajo");
        nLegajo = null == nLegajo ? "" : nLegajo;
        moderador.setLegajo(nLegajo);
        
        try{
            if(moderador.getIdModerador() == 0){
                if("".equals(moderador.getNombre()) || "".equals(moderador.getApellido()) 
                || "".equals(moderador.getTelefono()) || "".equals(moderador.getEmail())
                || "".equals(moderador.getDireccion()) || "".equals(moderador.getLegajo())){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ModeradorAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    moderador.setIdModerador(controlador.crearModerador(moderador));
                }
            }else{
                controlador.modificarModerador(moderador);
            }
        } catch(ApplicationException ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("moderador", moderador); 
        response.sendRedirect("MenuAdministrador?redirect=Moderador");
    }
}
