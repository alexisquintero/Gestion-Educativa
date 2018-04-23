/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import Negocio.ControladorGestion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Supervisor
 */
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
        //Entidades.Administrador usuario = null;       
        PrintWriter out = response.getWriter();  
        usuario = (Entidades.Moderador)session.getAttribute("usuario");
        
        if(usuario == null) {response.sendError(401, "Login required"); return;}
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e1){
            out.println(e1.getMessage());
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
