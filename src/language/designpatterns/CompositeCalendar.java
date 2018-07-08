package language.designpatterns;

/**
 * In fact CompositeCalendar (or any other concrete calendar) do not need to extend a common abstract type.
 * This is done only for convenience for the client: to be able to put them all in the same List<Calendar>, see Client.
 */
public class CompositeCalendar extends Calendar {
    GoogleCalendar gCal;
    OfficeCalendar oCal;

    public CompositeCalendar(GoogleCalendar gCal, OfficeCalendar oCal) {
        this.gCal = gCal;
        this.oCal = oCal;
    }

    void accept(Visitor v) {
        /*
        // we can either have the traversal logic for each element here:
        v.visitGoogleCalendar(gCal);
        v.visitOfficeCalendar(oCal);

        // and the visit this
        v.visitCompositeCalendar(this);
       */

        // or leave the traversal logic on the specific Visitor
        v.visitCompositeCalendar(this);
    }
}
