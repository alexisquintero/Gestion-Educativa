/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatoInscripcionFinal;
import Entidades.InscripcionFinal;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class NegocioInscripcionFinal extends negocio{

    public NegocioInscripcionFinal(){
        datos = new DatoInscripcionFinal();
    }

    @Override
    public entidad buscar(entidad e) throws ApplicationException{ 
        //return datos.getOne(((InscripcionFinal)e).idInscripcionFinal); 
        return null;
    }

    @Override
    public ArrayList<entidad> buscar() throws ApplicationException{
        return datos.getAll();
    }

    @Override
    public int nuevo(entidad e) throws ApplicationException{
        if (this.buscar(e) == null) {
            throw new EntidadExistenteException("La InscripcionFinal ya existe");
        }       
        return datos.newObject(e);
    }

    @Override
    public void modificar(entidad e) throws ApplicationException{
        datos.modify(e);
    }

    @Override
    public void eliminar(entidad e) throws ApplicationException{
        //datos.delete(((InscripcionFinal)e).idInscripcionFinal);
    }
}
