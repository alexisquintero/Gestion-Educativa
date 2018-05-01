package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import Otros.Enumeraciones.MateriaAction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Materia extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        MateriaAction redirect = 
                MateriaAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Materia> materias = new ArrayList();
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
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
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
                response.sendRedirect("LoginAdministrador.jsp"); return;
        }
        
        session.setAttribute("materia", materia);
        dispatcher.forward(request, response);
    }
}
