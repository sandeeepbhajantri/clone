package model1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class User {
    private final String name;
    private final Map<String, Booking> bookings = new HashMap<>();

    public User(String name) {
        this.name = name;
    }
    public boolean hasConflict(String time) {
        return bookings.values().stream().anyMatch(b -> b.getTime().equals(time));
    }
    public void addBooking(Booking b) {
        bookings.put(b.getId(), b);
    }
    public Booking cancelBooking(String id) {
        return bookings.remove(id);
    }
    public String getName() {
        return name;
    }
    public Collection<Booking> getBookings() {
        return bookings.values();
// hey i am sandeep
    }
}
