package bank;

import queu.DQueue;

/**
 * Created by Fran on 10/04/14.
 */
public class Bank {
    private Cashier cashier1, cashier2, cashier3;
    private DQueue queue=new DQueue();
    private int seconds;
    private int personTime;


    public Bank(){
        seconds=0;
        personTime=0;
        cashier1=new Cashier(90);
        cashier2=new Cashier(120);
        cashier3=new Cashier(150);
        for(int i=0;i<15;i++){
            Person person=new Person();
            queue.enqueu(person);
        }
    }
    public void run(){
        while(seconds<=18000||!queue.isEmpty()){
            if (!queue.isEmpty()){
            if (cashier1.isFree()&&cashier2.isFree()&&cashier3.isFree()){
              int probability=1+(int)(Math.random()*((4-1)));
                if (probability==1){
                cashier1.assist((Person)queue.queu());
                }
                if (probability==2){
                cashier2.assist((Person)queue.queu());
                }
                if (probability==3){
                cashier3.assist((Person)queue.queu());
                }
            }
            else if (!cashier1.isFree()&&!cashier2.isFree()){
                int probability=1+(int)(Math.random()*((3-1)));
               if (probability==1){
                   cashier1.assist((Person)queue.queu());

               }
                if (probability==2){
                    cashier2.assist((Person)queue.queu());

                }
            }
            else if (!cashier1.isFree()&&!cashier3.isFree()){
                int probability=1+(int)(Math.random()*((3-1)));
                if (probability==1){
                    cashier1.assist((Person)queue.queu());

                }
                if (probability==2){
                    cashier3.assist((Person)queue.queu());

                }
            }
            else if (cashier2.isFree()&&cashier3.isFree()){
                int probability=1+(int)(Math.random()*((3-1)));
                if (probability==1){
                    cashier2.assist((Person)queue.queu());

                }
                if (probability==2){
                    cashier3.assist((Person)queue.queu());

                }
            }
            else{
            if (cashier1.isFree()){
                cashier1.assist((Person)queue.queu());

            }   else if (cashier2.isFree()){
                cashier2.assist((Person)queue.queu());

            }
                else if (cashier3.isFree()){
                cashier3.assist((Person)queue.queu());

            }
            }
            }
            if (personTime==90&&seconds<=18000){
                personTime=0;
                queue.enqueu(new Person());
            }
            cashier1.time(10);
            cashier2.time(10);
            cashier3.time(10);
            personTime=personTime+10;
            seconds= seconds+10;
        }
        System.out.println("People assist\nCashier 1="+cashier1.getPeopleAssist()+"\nCashier 2="+cashier2.getPeopleAssist()+"\nCashier 3="+cashier3.getPeopleAssist());
        System.out.println("Total people assist ="+(cashier1.getPeopleAssist()+cashier2.getPeopleAssist()+cashier3.getPeopleAssist()));


    }
}
    class BackTester{
        public static void main(String[] args) {
            Bank bank=new Bank();
            bank.run();
        }
    }



