package Lesson6;

public class Dog extends Animals{

    private String name;
    private static int dogCount;

    public Dog(String name) {
        this.name = name;
        dogCount++;
    }


    @Override
    public void Swim(int distance) {
        if (distance > 10) System.out.printf("%s the dog swam 10m and depleted its stamina%n", name);
        else System.out.printf("%s the dog swam %dm", name, distance);
    }

    @Override
    public void Run(int distance) {
        if (distance > 500) System.out.printf("%s the dog run through 500m and depleted its stamina%n", name);
        else  System.out.printf("%s the dog run through %dm", name, distance);
    }

    public static int getDogCount() {
        return dogCount;
    }
}
