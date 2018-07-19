package Entidades;

public class NotaParcial extends entidad{

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isPresencia() {
        return presencia;
    }

    public void setPresencia(boolean presencia) {
        this.presencia = presencia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Parcial getParcial() {
        return parcial;
    }

    public void setParcial(Parcial parcial) {
        this.parcial = parcial;
    }

    /**
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
