/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import Otros.Enumeraciones.MateriaAction;
import java.io.IOException;
import java.sql.Date;
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
public class Materia extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        MateriaAction redirect = 
                MateriaAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Materia> materias = null;
        Entidades.Materia materia = new Entidades.Materia(0, "", "", 
                Enumeraciones.Anios.Primero.toString(), false, 0,
                ((Entidades.Administrador)usuario).getIdAdministrador());
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            materias = (List<Entidades.Materia>)session.
                getAttribute("materias");
            materia = materias.stream().
                filter(c -> c.getIdMateria() == id).findFirst().get();                 
        }
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/MateriaAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarMateria(materia);
                    materias = (List<Entidades.Materia>)(List<?>)controlador.buscarMaterias();                       
                } catch (ApplicationException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("materias", materias);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Materia.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/MateriaAM.jsp"); 
                    materia = new Entidades.Materia(0, "", "", 
                        Enumeraciones.Anios.Primero.toString(), false, 0,
                        ((Entidades.Administrador)usuario).getIdAdministrador());
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp");
        }
        
        session.setAttribute("materia", materia);
        dispatcher.forward(request, response);
    }
}
