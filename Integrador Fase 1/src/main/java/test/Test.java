package test;

//import daomanager.ActionsImpl;
import daomanager.DAOgeneroImpl;
import daomanager.DAOpelicula;
import daomanager.DAOpeliculaGeneroImpl;
import daomanager.DAOpeliculaImpl;
import model.Genero;
import model.Pelicula;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test {
    private static final DAOpeliculaImpl peliculaDAO = new DAOpeliculaImpl();
    private static final DAOgeneroImpl generoDAO = new DAOgeneroImpl();
    private static final DAOpeliculaGeneroImpl peliculaGeneroDAO = new DAOpeliculaGeneroImpl();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String message = ("Bienvenido al proyecto integrador de la fase 1:\n" +
            "Que tipo de busqueda desea realizar:\n" +
            "1- busqueda por titulo.\n" +
            "2- mostrar todas las peliculas.\n" +
            "3- busqueda por genero.\n" +
            "4- Agregar pelicula.\n" +
            "5- modificar pelicula por codigo.\n" +
            "6- eliminar pelicula por codigo.\n" +
            "7- Salir");

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println(message);
            int opcion = scanner.nextInt();
            boolean opcionValida = (opcion >= 1 && opcion <= 7);

            if (opcionValida) {
                switch (opcion) {
                    case 1:
                        peliculasPorTitulo();
                        break;
                    case 2:
                        todasPeliculas();
                        break;
                    case 3:
                        peliculasPorGenero();
                        break;
                    case 4:
                        agregarPeli();
                        break;
                    case 5:
                        modificarPeli();
                        break;
                    case 6:
                        eliminarPeli();
                        break;
                    case 7:
                        continuar = false;
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("\nOpción no válida.\n");
                        break;
                }
            } else {
                System.out.println("\nOpción no válida.\n");
            }
        }

        scanner.close();
    }

    public static void imprimirPeliculas(List<Pelicula> peliculas) {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas disponibles.");
        } else {
            for (Pelicula pelicula : peliculas) {
                System.out.println(formatearPelicula(pelicula));
                System.out.println("---------------------------");
            }
        }
    }

    private static String formatearPelicula(Pelicula pelicula) {
        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(pelicula.getCodigo()).append("\n");
        sb.append("Título: ").append(pelicula.getTitulo()).append("\n");
        sb.append("Director: ").append(pelicula.getDirector()).append("\n");
        sb.append("URL: ").append(pelicula.getUrl()).append("\n");
        sb.append("Imagen: ").append(Arrays.toString(pelicula.getImagen())).append("\n");
        sb.append("Géneros: ").append(formatearGeneros(pelicula.getGeneros())).append("\n");
        return sb.toString();
    }
    private static String formatearGeneros(List<Genero> generos) {
        if (generos == null || generos.isEmpty()) {
            return "Ninguno";
        }
        StringBuilder sb = new StringBuilder();
        for (Genero genero : generos) {
            sb.append(genero.getNombre()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
    private static List<Genero> generosDisponiblesYgenerosSeleccionados(List<Genero> generosDisponibles) {
        List<Genero> generosSeleccionados = new ArrayList<>();
        System.out.println("Géneros disponibles:");

        for (int i = 0; i < generosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + generosDisponibles.get(i).getNombre());
        }

        System.out.println("Ingrese los números de los géneros (separados por comas si es mas de 1): ");
        String[] seleccion = scanner.nextLine().split(",");

        for (String s : seleccion) {
            int index = Integer.parseInt(s.trim()) - 1;
            if (index >= 0 && index < generosDisponibles.size()) {
                generosSeleccionados.add(generosDisponibles.get(index));
            }
        }

        return generosSeleccionados;
    }

    private static byte[] leerArchivo(String rutaArchivo) {
        try {
            Path archivo = Paths.get(rutaArchivo);
            return Files.readAllBytes(archivo);
        } catch (IOException IOExcep) {
            System.out.println("Error al cargar.");
            return null;
        }
    }

    private static byte[] obtenerImagen(Scanner scanner) {
        byte[] imagen;


        String rutaImagen = scanner.nextLine();
        if(rutaImagen!= null){
            imagen = leerArchivo(rutaImagen);
            return imagen;
        }else{
            return imagen = null;
        }


    }

    private static void peliculasPorTitulo(){
        System.out.println("Ingrese el titulo de la pelicula que desea buscar: ");
        String titulo = scanner.nextLine();
        titulo = scanner.nextLine();
        peliculaDAO.busquedaTitulo(titulo);
    }

    private static void peliculasPorGenero(){
        System.out.print("\nIngrese el género: ");
        String genero = scanner.nextLine();
        genero = scanner.nextLine();
        peliculaGeneroDAO.pelisPorGenero(genero);

    }

    private static void todasPeliculas(){
        System.out.println("Todas las películas:");
        List<Pelicula> peliculasCont = peliculaDAO.todasPeliculas();
        for (Pelicula pelicula : peliculasCont) {
            List<Genero> generos = peliculaGeneroDAO.pelisPorCodigo(pelicula.getCodigo());
            pelicula.setGeneros(generos);
        }
        imprimirPeliculas(peliculasCont);
    }

    private static void agregarPeli(){
        System.out.print("\nIngrese el título de la película: ");
        String titulo = scanner.nextLine();
        titulo = scanner.nextLine();
        System.out.print("Ingrese el/la director/a de la película: ");
        String director = scanner.nextLine();
        System.out.print("Ingrese la URL de la película: ");
        String url = scanner.nextLine();
        System.out.print("Ingrese la ruta de la imagen: ");
        byte[] imagen = obtenerImagen(scanner);

        List<Genero> generosDisponibles = generoDAO.obtenerGeneros();
        List<Genero> generosSeleccionados = generosDisponiblesYgenerosSeleccionados(generosDisponibles);

        Pelicula nuevaPelicula = new Pelicula(titulo, director, url, imagen, generosSeleccionados);
        peliculaDAO.agregarPelicula(nuevaPelicula);
        System.out.println("\nPelícula agregada!");
        return;
    }

    private static void modificarPeli() {
        Integer codigo;
        boolean condicion = true;

        do {
            System.out.println("\nIngrese el código de la película que desea modificar, 0 para cancelar: ");
            codigo = scanner.nextInt();

            if (codigo == 0) {
                condicion = false;
                return;
            } else if (codigo > 0) {
                condicion = false;
            } else {
                System.out.println("Código inválido. Por favor, intente nuevamente.");
            }
        } while (condicion);

        List<Pelicula> peliculas = peliculaDAO.todasPeliculas();
        Pelicula pelicula = null;

        for (Pelicula p : peliculas) {
            if (p.getCodigo() == codigo) {
                pelicula = p;
                break;
            }
        }

        if (pelicula == null) {
            System.out.println("\nLa película con código: " + codigo + " no existe");
            return;
        }

        System.out.print("Ingrese el nuevo título de la película: ");
        String nuevoTitulo = scanner.nextLine();
        nuevoTitulo = scanner.nextLine();
        System.out.print("Ingrese el nuevo director: ");
        String nuevoDirector = scanner.nextLine();
        System.out.print("Ingrese la nueva URL: ");
        String nuevaUrl = scanner.nextLine();
        System.out.print("Ingrese la ruta de la imagen: ");
        byte[] nuevaImagen = obtenerImagen(scanner);

        List<Genero> generosDisponibles = generoDAO.obtenerGeneros();
        List<Genero> generosSeleccionados = generosDisponiblesYgenerosSeleccionados(generosDisponibles);

        Pelicula peliculaModificada = new Pelicula(codigo, nuevoTitulo, nuevoDirector, nuevaUrl, nuevaImagen, generosSeleccionados);

        peliculaDAO.modificarPelicula(peliculaModificada);
        System.out.println("\nPelícula modificada correctamente!");
    }

    private static void eliminarPeli() {
        System.out.println("\nListado de todas las películas:");
        System.out.println("\nCódigo\t| Título");
        System.out.println("-----------------------------------");

        List<Pelicula> peliculas = peliculaDAO.todasPeliculas();
        peliculas.forEach(pelicula -> System.out.println(pelicula.getCodigo() + "\t| " + pelicula.getTitulo()));

        Integer codigo = null;
        boolean esValido = false;

        while (!esValido) {
            System.out.print("\nIngrese el código de la película que desea eliminar, 0 para cancelar: ");
            if (scanner.hasNextInt()) {
                codigo = scanner.nextInt();
                esValido = true;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese nuevamente un número.");
                scanner.next();
            }
        }
        scanner.nextLine();

        if (codigo == 0) {
            System.out.println("Regresando al menú principal");
            return;
        }

        Integer finalCodigo = codigo;
        Pelicula pelicula = peliculas.stream()
                .filter(p -> p.getCodigo() == finalCodigo)
                .findFirst()
                .orElse(null);

        if (pelicula == null) {
            System.out.println("\nLa película con código: " + codigo + " no existe");
            return;
        }

        peliculaDAO.eliminarPeli(codigo);
        System.out.println("\nPelícula eliminada!");
    }
}
