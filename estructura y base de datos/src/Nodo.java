/**
 * Created by Fran on 21/03/14.
 */
public class Nodo {
    protected  Object dato;
    protected  Nodo sig;


}
   class TesterNodo{
       public static void main(String[] args) {
           Nodo miNodo=new Nodo();
           miNodo.dato=1;
           miNodo.sig=new Nodo();
           miNodo.sig.dato=2;
           miNodo.sig.sig=new Nodo();
           miNodo.sig.sig.dato=3;
           miNodo.sig.sig.sig=new Nodo();
           miNodo.sig.sig.sig.dato=4;
           Nodo count=miNodo;
           while(count!=null){
               System.out.println(count.dato);
               count=count.sig;
           }
       }
   }