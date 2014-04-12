import pila.PilaE4;

/**
 * Created by Fran on 21/03/14.
 */
    public class Calculadora {

        private PilaE4 pila;

        public Calculadora(){pila = new PilaE4();}

        public double calcular(String calcular){
            char[] calcularPostfijo = CalcularPostfijo(calcular);
            return readCalcular(calcularPostfijo);
        }

        private char[] CalcularPostfijo(String calcular) {
            char postfijo [] = new char[calcular.length()];
            char temp1 = 0;
            int contador = 0;
            for (int i = 0; i < calcular.length(); i++) {
                char c = calcular.charAt(i);
                if ((c-48) >= 0 && (c-48) <= 9){
                    if (temp1 != 0){
                        postfijo[i-1] = c;
                        postfijo[i] = temp1;
                        temp1 = 0;
                    }else{
                        postfijo[i] = c;
                    }
                }else{
                    if((c+0) == 42 || (c+0) == 47){
                        if(contador != 0){
                            char temp2 = calcular.charAt(i+1);
                            char temp = postfijo [i-1];
                            postfijo [i-1] = temp2;
                            postfijo [i] = c;
                            postfijo [i+1] = temp;
                            i++;
                        }else{
                            temp1 = c;
                        }
                    }else{
                        temp1 = c;
                        contador++;
                    }
                }
            }
            return postfijo;
        }

        private double readCalcular(char calcularPostfijo []){
            double respuesta = 0;
            for (int i = 0; i < calcularPostfijo.length; i++) {
                char c = calcularPostfijo[i];
                if ((c-48) >= 0 && (c-48) <= 9){
                    pila.apilar((double)(c-48));
                }
                else{
                    if((c+0) == 42 ){
                        double uno = (Double) pila.verTope();
                        pila.desApilar();
                        double dos = (Double) pila.verTope();
                        pila.desApilar();
                        respuesta = uno * dos;
                        pila.apilar(respuesta);
                    }
                    else if((c+0) == 47){
                        double uno = (Double) pila.verTope();
                        pila.desApilar();
                        double dos = (Double) pila.verTope();
                        pila.desApilar();
                        respuesta = dos / uno;
                        pila.apilar(respuesta);
                    }
                    else if((c+0) == 43){
                        double uno = (Double) pila.verTope();
                        pila.desApilar();
                        double dos = (Double) pila.verTope();
                        pila.desApilar();
                        respuesta = uno + dos;
                        pila.apilar(respuesta);
                    }
                    else {
                        double uno = (Double) pila.verTope();
                        pila.desApilar();
                        double dos = (Double) pila.verTope();
                        pila.desApilar();
                        respuesta = dos - uno;
                        pila.apilar(respuesta);
                    }
                }
            }
            return (Double) pila.verTope();
        }
    }