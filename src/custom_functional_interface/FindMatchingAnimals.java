package custom_functional_interface;

import custom_functional_interface.interfaces.CheckTrait;
import custom_functional_interface.models.Animal;

public class FindMatchingAnimals {
	
	private static void print(final Animal animal, final CheckTrait trait) {
		if (trait.test(animal)) {
			System.out.println(animal);
		}
	}
	
	public static void main(final String[] args) {
		print(new Animal("fish", false, true), Animal::isCanHop);
		print(new Animal("kangarou", true, false), Animal::isCanHop);
	}
	
}
