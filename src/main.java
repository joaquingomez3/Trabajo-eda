
public class main {

    public static void main(String[] args) {
        Libro libro1= new Libro("fantasias", 1);
        Libro libro2= new Libro("matematicas", 2);
        Libro libro3= new Libro("lagunas", 3);
        Libro libro4= new Libro("motos", 4);
        Libro libro5= new Libro("fantasias 2", 5);
        
        Arbol arbol=new Arbol();
        arbol.insertarN(libro1);
        arbol.insertarN(libro2);
        arbol.insertarN(libro3);
        arbol.insertarN(libro4);
        arbol.insertarN(libro5);
        
        System.out.println("muestra de recorrido");
       arbol.Recorrido(arbol.raiz);
    }
    
}
