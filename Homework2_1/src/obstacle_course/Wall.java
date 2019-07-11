package obstacle_course;

import particiant.Animal;
import particiant.Jumping;

public class Wall implements Obstacle {

	private float height;

	public Wall(float height) {
		this.height = height;
	}

	@Override
	public boolean doIt(Animal animal) {
		if (animal instanceof Jumping)
			return ((Jumping) animal).jump(height);
		else
			return false;
	}

	public float getHeight() {
		return height;
	}
}
