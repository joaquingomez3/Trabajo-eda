
public class Nodo {
   private Libro libro;
   private Nodo izq;
   private Nodo der;

    public Nodo(Libro libro, Nodo izq, Nodo der) {
        this.libro = libro;
        this.izq = izq;
        this.der = der;
    }
    
    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
