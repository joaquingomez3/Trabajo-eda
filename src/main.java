
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Arbol arbol=new Arbol();
        int opcion, indice;
        do {
            System.out.println("------------------------------------------------");
            System.out.println("Menú:");
            System.out.println("1. Insertar libro");
            System.out.println("2. Colocar libro de hechizos");
            System.out.println("3. Buscar libro y calcular pasos ");
            System.out.println("4. Buscar libro de hechizos y calcular pasos");
            System.out.println("5. Salir");
            System.out.println("------------------------------------------------");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese título del libro: ");
                    String titulo = scanner.next();
                    System.out.print("Ingrese un indice numerico: ");
                    indice = scanner.nextInt();
                    Libro libro= new Libro(titulo, indice);
                    arbol.insertarN(libro);
                    System.out.println("Libro agregado exitosamente");
                    break;
                case 2:
                    System.out.print("Ingrese título del libro de hechizos: ");
                    String tituloHechizos = scanner.next();
                    Libro libro1= new Libro(tituloHechizos);
                    arbol.insertarN(libro1);
                    System.out.println("Libro de hechizos agregado exitosamente");
                    break;
                case 3:
                    arbol.busquedaDeLibro();
                    break;
                case 4:
                    //agregar metodo de busqueda de libro de hechizos
                    break;
                case 5:
                    System.out.println("Adiós!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion!= 4);
    }
}
