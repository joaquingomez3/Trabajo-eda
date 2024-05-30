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
    public void insertarN(int valor1){
        Nodo nuevo=new Nodo(valor1);
        if (raiz==null){
            raiz=nuevo;
           
        } else{ 
            Nodo aux =raiz;
            Nodo padre;
            while(true){
            padre=aux;    
            if (valor1<aux.valor){
                aux=aux.izq;
             if(aux==null){
                padre.izq=nuevo;
                return;
             }
            } else{
                aux=aux.der;
                 if(aux==null){
                padre.der=nuevo;
                return;
             }
            }
            }
        }
         
    }
    //metodo busqueda de nodo
    public Nodo busquedaN( int valor){
       Nodo punt=raiz; 
       
        while(punt.valor != valor){
            if(valor<punt.valor){
                punt=punt.izq;
            }else{
                punt=punt.der;
            }
            if(punt==null){
                return null;
            }
        }
    return punt;
}
    //recorrido de nodo
    public void Recorrido(Nodo raiz){
        if(raiz!=null){
            System.out.println(raiz.valor);
            Recorrido(raiz.izq);
            Recorrido(raiz.der);
        }
    }
}
