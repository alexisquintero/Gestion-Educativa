package Entidades;

import java.sql.Date;
import java.time.LocalDate;

public class InscripcionHorario extends entidad{

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public InscripcionHorario() {
        this.fecha = Date.valueOf(LocalDate.MIN);
        this.horario = new Horario();
        this.alumno = new Alumno();
    }

    /**
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
