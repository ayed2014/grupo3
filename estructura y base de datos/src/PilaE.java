/**
 * Created by Fran on 14/03/14.
 */
public class PilaE implements Pila {
   private Object[] array;
    private int tope =0;

    public PilaE(){
     array=new Object[5];
    }

    public void apilar(Object object){
        if (tope==array.length){
            array=duplicarArray(array);
        }
        array[tope]=object;
        tope++;
    }

    public void desApilar(){
      tope--;
    }
    public Object verTope(){
        Object toReturn=new Object();
        if (tope!=0){
            tope--;
            Auto auto=(Auto) array[tope];
         toReturn= array[tope];
            tope++;
        }
        return toReturn;
    }
       public boolean estaVacio(){
           if (tope==0){
               return true;
           }
           return false;
       }
      public Object[] duplicarArray(Object[] array){
          int legth=  array.length*2;
          Object[] array2=new Object[legth];
          for(int i=0;i<array.length;i++){
              array2[i]=array[i];
          }
          return array2;
      }

}
