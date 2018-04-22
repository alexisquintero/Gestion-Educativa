/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        
        Enumeraciones.MateriaRegularAprobada redirect = 
                Enumeraciones.MateriaRegularAprobada.
                        valueOf(request.getParameter("redirect"));
                        
        Entidades.Materia materia = (Entidades.Materia)session.getAttribute("materia");
        ArrayList<Entidades.Materia> materiasRegulares = 
            (ArrayList<Entidades.Materia>)(ArrayList<?>)materia.getCorrelativasRegulares();
        ArrayList<Entidades.Materia> materiasAprobadas = 
            (ArrayList<Entidades.Materia>)(ArrayList<?>)materia.getCorrelativasAprobadas();
        
        RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Agregar: {
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
                materiasDisponible = filtrarSelf(
                    new ArrayList(materiasDisponible), materia.getIdMateria());
                session.setAttribute("materiasDisponible", materiasDisponible);                
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/MateriaRegular.jsp");
                break;
            }
            case Eliminar: {
                ArrayList<Entidades.Materia> materias = 
                        (ArrayList<Entidades.Materia>)
                        (ArrayList<?>)materia.getCorrelativasRegulares();
                int id = Integer.parseInt(request.getParameter("id"));
                
                materias = new ArrayList(materias.stream().
                        filter(m -> m.getIdMateria() != id).
                            collect(Collectors.toList()));
                materia.setCorrelativasRegulares(
                        ((ArrayList<Entidades.entidad>)(ArrayList<?>)materias));  
                session.setAttribute("materia", materia);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/MateriaAM.jsp");
                break;
            }                              
            default:
                throw new AssertionError();
        }       
        
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Materia materia = 
                (Entidades.Materia)session.getAttribute("materia");
        
        String[] ids = request.getParameterValues("id");
        RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/MateriaAM.jsp"); 
        if(ids == null ){ dispatcher.forward(request, response); return; }
        
        List<String> sids = Arrays.asList(ids);
        List<Integer> iids = sids.stream().map(s -> Integer.valueOf(s)).
                collect(Collectors.toList());
        
        for(String s: ids) iids.add(Integer.valueOf(s));
        
        ArrayList<Entidades.Materia> materiasDisponible = 
        (ArrayList<Entidades.Materia>)session.getAttribute("materiasDisponible");
        
        List<Entidades.Materia> materiasAgregar = materiasDisponible.stream().
                filter(m -> iids.contains(m.getIdMateria())).
                collect(Collectors.toList());
        ArrayList<entidad> nMaterias = new ArrayList<>(materiasAgregar);
        
        ArrayList<entidad> materiasExistentes = materia.getCorrelativasRegulares();
        if(null == materiasExistentes){
               materiasExistentes = nMaterias;
        }else{
            for(entidad e: nMaterias) materiasExistentes.add(e);   
        }
        materia.setCorrelativasRegulares(materiasExistentes);
        session.setAttribute("materia", materia); 
        
        dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/MateriaAM.jsp");
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
             
        return materias.stream().
            filter(m -> aprobadas.stream().
                noneMatch(a -> a.getIdMateria() == m.getIdMateria())).
                    collect(Collectors.toList());
            
    }
    
    private List<Entidades.Materia> filtrarSelf(
            ArrayList<Entidades.Materia> materias, int id){
        return materias.stream().
                filter(m -> m.getIdMateria() != id).
                    collect(Collectors.toList());
    }
}
