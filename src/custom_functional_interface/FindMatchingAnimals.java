package custom_functional_interface;

import models.Animal;

/**
 * Java relies on context when figuring out what lambda expressions mean.
 * we are passing a lambda as the second parameter of the print() method.
 * print method expect CheckHop as a second parameter. Since we are passing a lambda instead.
 * Java treats CheckHop as a functional interface and tries to map it to the single abstract method.
 */
public class FindMatchingAnimals {

    private static void print(final Animal animal, final CheckHop trait) {
        if (trait.test(animal)) {
            System.out.println(animal);
        }
    }

    public static void main(final String[] args) {
        print(new Animal("fish", false, true), a -> a.isCanHop());
        print(new Animal("kangarou", true, false), a -> a.isCanHop());
    }

}
