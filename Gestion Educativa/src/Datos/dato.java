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
import Excepciones.*;

/**
 *
 * @author Supervisor
 */
public abstract class dato {
    
    protected Connection myConn = null;
    protected Statement stm = null;
    protected PreparedStatement pstm = null;
    protected ResultSet rsl = null;
    
    public abstract entidad getOne(int id) throws ApplicationException;
    public abstract int newObject(entidad e) throws ApplicationException;
    public abstract ArrayList<entidad> getAll() throws ApplicationException;
    public abstract void modify(entidad e) throws ApplicationException;
    public abstract void delete(int id) throws ApplicationException;
}
