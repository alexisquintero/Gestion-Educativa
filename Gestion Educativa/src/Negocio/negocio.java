package Negocio;

import Datos.dato;
import Entidades.entidad;
import Excepciones.*;
import java.util.ArrayList;

public abstract class negocio {
    protected ControladorGestion controlador = new ControladorGestion();
    protected dato datos;
    
    public abstract entidad buscar(entidad e) throws ApplicationException;
    public abstract ArrayList<entidad> buscar() throws ApplicationException;
    public abstract int nuevo(entidad e) throws ApplicationException;
    public abstract void modificar(entidad e) throws ApplicationException;
    public abstract void eliminar(entidad e) throws ApplicationException;
}
