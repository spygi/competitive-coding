package language.inheritance;

/**
 * Single inheritance means 1:N (abstract to concrete classes). Of course an abstract class can be extended by N classes.
 * Single inheritance can get by-passed with interfaces (or a combination of 1 superclass and an interface).
 * <p>
 * This class is still abstract though because it implements some abstract methods but not all (not the one from {@link Gallopable})
 * From: https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 * We could still declare it as abstract even if it did implement everything to avoid it being instantiated
 * (though a subclass of it could get instantiated so...)
 */
public abstract class WalkingAnimal extends AbstractSpecies implements Walkable, Gallopable {
    // Know the difference of override vs overload
    @Override
    public void walk() {
        System.out.println("I am walking");
        position++;
    }

    WalkingAnimal() {
        whatTypeAmI();
    }
}
