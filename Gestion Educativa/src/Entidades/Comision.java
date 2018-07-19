package Entidades;

import java.util.ArrayList;

public class Comision extends entidad{

    public int getIdComision() {
        return idComision;
    }

    public void setIdComision(int idComision) {
        this.idComision = idComision;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Moderador getModerador() {
        return moderador;
    }

    public void setModerador(Moderador moderador) {
        this.moderador = moderador;
    }

    public ArrayList<entidad> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<entidad> horarios) {
        this.horarios = horarios;
    }

    /**
     * @param idComision
     * @param aula
     * @param cupo
     * @param idModerador
     */
    public Comision(int idComision, String aula, int cupo, int idModerador) {
        this.idComision = idComision;
        this.aula = aula;
        this.cupo = cupo;
        this.moderador = new Moderador();
        this.moderador.setIdModerador(idModerador);
        this.horarios = new ArrayList();
        this.parciales = new ArrayList();
    }
    private int idComision;
    private String aula;
    private int cupo;
    private Moderador moderador;
    private ArrayList<entidad> horarios; 
    private ArrayList<entidad> parciales;

    Comision() {
        this.idComision = 0;
        this.aula = "aula";
        this.cupo = 0;
        this.moderador = new Moderador();
        this.horarios = new ArrayList();
        this.parciales = new ArrayList();
    }

    /**
     * @return the parciales
     */
    public ArrayList<entidad> getParciales() {
        return parciales;
    }

    /**
     * @param parciales the parciales to set
     */
    public void setParciales(ArrayList<entidad> parciales) {
        this.parciales = parciales;
    }
}
