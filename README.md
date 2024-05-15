# Trabajo integrador fase 1

Dentro de este readme vamos a encontrar información referida a la fase 1 del trabajo integrador.

## Tecnologias

Las tecnologias utilizadas en este trabajo son: 

```bash
-Java | Maven
-SQL
```

## Tabla SQL

```sql
create database integrador_fase_1_peliculas;
USE integrador_fase_1_peliculas;
-- Crear la tabla 'genero'
CREATE TABLE genero (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    genero VARCHAR(50) NOT NULL
);

-- Crear la tabla 'pelicula'
CREATE TABLE `peliculas` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(40) NOT NULL,
  `director` varchar(25) NOT NULL,
  `url` varchar(80) NOT NULL,
  `imagen` longblob,
  PRIMARY KEY (`codigo`)
) ;

-- Crear la tabla de relación 'pelicula_genero'
CREATE TABLE `peliculas_generos` (
  `codigoPelicula` int NOT NULL,
  `idGenero` int NOT NULL,
  PRIMARY KEY (`codigoPelicula`,`idGenero`),
  KEY `idGenero` (`idGenero`),
  CONSTRAINT `peliculas_generos_ibfk_1` FOREIGN KEY (`codigoPelicula`) REFERENCES `peliculas` (`codigo`),
  CONSTRAINT `peliculas_generos_ibfk_2` FOREIGN KEY (`idGenero`) REFERENCES `generos` (`id`)
);

INSERT INTO genero (genero) 
VALUES 
    ('Accion'),
    ('Comedia'),
    ('Drama'),
    ('Ciencia ficción');


```

## Redes
```bash
-https://github.com/FrancoBenitez23
-https://www.linkedin.com/in/franco-benitez-ba197a213/
```

## Aclaraciones
Que tal profes, hago un pequeño apartado de aclaraciones, ya que hay dos puntos que quería comentarles acerca de la actividad y su entrega:

- Debido a problemas personales, no pude subir el trabajo el día de la fecha de entrega planteada, debido a eso me atrase con la entrega, pero aun así no quería quedarme sin enviarles el trabajo y recibir feedback sobre el mismo.
- Solamente tuve un problema al momento de desarrollar la actividad que es que al momento de cargar peliculas, se me duplican en la tabla "pelicula" cuando tenemos mas de 1 genero por pelicula, generando un problema al momento de buscar información o eliminar peliculas. Este es un problema que no pude llegar a solucionar. 

## Modificaciones
-Se tomaron en cuenta todas las modificaciones aclaradas en la devolución del trabajo, debido a que se tenia que realizar un cambio estructural del DAO, parece un nuevo trabajo hecho de 0, debido a eso y para evitar conflictos con el git, me tome el atrevimiento de en algunas situaciones, updatear archivos a mano desde la pagina web, si bien no es lo previsto, me parece lo mejor para evitar romper el repositorio actual. Se actualizaron tambien tablas sql, estas mismas estan aclaradas dentro de este mismo readme.
