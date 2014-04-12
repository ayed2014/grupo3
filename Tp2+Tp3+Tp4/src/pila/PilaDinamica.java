package pila;

/**
 * Created by Fran on 28/03/14.
 */
public class PilaDinamica implements Pila {
    private Nodo nodo=null;
    int count=0;
    @Override
    public void apilar(Object object) {
        count++;
        Nodo backup=new Nodo() ;
        backup.dato=object;
        backup.sig=nodo;
        nodo=backup;
    }

    @Override
    public void desApilar() {
        Nodo backup=null;
        for(int i=0;i<count;i++){
            backup=nodo.sig;


        }

    }

    @Override
    public Object verTope() {
       Nodo Backup= new Nodo();
    return null;
    }

    @Override
    public boolean estaVacio() {
        if (nodo.dato==null){
            return true;
        }
        return false;
    }

    @Override
    public Object[] duplicarArray(Object[] array) {
        Nodo backup=new Nodo();
    return null;
    }
}
