package Entidades;

public class Moderador extends Persona{

    public int getIdModerador() {
        return idModerador;
    }

    public void setIdModerador(int idModerador) {
        this.idModerador = idModerador;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * @param idModerador
     * @param idAdministrador
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Moderador(int idModerador, int idAdministrador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idModerador = idModerador;
        this.administrador = new Administrador();
        this.administrador.setIdAdministrador(idAdministrador);
    }
    private int idModerador;
    private Administrador administrador;

    Moderador() {
        super();
        this.idModerador = 0;
        this.administrador = new Administrador();
    }
}
