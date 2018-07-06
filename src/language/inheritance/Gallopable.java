package language.inheritance;

/**
 * Interfaces can be subclassed by other interfaces. We assume here that the ones that can walk can also gallop.
 *
 * Access: If you want / need to restrict access on methods/fields you need to set the access on the interface.
 *
 * I choose Gallopable as a name and not Runnable because of Java's Runnable.
 */
interface Gallopable extends Walkable {
    /* Methods are implicitly public and abstract (but not final): they need to be overriden
     * Except if static or default/private: From: https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
     * OR the interface itself has another access identifier: https://stackoverflow.com/a/17011419
     * If the interface is a top-level class then default is the only option besides public.
     */
    public void gallop(); // this makes no sense because the interface is not visible outside of the package anyway

    // Fields in an interface are implicitly public, static and final
    int distanceToGallop = 2;
}
