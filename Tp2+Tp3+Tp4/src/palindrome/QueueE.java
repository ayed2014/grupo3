package palindrome;

/**
 * Created by Fran on 11/04/14.
 */
public class QueueE {
    private Object[] queue;
    private int front;
    private int end;
    private int length;
    private int quantity;

    public QueueE(){
        queue = new Object[10];
        length = queue.length;
        front = 0;
        end = 0;
        quantity = 0;
    }
    private int increment(int i){
        if(i == length-1){
            i = 0;
        }
        else {
            i++;
        }
        return i;
    }
    private void reSize(){
        Object [] newQueue = new Object[length + 10];
        for (int i = 0; !(end == front); i++) {
            newQueue [i] = queue[front];
            front = increment(front);
        }
        newQueue[length-1] = queue[front];
        front = 0;
        end = quantity;
        length = newQueue.length;
        queue = newQueue;
    }
    public void enQueue(Object o) {
        if(isEmpty()){
            queue[end] = o;
            quantity++;
            if(end+1 != front){
                end = increment(end);
            }

        }
        else {
            reSize();
            enQueue(o);
        }
    }

    public Object deQueue() {
        if(quantity != 0){
            Object o = queue[front];
            front = increment(front);
            quantity--;
            return o;
        }
        else {
            return null;
        }
    }

    public boolean isEmpty() {
        return quantity != length;
    }

    public int length() {
        return length;
    }
    public int getQuantity(){
        return quantity;
    }
}
