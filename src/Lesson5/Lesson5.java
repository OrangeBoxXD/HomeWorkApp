package Lesson5;

public abstract class Lesson5 {

    public static void main(String[] args) {
        ShowOldEmployeeInfo(InputInfo());
    }

    public static Employee[] InputInfo() {
        Employee[] scientificLab = new Employee[5];
        scientificLab[0] = new Employee("Jackass Octane", "clerk", "stfu@gmail.ru", 89234345001L, 300, 28);
        scientificLab[1] = new Employee("Mirage Voyage", "CEO", "uGotBamboozled@mail.ru", 89234345002L, 10000, 41);
        scientificLab[2] = new Employee("Wraith Bold", "HR", "comeFindMe@mail.ru", 89234345003L, 500, 33);
        scientificLab[3] = new Employee("Sanya Caustic", "Researcher", "deathIsPeace@mail.ru", 89234345004L, 700, 53);
        scientificLab[4] = new Employee("Liza Kot", "IT designer", "havebiggertroubles@gmail.ru", 89234345005L, 1000, 24);
        return scientificLab;
    }
    public static void ShowOldEmployeeInfo(Employee[] scientificLab) {
        for (int i = 0; i < 5; i++) {
            if (scientificLab[i].GetAge() > 40) {
                scientificLab[i].ShowInfo();
            }
        }
    }
}
