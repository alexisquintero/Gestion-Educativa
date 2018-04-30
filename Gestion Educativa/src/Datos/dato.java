package Datos;

import Entidades.entidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Excepciones.*;

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
