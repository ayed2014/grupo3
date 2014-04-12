package palindrome;

import queu.Nodo;

/**
 * Created by Fran on 11/04/14.
 */
public class PilaD {
    private Nodo tope;

    public PilaD(){
        tope = null;
    }
    public void apilar(Object x){
        Nodo p = new Nodo();
        p.dato=x;
        p.sig = tope;
        tope = p;
    }
    public void desapilar(){
        tope = tope.sig;
    }
    public Object verTope(){
        return tope.dato;
    }
    public boolean esVacio() {
        return (tope == null);
    }
    public void vaciar(){
        tope = null;
    }
    public void print(){
        Nodo siguiente = tope;
        while (siguiente.sig != null) {
            System.out.println(siguiente.dato);
            siguiente = siguiente.sig;
        }
        System.out.println(siguiente.dato);
    }
}
