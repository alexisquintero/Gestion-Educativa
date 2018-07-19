package Entidades;

import java.util.ArrayList;

public class Carrera extends entidad{

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public ArrayList<entidad> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<entidad> materias) {
        this.materias = materias;
    }

    /**
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
