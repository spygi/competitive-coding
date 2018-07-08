package language.designpatterns;

import java.util.Date;
import java.util.Random;

public class WriteVisitor implements Visitor {
    final Date event;
    private boolean result;


    public WriteVisitor(Date event) {
        this.event = event;
    }

    @Override
    public void visitGoogleCalendar(GoogleCalendar cal) {
        float rnd = new Random().nextFloat();
        if (rnd < 0.5) {
            System.out.printf("Failed to write a %s cal, will try again %n", "Google");
            result = false;
            retry(cal);
        } else{
            System.out.printf("I wrote to an %s cal%n", "Google");
            result = true;
        }
    }

    @Override
    public void visitOfficeCalendar(OfficeCalendar cal) {
        System.out.printf("I wrote to an %s cal%n", "Office");
        result = true;
    }

    private void retry(Calendar c) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c.accept(this);
    }

    @Override
    public void visitCompositeCalendar(CompositeCalendar cal) {
        /*
         Here the traversal might not be "complex": does not depend on the result (we will try to write both calendars anyways,
         there is no early aborting like in AvailabilityVisitor) but because we have at least one complex traversal (AvailabilityVisitor)
         we need to repeat the code here.
         */
        visitGoogleCalendar(cal.gCal);
        if (!result)
            retry(cal.gCal);

        visitOfficeCalendar(cal.oCal);
        if (!result)
            retry(cal.oCal);
    }
}
