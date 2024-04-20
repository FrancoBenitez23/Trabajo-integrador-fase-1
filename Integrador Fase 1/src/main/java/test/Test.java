package test;

import daomanager.ActionsImpl;
import model.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        ActionsImpl act = new ActionsImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al proyecto integrador de la fase 1: ");
        System.out.println("Que tipo de busqueda desea realizar: ");
        System.out.println("1- busqueda por titulo.");
        System.out.println("2- busqueda por genero.");
        System.out.println("3- busqueda por codigo.");
        System.out.println("4- Agregar pelicula.");
        System.out.println("5- modificar pelicula por codigo.");
        System.out.println("6- eliminar pelicula por codigo.");
        Integer opcion = scanner.nextInt();


        if(opcion == 1){
            System.out.println("BUSQUEDA POR TITULO: ");
            System.out.println("Ingrese el titulo: ");
            String nombreTitulo = scanner.nextLine();
            nombreTitulo = scanner.nextLine();
            Map<Integer, String> busquedaPorTitulo = act.busquedaTitulo(nombreTitulo);
            if(busquedaPorTitulo.isEmpty() || busquedaPorTitulo == null){
                System.out.println("No se encontro ninguna pelicula con el titulo especificado");
            }else{
                for (Map.Entry<Integer, String> entry : busquedaPorTitulo.entrySet()) {
                    int codigo = entry.getKey();
                    String titulo = entry.getValue();
                    System.out.println("Código: " + codigo + ", Título: " + titulo);
                }
            }
        } else if (opcion == 2) {
            System.out.println("BUSQUEDA POR GENERO: ");
            System.out.println("Ingrese el genero: ");
            String nombreGenero = scanner.nextLine();
            nombreGenero = scanner.nextLine();
            List<Map<Integer, String>> busquedaGenero = act.busquedaGenero(nombreGenero);
            if(busquedaGenero.isEmpty()){
                System.out.println("No se encontro ninguna pelicula con ese genero");
            }else{
                for (Map<Integer, String> elementList : busquedaGenero){
                    for (Map.Entry<Integer, String> entry : elementList.entrySet()){
                        int codigo = entry.getKey();
                        String titulo = entry.getValue();
                        System.out.println("Código: " + codigo + ", Título: " + titulo);
                    }
                }
            }
        } else if (opcion == 3) {
            System.out.println("BUSQUEDA POR CODIGO: ");
            System.out.println("Ingrese el codigo: ");
            Integer codigo = scanner.nextInt();
            List<Map<String, String>> busquedaCodigo = act.busquedaCodigo(codigo);
            if (busquedaCodigo.isEmpty()) {
                System.out.println("No se encontró ninguna película con ese código.");
            } else {
                for (Map<String, String> pelicula : busquedaCodigo) {
                    for (Map.Entry<String, String> entry : pelicula.entrySet()) {
                        String clave = entry.getKey();
                        String valor = entry.getValue();
                        System.out.println(clave + ": " + valor);
                    }
                    System.out.println();
                }
            }
        }else if(opcion == 4){
            System.out.println("ALTA DE PELÍCULA: ");
            System.out.println("Ingrese el título de la película: ");
            String titulo = scanner.nextLine();
            titulo = scanner.nextLine();
            System.out.println("Ingrese la URL de la película: ");
            String url = scanner.nextLine();
            System.out.println("Ingrese los géneros de la película:");
            String generos = scanner.nextLine();
            System.out.println("Ingrese la ruta del archivo de la imagen de la película: ");
            String rutaImagen = scanner.next();
            Pelicula pelicula = new Pelicula(titulo,url,generos,rutaImagen);
            act.altaPelicula(pelicula);

        }else if (opcion == 5){
            System.out.println("modificar pelicula por codigo");
            System.out.println("Ingrese el codigo: ");
            Integer codigo = scanner.nextInt();
            System.out.println("Ingresar nuevo titulo: ");
            String nombre = scanner.nextLine();
            nombre = scanner.nextLine();
            System.out.println("Ingresar nuevo url: ");
            String url = scanner.nextLine();
            System.out.println("Ingresar el nombre del genero: ");
            String generos = scanner.nextLine();
            System.out.println("Ingrese la ruta del archivo de la imagen de la película: ");
            String rutaImagen = scanner.next();
            Pelicula pelicula = new Pelicula(nombre,url,generos,rutaImagen);
            act.modificacionPelicula(codigo,pelicula);

        } else if (opcion == 6) {
            System.out.println("Eliminar pelicula por codigo");
            System.out.println("Ingrese el codigo: ");
            Integer codigo = scanner.nextInt();
            act.bajaPelicula(codigo);


        }



    }
}
