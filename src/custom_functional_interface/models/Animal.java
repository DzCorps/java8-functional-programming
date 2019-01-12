package custom_functional_interface.models;

public class Animal {
	private final String species;
	private final boolean canHop;
	private final boolean canSwim;
	
	public Animal(final String species, final boolean canHop, final boolean canSwim) {
		this.species = species;
		this.canHop = canHop;
		this.canSwim = canSwim;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public boolean isCanHop() {
		return this.canHop;
	}
	
	public boolean isCanSwim() {
		return this.canSwim;
	}
	
	@Override public String toString() {
		return "Animal{" + "species='" + this.species + '\'' + ", canHop=" + this.canHop + ", canSwim=" + this.canSwim + '}';
	}
}
