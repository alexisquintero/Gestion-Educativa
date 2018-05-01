package Entidades;

import java.util.ArrayList;

public class Carrera extends entidad{

    /**
     * @return the idCarrera
     */
    public int getIdCarrera() {
        return idCarrera;
    }

    /**
     * @param idCarrera the idCarrera to set
     */
    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the materias
     */
    public ArrayList<entidad> getMaterias() {
        return materias;
    }

    /**
     * @param materias the materias to set
     */
    public void setMaterias(ArrayList<entidad> materias) {
        this.materias = materias;
    }

    /**
     * 
     * @param idCarrera
     * @param nombre
     * @param descripcion
     * @param idAdministrador
     * @param materias
     */
    public Carrera(int idCarrera, String nombre, String descripcion, int idAdministrador, ArrayList<entidad> materias) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.administrador = new Administrador();
        this.administrador.setIdAdministrador(idAdministrador);
        this.materias = materias;
    }
    private int idCarrera;
    private String nombre;
    private String descripcion;
    private Administrador administrador;
    private ArrayList<entidad> materias;

    Carrera() {
        this.idCarrera = 0;
        this.nombre = "nombre";
        this.descripcion = "descripcion";
        this.administrador = new Administrador();
        this.materias = new ArrayList();
    }
}
