
import java.util.Scanner;

/*Construir el árbol mediante inserciones
Colocar el libro de hechizos de manera aleatoria
Dar la opción que el usuario elija la rama por la que el fantasma buscará el libro y calcular la cantidad de pasos recorridos
Buscar el libro de hechizos mediante un algoritmo y calcular los pasos recorridos
 */
public class Arbol {

    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void busquedaDeLibro() {
        Scanner scan = new Scanner(System.in);
        int pasos = 0;

        if (raiz.getLibro().getNombre().equalsIgnoreCase("Libro de hechizos")) {
            System.out.println("Este es su libro de hechizos" + raiz.toString());
            System.out.println("No hizo falta dar ni un paso para encontrarlo");
        } else {
            Nodo aux = raiz;
            Nodo padre = aux;
            boolean band = false;
            while (!band) {
                if (padre.getLibro().getNombre().equalsIgnoreCase("Libro de hechizos")) {
                    System.out.println("Ingrese 1 para ir a la izquierda y 2 para la derecha");
                    int num = scan.nextInt();
                    pasos++;
                    if (num == 1 && padre.getIzq() != null) {
                        padre = padre.getIzq();
                    } else if (num == 2 && padre.getDer() != null) {
                        padre = padre.getDer();
                    } else {
                        System.out.println("¡Opción no válida!");
                        continue;
                    }

                    if (padre.getLibro().getNombre().equalsIgnoreCase("Libro de hechizos")) {
                        System.out.println("Este es su libro de hechizos" + padre.toString());
                        System.out.println("Pasos recorridos: " + pasos);
                        band = true;
                    }
                }
            }
        }
    }

    public void insertarN(Libro libro) {
        Nodo nuevo = new Nodo(libro, null, null);
        if (raiz == null) {

            raiz = nuevo;

        } else {
            Nodo aux = raiz;
            Nodo padre;
            while (true) {
                padre = aux;
                if (libro.getId() < aux.getLibro().getId()) {
                    aux = aux.getIzq();
                    if (aux == null) {
                        padre.setIzq(nuevo);
                        return;
                    }
                } else {
                    aux = aux.getIzq();
                    if (aux == null) {
                        padre.setIzq(nuevo);
                        return;
                    }
                }
            }
        }
    }

    public void Recorrido(Nodo raiz) {
        if (raiz != null) {
            System.out.println(raiz.getLibro().getNombre());
            Recorrido(raiz.getIzq());
            Recorrido(raiz.getDer());
        }

    }

    public void BuscarLibro(Libro libro) {
        Nodo puntero = raiz;
        int pasos = 0;
        while (puntero.getLibro().getId() != libro.getId()) {
            if (libro.getId() < puntero.getLibro().getId()) {
                puntero = puntero.getIzq();
                pasos++;
            } else {
                puntero = puntero.getDer();
                pasos++;
            }
            if (puntero == null) {
                System.out.println("Este arbol esta vacio");
            } else {
                System.out.println("Se encontro el libro" + libro.getNombre());
                System.out.println("Dio " + pasos + " pasos para encontrar su libro");
            }
        }
    }

}
