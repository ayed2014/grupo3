/**
 * Created by Fran on 21/03/14.
 */
public class PilaE2 extends PilaE{

      private  Object[] array;
      private  int tope =0;

        public PilaE2(){
            super();
        }

        public Object desApilarYVer(){
            if (tope!=0){
                tope--;
                return array[tope];
            }
            return null;
        }

}
