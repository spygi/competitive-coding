package language.designpatterns;

public class GoogleCalendar extends Calendar {
    @Override
    public void accept(Visitor v) {
        v.visitGoogleCalendar(this);
    }
}
