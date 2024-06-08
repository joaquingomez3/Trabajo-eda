
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arbol arbol = new Arbol();
        int opcion = -1;
        do {
            try {
                System.out.println("------------------------------------------------");
                System.out.println("Menu:");
                System.out.println("1. Guardar un libro");
                System.out.println("2. Busca un libro ");
                System.out.println("3. Encuentra el libro de hechizos");
                System.out.println("4. Mostrar biblioteca");
                System.out.println("5. Salir");
                System.out.println("------------------------------------------------");
                System.out.print("Ingrese una opción: ");

                 opcion = scan.nextInt();
                scan.nextLine(); 

                switch (opcion) {
                    case 1:
                        arbol.insertarLibro();
                        break;
                    case 2:
                        if (arbol.raiz == null) {
                            System.out.println("Este árbol está vacío");
                        } else {
                            System.out.println("Ingrese el nombre del libro que desea buscar: ");
                            String nombre = scan.nextLine();
                            int id = -1;
                            boolean idValido = false;

                            while (!idValido) {
                                try {
                                    System.out.println("Ingrese el identificador numérico del libro: ");
                                    id = scan.nextInt();
                                    scan.nextLine(); 
                                    idValido = true;
                                } catch (Exception e) {
                                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                                    scan.nextLine();
                                }
                            }

                            Libro libro = new Libro(nombre, id);
                            arbol.buscarLibro(libro);
                        }
                        break;
                    case 3:
                        arbol.busquedaLibroHechizado();
                        break;
                    case 4:
                        arbol.recorrido(arbol.raiz);
                        break;
                    case 5:
                        System.out.println("Adiós!");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, intente de nuevo.");
                scan.nextLine();
            }
        } while (opcion != 5);
    }
}
