package queu;

/**
 * Created by Fran on 05/04/14.
 */
public class DQueue implements Queue {
   private Nodo front;
    private Nodo back;
    int count;

    public DQueue(){
        front =new Nodo();
        back=front;
        count=0;
    }

    @Override
    public void enqueu(Object x) {
        back.dato = x;
        back.sig = new Nodo();
        back = back.sig;
        count++;
    }

    @Override
    public Object queu() {
        Object o = front.dato;
        front = front.sig;
        count--;
        return o;
    }

    @Override
    public boolean isEmpty() {
        if (count==0){
          return true;
        }
        return false;
    }

    @Override
    public int lenght() {
        return count;
    }
}
class DQueueTester{
    public static void main(String[] args) {
        DQueue queue=new DQueue();
        for(int i=0;i<10;i++){
            queue.enqueu(i);
        }
        for(int i=0;i<10;i++){
        System.out.println(queue.queu());
        }
    }
}
