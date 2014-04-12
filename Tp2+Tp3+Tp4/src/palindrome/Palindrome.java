package palindrome;

/**
 * Created by Fran on 11/04/14.
 */
public class Palindrome {
    private QueueE toAnalise;
    private QueueE answer;

    public Palindrome(){
        toAnalise = new QueueE();
        answer = new QueueE();
    }

    public boolean checkIfPalindrome(String string){
        QueueE aux = new QueueE();
        String word = "";
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(c != 32){
                word += c;
            }
            else{
                toAnalise.enQueue(word);
                aux.enQueue(word);
                word = "";
            }
        }
        toAnalise.enQueue(word);
        aux.enQueue(word);
        PilaD pila = new PilaD();
        for (int i = 0; i < toAnalise.getQuantity(); i++) {
            String a = (String) aux.deQueue();
            pila.apilar('/');
            for (int j = 0; j < a.length(); j++) {
                char c = a.charAt(j);
                pila.apilar(c);
            }
        }
        String word1 = "";
        while(!pila.esVacio()){
            char c = (Character) pila.verTope();
            pila.desapilar();
            if(c!=47){
                word1 += c;
            }
            else{
                answer.enQueue(word1);
                word1 = "";
            }
        }
        for (int i = 0; i < toAnalise.getQuantity(); i++) {
            String s = (String) toAnalise.deQueue();
            String s1 = (String) answer.deQueue();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                char c1 = s1.charAt(j);
                if(c != c1){
                    return false;
                }
            }
        }
        return true;
    }
}
