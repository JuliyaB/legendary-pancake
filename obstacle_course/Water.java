package obstacle_course;

import particiant.Animal;
import particiant.Swiming;

public class Water implements Obstacle {
	private int length;

	public Water(int length) {
		this.length = length;
	}

	@Override
	public boolean doIt(Animal animal) {
		if (animal instanceof Swiming)
			return ((Swiming) animal).swim(length);
		else
			return false;
	}

	public int getLength() {
		return length;
	}
}
