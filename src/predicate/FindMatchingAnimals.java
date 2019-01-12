package predicate;

import models.Animal;

import java.util.function.Predicate;

/**
 * The result of using Predicate is that we no longer need our custom functional interface.
 * Predicate is a functional interface included in JAVA8, it takes a T type, in our case Animal.
 * Below a rewrite without our functional interface.
 */
public class FindMatchingAnimals {
	
	private static void print(final Animal animal, final Predicate<Animal> trait) {
		if (trait.test(animal)) {
			System.out.println(animal);
		}
	}
	
	public static void main(final String[] args) {
		print(new Animal("fish", false, true), a -> a.isCanHop());
		print(new Animal("kangarou", true, false), a -> a.isCanHop());
	}
	
}
