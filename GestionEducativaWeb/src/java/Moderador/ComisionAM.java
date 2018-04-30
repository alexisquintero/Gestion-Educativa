package Moderador;

import Entidad.ServletM;
import Excepciones.ApplicationException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ComisionAM extends ServletM {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Comision comision = 
                (Entidades.Comision)session.getAttribute("comision");
        
        String nAula = request.getParameter("aula");
        nAula = null == nAula ? "" : nAula;
        comision.setAula(nAula);
        String sCupo = request.getParameter("cupo");
        int nCupo = tryParseInt(sCupo) ? Integer.parseInt(sCupo) : 0;
        comision.setCupo(nCupo);
        session.setAttribute("comision", comision); 
        
        try{
            if(comision.getIdComision() == 0){
                if("".equals(comision.getAula()) || 0 == comision.getCupo()){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/ComisionAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    comision.setIdComision(controlador.crearComision(comision));
                }
            }else{
                controlador.modificarComision(comision);
            }
        } catch(ApplicationException ex) {
            session.setAttribute("error", ex.getMessage());
            RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
            dispatcher.forward(request, response); return;
        }
        response.sendRedirect("MenuModerador?redirect=Comision");

    }
    
    private boolean tryParseInt(String value) {  
        try {  
            Integer.parseInt(value);  
            return true;  
        } catch (NumberFormatException e) {  
            return false;  
        }  
    }
}
