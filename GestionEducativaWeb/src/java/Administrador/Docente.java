/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Otros.Enumeraciones.DocenteAction;
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
public class Docente extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        DocenteAction redirect = 
                DocenteAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Docente> docentes = null;
        Entidades.Docente docente = new Entidades.
            Docente(0, ((Entidades.Administrador)usuario).getIdAdministrador(), 
                    "", "", "", "", "", "", "", "");
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            docentes = (List<Entidades.Docente>)session.
                getAttribute("docentes");
            docente = docentes.stream().
                filter(c -> c.getIdDocente() == id).findFirst().get();                 
        }
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/DocenteAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarDocente(docente);
                    docentes = (List<Entidades.Docente>)(List<?>)controlador.buscarDocentes();                       
                } catch (ApplicationException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("docentes", docentes);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Docente.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/DocenteAM.jsp");
                    docente = new Entidades.
                        Docente(0, ((Entidades.Administrador)usuario).getIdAdministrador(), 
                    "", "", "", "", "", "", "", "");
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp");
        }
        
        session.setAttribute("docente", docente);
        dispatcher.forward(request, response);
    }
}
