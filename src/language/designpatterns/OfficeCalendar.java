package language.designpatterns;

public class OfficeCalendar extends Calendar {
    @Override
    public void accept(Visitor v) {
        v.visitOfficeCalendar(this);
    }
}
