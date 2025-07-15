package service;

import model1.LiveShow;
import model1.ShowSlot;
import strategy.SlotRankingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveShowService {
    private final Map<String, LiveShow> showMap = new HashMap<>();
    public void registerShow(String name, String genre){
        showMap.put(name, new LiveShow(name,genre));
        System.out.println(name + "show is registered");

    }
    public void addSlots(String name, Map<String, Integer> slotMap){
        LiveShow show = showMap.get(name);
        if (show !=null) {
            for (var entry : slotMap.entrySet()){
                show.addSlot(entry.getKey(), entry.getValue());
            }
            System.out.println("Slots added to " + name);
        }

    }
    public List<ShowSlot> getSlotsByGenre(String genre, SlotRankingStrategy strategy){
        List<ShowSlot> slots = new ArrayList<>();
        for (LiveShow s : showMap.values()){
            if(s.getGenre().equalsIgnoreCase(genre)) {
                slots.addAll(s.getSlots());
            }
        }
        return strategy.rank(slots);
    }
    public ShowSlot getSlot(String showName, String time) {
        LiveShow show = showMap.get(showName);
        return show != null ? show.getSlot(time) : null;
    }
}
