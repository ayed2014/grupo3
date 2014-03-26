import java.util.Scanner;

/**
 * Created by juan on 19/03/14.
 */
public class TesterCalculadora {
    public static void main(String[] args){
        boolean run = false;
        while(!run){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese la expresion matematica a calcular");
            String calcular = scanner.nextLine();
            Calculadora calculadora = new Calculadora();
            try {
                double resultado = calculadora.calcular(calcular);
                System.out.println("Resultado = "+ resultado);
            } catch (Exception e) {
                System.out.println("Expresion Invalida");
            }
            System.out.println("0 para salir o calquier numero para continuar");
            int answer = scanner.nextInt();
            if(answer == 0){
                run = true;
            }
            else{
                run = false;
            }
        }
    }
}