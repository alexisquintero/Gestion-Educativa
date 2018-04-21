/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Entidades.entidad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class CarreraMateriaPost extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Carrera carrera = (Entidades.Carrera)session.getAttribute("carrera"); 
        
        String[] ids = request.getParameterValues("id");
        RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp"); 
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
        
        ArrayList<entidad> materiasExistentes = carrera.getMaterias();
        
        for(entidad e: nMaterias) materiasExistentes.add(e);
        carrera.setMaterias(materiasExistentes);
        session.setAttribute("carrera", carrera); 
        
        dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraAM.jsp");
        dispatcher.forward(request, response);
    }
}
