package Entidades;

import java.sql.Date;



public class Asistencia extends entidad{

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isPresencia() {
        return presencia;
    }

    public void setPresencia(boolean presencia) {
        this.presencia = presencia;
    }

    public Bedel getBedel() {
        return bedel;
    }

    public void setBedel(Bedel bedel) {
        this.bedel = bedel;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * @param fecha
     * @param presencia
     * @param idBedel
     * @param idAlumno
     * @param idHorario 
     */
    public Asistencia(Date fecha, boolean presencia, int idBedel, int idAlumno, int idHorario) {
        this.fecha = fecha;
        this.presencia = presencia;
        this.bedel = new Bedel();
        this.bedel.setIdBedel(idBedel); 
        this.alumno = new Alumno();
        this.alumno.setIdAlumno(idAlumno);
        this.horario = new Horario();
        this.horario.setIdHorario(idHorario);
    }

    /**
     * 
     * @param fecha
     * @param presencia
     * @param idBedel
     * @param idAlumno 
     */
    public Asistencia(Date fecha, boolean presencia, int idBedel, int idAlumno) {
        this.fecha = fecha;
        this.presencia = presencia;
        this.bedel = new Bedel();
        this.bedel.setIdBedel(idBedel); 
        this.alumno = new Alumno();
        this.alumno.setIdAlumno(idAlumno);
    }
    private Date fecha;
    private boolean presencia;
    private Bedel bedel;
    private Alumno alumno;
    private Horario horario;
}
