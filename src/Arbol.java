


import java.util.Scanner;

/*Construir el árbol mediante inserciones
Colocar el libro de hechizos de manera aleatoria
Dar la opción que el usuario elija la rama por la que el fantasma buscará el libro y calcular la cantidad de pasos recorridos
Buscar el libro de hechizos mediante un algoritmo y calcular los pasos recorridos
 */
public class Arbol {

    Scanner scan = new Scanner(System.in);
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

    public void busquedaLibroHechizado() {
        try {
            if (raiz == null) {
                System.out.println("Este arbol esta vacio");
                return;
            }

            Nodo aux = raiz;
            int pasos = 0;
            while (aux != null) {
                if (aux.getLibro().getNombre().equalsIgnoreCase("hechizos")) {
                    System.out.println("Este es : " + aux.getLibro().getNombre() );
                    System.out.println("Pasos recorridos: " + pasos);
                    return;
                }
                boolean entradaValida = false;
                int num = 0;
                while (!entradaValida) {
                    try {
                        System.out.println("Ingrese 1 para ir a la izquierda y 2 para la derecha");
                        num = scan.nextInt();
                        if (num == 1 || num == 2) {
                            entradaValida = true;
                        } else {
                            System.out.println("¡Opción no válida! Intente de nuevo.");
                        }
                    } catch (Exception e) {
                        System.out.println("Entrada no válida. Por favor ingrese un número.");
                        scan.next();
                    }
                }
                pasos++;

                if (num == 1) {
                    if (aux.getIzq() != null) {
                        aux = aux.getIzq();
                    } else {
                        System.out.println("No hay mas nodos a la izquierda.");
                        break;
                    }
                } else if (num == 2) {
                    if (aux.getDer() != null) {
                        aux = aux.getDer();
                    } else {
                        System.out.println("No hay mas nodos a la derecha.");
                        break;
                    }
                } else {
                    System.out.println("¡Opción no válida! Intente de nuevo.");
                }
            }

            System.out.println("No se encontro el libro de hechizos");
        } catch (Exception e) {
            System.out.println("Ocurrió un error durante la búsqueda: " + e.getMessage());
        }
    }

    
    public void insertarLibro() {
         String titulo;
    while (true) {
        try {
            System.out.print("Ingrese título del libro: ");
            titulo = scan.nextLine(); 
            scan.nextLine();
            break;
        } catch (Exception e) {
            System.out.println("Entrada no válida. Por favor, ingrese el título del libro nuevamente.");
            scan.nextLine(); 
        }
    }

    int indice;
    if (titulo.equals("hechizos")) {
        indice = (int) (Math.random() * 1000);
        System.out.println("Asignando ID aleatorio: " + indice);
    } else {
        while (true) {
            try {
                
                System.out.print("Ingrese un índice numérico: ");
                indice = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un índice numérico.");
                scan.nextLine();
            }
        }
    }

    try {
        Libro libro = new Libro(titulo, indice);
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
                    aux = aux.getDer();
                    if (aux == null) {
                        padre.setDer(nuevo);
                        return;
                    }
                }
            }
        }
        System.out.println("Libro agregado exitosamente");
    } catch (Exception e) {
        System.out.println("Ocurrió un error al insertar el libro: " + e.getMessage());
    }
    }

    public void recorrido(Nodo raiz) {
        if (raiz != null) {
            System.out.println(raiz.getLibro().getNombre() + raiz.getLibro().getId());
            recorrido(raiz.getIzq());
            recorrido(raiz.getDer());
        }

    }

    public void buscarLibro(Libro libro) {
     
            Nodo puntero = raiz;
            int pasos = 0;
   try {
            while (puntero != null && puntero.getLibro().getId() != libro.getId()) {
                if (libro.getId() < puntero.getLibro().getId()) {
                    puntero = puntero.getIzq();
                } else {
                    puntero = puntero.getDer();
                }
                pasos++;
            }

            if (puntero == null) {
                System.out.println("No se encontro el libro " + libro.getNombre());
            } else {
                System.out.println("Se encontro el libro " + libro.getNombre()+" con el id: "+ libro.getId());
                System.out.println("Dio " + pasos + " pasos para encontrar su libro");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error durante la búsqueda: " + e.getMessage());
        }
    }
}
