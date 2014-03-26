/**
 * Created by Fran on 20/03/14.
 */
public class PlayadeEstacionamiento {
   private PilaE pila=new PilaE();
    public void addAuto(Auto auto){
        pila.apilar(auto);
    }

    public Auto retirarAuto(String patente){
        PilaE pila2=new PilaE();
        int count=0;
        while(!pila.estaVacio()){
            Auto auto= (Auto) pila.verTope();
            pila.desApilar();
            if (auto.getPatente().equals(patente)){
                while (!pila2.estaVacio()){
                    pila.apilar(pila2.verTope());
                    pila2.desApilar();
                }
                return auto;
            }
            else{
                pila2.apilar(auto);
            }
            count++;
        }
        while (!pila2.estaVacio()){
            pila.apilar(pila2.verTope());
        }
        System.out.println("No se a encontrado el auto");
        return null;
    }

}
class PlayaTester{
    public static void main(String[] args) {
        Auto auto1=new Auto("AAA");
        Auto auto2=new Auto("AAB");
        Auto auto3=new Auto("ABB");
        Auto auto4=new Auto("BBB");
        PlayadeEstacionamiento playa=new PlayadeEstacionamiento();
        playa.addAuto(auto1);
        playa.addAuto(auto2);
        playa.addAuto(auto3);
        playa.addAuto(auto4);
        System.out.println(playa.retirarAuto("ABB").getPatente());
    }
}
