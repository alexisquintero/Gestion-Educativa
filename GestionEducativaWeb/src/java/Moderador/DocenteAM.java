package Moderador;

import Entidad.ServletM;
import Excepciones.ApplicationException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DocenteAM extends ServletM {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Docente docente = 
                (Entidades.Docente)session.getAttribute("docente");
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        docente.setNombre(nNombre);
        String nApellido = request.getParameter("apellido");
        nApellido = null == nApellido ? "" : nApellido;
        docente.setApellido(nApellido);
        String nTelefono = request.getParameter("telefono");
        nTelefono = null == nTelefono ? "" : nTelefono;
        docente.setTelefono(nTelefono);
        String nEmail = request.getParameter("email");
        nEmail = null == nEmail ? "" : nEmail;
        docente.setEmail(nEmail);
        String nDireccion = request.getParameter("direccion");
        nDireccion = null == nDireccion ? "" : nDireccion;
        docente.setDireccion(nDireccion);
        String nLegajo = request.getParameter("legajo");
        nLegajo = null == nLegajo ? "" : nLegajo;
        docente.setLegajo(nLegajo);
        
        try{
            if(docente.getIdDocente() == 0){
                if("".equals(docente.getNombre()) || "".equals(docente.getApellido()) 
                || "".equals(docente.getTelefono()) || "".equals(docente.getEmail())
                || "".equals(docente.getDireccion()) || "".equals(docente.getLegajo())){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/DocenteAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    docente.setIdDocente(controlador.crearDocente(docente));
                }
            }else{
                controlador.modificarDocente(docente);
            }
        } catch(ApplicationException ex) {
            session.setAttribute("error", ex.getMessage());
            RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
            dispatcher.forward(request, response); return;
        }
        
        session.setAttribute("docente", docente); 
        response.sendRedirect("MenuModerador?redirect=Docente");
    }
}
