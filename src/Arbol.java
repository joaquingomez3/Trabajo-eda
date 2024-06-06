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
        
        if (raiz==null){
            Nodo nuevo=new Nodo(libro,null,null);
            raiz=nuevo;
           
        } else{ 
            Nodo aux =raiz;
            Nodo padre;
            while(aux!=null){
            padre=aux;    
            aux=aux.getDer();
             if(aux.getDer()==null){
                padre.setLibro(libro);  
             }
             else{
                aux=aux.getIzq();
                 if(aux.getIzq()==null){
                padre.setLibro(libro);
               
             }
             }
            
        }
        } 
    }
    
}
