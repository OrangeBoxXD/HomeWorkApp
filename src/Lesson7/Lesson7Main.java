package Lesson7;

public class Lesson7Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Charlie", 5),
                new Cat("Foxtrot", 11),
                new Cat("Romeo", 8),
                new Cat("November", 20)
        };
//        Plate[] plate = {
//                new Plate(87),
//                new Plate(50),
//                new Plate(300)
//        };
        Plate plateTest = new Plate(20);

        FeedACat(cats[0], plateTest);
        FeedACat(cats[1], plateTest);
        plateTest.RefillPlate(17);
        FeedACat(cats[2], plateTest);
        FeedACat(cats[3], plateTest);
    }
    public static void FeedACat(Cat cat, Plate plate) {
        cat.Eat(plate);
        plate.PlateFullnessInfo();
        System.out.println("===========================================================");
    }
}
