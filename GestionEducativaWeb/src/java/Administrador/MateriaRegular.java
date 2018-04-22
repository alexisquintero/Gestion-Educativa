/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import java.io.IOException;
import java.util.ArrayList;
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
public class MateriaRegular extends Servlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
                        
        Entidades.Materia materia = (Entidades.Materia)session.getAttribute("materia");
        ArrayList<Entidades.Materia> materiasRegulares = 
            (ArrayList<Entidades.Materia>)(ArrayList<?>)materia.getCorrelativasRegulares();
        ArrayList<Entidades.Materia> materiasAprobadas = 
            (ArrayList<Entidades.Materia>)(ArrayList<?>)materia.getCorrelativasAprobadas();       
        
        ArrayList<Entidades.Materia> materias = new ArrayList();
        
        try {
            materias = (ArrayList<Entidades.Materia>)
                (ArrayList<?>)controlador.buscarMaterias();
        } catch (ApplicationException ex) {
            Logger.getLogger(CarreraMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Entidades.Materia> materiasDisponible = new ArrayList(); 
        
        if(materiasRegulares.isEmpty() && materiasAprobadas.isEmpty()){
            materiasDisponible = materias;
        }
        else if(materiasRegulares.isEmpty() || materiasAprobadas.isEmpty()){
            if(materiasRegulares.isEmpty()){
                materiasDisponible = filtrarAprobadas(materias, materiasAprobadas);
            }
            if(materiasAprobadas.isEmpty()){
                materiasDisponible = filtrarRegulares(materias, materiasRegulares);
            }
        }
        else {
            if(!materias.isEmpty()){
                materiasDisponible = filtrarAprobadas(new ArrayList(filtrarRegulares(materias, materiasRegulares)), materiasAprobadas);
            } 
        }  
        
        session.setAttribute("materiasDisponible", materiasDisponible);                
        RequestDispatcher dispatcher = getServletContext().
            getRequestDispatcher("/WEB-INF/MateriaRegular.jsp");
        dispatcher.forward(request, response);
    }
    
    private List<Entidades.Materia> filtrarRegulares(
        ArrayList<Entidades.Materia> materias, 
        ArrayList<Entidades.Materia> regulares) {
        
        return materias.stream().
            filter(m -> regulares.stream().
                noneMatch(r -> r.getIdMateria() == m.getIdMateria())).
                    collect(Collectors.toList());
        
    }
    
    private List<Entidades.Materia> filtrarAprobadas(
        ArrayList<Entidades.Materia> materias, 
        ArrayList<Entidades.Materia> aprobadas) {
        
        List<Entidades.Materia> ret = null;
        
        ret = materias.stream().
            filter(m -> aprobadas.stream().
                noneMatch(a -> a.getIdMateria() == m.getIdMateria())).
                    collect(Collectors.toList());
        
        return ret;
    }
}
