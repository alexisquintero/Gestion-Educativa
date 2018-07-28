package Negocio;

import Datos.DatoInscripcionFinal;
import Entidades.Alumno;
import Entidades.Final;
import Entidades.InscripcionFinal;
import Entidades.entidad;
import Excepciones.ApplicationException;
import Excepciones.EntidadExistenteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (this.buscar(e) != null) {
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
    
    public List<InscripcionFinal> inscripcionesAlumno(Alumno alumno) throws ApplicationException{
        return ((DatoInscripcionFinal)datos).getFinalesAlumno(alumno);
    }
    
    public Map<Final, Float> notaPromedioFinal() throws ApplicationException{
        //Obtengo todos los finales
        List<Final> finales = 
            (List<Final>) (List<?>) new NegocioFinal().buscar();
        //Obtengo todos las inscripciones a finales
        List<InscripcionFinal> inscripcionesFinales = 
            (List<InscripcionFinal>) (List<?>) this.buscar();
        Map<Final, Float> promedioFinal = new HashMap<>();
        //Obtengo el promedio por cada final
        for (Final final1 : finales) {
            //Obtengo las inscripciones para cada final
            List<InscripcionFinal> inscripcionesFinal = 
                inscripcionesFinales.stream().
                    filter(i -> i.getObjFinal().getIdFinal() == final1.getIdFinal()).
                    collect(Collectors.toList());
            //Calculo el promedio
            int suma, cont;
            float promedio = 0;
            suma = cont = 0;
            for (InscripcionFinal inscripcionFinal : inscripcionesFinal) {
                suma += inscripcionFinal.getNotaFinal();
                cont++;
            }
            promedio = 0 == cont ? 0 : suma/cont;
            //Agego el nuevo <key, value> al map
            promedioFinal.put(final1, promedio);
        }
        return promedioFinal;
    }
    
    public Map<Alumno, Float> notaPromedioAlumno() throws ApplicationException{
        //Obtengo todos los alumno
        List<Alumno> alumnos = 
            (List<Alumno>) (List<?>) new NegocioAlumno().buscar();
        //Obtengo todos las inscripciones a finales
        List<InscripcionFinal> inscripcionesFinales = 
            (List<InscripcionFinal>) (List<?>) this.buscar();
        Map<Alumno, Float> promedioAlumno = new HashMap<>();
        //Obtengo el promedio por cada alumno
        for (Alumno alumno : alumnos) {
            //Obtengo las inscripciones para cada alumno
            List<InscripcionFinal> inscripcionesFinal = 
                inscripcionesFinales.stream().
                    filter(i -> i.getAlumno().getIdAlumno() == alumno.getIdAlumno()).
                    collect(Collectors.toList());
            //Calculo el promedio
            int suma, cont;
            float promedio = 0;
            suma = cont = 0;
            for (InscripcionFinal inscripcionFinal : inscripcionesFinal) {
                suma += inscripcionFinal.getNotaFinal();
                cont++;
            }
            promedio = 0 == cont ? 0 : suma/cont;
            //Agego el nuevo <key, value> al map
            promedioAlumno.put(alumno, promedio);
        }
        return promedioAlumno;
    }
}
