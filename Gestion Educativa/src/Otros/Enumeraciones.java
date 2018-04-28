/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

/**
 *
 * @author Supervisor
 */
public class Enumeraciones {
    public enum TipoLogin {Administrador, Moderador, Bedel, Alumno, Docente};
    public enum TipoCorrelativa {Regular, Aprobada};
    public enum Presencia {Ausente, Presente};
    public enum TipoMateria {Electiva, Obligatoria};
    public enum MenuAdministradorOpciones {Carrera, Moderador, Materia};
    public enum CarreraAction {Editar, Eliminar, Crear};
    public enum CarreraMateria {Agregar, Eliminar};
    public enum Anios {Primero, Segundo, Tercero, Cuarto, Quinto};
    public enum ModeradorAction {Editar, Eliminar, Crear};
    public enum DocenteAction {Editar, Eliminar, Crear};
    public enum MateriaAction {Editar, Eliminar, Crear};
    public enum MateriaRegularAprobada {Agregar, Eliminar};
    public enum MenuModeradorOpciones {Alumno, Docente, Comision, Final};
    public enum AlumnoAction {Editar, Eliminar, Crear};
    public enum ComisionAction {Editar, Eliminar, Crear};
}
