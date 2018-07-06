package language.inheritance;

/**
 * An interface can not contain implementation in Java < 8.
 * An interface represents common behavior.
 * A class can implement multiple interfaces and an interface can be implemented by multiple classes, N:N
 *
 * An interface with only one function is called a functional interface.
 */
public interface Walkable {
    // public is redundant here
    public default void whatCanIDo(){ // default is new since Java 8
        System.out.println("I walk");
    }

    default void another(){
        // there can be multiple defaults: here is another one
    }

    private void prive(){ // private is new since Java 9
        System.out.println("A secret");
    }

    void walk(); // implicitly abstract and with the same access level (public) as the interface.
}
