package Entidades;

public class Docente extends Persona{

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public Moderador getModerador() {
        return moderador;
    }

    public void setModerador(Moderador moderador) {
        this.moderador = moderador;
    }

    /**
     * @param idDocente
     * @param idModerador
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Docente(int idDocente, int idModerador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idDocente = idDocente;
        this.moderador = new Moderador();
        this.moderador.setIdModerador(idModerador);
    }
    
    private int idDocente;
    private Moderador moderador;
}
