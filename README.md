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
CREATE TABLE pelicula (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    url VARCHAR(255) NOT NULL,
	genero_id INT NOT NULL,
    imagen BLOB,
    FOREIGN KEY (genero_id) REFERENCES genero(codigo)
);

-- Crear la tabla de relación 'pelicula_genero'
CREATE TABLE pelicula_genero (
    pelicula_id INT NOT NULL,
    genero_id INT NOT NULL,
    PRIMARY KEY (pelicula_id, genero_id),
    FOREIGN KEY (pelicula_id) REFERENCES pelicula(codigo),
    FOREIGN KEY (genero_id) REFERENCES genero(codigo)
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
