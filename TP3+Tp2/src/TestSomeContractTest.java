/**
 * Created with IntelliJ IDEA.
 * User: Fran
 * Date: 14/03/14
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
public class TestSomeContractTest {

    public void testContract(){
        new TestSomeContract().testContract(-1);
    }
}
class Tester{
    public static void main(String[] args) {
        TestSomeContractTest test=new TestSomeContractTest();
        test.testContract();
    }
}
