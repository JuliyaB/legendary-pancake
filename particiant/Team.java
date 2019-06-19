package particiant;

import java.util.Random;

public class Team {
	String Teamname = "��������";
	Animal[] zoo = { new Cat("������"), new Dog("�����"), new Human("����"), new Lion("���", 2000, 1000, 200f) };
	public Animal[] teamAnimal = new Animal[4];
	Random random = new Random();

	public Team(String Teamname) {
		this.Teamname = Teamname;
		for (int i = 0; i < 4; i++) {
			int ran = random.nextInt(4);
			teamAnimal[i] = zoo[ran];
		}
	}

	public void printInformationAboutTheTeam() {
		System.out.println("�������: " + Teamname);
		for (Animal a : teamAnimal) {
			System.out.println(a);
			System.out.println("��� ��: " + a.runl + "�");
			System.out.println("�������� ��: " + a.swiml + "�");
			System.out.println("������ ��: " + a.jumpl + "�");
			System.out.println();

		}
		System.out.println();
	}

	public void passedTheDistance() {
		System.out.println(Teamname + "\n");
		for (Animal a : teamAnimal) {
			if (a.passing) {
				System.out.print(a + " ������ ����������.\n");
			} else {
				System.out.print(a + " �� ������ ����������.\n");
			}
		}
		System.out.println();
	}
}
