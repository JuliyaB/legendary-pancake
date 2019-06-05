/**
 * Java. Lesson5. My Homework5.
 *
 * @author Juliya
 * @version dated 5.06.2019
 */
public class Homework5 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Жукин Игорь Александрович", "Электрик", "Gykin@mox.com", "89112334556", 10500, 25);
        persArray[1] = new Employee("Соловей Галина Петрова", "Бугалтер", "Colovy@mox.com", "89338347612", 25000, 40);
        persArray[2] = new Employee("Луковский Аркадий Дмитривич", "Администратор", "Lykovsk@mox.com", "89002348765", 40789, 30);
        persArray[3] = new Employee("Змей Горыныч Огнедышащий", "Завхоз", "Z@mox.com", "89001114455", 15393, 45);
        persArray[4] = new Employee("Баба Яга Мудрейшая", "Директор", "BYmox.com", "89009999999", 500500, 35);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() >= 40) {
                persArray[i].info();
                //System.out.println(persArray[i]);
            }
        }
    }
}
