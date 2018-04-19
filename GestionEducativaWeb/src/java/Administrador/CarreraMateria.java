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
import Otros.Enumeraciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        Entidades.Administrador usuario = null;  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        usuario = (Entidades.Administrador)session.getAttribute("usuario");
        ControladorGestion controlador = 
                (ControladorGestion)session.getAttribute("ControladorGestion");
        
        if(usuario == null) {response.sendError(401, "Login required"); return;}
        
        Enumeraciones.CarreraMateria redirect = 
                Enumeraciones.CarreraMateria.
                        valueOf(request.getParameter("redirect"));
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            out.println(e1.getMessage());
        }
        
        List<Entidades.Materia> materias = null;
        Entidades.Carrera carrera = (Entidades.Carrera)session.getAttribute("carrera");
        List<Entidades.Materia> materiasExistentes = 
                (List<Entidades.Materia>)(List<?>)carrera.getMaterias();  
        
        RequestDispatcher dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Agregar: 
                try {
                    materias = (List<Entidades.Materia>)
                            (List<?>)controlador.buscarMaterias();
                } catch (ApplicationException ex) {
                    Logger.getLogger(CarreraMateria.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                List<Entidades.Materia> materiasDisponibles = null;
                if(null != materias){
                    materiasDisponibles = 
                            materias.stream().
                            filter(m -> materiasExistentes.stream().
                                    noneMatch(me -> me.getIdMateria() == m.getIdMateria())).
                                    collect(Collectors.toList());         
                }
                
                session.setAttribute("materiasDisponible", materiasDisponibles); 
                dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/CarreraMateria.jsp");
                
                break;
            case Eliminar: 
                int id = Integer.parseInt(request.getParameter("id"));
                List<Entidades.Materia> materiasExistentesEliminada = 
                        materiasExistentes.stream().filter(m -> m.getIdMateria() != id).
                                collect(Collectors.toList());
                ArrayList<entidad> nMaterias = new ArrayList<>(materiasExistentesEliminada);
                carrera.setMaterias(nMaterias);
                session.setAttribute("carrera", carrera);  
                dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/CarreraAM.jsp");
                break;
            default:
                response.sendRedirect("LoginAlumno.jsp");;
        }

        dispatcher.forward(request, response);
    }
}
