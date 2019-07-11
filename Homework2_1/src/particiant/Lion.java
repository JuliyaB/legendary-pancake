package particiant;

public class Lion extends Animal implements Jumping, Swiming {
	private final int Runl = 1500;
	private final int Swiml = 700;
	private final Float Jumpl = 300f;

	public Lion(String name) {
		this.name = name;
		this.runl = Runl;
		this.swiml = Swiml;
		this.jumpl = Jumpl;
	}

	public Lion(String name, int runl, int swiml, float jumpl) {
		this.name = name;
		this.runl = Runl;
		this.swiml = Swiml;
		this.jumpl = Jumpl;
	}
}
