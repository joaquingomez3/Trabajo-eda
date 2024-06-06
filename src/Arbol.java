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
    public void insertarN(Libro libro){
        Nodo nuevo=new Nodo(libro, null, null); 
        if (raiz==null){
            
            raiz=nuevo;
           
        } else{ 
            Nodo aux =raiz;
            Nodo padre;
            while(true){
            padre=aux;    
            if (libro.getId()<aux.getLibro().getId()){
                aux=aux.getIzq();
             if(aux==null){
                padre.setIzq(nuevo);
                return;
             }
            } else{
                aux=aux.getIzq();
                 if(aux==null){
                padre.setIzq(nuevo);
                return;
             }
            }
            }
        }
    }
     public void Recorrido(Nodo raiz){
        if(raiz!=null){
            System.out.println(raiz.getLibro().getNombre());
            Recorrido(raiz.getIzq());
            Recorrido(raiz.getDer());
        }
    }
}

