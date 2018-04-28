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
import java.sql.Date;
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
public class MateriaAM extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Materia materia = (Entidades.Materia)session.getAttribute("materia");
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        materia.setNombre(nNombre);     
        String nDescripcion = request.getParameter("descripcion");
        nDescripcion = null == nDescripcion ? "" : nDescripcion;
        materia.setDescripcion(nDescripcion);   
        String sAnio = request.getParameter("anio");
        Date nAnio = tryParseDate(sAnio) ? Date.valueOf(sAnio) : null;
        materia.setAnio(nAnio); 
        boolean nElectiva = Boolean.parseBoolean(request.getParameter("electiva"));        
        materia.setElectiva(nElectiva); 
        String sHoras = request.getParameter("horasSemana");
        int nHoras = tryParseInt(sHoras) ? Integer.parseInt(sHoras): 0;
        materia.setHorasSemana(nHoras);                        
        session.setAttribute("materia", materia);
        
        try{
            if(materia.getIdMateria() == 0){
                if("".equals(materia.getNombre()) || "".equals(materia.getDescripcion())
                    || null == materia.getAnio() || 0 == materia.getHorasSemana()){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/MateriaAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    materia.setIdMateria(controlador.crearMateria(materia));
                    session.setAttribute("materia", materia); 
                }
            }else{
                controlador.modificarMateria(materia);
            }
        } catch(ApplicationException ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
        }
       
        response.sendRedirect("MenuAdministrador?redirect=Materia");
        
    }
    
    private boolean tryParseInt(String value) {  
        try {  
            Integer.parseInt(value);  
            return true;  
        } catch (NumberFormatException e) {  
            return false;  
        }  
    }
    
    private boolean tryParseDate(String value) {  
        try {  
            Date.valueOf(value);  
            return true;  
        } catch (IllegalArgumentException e) {  
            return false;  
        }  
    }
}
