package Alumno;

import Entidad.Servlet;
import Entidades.Final;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FinalInsc extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Enumeraciones.FinalInsc redirect = 
                Enumeraciones.FinalInsc.
                        valueOf(request.getParameter("redirect"));
        
        List<Final> finales = 
            (List<Final>)session.getAttribute("finales");
        Entidades.Final final1 = null;
        if(request.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(request.getParameter("id"));
            final1 = finales.stream().
                filter(h -> h.getIdFinal() == id).
                findAny().get();
        }
        
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
        
        switch (redirect) {
            case Inscribir:
                try {
                    controlador.inscribirFinal(final1, (Entidades.Alumno)usuario);
                } catch (ApplicationException ex) {
                    session.setAttribute("error", ex.getMessage());
                    dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/Error.jsp");
                    dispatcher.forward(request, response); return;
                }
                dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/InscripcionMaeriaFinal.jsp"); break;
            default:
                response.sendRedirect("LoginAlumno.jsp"); return;
        }
        dispatcher.forward(request, response);
    }
}
