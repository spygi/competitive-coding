package language.inheritance;

public class Zoo {
    public static void main(String[] args) {
        // anonymous class: the constructor of WalkingAnimal returns Zoo$1 !!
        WalkingAnimal walking = new WalkingAnimal() {
            @Override
            public void reproduce() {

            }

            @Override
            public void gallop() {

            }
        };

        // Type system
        Cat c = new Cat(); // returns Cat not AbstractSpecies

        AbstractSpecies abstractMax = new Dog("Abstract Max", 2);
        // as.prive(); // conflict because it's contained in both the interface and the implementing class
        ((Dog) abstractMax).prive();
        ((Dog) abstractMax).whatCanIDo();
        // abstractMax.another(); //  can't get resolved because this is in walkable
        abstractMax.reproduce(); // but this works

        // Type conversions
        Dog pureDoggo =  (Dog) abstractMax; // going down the hierarchy needs casting
        pureDoggo.gallop(); // abstractMax.gallop(); would not work but this does
        abstractMax.printPosition(); // this works normally for AbstractSpecies too
        // by the way it's clear that the class is not immutable since pureDoggo galloped before

        abstractMax = pureDoggo; // going up the hierarchy works without casting

        try {
            Cat attempt = (Cat) abstractMax;
        } catch (ClassCastException ex){
        }
    }
}
