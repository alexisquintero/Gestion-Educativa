package Administrador;


import Entidad.Servlet;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Bedel extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Enumeraciones.BedelAction redirect = 
                Enumeraciones.BedelAction.
                        valueOf(request.getParameter("redirect"));
        
        List<Entidades.Bedel> bedeles = null;
        Entidades.Bedel bedel = new Entidades.Bedel(0, 
            ((Entidades.Administrador)usuario).getIdAdministrador(), "", 
            "", "", "", "", "", "", "");
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            bedeles = (List<Entidades.Bedel>)session.
                getAttribute("bedeles");
            bedel = bedeles.stream().
                filter(c -> c.getIdBedel() == id).findFirst().get();                           
        }
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Editar: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/BedelAM.jsp"); break;
            case Eliminar: {
                try {
                    controlador.eliminarBedel(bedel);
                    bedeles = (List<Entidades.Bedel>)(List<?>)controlador.buscarBedel();                       
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                session.setAttribute("bedeles", bedeles);
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/Bedel.jsp"); break;
            }
            case Crear: dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/BedelAM.jsp"); 
                    bedel = new Entidades.Bedel(0, 
                        ((Entidades.Administrador)usuario).getIdAdministrador(),
                        "", "", "", "", "", "", "", "");
                    break;
                    
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        
        session.setAttribute("bedel", bedel);
        dispatcher.forward(request, response);
    }
}
