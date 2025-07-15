package strategy;

import model1.ShowSlot;

import java.util.List;

public interface SlotRankingStrategy {
    List<ShowSlot> rank(List<ShowSlot> slots);
}
