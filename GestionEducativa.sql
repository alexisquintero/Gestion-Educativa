USE [master]
GO
/****** Object:  Database [GestionEducativa]    Script Date: 26-May-18 11:20:42 PM ******/
CREATE DATABASE [GestionEducativa]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GestionEducativa', FILENAME = N'F:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\GestionEducativa.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'GestionEducativa_log', FILENAME = N'F:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\GestionEducativa_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [GestionEducativa] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GestionEducativa].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GestionEducativa] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GestionEducativa] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GestionEducativa] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GestionEducativa] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GestionEducativa] SET ARITHABORT OFF 
GO
ALTER DATABASE [GestionEducativa] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GestionEducativa] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [GestionEducativa] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GestionEducativa] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GestionEducativa] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GestionEducativa] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GestionEducativa] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GestionEducativa] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GestionEducativa] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GestionEducativa] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GestionEducativa] SET  DISABLE_BROKER 
GO
ALTER DATABASE [GestionEducativa] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GestionEducativa] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GestionEducativa] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GestionEducativa] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GestionEducativa] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GestionEducativa] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GestionEducativa] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GestionEducativa] SET RECOVERY FULL 
GO
ALTER DATABASE [GestionEducativa] SET  MULTI_USER 
GO
ALTER DATABASE [GestionEducativa] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GestionEducativa] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GestionEducativa] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GestionEducativa] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'GestionEducativa', N'ON'
GO
USE [GestionEducativa]
GO
/****** Object:  User [Java]    Script Date: 26-May-18 11:20:42 PM ******/
CREATE USER [Java] FOR LOGIN [Java] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [Java]
GO
ALTER ROLE [db_datareader] ADD MEMBER [Java]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [Java]
GO
/****** Object:  Table [dbo].[Administrador]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Administrador](
	[id_administrador] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[telefono] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[legajo] [char](10) NOT NULL,
	[usuario] [varchar](50) NOT NULL,
	[clave] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Alumno]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Alumno](
	[id_alumno] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[telefono] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[legajo] [char](10) NOT NULL,
	[usuario] [varchar](50) NOT NULL,
	[clave] [varchar](50) NOT NULL,
	[id_moderador] [int] NOT NULL,
	[id_carrera] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Asistencia]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Asistencia](
	[fecha] [date] NOT NULL,
	[presencia] [bit] NOT NULL,
	[id_alumno] [int] NOT NULL,
	[id_bedel] [int] NOT NULL,
	[id_horario] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Bedel]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Bedel](
	[id_bedel] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[telefono] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[legajo] [char](10) NOT NULL,
	[usuario] [varchar](50) NOT NULL,
	[clave] [varchar](50) NOT NULL,
	[id_administrador] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Carrera]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Carrera](
	[id_carrera] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[descripcion] [varchar](500) NOT NULL,
	[id_administrador] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Carrera_Materia]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carrera_Materia](
	[id_carrera] [int] NOT NULL,
	[id_materia] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Comision]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Comision](
	[id_comision] [int] IDENTITY(1,1) NOT NULL,
	[aula] [char](10) NOT NULL,
	[id_moderador] [int] NOT NULL,
	[cupo] [int] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Correlativa]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Correlativa](
	[id_materia] [int] NOT NULL,
	[id_materia_correlativa] [int] NOT NULL,
	[tipo_correlativa] [varchar](10) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Docente]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Docente](
	[id_docente] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[telefono] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[legajo] [char](10) NOT NULL,
	[usuario] [varchar](50) NOT NULL,
	[clave] [varchar](50) NOT NULL,
	[id_moderador] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Docente_Horario]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Docente_Horario](
	[id_horario] [int] NOT NULL,
	[id_docente] [int] NOT NULL,
	[cargo] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Final]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Final](
	[id_final] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[horario_inicio] [time](7) NOT NULL,
	[horario_fin] [time](7) NOT NULL,
	[aula] [char](10) NOT NULL,
	[id_materia] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Horario]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Horario](
	[id_comision] [int] NOT NULL,
	[dia] [char](10) NOT NULL,
	[horario_inicio] [time](7) NOT NULL,
	[horario_fin] [time](7) NOT NULL,
	[id_materia] [int] NOT NULL,
	[id_horario] [int] IDENTITY(1,1) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Inscripcion_Final]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inscripcion_Final](
	[id_final] [int] NOT NULL,
	[id_alumno] [int] NOT NULL,
	[fecha_inscripcion] [date] NOT NULL,
	[nota_practica] [int] NULL,
	[nota_teoria] [int] NULL,
	[nota_final] [int] NOT NULL,
	[presencia] [bit] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Inscripcion_Horario]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inscripcion_Horario](
	[fecha] [date] NOT NULL,
	[id_horario] [int] NOT NULL,
	[id_alumno] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Materia]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Materia](
	[id_materia] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[descripcion] [varchar](500) NOT NULL,
	[anio] [varchar](10) NULL,
	[electiva] [bit] NOT NULL,
	[horas_semana] [int] NOT NULL,
	[id_administrador] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Moderador]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Moderador](
	[id_moderador] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[telefono] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[legajo] [char](10) NOT NULL,
	[usuario] [varchar](50) NOT NULL,
	[clave] [varchar](50) NOT NULL,
	[id_administrador] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Parcial]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Parcial](
	[id_parcial] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](500) NOT NULL,
	[fecha] [date] NOT NULL,
	[horario_inicio] [time](7) NOT NULL,
	[horario_fin] [time](7) NOT NULL,
	[id_horario] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Parcial_Alumno]    Script Date: 26-May-18 11:20:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parcial_Alumno](
	[id_parcial] [int] NOT NULL,
	[id_alumno] [int] NOT NULL,
	[nota] [int] NOT NULL,
	[presencia] [bit] NOT NULL
) ON [PRIMARY]

GO
USE [master]
GO
ALTER DATABASE [GestionEducativa] SET  READ_WRITE 
GO
