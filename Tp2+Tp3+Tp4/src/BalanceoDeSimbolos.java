import pila.PilaE;

import java.io.*;


public class BalanceoDeSimbolos {
    private PilaE pila= new PilaE();

    public boolean estaBalanceado(File file){
        try {
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            try{
            while ((line=br.readLine())!=null){
                int count=0;
                while (line.length()>count){
                    char character=line.charAt(count);
                    if (character=='{'||character=='['||character=='('){
                        pila.apilar(line.charAt(count));
                    }
                    else  if (character=='}'||character==']'||character==')'){
                        if (pila.estaVacio()){
                            return false;
                        }
                        Object tope=pila.verTope();
                        pila.desApilar();
                        if ((character=='}'&&!tope.equals('{'))||(character==']'&&!tope.equals('['))||(character=='('&&!tope.equals(')'))){
                            return false;
                        }
                    }
                    count++;
                }
            }
            return true;
            }catch (IOException E1) {
                System.out.println(E1.getMessage());
            }
        } catch (FileNotFoundException E2){
            System.out.println(E2.getMessage());
        }
        return false;
}

}
       class Tester2{
           public static void main(String[] args) {
                BalanceoDeSimbolos a=new BalanceoDeSimbolos();
           }
       }