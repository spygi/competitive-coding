package language.designpatterns;

/**
 * Could be an abstract class or interface.
 * A reason to use an abstract class would be to restrict access to the Visitor and its implementations.
 */
interface Visitor {
    void visitGoogleCalendar(GoogleCalendar cal);
    void visitOfficeCalendar(OfficeCalendar cal);
    void visitCompositeCalendar(CompositeCalendar cal);
}
