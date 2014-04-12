package queu;

/**
 * Created by Fran on 28/03/14.
 */
public class QueueE implements Queue {
    private int front = -1;
    private int back = -1;
    private int size = 2;
    private int places = 0;
    Object[] array;

    public QueueE() {
        array = new Object[size];
    }

    @Override
    public void enqueu(Object toEnque) {
        if (back==array.length-1){
         if (!isFull()){
             back=0;
         }
        }
       else if(isEmpty()){
            front=0;
            back=0;
        }
        else{
        reSize();
        back++;
        }

        array[back] = toEnque;
        places++;
    }

    @Override
    public Object queu() {
        if (isEmpty()) {
            return null;
        }
        Object toReturn = array[front];
        front = increment(front);
        places--;
        return toReturn;
    }

    @Override
    public boolean isEmpty() {
        if (front==-1&&back==-1) {
            return true;
        }
        return false;

    }

    @Override
    public int lenght() {
        return array.length;
    }

    private int increment(int x) {
        if (x == array.length-1) {
            x = 0;
        } else {
            x++;
        }
        return x;
    }
    public boolean isFull(){
        if (places==size){
            return true;
        }
        return false;
    }

    private void reSize() {
        if (isFull()) {
            int count=-1;
            Object[] array2 = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                array2[i]=queu();
                count++;
            }
            back=count;
            size=size*2;
            front=0;
            array = array2;
        }
    }
}

class QueueTester {
    public static void main(String[] args) {
        QueueE queu = new QueueE();
        queu.enqueu(1);
        queu.enqueu(2);
        queu.queu();
        queu.enqueu(3);
        queu.enqueu(4);
        queu.enqueu(5);
        System.out.println(queu.queu() + "\n" + queu.queu() + "\n" + queu.queu()+"\n"+queu.queu());

    }
}
