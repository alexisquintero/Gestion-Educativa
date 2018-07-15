package Entidades;

import java.sql.Date;

public class InscripcionFinal extends entidad{

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNotaPractica() {
        return notaPractica;
    }

    public void setNotaPractica(int notaPractica) {
        this.notaPractica = notaPractica;
    }

    public int getNotaTeoria() {
        return notaTeoria;
    }

    public void setNotaTeoria(int notaTeoria) {
        this.notaTeoria = notaTeoria;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
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

    public Final getObjFinal() {
        return objFinal;
    }

    public void setObjFinal(Final objFinal) {
        this.objFinal = objFinal;
    }

    /**
     * @param fecha
     * @param notaPractica
     * @param notaTeoria
     * @param notaFinal
     * @param presencia
     * @param idAlumno 
     * @param idFinal 
     */
    public InscripcionFinal(Date fecha, int notaPractica, int notaTeoria, int notaFinal, boolean presencia, int idAlumno, int idFinal) {
        this.fecha = fecha;
        this.notaPractica = notaPractica;
        this.notaTeoria = notaTeoria;
        this.notaFinal = notaFinal;
        this.presencia = presencia;
        this.alumno = new Alumno();
        this.alumno.setIdAlumno(idAlumno);
        this.objFinal = new Final();
        this.objFinal.setIdFinal(idFinal);
    }
    private Date fecha;
    private int notaPractica;
    private int notaTeoria;
    private int notaFinal;
    private boolean presencia;
    private Alumno alumno;
    private Final objFinal;
}
