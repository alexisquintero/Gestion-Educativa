package Entidad;

import Negocio.ControladorGestion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletM", urlPatterns = {"/ServletM"})
public class ServletM extends HttpServlet {

    protected ControladorGestion controlador;
    protected Entidades.Persona usuario;

    public ServletM() {
        this.controlador = new ControladorGestion();
    }
    
    protected void initialization(HttpServletRequest request, 
            HttpServletResponse response, 
            HttpSession session) 
            throws ServletException, IOException{      
        usuario = (Entidades.Moderador)session.getAttribute("usuario");
        
        if(usuario == null) {response.sendError(401, "Login required"); return;}
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            session.setAttribute("error", e1.getMessage());
            RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
            dispatcher.forward(request, response); return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
               
    }
}
