package language.designpatterns;

import java.util.Date;
import java.util.Random;

/**
 * Based on availability functionality: go through events of the calendars using their APIs
 * and check if we are free for a given date.
 */
class AvailabilityVisitor implements Visitor {
    Date date;
    private boolean calendarAvailable; // a visitor accumulates state as they traverse

    AvailabilityVisitor(Date date) {
        this.date = date;
    }

    @Override
    public void visitGoogleCalendar(GoogleCalendar cal) {
        System.out.printf("I am visiting a %s cal for availability%n", "Google");
        // read events within the calendar and check if we are available on date
        calendarAvailable = true;
    }

    @Override
    public void visitOfficeCalendar(OfficeCalendar cal) {
        System.out.printf("I am visiting a %s cal for availability%n", "Office");

        float a = new Random().nextFloat();
        if (a > 0.5)
            calendarAvailable = true;
        else
            calendarAvailable= false;
    }

    @Override
    public void visitCompositeCalendar(CompositeCalendar cal) {
        /*
         * The traversal of a composite is based on the result of traversing the components.
         * That's why we have the traversal logic here instead of the CompositeCalendar.accept method.
         */
        visitGoogleCalendar(cal.gCal);
        if (!calendarAvailable) {
            return; // abort before trying another potentially expensive operation
        }
        visitOfficeCalendar(cal.oCal);
    }

    public boolean isCalendarAvailable() {
        return calendarAvailable;
    }
}
