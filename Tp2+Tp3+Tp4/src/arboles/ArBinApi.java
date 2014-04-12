package arboles;

/**
 * Created by Fran on 26/03/14.
 */
public class ArBinApi {

    public int peso(ArBin a){
        if(a.isEmpty()){
            return 0;
        }
        else {
             return 1+peso(a.getLeft())+peso(a.getRight());
        }
    }
    public int ojas(ArBin a){
        int count=0;
        if(a.isEmpty()){
            return 0;
        }
        if(a.getLeft().isEmpty()&&a.getRight().isEmpty()) {
            count++;
        }
        else {
            count+=ojas(a.getLeft());
           count+=ojas(a.getRight());
        }
        return count;
    }

}
