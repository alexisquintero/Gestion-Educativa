/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidad.ServletM;
import Entidades.entidad;
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
public class MenuModerador extends ServletM {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);

        Enumeraciones.MenuModeradorOpciones redirect = 
                Enumeraciones.MenuModeradorOpciones.
                        valueOf(request.getParameter("redirect"));
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Alumno: {
                try {
                    List<entidad> alumnos = controlador.buscarAlumnos();
                    session.setAttribute("alumnos", alumnos);
                    for (entidad alumno : alumnos) {
                        ((Entidades.Alumno)alumno).
                        setCarrera((Entidades.Carrera)controlador.
                        buscarCarrera(((Entidades.Alumno)alumno).getCarrera()));
                    }
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/Alumno.jsp");break;
                } catch (ApplicationException ex) {
                    Logger.getLogger(MenuModerador.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
            case Docente:
                {
                    try {
                        List<entidad> docentes = controlador.buscarDocentes();
                        session.setAttribute("docentes", docentes);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/Docente.jsp");break;
                    } catch (ApplicationException ex) {
                        Logger.getLogger(MenuAdministrador.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                } 
            case Comision: {
                try {
                    List<entidad> comisiones = controlador.buscarComision();
                    session.setAttribute("comisiones", comisiones);
                    dispatcher = getServletContext().
                        getRequestDispatcher("/WEB-INF/Comision.jsp");break;
                } catch (ApplicationException ex) {
                    Logger.getLogger(MenuModerador.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }           
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        dispatcher.forward(request, response);
    }
}
