package bank;

import queu.DQueue;

/**
 * Created by Fran on 11/04/14.
 */
public class BankB {
   private DQueue queue1,queue2,queue3;
    private Cashier cashier1,cashier2,cashier3;
    private int time;
    private int personTime;


    public BankB(){
        queue1=new DQueue();
        queue2=new DQueue();
        queue3=new DQueue();
        cashier1=new Cashier(90);
        cashier2=new Cashier(120);
        cashier3=new Cashier(150);
        time=0;
        for(int i=0;i<15;i++){
            peopleQueue();
        }
        }
    public void run(){
        while(time<=18000){

        if (cashier1.isFree()){
            if (!queue1.isEmpty()) {
            cashier1.assist((Person)queue1.queu());
            }
        }
            if (cashier2.isFree()){
                if (!queue2.isEmpty()){
                cashier2.assist((Person)queue2.queu());
                }
            }
            if (cashier3.isFree()){
                if (!queue3.isEmpty()){
                cashier3.assist((Person)queue3.queu());
            }
            }

            if (personTime==90&&time<=18000){
                personTime=0;
                peopleQueue();
            }
      cashier1.time(10);
      cashier2.time(10);
      cashier3.time(10);
      time=time+10;
      personTime=personTime+10;
    }
        System.out.println("People assist\nCashier 1="+cashier1.getPeopleAssist()+"\nCashier 2="+cashier2.getPeopleAssist()+"\nCashier 3="+cashier3.getPeopleAssist());
        System.out.println("Total people assist ="+(cashier1.getPeopleAssist()+cashier2.getPeopleAssist()+cashier3.getPeopleAssist()));
}
    private void peopleQueue(){

    if ((queue1.isEmpty()&&queue2.isEmpty()&&queue3.isEmpty())||(queue1.lenght()==queue2.lenght()&&queue1.lenght()==queue3.lenght())){
        int probability=1+(int)(Math.random()*((4-1)));
       switch (probability){
           case 1:
               queue1.enqueu(new Person());
               break;
           case 2:
               queue2.enqueu(new Person());
               break;
           case 3:
               queue3.enqueu(new Person());
        }
    }
       else if (queue1.isEmpty()&&queue2.isEmpty()&&!queue3.isEmpty()){
            int probability=1+(int)(Math.random()*((3-1)));
              switch (probability){
                  case 1:
                      queue1.enqueu(new Person());
                      break;
                  case 2:
                      queue2.enqueu(new Person());
                      break;
              }
        }
        else if (queue1.isEmpty()&&queue3.isEmpty()&&!queue2.isEmpty()){
            int probability=1+(int)(Math.random()*((3-1)));
            switch (probability){
                case 1:
                    queue1.enqueu(new Person());
                    break;
                case 2:
                    queue3.enqueu(new Person());
                    break;

        }
    }
    else if (queue3.isEmpty()&&queue2.isEmpty()&&!queue1.isEmpty()){
        int probability=1+(int)(Math.random()*((3-1)));
        switch (probability){
            case 1:
                queue3.enqueu(new Person());
                break;
            case 2:
                queue3.enqueu(new Person());
                break;

        }
    }
    else if (queue1.isEmpty()&&!queue2.isEmpty()&&!queue3.isEmpty()){
        queue1.enqueu(new Person());
    }
    else if (queue2.isEmpty()&&!queue1.isEmpty()&&!queue3.isEmpty()){
        queue2.enqueu(new Person());
    }
    else if (queue3.isEmpty()&&!queue2.isEmpty()&&!queue1.isEmpty()){
        queue3.enqueu(new Person());
    }

        else if (!queue1.isEmpty()&&!queue2.isEmpty()&&!queue3.isEmpty()){
        if (queue1.lenght()<queue2.lenght()&&queue1.lenght()<queue3.lenght()){
            queue1.enqueu(new Person());
        }
        else if (queue2.lenght()<queue1.lenght()&&queue2.lenght()<queue3.lenght()){
            queue2.enqueu(new Person());
        }
        else if (queue3.lenght()<queue1.lenght()&&queue3.lenght()<queue2.lenght()){
            queue3.enqueu(new Person());
        }
        else if (queue1.lenght()==queue2.lenght()){
            int probability=1+(int)(Math.random()*((3-1)));
            if (probability==1){
                queue1.enqueu(new Person());
            }
            if (probability==2){
                queue2.enqueu(new Person());
            }
        }
        else if (queue1.lenght()==queue3.lenght()){
            int probability=1+(int)(Math.random()*((3-1)));
            if (probability==1){
                queue1.enqueu(new Person());
            }
            if (probability==2){
                queue3.enqueu(new Person());
            }
        }
        else if (queue2.lenght()==queue3.lenght()){
            int probability=1+(int)(Math.random()*((3-1)));
            if (probability==1){
                queue2.enqueu(new Person());
            }
            if (probability==2){
                queue3.enqueu(new Person());
            }
        }
    }
}


}
class BackBTester{
    public static void main(String[] args) {
        BankB bankB=new BankB();
        bankB.run();
    }
}



