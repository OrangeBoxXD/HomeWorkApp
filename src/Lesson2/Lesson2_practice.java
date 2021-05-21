package Lesson2;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Lesson2_practice {

    public static void main(String[] args) {

        System.out.println("Enter task number: ");
        int taskNumber = IntScanner();
        switch(taskNumber) {

            case 1:
        /* 1. Написать метод, принимающий на вход два целых числа и проверяющий,
        что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.*/
            System.out.println(IsSumInRange());
            break;

            case 2:
        /*2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
        положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.*/
            IsPositive(MakeRandomInt());
            break;

            case 3:
        /*3. Написать метод, которому в качестве параметра передается целое число.
        Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.*/
            System.out.println(IfNegative());
            break;

            case 4:
        /*4. Написать метод, которому в качестве аргументов передается строка и число,
        метод должен отпечатать в консоль указанную строку, указанное количество раз;*/
            IWillNotWasteChalk();
            break;

            case 5:
        /*5. * Написать метод, который определяет, является ли год високосным,
        и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным,
        кроме каждого 100-го, при этом каждый 400-й – високосный.*/
            System.out.println(IfLeapYear());
            break;
        }

    }

    static boolean IsSumInRange () {
        int a = IntScanner();
        int b = IntScanner();
        return (a + b) >= 10 && (a + b) <=20;
    }

    static void IsPositive (int a) {
        if (a>=0)
            System.out.println(a + " Positive");
        else
            System.out.println(a + " Negative");
    }

    static boolean IfNegative() {
        int a = IntScanner();
        return a < 0;
    }

    static void IWillNotWasteChalk() {
        String s = StringScanner();
        int count = IntScanner();
        for(int i = 0; i < count; i++) {
            System.out.println(s);
        }
    }

    static boolean IfLeapYear() {
        System.out.println("Enter the year: ");
        Scanner inputYear = new Scanner(System.in);
        int year = inputYear.nextInt();
        return (year %4 == 0 && year %100 != 0) || year %400 == 0;
    }

    static int IntScanner() {
        Scanner inputNumber = new Scanner(System.in);
        int number = inputNumber.nextInt();
        //inputNumber.close();
        //я не понимаю, почему закрытие сканнера здесь вызывает каскад внутренних ошибок
        return number;

    }

    static String StringScanner() {
        Scanner inputString = new Scanner(System.in);
        String str = inputString.nextLine();
        //inputString.close();
        //я не понимаю, почему закрытие сканнера и здесь вызывает каскад внутренних ошибок
        return str;
    }

    static int MakeRandomInt() {
        int min = -100;
        int max = 100;
        max++;
        Random rnd = new Random();
        return rnd.nextInt((max - min) + min);
    }
}
