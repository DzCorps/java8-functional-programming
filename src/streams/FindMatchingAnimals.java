package streams;

import models.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream API is a powerful collection framework, java8 changes the way that data are processed.
 * Collections are the most important part for any java application, jav8 comes with such a strong API to
 * make things more powerful and easy to use.
 * In the example below we will see a use case of a stream API, including a filter Predicate.
 * Oh yes, Stream API is based on predicates ... functional programming :)
 * The stream consumes data when they are ready and do not store them in the memory, that's why it's powerful
 * and fast.
 * ---------------
 * More complex example will be discussed later :)
 */
public class FindMatchingAnimals {

    public static void main(final String[] args) {
        // prepare data
        final List<Animal> animals = new ArrayList<>();
        final Animal fish = new Animal("fish", false, true);
        final Animal kangarou1 = new Animal("kangarou", true, false);
        final Animal kangarou2 = new Animal("kangarou", true, false);
        final Animal cat = new Animal("cat", true, false);
        final Animal dog = new Animal("dog", true, false);
        animals.add(fish);
        animals.add(kangarou1);
        animals.add(kangarou2);
        animals.add(cat);
        animals.add(dog);

        // processing...
        // In the given list, keep only (kangarou) and remove all the others.
        // with JAVA7 we create loop like this:
        final List<Animal> java7FilteredAnimals = new ArrayList<>();
        for (final Animal animal : animals) {
            if ("kangarou".equals(animal.getSpecies())) {
                java7FilteredAnimals.add(animal);
            }
        }
        System.out.println("JAVA7 filtered list: " + java7FilteredAnimals.toString());

        // with JAVA8, we stream -> add a predicate -> DONE :)
        final List<Animal> collect = animals
                .stream()
                .filter(animal -> "kangarou".equals(animal.getSpecies()))
                .collect(Collectors.toList());
        System.out.println("JAVA8 filtered list: " + collect.toString());
    }

}
