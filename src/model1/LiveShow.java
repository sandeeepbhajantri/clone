package model1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LiveShow {
    private final String name;
    private final String genre;
    private final Map<String, ShowSlot> timeSlots = new HashMap<>();

    public LiveShow(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public void addSlot(String time, int capacity) {
        timeSlots.put(time, new ShowSlot(this.name, time, capacity));
    }
    public String getName(){
        return name;
    }

    public String getGenre() {
        return genre;
    }

   public Collection<ShowSlot> getSlots() {
        return timeSlots.values();
   }
   public ShowSlot getSlot(String time) {
        return timeSlots.get(time);
   }
}
