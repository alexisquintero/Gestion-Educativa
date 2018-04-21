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
    public enum Presencia {Ausente, Presente};
    public enum TipoMateria {Electiva, Obligatoria};
    public enum MenuAdministradorOpciones {Carrera, Moderador, Docente, Materia};
    public enum CarreraAction {Editar, Eliminar, Crear};
    public enum CarreraMateria {Agregar, Eliminar};
    public enum Anios {Primero, Segundo, Tercero, Cuarto, Quinto};
    public enum ModeradorAction {Editar, Eliminar, Crear};
    public enum DocenteAction {Editar, Eliminar, Crear};
}
