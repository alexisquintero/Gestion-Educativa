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
public class DocenteAM extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Docente docente = 
                (Entidades.Docente)session.getAttribute("docente");
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        docente.setNombre(nNombre);
        String nApellido = request.getParameter("apellido");
        nApellido = null == nApellido ? "" : nApellido;
        docente.setApellido(nApellido);
        String nTelefono = request.getParameter("telefono");
        nTelefono = null == nTelefono ? "" : nTelefono;
        docente.setTelefono(nTelefono);
        String nEmail = request.getParameter("email");
        nEmail = null == nEmail ? "" : nEmail;
        docente.setEmail(nEmail);
        String nDireccion = request.getParameter("direccion");
        nDireccion = null == nDireccion ? "" : nDireccion;
        docente.setDireccion(nDireccion);
        String nLegajo = request.getParameter("legajo");
        nLegajo = null == nLegajo ? "" : nLegajo;
        docente.setLegajo(nLegajo);
        
        try{
            if(docente.getIdDocente() == 0){
                if("".equals(docente.getNombre()) || "".equals(docente.getApellido()) 
                || "".equals(docente.getTelefono()) || "".equals(docente.getEmail())
                || "".equals(docente.getDireccion()) || "".equals(docente.getLegajo())){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/DocenteAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    docente.setIdDocente(controlador.crearDocente(docente));
                }
            }else{
                controlador.modificarDocente(docente);
            }
        } catch(ApplicationException ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("docente", docente); 
        response.sendRedirect("MenuAdministrador?redirect=Docente");
    }
}
