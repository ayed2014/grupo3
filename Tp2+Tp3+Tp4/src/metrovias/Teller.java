package metrovias;

/**
 * Created by Fran on 11/04/14.
 */
public class Teller {
    private QueueD queue;
    private double money;
    private int idleTime;
    private int timeResting;
    private double waitingTimeOfPassengers;
    private int passengerAttended;
    private Passenger currentClient;

    public Teller(){
        queue = new QueueD();
        money = 0;
        timeResting = 0;
        waitingTimeOfPassengers = 0;
        idleTime = 0;
        currentClient = null;
    }

    public double getMoney() {
        return money;
    }

    public void setTimeResting(int timeResting) {
        this.timeResting = timeResting;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public QueueD getQueue() {
        return queue;
    }

    public Passenger getCurrentClient(){
        return currentClient;
    }

    public void attend(int time){
        if(currentClient == null){
            idleTime = idleTime + (time - timeResting);
            currentClient = (Passenger)queue.deQueue();
        }else{
            currentClient.setTimeAttended(time);
            waitingTimeOfPassengers += currentClient.calculateWaitingTime();
            passengerAttended++;
            money+= 0.70;
            if(!queue.isEmpty()){
                currentClient = (Passenger)queue.deQueue();
            }
            else {
                currentClient = null;
            }
        }
    }

    public double calculateAverageTime(){
        return waitingTimeOfPassengers / passengerAttended;
    }
}
