package Entidades;

public abstract class Persona extends entidad{

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Persona() {
        this.nombre = "nombre";
        this.apellido = "apellido";
        this.telefono = "telefono";
        this.email = "email";
        this.direccion = "direccion";
        this.legajo = "legajo";
        this.usuario = "usuario";
        this.clave = "clave";
    }

    /**
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param direccion
     * @param legajo
     * @param usuario
     * @param clave 
     */
    public Persona(String nombre, String apellido, String telefono, String email, String direccion, String legajo, String usuario, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.legajo = legajo;
        this.usuario = usuario;
        this.clave = clave;
    }
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private String legajo;
    private String usuario;
    private String clave;
}
