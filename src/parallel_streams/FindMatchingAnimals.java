package parallel_streams;

import models.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Stream API uses the CPU cores when requested to process collections in multiple threads.
 * BELOW AN EXAMPLE :)
 * By running the program you can see the process time of each technique
 */
public class FindMatchingAnimals {

    public static void main(final String[] args) {
        // prepare data
        final List<Animal> animals = new ArrayList<>();
        final Animal fish = new Animal("fish", false, true);
        IntStream.range(0, 90000000).forEach(num -> animals.add(fish));
        final Animal dog = new Animal("dog", true, false);
        animals.add(dog);

        // processing...
        // In the given list, keep only (kangarou) and remove all the others.
        /**
         *  With JAVA7 we create loop like below:
         */
        long start = System.nanoTime();
        final List<Animal> java7FilteredAnimals = new ArrayList<>();
        for (final Animal animal : animals) {
            if ("dog".equals(animal.getSpecies())) {
                java7FilteredAnimals.add(animal);
            }
        }
        long finish = System.nanoTime();
        long elapsedTime = finish - start;
        System.out.println("JAVA7 filtered list: " + java7FilteredAnimals.toString()
                + " -- elapsed time: [" + elapsedTime / 1000000 + "]");

        /**
         *  With JAVA8, we stream -> add a predicate -> DONE :)
         */
        start = System.nanoTime();
        final Predicate<Animal> predicate = animal -> "dog".equals(animal.getSpecies());
        final List<Animal> collect = animals
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
        finish = System.nanoTime();
        elapsedTime = finish - start;
        System.out.println("JAVA8 filtered list: " + collect.toString()
                + " -- elapsed time: [" + elapsedTime / 1000000 + "]");


        /**
         *  With JAVA8, we stream -> add a predicate -> DONE :)
         */
        start = System.nanoTime();
        final List<Animal> collect1 = animals
                .parallelStream()
                .filter(predicate)
                .collect(Collectors.toList());
        final long finish8 = System.nanoTime();
        elapsedTime = finish8 - start;
        System.out.println("JAVA8 parallel filtered list: " + collect1.toString()
                + " -- elapsed time: [" + elapsedTime / 1000000 + "]");
    }

}
