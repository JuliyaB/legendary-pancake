package obstacle_course;

import particiant.Animal;

public class Track implements Obstacle {
	private int length;

	public Track(int length) {
		this.length = length;
	}

	@Override
	public boolean doIt(Animal animal) {
		return animal.run(length);
	}

	public int getLength() {
		return length;
	}
}
