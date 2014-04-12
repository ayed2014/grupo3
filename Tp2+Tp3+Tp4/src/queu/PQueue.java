package queu;

/**
 * Created by Fran on 11/04/14.
 */
public class PQueue {
    private Nodo[] nodos;
     private int elements;
    public PQueue(){
      nodos =new Nodo[5];
        elements=0;
    }
    public void insert(Object object,int priority){
        boolean find=false;
        if (nodos[0]==null){
            nodos[0]=new Nodo();
            nodos[0].dato=priority;
            nodos[0].sig=new Nodo();
            nodos[0].sig.dato=object;
        }
        else{
        for(int i=0;i<nodos.length;i++){
            if ((Integer)nodos[i].dato==priority){
                Nodo nodo2=new Nodo();
                nodo2.sig=nodos[i].sig;
                nodo2.dato=object;
                nodos[i].sig=nodo2;
                find=true;
                elements++;
                if (elements+1==nodos.length){
                    resizeArray(2);
                }
            }
            break;
        }
        if (!find){
            int count=0;
                while (nodos[count]!=null&&priority>(Integer)nodos[count].dato){
                    if (count>nodos.length){
                        resizeArray(5);
                        nodos[count]=new Nodo();
                        nodos[count].dato=priority;
                        nodos[count].sig.dato=object;
                        elements++;
                    }
                    count++;
                }
            if (nodos[count]==null){
                nodos[count]=new Nodo();
                nodos[count].dato=priority;
                nodos[count].sig=new Nodo();
                nodos[count].sig.dato=object;
            }
            else{
                inset(count,priority);
            }
        }
        }

    }
    public void delete(){
        if (nodos[0]!=null){
        if (nodos[0].sig.sig!=null){
        nodos[0].sig=nodos[0].sig.sig;
        }else{
            for(int i=0;i<nodos.length;i++){
                nodos[i]=nodos[i+1];
                nodos[i+1]=null;
                delete();
            }
        }
        }
    }
    public Object getFirst(){
        if (nodos[0]!=null){
            if (nodos[0].sig!=null){
                Object object=nodos[0].sig.dato;
                nodos[0].sig=nodos[0].sig.sig;
                return object;
            }else{
                for(int i=0;i<nodos.length-1;i++){
                    nodos[i]=nodos[i+1];
                    nodos[i+1]=null;
                  return  getFirst();
                }
            }
        }
        return null;
    }


    private void inset(int i,int priority){
     for(int j=nodos.length;j>i;j--){
         nodos[j]=nodos[j-1];
     }
        nodos[i]=new Nodo();
        nodos[i].dato=priority;
        elements++;
    }
    private void resizeArray(int size){
        if (nodos.length<size){
            Nodo[] nodos2=new Nodo[size];
            for(int i=0;i< nodos.length;i++){
                nodos2[i]= nodos[i];
            }
            nodos =nodos2;
        }
    }


}
class PQueueTester{
    public static void main(String[] args) {
        PQueue pQueue=new PQueue();
        pQueue.insert(1,1);
        pQueue.insert(2, 1);
        pQueue.insert(3,2);
        System.out.println(pQueue.getFirst());
        System.out.println(pQueue.getFirst());
        System.out.println(pQueue.getFirst());
    }
}
