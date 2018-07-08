package language.designpatterns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usage {
    public static void main(String[] args) {
        List<Calendar> calendars = new ArrayList<>();
        GoogleCalendar gCal = new GoogleCalendar();
        OfficeCalendar oCal = new OfficeCalendar();
        CompositeCalendar compositeCalendar = new CompositeCalendar(gCal, oCal);
        calendars.add(gCal);
        calendars.add(compositeCalendar);
        Date event = new Date();

        for (Calendar c : calendars) {
            AvailabilityVisitor availabilityVisitor = new AvailabilityVisitor(event);
            c.accept(availabilityVisitor); // we could call availabilityVisitor methods directly but we would have to see what type of c we have: this is double dispatch

            if (availabilityVisitor.isCalendarAvailable()){
                System.out.println("Calendar available");
                WriteVisitor w = new WriteVisitor(event);
                c.accept(w);
            } else {
                // we need user interaction to free up their calendars
                System.out.printf("Your cal %s is not free at that time, check them out!%n", c.getClass().getCanonicalName());
            }
        }
    }
}
