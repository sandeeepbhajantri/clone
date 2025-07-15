package strategy;

import model1.ShowSlot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StartTimeRankingStrategy implements SlotRankingStrategy{
    @Override
    public List<ShowSlot> rank(List<ShowSlot> slots){
        return slots.stream()
                .sorted(Comparator.comparing(ShowSlot::getTime))
                .collect(Collectors.toList());
    }
}
