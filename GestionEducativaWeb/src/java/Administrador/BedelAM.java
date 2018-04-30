package Administrador;

import Entidad.Servlet;
import Excepciones.ApplicationException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BedelAM extends Servlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        this.initialization(request, response, session);
        
        Entidades.Bedel bedel = 
                (Entidades.Bedel)session.getAttribute("bedel");
        String nNombre = request.getParameter("nombre");
        nNombre = null == nNombre ? "" : nNombre;
        bedel.setNombre(nNombre);
        String nApellido = request.getParameter("apellido");
        nApellido = null == nApellido ? "" : nApellido;
        bedel.setApellido(nApellido);
        String nTelefono = request.getParameter("telefono");
        nTelefono = null == nTelefono ? "" : nTelefono;
        bedel.setTelefono(nTelefono);
        String nEmail = request.getParameter("email");
        nEmail = null == nEmail ? "" : nEmail;
        bedel.setEmail(nEmail);
        String nDireccion = request.getParameter("direccion");
        nDireccion = null == nDireccion ? "" : nDireccion;
        bedel.setDireccion(nDireccion);
        String nLegajo = request.getParameter("legajo");
        nLegajo = null == nLegajo ? "" : nLegajo;
        bedel.setLegajo(nLegajo);
        session.setAttribute("bedel", bedel); 
        
        try{
            if(bedel.getIdBedel() == 0){
                if("".equals(bedel.getNombre()) || "".equals(bedel.getApellido()) 
                || "".equals(bedel.getTelefono()) || "".equals(bedel.getEmail())
                || "".equals(bedel.getDireccion()) || "".equals(bedel.getLegajo())){
                    RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/WEB-INF/BedelAM.jsp"); 
                    dispatcher.forward(request, response); return;                  
                } else{
                    bedel.setIdBedel(controlador.crearBedel(bedel));
                }
            }else{
                controlador.modificarBedel(bedel);
            }
        } catch(ApplicationException ex) {
            session.setAttribute("error", ex.getMessage());
            RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/Error.jsp");
            dispatcher.forward(request, response); return;	
        }
        
        response.sendRedirect("MenuAdministrador?redirect=Bedel");
    }
}
