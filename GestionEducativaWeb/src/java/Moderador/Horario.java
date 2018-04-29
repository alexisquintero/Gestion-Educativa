/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moderador;

import Entidad.ServletM;
import java.io.IOException;
import java.util.ArrayList;
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
public class Horario extends ServletM {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Comision comision = 
                (Entidades.Comision)session.getAttribute("comision");       
        int IdHorario = Integer.valueOf(request.getParameter("id"));
        
        List<Entidades.Horario> horarios = 
            (ArrayList<Entidades.Horario>)(ArrayList<?>)comision.getHorarios();
        
        horarios = horarios.stream()
            .filter(h -> h.getIdHorario() != IdHorario)
            .collect(Collectors.toList());
        
        comision.setHorarios(new ArrayList(horarios));
        session.setAttribute("comision", comision);
        RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ComisionAM.jsp");
        dispatcher.forward(request, response);
    }
}
