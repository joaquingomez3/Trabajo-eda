
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

    //metodo insertar nodo
//    public void insertarN(Libro libro){
//        Nodo nuevo=new Nodo(libro);
//        if (raiz==null){
//            raiz=nuevo;
//           
//        } else{ 
//            Nodo aux =raiz;
//            Nodo padre;
//            while(true){
//            padre=aux;    
//            if (valor1<aux.valor){
//                aux=aux.izq;
//             if(aux==null){
//                padre.izq=nuevo;
//                return;
//             }
//            } else{
//                aux=aux.der;
//                 if(aux==null){
//                padre.der=nuevo;
//                return;
//             }
//            }
//            }
//        }
//    }
    //metodo busqueda de nodo
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

//    public Nodo busquedaN( int valor){
//       Nodo punt=raiz; 
//       
//        while(punt.valor != valor){
//            if(valor<punt.valor){
//                punt=punt.izq;
//            }else{
//                punt=punt.der;
//            }
//            if(punt==null){
//                return null;
//            }
//        }
//    return punt;
//}
//    //recorrido de nodo
//    public void Recorrido(Nodo raiz){
//        if(raiz!=null){
//            System.out.println(raiz.valor);
//            Recorrido(raiz.izq);
//            Recorrido(raiz.der);
//        }
//    }
}
