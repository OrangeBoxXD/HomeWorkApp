package Lesson6;

public class Lesson6_main {

    public static void main(String[] args) {

        Cat whiskey = new Cat("Whiskey");
        Dog charlie = new Dog("Charlie");

        whiskey.Swim(30);
        charlie.Run(1000);

        AnimalCount();
    }

    public static void AnimalCount() {
        System.out.printf("Animal count: %d%n", Cat.getCatCount() + Dog.getDogCount());
        System.out.printf("Amount of cats: %d%n", Cat.getCatCount());
        System.out.printf("Amount of dogs: %d%n", Dog.getDogCount());
    }
}
