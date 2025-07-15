package model1;

import java.util.UUID;

public class Booking {
    private final String id;
    private final String userName;
    private final String showName;
    private final String time;
    private final int persons;

    public Booking(String userName, String showName, String time, int persons) {
      this.id = UUID.randomUUID().toString().substring(0,6);
        this.userName = userName;
        this.showName = showName;
        this.time = time;
        this.persons = persons;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getShowName() {
        return showName;
    }

    public String getTime() {
        return time;
    }

    public int getPersons() {
        return persons;
    }
}

