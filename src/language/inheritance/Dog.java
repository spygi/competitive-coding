package language.inheritance;

/**
 * Dog can extend WalkingAnimal, even if WalkingAnimal was an abstract class.
 */
public class Dog extends WalkingAnimal {
    private static int gallopLength = 2;
    Dog(String name, int position) {
        // implicitly calls super()
        this.name = name;
        this.position = position; // this overrides the value in the AbstractSpecies constructor
    }

    @Override
    public void gallop() {
        int localCopy = distanceToGallop;
        while (localCopy > 0) { // would be distanceToGallop here
            position += gallopLength;
            // distanceToGallop--; // doesn't work because it's final
            localCopy--;
        }
    }

    @Override
    public void reproduce() {
        System.out.println("Where is a good doggo?");
    }

    // Overriden from the interface: note that access has to be the same or more liberal
    @Override
    public void whatCanIDo() {
        System.out.println("I play all day");
    }

    // private void prive() {}; // does not work because it's private in Walkable
    public void prive() {
        System.out.println("I pee in the garden, shhh");
    }
}
