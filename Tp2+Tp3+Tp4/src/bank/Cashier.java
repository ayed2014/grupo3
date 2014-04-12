package bank;

import queu.DQueue;

/**
 * Created by Fran on 06/04/14.
 */
public class Cashier {
   private boolean free;
    private int timeLimit;
    private DQueue persons;
    private int time;

    public Cashier(int time){
        persons=new DQueue();
        free=true;
        this.timeLimit =time;
        this.time=0;
    }
    public boolean isFree(){
        return free;
    }
    public void assist(Person person){
        free=false;
            persons.enqueu(person);
    }
    public void time(int time){
        this.time+=time;
        if (timeLimit >this.time&&this.time>=90){
            int random=(int)(Math.random()*10);
            if (random>=5){
                free=true;
                this.time=0;
            }
        }
        if (this.time==timeLimit){
            free=true;
            this.time=0;
        }
    }
    public int getPeopleAssist(){
     return persons.lenght();
    }


}
