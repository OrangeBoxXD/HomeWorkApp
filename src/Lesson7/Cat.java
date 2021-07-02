package Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hunger = true;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void Eat(Plate plate) {
        if (plate.getFoodAmount() >= appetite) {
            plate.DecreaseFoodAmount(appetite);
            hunger = false;
            System.out.printf("Cat %s is not hungry anymore. purr-purr-purr <3%n%b hunger%n", name, hunger);
        }
        else if (!hunger) System.out.printf("Hunger is %b! Don't feed this dickhead %s anymore, he's already eaten!", hunger, name);
        else {
            System.out.printf("Not enough food for cat, %s is furious!%n%b hunger%n", name, hunger);
        }
    }

}
