package Lesson6;

public class Cat extends Animals{

    private String name;
    private static int catCount;

    public Cat(String name) {
        this.name = name;
        catCount++;
    }

    @Override
    public void Swim(int distance) {
        System.out.println("Cats hate swimming. No way.%n");
    }

    @Override
    public void Run(int distance) {
        if (distance > 200) System.out.printf("%s the cat run through 200m and depleted its stamina%n", name);
        else  System.out.printf("%s the cat run through %dm", name, distance);
    }

    public static int getCatCount() {
        return catCount;
    }
}
