package pila;

/**
 * Created by Fran on 21/03/14.
 */
public class Lista {
    Nodo nodo;
    public void agregar(Object a){
        Nodo temporario=new Nodo() ;
          temporario.dato=a;
        temporario.sig=nodo;
        nodo=temporario;

    }
    public Object quitar(int a){
        Nodo nodoCount=nodo;
       int count=1;
        a--;
        while(count!=a){
            nodoCount=nodoCount.sig;
            count++;
        }
        nodoCount.sig=nodoCount.sig.sig;
        return nodoCount.sig;

    }

    public int longitud(){
        Nodo nodoCount=nodo;
        int count=0;
        while(nodoCount!=null){
            count++;
            nodoCount=nodoCount.sig;
        }
        return count;
    }
    public void vaciar(){
      nodo=null;
    }
    public Object ver(int a){
        Nodo nodoCount=nodo;
        int count=0;
        while(count!=a){
            nodoCount=nodoCount.sig;
            count++;
        }
        return nodoCount;
    }
    }
    class TesterLista{
        public static void main(String[] args) {
            Lista lista=new Lista();
            lista.agregar(1);
            lista.agregar(2);
            lista.agregar(3);
            System.out.println(lista.quitar(2));
            while(lista.longitud()!=0){
                System.out.println();
            }
        }
    }
