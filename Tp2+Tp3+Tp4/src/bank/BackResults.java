package bank;

/**
 * Created by Fran on 11/04/14.
 */
public class BackResults {
    public static void main(String[] args) {
        System.out.println("Banck with only one queue:\n");
        Bank bank=new Bank();
        bank.run();
        System.out.println("\nBanck with 3 queues:\n");
        BankB bankB=new BankB();
        bankB.run();
    }
}
