package list;

/**
 * Created by Fran on 04/04/14.
 */
public class List implements ListI {
    private Object[] array;
    private int window;

    public List(){
        array=new Object[2];
        window=0;
    }

    @Override
    public Object actualObject() {

     return array[window];
    }

    @Override
    public void deleteAll() {
        window=0;
      array=new Object[2];
    }

    @Override
    public boolean isEmpty() {
       if (array[0]==null){
           return true;
       }
        return false;
    }

    @Override
    public void insertBefore(Object object) {
        if (window==0){
         throw new IndexOutOfBoundsException();
        }
      insert(window-1,object);
    }

    @Override
    public void insertAfter(Object object) {
        if (isFull()){
            reSize();
        }
        if (array[window+1]==null){
            array[window+1]=object;
        }
        else {
     insert(window+1,object);
        }
        window++;
    }

    @Override
    public void next() {
        if (window==array.length-1){
            throw new IndexOutOfBoundsException();
        }
     window++;
    }

    @Override
    public void before() {
        if (window==0){
            throw new IndexOutOfBoundsException();
        }
    window--;
    }

    @Override
    public void position(int position) {
        if (position==array.length-1||position<0){
            throw new IndexOutOfBoundsException();
        }
        window=position;
    }

    @Override
    public void delete() {
        int a=window;
        int b=a;
        while (window!=array.length){
            array[window+1]=array[a];
            a++;
        }
        window=b;
    }
    public boolean isFull(){
       if(array[array.length-1]==null){
        return false;
       }
        return true;
    }
    public void insert(Object object){
        if (isFull()){
            reSize();
        }
        array[window]=object;
    }
    private void reSize(){
        Object[] backup=new Object[array.length*2];
        for (int i=0;i<array.length;i++){
            backup[i]=array[i];
        }
        array=backup;
    }
    private Integer lastObject(){
        for(int i=0;i<array.length;i++){
            if (array[i]==null){
                return i-1;
            }
        }
        return null;
    }
    private void insert(int position,Object object){
        if (isFull()){
            reSize();
        }
        int a=lastObject();
        while (position!=a){
         array[a]=array[a+1];
            a--;
        }
        array[a]=object;
    }
}
 class ListTester{


     public static void main(String[] args) {
         System.out.println(System.currentTimeMillis()/1000/3600);
         List list=new List();
           list.insert(2);
         list.insertAfter(3);
         list.insertAfter(4);
         System.out.println(list.actualObject());
         list.before();
         System.out.println(list.actualObject());
         list.before();
         System.out.println(list.actualObject());
         list.position(1);
         list.delete();
         list.position(0);
         System.out.println(list.actualObject());
         list.next();
         System.out.println(list.actualObject());
     }

}
