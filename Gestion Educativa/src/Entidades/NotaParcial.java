package Entidades;

public class NotaParcial extends entidad{

    /**
     * @return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * @return the presencia
     */
    public boolean isPresencia() {
        return presencia;
    }

    /**
     * @param presencia the presencia to set
     */
    public void setPresencia(boolean presencia) {
        this.presencia = presencia;
    }

    /**
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the parcial
     */
    public Parcial getParcial() {
        return parcial;
    }

    /**
     * @param parcial the parcial to set
     */
    public void setParcial(Parcial parcial) {
        this.parcial = parcial;
    }

    /**
     * 
     * @param nota
     * @param presencia
     * @param idAlumno
     * @param idParcial 
     */
    public NotaParcial(int nota, boolean presencia, int idAlumno, int idParcial) {
        this.nota = nota;
        this.presencia = presencia;
        this.alumno = new Alumno();
        this.alumno.setIdAlumno(idAlumno);
        this.parcial = new Parcial();
        this.parcial.setIdParcial(idParcial);
    }
    private int nota;
    private boolean presencia;
    private Alumno alumno;
    private Parcial parcial;
    
}
