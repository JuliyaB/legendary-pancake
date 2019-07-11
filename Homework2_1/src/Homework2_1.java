import java.util.Scanner;

import obstacle_course.*;
import particiant.*;

public class Homework2_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Назваие первой команды: ");
		Team team1 = new Team(in.nextLine());
		team1.printInformationAboutTheTeam();
		System.out.print("Назваие первой команды: ");
		Team team2 = new Team(in.nextLine());
		team2.printInformationAboutTheTeam();
		Course course = new Course();
		course.printInformationAboutTheObstacle();
		course.passObstacles(team1);
		course.passObstacles(team2);
		team1.passedTheDistance();
		team2.passedTheDistance();
	}

}
