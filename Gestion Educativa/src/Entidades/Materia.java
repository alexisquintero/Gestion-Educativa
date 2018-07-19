package Entidades;

import Otros.Enumeraciones;
import java.util.ArrayList;

public class Materia extends entidad{

    public ArrayList<entidad> getCorrelativasRegulares() {
        return correlativasRegulares;
    }

    public void setCorrelativasRegulares(ArrayList<entidad> correlativasRegulares) {
        this.correlativasRegulares = correlativasRegulares;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
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

    public String getAnio() {
        return anio.toString();
    }

    public void setAnio(String anio) {
        this.anio = Enumeraciones.Anios.valueOf(anio);
    }

    public boolean isElectiva() {
        return electiva;
    }

    public void setElectiva(boolean electiva) {
        this.electiva = electiva;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public ArrayList<entidad> getCorrelativasAprobadas() {
        return correlativasAprobadas;
    }

    public void setCorrelativasAprobadas(ArrayList<entidad> correlativasAprobadas) {
        this.correlativasAprobadas = correlativasAprobadas;
    }

    public ArrayList<Final> getFinales() {
        return finales;
    }

    public void setFinales(ArrayList<Final> finales) {
        this.finales = finales;
    }

    /**
     * @param idMateria
     * @param nombre
     * @param descripcion
     * @param anio
     * @param electiva
     * @param horasSemana 
     * @param idAdministrador 
     */
    public Materia(int idMateria, String nombre, String descripcion, String anio, boolean electiva, int horasSemana, int idAdministrador) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anio = Enumeraciones.Anios.valueOf(anio);
        this.electiva = electiva;
        this.horasSemana = horasSemana;
        this.administrador = new Administrador();
        this.administrador.setIdAdministrador(idAdministrador);
        this.correlativasAprobadas = new ArrayList<>();
        this.correlativasRegulares = new ArrayList<>();
    }
    private int idMateria;
    private String nombre;
    private String descripcion;
    private Enumeraciones.Anios anio;
    private boolean electiva;
    private int horasSemana;
    private Administrador administrador;
    private ArrayList<entidad> correlativasAprobadas;
    private ArrayList<entidad> correlativasRegulares;
    private ArrayList<Final> finales;

    Materia() {
       this.idMateria = 0;
        this.nombre = "nombre";
        this.descripcion = "descripcion";
        this.anio = Enumeraciones.Anios.Primero;
        this.electiva = false;
        this.horasSemana = 0;
        this.administrador = new Administrador(); 
        this.correlativasAprobadas = new ArrayList();
        this.correlativasRegulares = new ArrayList();
        this.finales = new ArrayList();
    }
}
