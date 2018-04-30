package Moderador;

import Administrador.Carrera;
import Entidad.ServletM;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Comision extends ServletM {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Enumeraciones.ComisionAction redirect = 
                Enumeraciones.ComisionAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Comision> comisiones = null;
        Entidades.Comision comision = new Entidades.Comision(0, "", 0, 
            ((Entidades.Moderador)usuario).getIdModerador());
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            comisiones = (List<Entidades.Comision>)session.
                getAttribute("comisiones");
            comision = comisiones.stream().
                filter(c -> c.getIdComision() == id).findFirst().get();                           
        } 
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ComisionAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarComision(comision);
                    comisiones = (List<Entidades.Comision>)(List<?>)controlador.buscarComision();
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                session.setAttribute("comisiones", comisiones);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Comision.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ComisionAM.jsp"); 
                    comision = new Entidades.Comision(0, "", 0, 
                        ((Entidades.Moderador)usuario).getIdModerador());
                    break;
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        
        session.setAttribute("comision", comision);
        dispatcher.forward(request, response);
    }
}
