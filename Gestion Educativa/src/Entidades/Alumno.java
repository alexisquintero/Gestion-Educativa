package Entidades;

import java.util.ArrayList;

public class Alumno extends Persona{

    /**
     * @return the idAlumno
     */
    public int getIdAlumno() {
        return idAlumno;
    }

    /**
     * @param idAlumno the idAlumno to set
     */
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    /**
     * @return the moderador
     */
    public Moderador getModerador() {
        return moderador;
    }

    /**
     * @param moderador the moderador to set
     */
    public void setModerador(Moderador moderador) {
        this.moderador = moderador;
    }

    /**
     * @return the carrera
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the comisiones
     */
    public ArrayList<Comision> getComisiones() {
        return comisiones;
    }

    /**
     * @param comisiones the comisiones to set
     */
    public void setComisiones(ArrayList<Comision> comisiones) {
        this.comisiones = comisiones;
    }

    /**
     * @return the inscripciones
     */
    public ArrayList<InscripcionFinal> getInscripciones() {
        return inscripciones;
    }

    /**
     * @param inscripciones the inscripciones to set
     */
    public void setInscripciones(ArrayList<InscripcionFinal> inscripciones) {
        this.inscripciones = inscripciones;
    }
    private int idAlumno;
    private Moderador moderador;
    private Carrera carrera;
    private ArrayList<Comision> comisiones;
    private ArrayList<InscripcionFinal> inscripciones;

    /**
     * 
     * @param idAlumno
     * @param idModerador
     * @param idCarrera
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Alumno(int idAlumno, int idModerador, int idCarrera, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idAlumno = idAlumno;
        this.moderador = new Moderador();
        this.moderador.setIdModerador(idModerador); 
        this.carrera = new Carrera();
        this.carrera.setIdCarrera(idCarrera);
    }

    Alumno() {
        super();
        this.idAlumno = 0;
        this.moderador = new Moderador();
        this.carrera = new Carrera();
    }

}
