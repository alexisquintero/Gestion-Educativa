/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.entidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Excepciones.ApplicationException;

/**
 *
 * @author Supervisor
 */
public class dato {
    
    protected Connection myConn = null;
    protected Statement stm = null;
    protected PreparedStatement pstm = null;
    protected ResultSet rsl = null;
    
    public entidad getOne(int id) throws ApplicationException{
        return null;
    }
    public int newObject(entidad e) throws ApplicationException{    //Devuelve el id del elemento creado
        return 0;
    }
    public ArrayList<entidad> getAll() throws ApplicationException{
        return null;
    }
    public void modify(entidad e) throws ApplicationException{
        
    }
}
