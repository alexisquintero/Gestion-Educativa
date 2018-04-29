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
public class BedelAM extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Bedel bedel = 
                (Entidades.Bedel)session.getAttribute("bedel");
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        bedel.setNombre(nNombre);
        String nApellido = request.getParameter("apellido");
        nApellido = null == nApellido ? "" : nApellido;
        bedel.setApellido(nApellido);
        String nTelefono = request.getParameter("telefono");
        nTelefono = null == nTelefono ? "" : nTelefono;
        bedel.setTelefono(nTelefono);
        String nEmail = request.getParameter("email");
        nEmail = null == nEmail ? "" : nEmail;
        bedel.setEmail(nEmail);
        String nDireccion = request.getParameter("direccion");
        nDireccion = null == nDireccion ? "" : nDireccion;
        bedel.setDireccion(nDireccion);
        String nLegajo = request.getParameter("legajo");
        nLegajo = null == nLegajo ? "" : nLegajo;
        bedel.setLegajo(nLegajo);
        
        try{
            if(bedel.getIdBedel() == 0){
                if("".equals(bedel.getNombre()) || "".equals(bedel.getApellido()) 
                || "".equals(bedel.getTelefono()) || "".equals(bedel.getEmail())
                || "".equals(bedel.getDireccion()) || "".equals(bedel.getLegajo())){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/AlumnoAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    bedel.setIdBedel(controlador.crearBedel(bedel));
                }
            }else{
                controlador.modificarBedel(bedel);
            }
        } catch(ApplicationException ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("bedel", bedel); 
        response.sendRedirect("MenuAdministrador?redirect=Bedel");
    }
}
