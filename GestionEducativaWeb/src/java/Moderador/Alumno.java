/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moderador;

import Administrador.Carrera;
import Entidad.ServletM;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
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
public class Alumno extends ServletM {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Enumeraciones.AlumnoAction redirect = 
                Enumeraciones.AlumnoAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Alumno> alumnos = null;
        Entidades.Alumno alumno = new Entidades.Alumno(0, 
            ((Entidades.Moderador)usuario).getIdModerador(), 0, "", 
            "", "", "", "", "", "", "");
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            alumnos = (List<Entidades.Alumno>)session.
                getAttribute("alumnos");
            alumno = alumnos.stream().
                filter(c -> c.getIdAlumno() == id).findFirst().get();                           
        } 
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/AlumnoAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarAlumno(alumno);
                    alumnos = (List<Entidades.Alumno>)(List<?>)controlador.buscarAlumnos();                       
                } catch (ApplicationException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("alumnos", alumnos);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Alumno.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/AlumnoAM.jsp"); 
                    alumno = new Entidades.Alumno(0, 
                        ((Entidades.Moderador)usuario).getIdModerador(),
                        0, "", "", "", "", "", "", "", "");
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        
        session.setAttribute("alumno", alumno);
        dispatcher.forward(request, response);
    }
}
