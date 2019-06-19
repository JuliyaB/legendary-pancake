package particiant;

public class Dog extends Animal implements Jumping, Swiming {
	public Dog(String name) {
		this.name = name;
		this.runl = 500;
		this.swiml = 100;
		this.jumpl = 0.5f;
	}
}
