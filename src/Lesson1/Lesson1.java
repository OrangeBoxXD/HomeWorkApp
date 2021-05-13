package Lesson1;

public class Lesson1 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColour();
        compareNumbers();
    }
    private static void printThreeWords() {
        System.out.println("_Orange");
        System.out.println("_Banana");
        System.out.println("_Apple");
    }
    private static void checkSumSign() {
        int a = 6006;
        int b = 73;
        long sum = a + b;
        if ((sum) >= 0) {
            System.out.println("Сумма положительная");
            System.out.println("a + b = " + sum);
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
    private static void printColour() {
        int value = 26;
        if (value <= 0) {
            System.out.println("Red");
        }
        else if (value > 0 && value <= 100) {
            System.out.println("Yellow");
        }
        else System.out.println("Green");
    }
    private static void compareNumbers() {
        int a = 5;
        int b = 4;
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }

}
