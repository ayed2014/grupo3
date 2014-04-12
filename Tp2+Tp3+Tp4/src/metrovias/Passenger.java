package metrovias;

/**
 * Created by Fran on 11/04/14.
 */
public class Passenger {
    private int timeArrived;
    private int timeAttended;

    public Passenger(int timeArrived){
        this.timeArrived = timeArrived;
    }

    public void setTimeAttended(int timeAttended) {
        this.timeAttended = timeAttended;
    }
    public int calculateWaitingTime(){
        return (timeAttended-timeArrived);
    }
}
