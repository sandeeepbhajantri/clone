package model1;

import java.util.LinkedList;
import java.util.Queue;

public class ShowSlot {
    private final String showName;
    private final String time;
    private final int capacity;
    private int booked = 0;
    private final Queue<Booking> waitlist = new LinkedList<>();
    private Booking confirmedBooking;

    public ShowSlot(String showName, String time, int capacity) {
        this.showName = showName;
        this.time = time;
        this.capacity = capacity;
    }
    public boolean isAvailable(int persons) {
        return (booked + persons) <= capacity;
    }
    public boolean hasConflict(ShowSlot other) {
        return this.time.equals(other.time);
    }



    public String getTime() {
        return time;
    }

    public int getRemaining(){
        return capacity - booked;
    }
    public String getShowName(){
        return showName;
    }
    public void addBooking(Booking b){
        booked += b.getPersons();
        confirmedBooking= b;
    }
    public void removeBooking(Booking b){
        booked -= b.getPersons();
        confirmedBooking= null;
    }
    public void addToWaitlist(Booking b) {
        waitlist.offer(b);
    }
    public Booking popWaitlist(){
        return waitlist.poll();
    }
    public boolean hasWaitlist() {
        return !waitlist.isEmpty();
    }

}
