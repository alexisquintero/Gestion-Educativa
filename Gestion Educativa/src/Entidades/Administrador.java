package Entidades;

public class Administrador extends Persona{

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    /**
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
    public Administrador(int idAdministrador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idAdministrador = idAdministrador;
    }
    private int idAdministrador;   

    Administrador() {
        super();
        this.idAdministrador = 0;
    }

}
