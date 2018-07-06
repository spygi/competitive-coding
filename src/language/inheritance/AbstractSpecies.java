package language.inheritance;

/**
 * From https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 * An abstract class is a class that is declared abstract—it may or may not include abstract methods.
 *
 * Abstract classes cannot be instantiated, but they can be subclassed and their subclasses can get instantiated.
 */
abstract class AbstractSpecies {
    private String cls = this.getClass().getName();
    int position;
    String name;

    /*
     * A subclass can not get instantiated, so why have a constructor?
     * For its subclasses.
     * OK so can it be private? Then the subclasses (whether concrete or abstract) would get a compile-error.
     */
    AbstractSpecies() {
        position = 0;
    }

    public void whatTypeAmI(){
        System.out.println(cls);
    }

    public abstract void reproduce(); // abstract methods don't have body

    public void printPosition() {
        System.out.println(position);
    }
}
