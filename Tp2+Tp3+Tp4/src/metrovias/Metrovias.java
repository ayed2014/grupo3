package metrovias;

import java.util.ArrayList;

/**
 * Created by Fran on 11/04/14.
 */
public class Metrovias {
    private ListE tellers;
    private int tellersQuantity;

    public Metrovias(int quantity){
        tellers = new ListE();
        for (int i = 0; i < quantity; i++) {
            Teller teller = new Teller();
            tellers.insertA(teller);
        }
        tellersQuantity = quantity;
    }

    public ArrayList<double[]> simulateDay() {
        ArrayList<double[]> answer = new ArrayList<double[]>();
        double [] average = new double[tellers.getQuantity()];
        double [] totalMoney = new double[tellers.getQuantity()];
        double [] totalIdleTime = new double[tellers.getQuantity()];
        int time = 0;
        // the first 57570 seconds
        while (time < 57570){
            for (int i = 0; i < 5; i++) {
                Passenger passenger = new Passenger(time);
                int random = (int)(10 * Math.random());
                while(random >= tellersQuantity){
                    random = (int)(10 * Math.random());
                }
                tellers.goTo(random);
                Teller teller = (Teller) tellers.seeCurrent();
                QueueD queue = teller.getQueue();
                queue.enQueue(passenger);
            }
            for (int j = 0; j < tellers.getQuantity(); j++) {
                tellers.goTo(j);
                Teller teller = (Teller)tellers.seeCurrent();
                int probability = (int)(100 * Math.random());
                if(probability < 30){
                    if(!teller.getQueue().isEmpty()){
                        teller.attend(time);
                    }
                }
                if(teller.getQueue().isEmpty() && teller.getCurrentClient() == null){
                    teller.setTimeResting(time);
                }
            }
            time+=10;
        }
        // last 30 seconds
        for (int j = 0; j < tellers.getQuantity(); j++) {
            tellers.goTo(j);
            Teller teller = (Teller)tellers.seeCurrent();
            while(teller.getCurrentClient() != null){
                teller.attend(time);
            }
        }
        // calculates the average of time, totalmoney and idletime of each teller
        for (int j = 0; j < tellers.getQuantity(); j++) {
            tellers.goTo(j);
            Teller teller = (Teller) tellers.seeCurrent();
            double money = teller.getMoney();
            double averageTime = teller.calculateAverageTime();
            double idleTime = teller.getIdleTime();
            average[j] = averageTime;
            totalMoney[j] = money;
            totalIdleTime [j] = idleTime;
        }
        answer.add(average);
        answer.add(totalMoney);
        answer.add(totalIdleTime);
        return answer;
    }
}
