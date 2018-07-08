package language.designpatterns;

/**
 * Can be an abstract class or interface.
 */
public abstract class Calendar {
    abstract void accept(Visitor v);
}
