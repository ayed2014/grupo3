package list;

import pila.Nodo;

/**
 * Created by Fran on 11/04/14.
 */
public class DList implements ListI {
  private   Nodo first;
  private   Nodo actual;
  private   Nodo centinela;

     public DList(){
         first=new Nodo();
         actual=first;
         centinela=new Nodo();
         first.sig=centinela;
     }

    public Object actualObject() {
        return actual.dato;
    }

    @Override
    public void deleteAll() {
     first.sig=centinela;
        actual=first;
    }

    @Override
    public boolean isEmpty() {
        if (actual==first){
            return true;
        }
        return false;
    }

    @Override
    public void insertBefore(Object object) {
        if (!isEmpty()){
        actual=getBefore(object);
        insertAfter(object);
    }
    }

    @Override
    public void insertAfter(Object object) {
     Nodo x=actual.sig;
        actual.sig.dato=object;
        actual.sig.sig=x;
            actual=actual.sig;
    }

    @Override
    public void next() {
     actual=actual.sig;
    }

    @Override
    public void before() {
      actual=getBefore(actual.dato);

    }

    @Override
    public void position(int position) {
     int count=0;
        boolean work=true;
        Nodo x=actual;
        if (position==0){
            actual=first.sig;
        }
        else{
        while(count!=position){
          x=x.sig;
            if (x.dato.equals(null)){
                actual=x;
                work=false;
            }
            if (work){
                actual=x;
            }
        }
        }
    }

    @Override
    public void delete() {
    actual=getBefore(actual.dato);
        actual.sig=actual.sig.sig;

    }

    private Nodo getBefore(Object object){
        if (!isEmpty()){
            Nodo x=first;
            while(!x.sig.dato.equals(object)){
                x=x.sig;
            }
            return x;
        }
        return null;
    }
}
class DListTester{
    public static void main(String[] args) {
        DList dList=new DList();
        System.out.println(dList.isEmpty());
        dList.insertAfter(1);
        dList.insertAfter(2);
        dList.insertAfter(3);
        System.out.println(dList.actualObject());
        dList.before();
        System.out.println(dList.actualObject());
        dList.before();
        System.out.println(dList.actualObject());
    }
}
