package custom_functional_interface;

import models.Animal;

@FunctionalInterface
public interface CheckHop {
    boolean test(Animal a);
}
