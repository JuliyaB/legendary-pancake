package particiant;

public class Human extends Animal implements Jumping, Swiming {
	public Human(String name) {
		this.name = name;
		this.runl = 10000;
		this.swiml = 5000;
		this.jumpl = 70f;
	}
}
