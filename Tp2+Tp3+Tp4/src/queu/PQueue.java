package queu;

/**
 * Created by Fran on 11/04/14.
 */
public class PQueue {
    Nodo[] nodos;
      int elements;
    public PQueue(){
      nodos =new Nodo[5];
        elements=0;
    }
    public void insert(Object object,int priority){
        boolean find=false;
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
        }
        if (!find){
            int count=0;
                while (priority>(Integer)nodos[count].dato){
                    count++;
                    if (count>nodos.length){
                        resizeArray(5);
                        nodos[count].dato=priority;
                        nodos[count].sig.dato=object;
                    }
            }
              inset(count,priority);
        }

    }

    private void inset(int i,int priority){
     for(int j=nodos.length;j>i;j--){
         nodos[j+1]=nodos[j];
     }
        nodos[i]=new Nodo();
        nodos[i].dato=priority;

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
