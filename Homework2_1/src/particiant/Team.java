package particiant;

import java.util.Random;

public class Team {
	String Teamname = "Чемпионы";
	Animal[] party = { new Cat("Барсик"), new Dog("Шарик"), new Human("Семён"), new Lion("Лео", 2000, 1000, 200f) };
	public Animal[] teamAnimal = new Animal[4];
	Random random = new Random();

	public Team(String Teamname) {
		this.Teamname = Teamname;
		for (int i = 0; i < 4; i++) {
			int ran = random.nextInt(4);
			teamAnimal[i] = party[ran];
		}
	}

	public void printInformationAboutTheTeam() {
		System.out.println("Участники:");
		for (Animal a : teamAnimal) {
			System.out.println(a.name);
			System.out.println("Бег до: " + a.runl + "м");
			System.out.println("Плаванье до: " + a.swiml + "м");
			System.out.println("Прыжок до: " + a.jumpl + "м");
			System.out.println();

		}
	}

	public void passedTheDistance() {
		System.out.println("Команда:"+Teamname);
		for (Animal a : teamAnimal) {
			if (a.passing) {
				System.out.println(a.name + " прошел дистаницию.");
			} else {
				System.out.println(a.name + " не прошел дистаницию.");
			}
		}
		System.out.println();
	}
}
