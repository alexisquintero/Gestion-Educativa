package Entidades;

import java.sql.Date;
import java.time.LocalDate;

public class InscripcionHorario extends entidad{

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

    public InscripcionHorario() {
        this.fecha = Date.valueOf(LocalDate.MIN);
        this.horario = new Horario();
        this.alumno = new Alumno();
    }

    /**
     * 
     * @param fecha
     * @param idHorario
     * @param idAlumno 
     */
    public InscripcionHorario(Date fecha, int idHorario, int idAlumno) {
        this.fecha = fecha;
        this.horario = new Horario();
        this.horario.setIdHorario(idHorario);
        this.alumno = new Alumno();
        this.alumno.setIdAlumno(idAlumno);
    }
    private Date fecha;
    private Horario horario;
    private Alumno alumno;
}
