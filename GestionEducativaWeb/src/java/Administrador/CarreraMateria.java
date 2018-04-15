/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Negocio.ControladorGestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
@WebServlet(name = "CarreraMateria", urlPatterns = {"/CarreraMateria"})
public class CarreraMateria extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Entidades.Administrador usuario = null;  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        usuario = (Entidades.Administrador)session.getAttribute("usuario");
        ControladorGestion controlador = 
                (ControladorGestion)session.getAttribute("ControladorGestion");
        
        if(usuario == null) {response.sendError(401, "Login required"); return;}
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            out.println(e1.getMessage());
        }
        
        ArrayList<Entidades.Carrera> materias = null;
        Entidades.Carrera carrera = (Entidades.Carrera)session.getAttribute("carrera");
        ArrayList<Entidades.Carrera> materiasExistentes = 
                (ArrayList<Entidades.Carrera>)(ArrayList<?>)carrera.getMaterias();        
        
        try {
            materias = (ArrayList<Entidades.Carrera>)
                    (ArrayList<?>)controlador.buscarMaterias();
        } catch (ApplicationException ex) {
            Logger.getLogger(CarreraMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stream<Entidades.Carrera> materiasDisponibles = null;
        //ArrayList<Entidades.Carrera> materiasDisponibles = null;
        if(null != materias){
            materiasDisponibles = 
                    materias.stream().
                    filter(m -> materiasExistentes.stream().
                            anyMatch(me -> me.getIdCarrera() != m.getIdCarrera()));  //TODO: Pasar a list para controlar el output          
        }
        
        session.setAttribute("materiasDisponible", materiasDisponibles); 
        RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/CarreraMateria.jsp");
        dispatcher.forward(request, response);
    }
}
