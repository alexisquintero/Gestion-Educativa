package Entidades;

import java.sql.Date;



public class Asistencia extends entidad{

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
     * @return the bedel
     */
    public Bedel getBedel() {
        return bedel;
    }

    /**
     * @param bedel the bedel to set
     */
    public void setBedel(Bedel bedel) {
        this.bedel = bedel;
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
     * @return the horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * 
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
