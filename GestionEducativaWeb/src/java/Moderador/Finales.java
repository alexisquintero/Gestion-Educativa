package Moderador;

import Entidad.Servlet;
import Entidades.Final;
import Excepciones.ApplicationException;
import Otros.Enumeraciones;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Finales extends Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);

        Enumeraciones.Finales redirect = 
                Enumeraciones.Finales.
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
            case NotaPromedio: /*
                {
                    try {
                        float nota = controlador.notaPromedioFinal(final1);
                        session.setAttribute("nota", nota);
                        session.setAttribute("final1", final1);
                        dispatcher = getServletContext().
                            getRequestDispatcher("/WEB-INF/FinalPromedio.jsp");break;
                    } catch (ApplicationException ex) {
                        session.setAttribute("error", ex.getMessage());
                        dispatcher = getServletContext()
                            .getRequestDispatcher("/WEB-INF/Error.jsp");
                        dispatcher.forward(request, response); return;
                    }
                }*/
            default:
                response.sendRedirect("LoginModerador.jsp");
        }
        dispatcher.forward(request, response);
    }
}
