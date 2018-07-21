package Otros;

public class Enumeraciones {
    public enum TipoLogin {Administrador, Moderador, Bedel, Alumno, Docente};
    public enum TipoCorrelativa {Regular, Aprobada};
    public enum Presencia {Ausente, Presente};
    public enum TipoMateria {Electiva, Obligatoria};
    public enum MenuAdministradorOpciones {Carrera, Moderador, Materia, Bedel};
    public enum CarreraAction {Editar, Eliminar, Crear};
    public enum CarreraMateria {Agregar, Eliminar};
    public enum Anios {Primero, Segundo, Tercero, Cuarto, Quinto};
    public enum ModeradorAction {Editar, Eliminar, Crear};
    public enum DocenteAction {Editar, Eliminar, Crear};
    public enum MateriaAction {Editar, Eliminar, Crear};
    public enum MateriaRegularAprobada {Agregar, Eliminar};
    public enum MenuModeradorOpciones {Alumno, Docente, Comision, Finales};
    public enum AlumnoAction {Editar, Eliminar, Crear};
    public enum ComisionAction {Editar, Eliminar, Crear};
    public enum BedelAction {Editar, Eliminar, Crear};
    public enum MenuAlumnoOpciones {InscripcionMateria, InscripcionFinal, NotaPromedio};
    public enum MateriaInscAction {Inscribir};
    public enum HorarioInscAction {Inscribir};
    public enum MateriaFinalInsc{Inscribir};
    public enum FinalInsc{Inscribir};
    public enum Finales{NotaPromedio};
}
