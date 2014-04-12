package metrovias;

/**
 * Created by Fran on 11/04/14.
 */
public class ListE {
    private Object [] vector;
    private int window;
    private int quantity;

    public ListE(){
        vector = new Object[10];
        window = 0;
        quantity = 0;
    }
    private void enlarge(){
        Object [] newVector = new Object[vector.length + 10];
        for (int i = 0; i < vector.length; i++) {
            newVector[i] = vector[i];
        }
        vector = newVector;
    }
    public Object seeCurrent() {
        return vector[window];
    }

    public boolean isEmpty() {
        return (vector[window] == null);
    }

    public void empty() {
        vector = new Object[vector.length];
    }

    public void insertA(Object o) {
        if(quantity == vector.length){
            enlarge();
        }
        if(quantity == 0){
            vector[window] = o;
        }
        for (int i = quantity-1; i > window; i--) {
            Object aux = vector[i];
            vector[i+1]= aux;
        }
        if(quantity > 0){
            next();
            vector[window]= o;
        }
        quantity++;
    }

    public void insertB(Object o) {
        if(window == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(quantity == vector.length){
            enlarge();
        }
        for (int i = quantity-1; i > window-1; i--) {
            Object aux = vector[i];
            vector[i+1]= aux;
        }
        vector[window]= o;
        quantity++;
    }

    public void next() {
        window++;
    }

    public void before() {
        window--;
    }

    public void goTo(int i) {
        if(i > vector.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            window = i;
        }
    }

    public void eliminate() {
        vector[window] = null;
        before();
        quantity--;
    }

    public void modify(Object o) {
        vector[window] = o;
    }
    public int getQuantity(){
        return quantity;
    }
}
