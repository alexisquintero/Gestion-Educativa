package Entidades;

public class Bedel extends Persona{

    public int getIdBedel() {
        return idBedel;
    }

    public void setIdBedel(int idBedel) {
        this.idBedel = idBedel;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * @param idBedel
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
    public Bedel(int idBedel, int idAdministrador, String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        super(nombre, apellido, telefono, email, direccion, legajo, usuario, clave);
        this.idBedel = idBedel;
        this.administrador = new Administrador();
        this.administrador.setIdAdministrador(idAdministrador);
    }
    private int idBedel;
    private Administrador administrador;

    Bedel() {
        super();
        this.idBedel = 0;
        this.administrador = new Administrador();
    }
}
