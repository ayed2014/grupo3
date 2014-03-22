import com.google.java.contract.Requires;

/**
 * Created with IntelliJ IDEA.
 * User: Fran
 * Date: 14/03/14
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class TestSomeContract {

    @Requires({"c>0"})
    public void testContract(int c){

    }
}
