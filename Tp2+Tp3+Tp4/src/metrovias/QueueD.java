package metrovias;

import queu.Nodo;

/**
 * Created by Fran on 11/04/14.
 */
public class QueueD {
    private Nodo nodo;
    private Nodo lastNodo;
    private int length;

    public QueueD() {
        nodo = new Nodo();
        lastNodo = nodo;
        length = 0;
    }
    public void enQueue(Object o) {
        lastNodo.dato = o;
        lastNodo.sig = new Nodo();
        lastNodo = lastNodo.sig;
        length++;
    }
    public Object deQueue() {
        Object o = nodo.dato;
        nodo = nodo.sig;
        length--;
        return o;
    }
    public boolean isEmpty() {
        return (length == 0);
    }
    public int length() {
        return length;
    }
}
