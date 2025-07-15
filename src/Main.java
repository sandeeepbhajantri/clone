import model1.ShowSlot;
import service.BookingService;
import service.LiveShowService;
import strategy.StartTimeRankingStrategy;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LiveShowService showService = new LiveShowService();
        BookingService bookingService = new BookingService(showService);
        showService.registerShow("TMKOC", "Comedy");
        showService.addSlots("TMKOC", Map.of("09:00", 3, "12:00", 2, "15:00", 5));

        showService.registerShow("Sonu Nigam Live", "Singing");
        showService.addSlots("Sonu Nigam Live", Map.of("10:00", 3, "13:00", 2, "17:00", 1));

        System.out.println("nAvailable Comedy shows:");
        List<ShowSlot> slots = showService.getSlotsByGenre("Comedy", new StartTimeRankingStrategy());
        for(ShowSlot slot : slots){
            System.out.println(slot.getShowName() + ": (" + slot.getTime() + ")" + slot.getRemaining());
System.out.println("100000");
        }
        bookingService.book("UserA", "TMKOC", "12:00", 2);
        bookingService.viewBooking("UserA");
        bookingService.cancel("UserA", "xxxxxx");
        bookingService.book("UserB", "TMKOC", "12:00", 1);
        bookingService.viewBooking("UserB");



    }
}
