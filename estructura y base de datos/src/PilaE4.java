/**
 * Created by Fran on 21/03/14.
 */
public class PilaE4 {
    protected Object [] array;
    private int tope = 0;

    public PilaE4(){
        array = new Object[10];
        for (int i = 0; i < array.length; i++) {
            Object ob = new Object();
            array [i] = ob;
        }
    }

    private void duplicateArray(){
        Object [] array1 = new Object[((array.length-1)*2)];
        for (int i = 0; i < array.length; i++) {
            array1 [i] = array [i];
        }
        array = array1;
    }
    public boolean esVacio(){
        if(tope == 0){
            return true;
        }
        return false;
    }
    public void desApilar(){
        tope--;
    }
    public void apilar(Object object){
        if(tope == array.length-1){
            duplicateArray();
        }
        array[tope] = object;
        tope++;
    }
    public void vaciar(){
        while (tope == 0) {
            array [tope] = new Object();
            tope--;
        }
    }
    public Object verTope(){
        return array [tope-1];
    }
}
