package particiant;

public class Animal {
	protected String name;
	protected int runl;
	protected int swiml;
	protected float jumpl;
	protected boolean passing;

	public boolean run(int length) {
		return runl >= length;
	}

	public boolean swim(int length) {
		return swiml >= length;
	}

	public boolean jump(float height) {
		return jumpl >= height;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " " + name;
	}

	public void setPassing(boolean passing) {
		this.passing = passing;
	}
}
