package obstacle_course;

import java.util.Random;

import particiant.*;

public class Course {
	Obstacle[] obs = new Obstacle[3];
	Random random = new Random();

	public Course() {
		Track track = new Track(random.nextInt(800));
		Wall wall = new Wall(random.nextFloat() * 13);
		Water water = new Water(random.nextInt(300));
		obs[0] = (Obstacle) track;
		obs[1] = (Obstacle) wall;
		obs[2] = (Obstacle) water;
	}

	public void printInformationAboutTheObstacle() {
		System.out.println("Длина дорожки: " + ((Track) obs[0]).getLength());
		System.out.println("Высота стены: " + ((Wall) obs[1]).getHeight());
		System.out.println("Длина отрезка воды: " + ((Water) obs[2]).getLength());
		System.out.println();
	}

	public void passObstacles(Team team) {
		for (Animal animal : team.teamAnimal) {
			for (Obstacle l : obs) {
				if (!l.doIt(animal)) {
					animal.setPassing(l.doIt(animal));
					break;
				}
				animal.setPassing(true);
			}
		}
	}
}
