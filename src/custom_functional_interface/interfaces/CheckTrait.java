package custom_functional_interface.interfaces;

import custom_functional_interface.models.Animal;

@FunctionalInterface
public interface CheckTrait {
    boolean test(Animal a);
}
