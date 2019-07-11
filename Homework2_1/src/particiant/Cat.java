package particiant;

public class Cat extends Animal implements Jumping, Swiming {
	public Cat(String name) {
		this.name = name;
		this.runl = 200;
		this.swiml = 50;
		this.jumpl = 2f;
	}
}
