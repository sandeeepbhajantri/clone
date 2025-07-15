package service;

import model1.Booking;
import model1.ShowSlot;
import model1.User;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class BookingService {
    private final Map<String, User> userMap = new HashMap<>();
    private final LiveShowService showService;

    public BookingService(LiveShowService showService) {
        this.showService = showService;
    }

    public void book(String userName, String showName, String time, int persons){
        User user = userMap.computeIfAbsent(userName, User::new);
        ShowSlot slot= showService.getSlot(showName, time);
        if(slot==null){
            System.out.println("Slot not found.");
            return;
        }
        if(user.hasConflict(time)) {
            System.out.println("User already has a booking at  this time.");
           return;
        }
        Booking b = new Booking(userName, showName, time
        ,persons);
        if (slot.isAvailable(persons)){
            slot.addBooking(b);
            user.addBooking(b);
            System.out.println("Booked. Booking id: " + b.getId());

        } else {
            slot.addToWaitlist(b);
            System.out.println("Slot full. User added to waitlist.");

        }
    }
    public void cancel(String userName, String bookingId) {
        User user = userMap.get(userName);
        if(user==null) return;
        Booking b= user.cancelBooking(bookingId);
        if(b ==null) return;
        ShowSlot slot = showService.getSlot(b.getShowName(),b.getTime());
        if(slot!=null){
            slot.removeBooking(b);
            if(slot.hasWaitlist()){
                Booking next = slot.popWaitlist();
                slot.addBooking(next);
                User waitUser = userMap.get(next.getUserName());
                if(waitUser !=null){
                    waitUser.addBooking(next);
                }
                System.out.println("Booking moved from Waitlist: " + next.getUserName());

            }

        }
        System.out.println("Booking cancelled.");

    }
    public void viewBooking(String userName) {
        User user =userMap.get(userName);
        if(user !=null){
            for(Booking b: user.getBookings()){
                System.out.println(b.getShowName() + "at" + b.getTime() + "for" + b.getPersons() + "person(s)");

            }
        }
    }
}
