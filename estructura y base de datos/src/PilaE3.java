

/**
 * Created by Fran on 21/03/14.
 */
public class PilaE3 extends PilaE {

    public PilaE3(){
        super();
    }
    public Integer posicionDeObjecto(Object a){
        PilaE3 pila= new PilaE3();
        int count=0;
                while(!estaVacio()){
                    pila.apilar(verTope());
                 if (verTope().equals(a)){
                     while(!pila.estaVacio()){
                         apilar(pila.verTope());
                         pila.desApilar();
                     }
                   return count;
                 }
                    desApilar();
                    count++;
                }
        return null;
    }
}
class testerPilaE3{
    public static void main(String[] args) {
        PilaE3 pila=new PilaE3();
        int count=0;
        while(count<6){
            pila.apilar(count);
            count++;
        }
        System.out.println(pila.posicionDeObjecto(4));
        while(!pila.estaVacio()){
            System.out.println(pila.verTope());
            pila.desApilar();
        }
    }
}
