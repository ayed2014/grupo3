/**
 * Created by Fran on 11/03/14.
 */
    public class Colectivo implements Comparable{
        private int linea;
        private int interno;
        private int asientos;
        boolean discpacitados;



        public Colectivo(int linea, int interno, int asientos, boolean discpacitados) {
            this.linea = linea;
            this.interno = interno;
            this.asientos = asientos;
            this.discpacitados = discpacitados;
        }

        public Colectivo(int linea, int interno) {
            this.linea = linea;
            this.interno = interno;
        }

        public int compareTo(Object x){
            Colectivo y = (Colectivo) x;
            if (this.linea != y.linea)
                return this.linea - y.linea;
            return this.interno - y.interno;

        }

        public int getLinea() {
            return linea;
        }

        public void setLinea(int linea) {
            this.linea = linea;
        }

        public int getInterno() {
            return interno;
        }

        public void setInterno(int interno) {
            this.interno = interno;
        }

        public int getAsientos() {
            return asientos;
        }

        public void setAsientos(int asientos) {
            this.asientos = asientos;
        }

        public boolean isDiscpacitados() {
            return discpacitados;
        }

        public void setDiscpacitados(boolean discpacitados) {
            this.discpacitados = discpacitados;
        }


    }