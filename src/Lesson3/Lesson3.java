package Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        IntegerArray();

    //2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100
        System.out.println(HundredLenghtArray());

        //3. Задать массив [  ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        DoubleIfLess5();

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    // (можно только одну из диагоналей, если обе сложно).
    // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
    // то есть [0][0], [1][1], [2][2], …, [n][n];
        SquareArray();

    //5. Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
        System.out.println(Arrays.toString(MakeAnArray()));

    //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        System.out.println(Arrays.toString(ExtremesOfArray(10)));

    //7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        int[] checkArray = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(EqualSumsOfArray(checkArray));

    //8. *** Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
        System.out.println("Negative moves left, positive moves right");
        System.out.println(Arrays.toString(MoveHowMuch(5, ILikeToMoveItMoveIt(HundredLenghtArray()))));;
    }
    static void IntegerArray() {
        System.out.println("Enter string lenght: ");
        Scanner stringLenght = new Scanner(System.in);
        Random arrayRandom = new Random();
        int lenght = stringLenght.nextInt();
        int[] array = new int[lenght];
        for(int i = 0; i < lenght; i++) {
            array[i] = arrayRandom.nextInt(2);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Inverted matrix: ");
        for(int i = 0; i < lenght; i++) {
            if (array[i] == 1)  array[i] = 0;
            else array[i] = 1;
        }
        System.out.println(Arrays.toString(array));
        stringLenght.close();
    }

    static int[] HundredLenghtArray() {
        int[] array = new int[100];
        for(int i = 0; i < 100; i++) {
            array[i] = i+1;
        }
        return array;
    }

    static void DoubleIfLess5() {
        System.out.println("This is you want me to do: ");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        System.out.println(Arrays.toString(array));

        System.out.println("This is more random: ");
        Scanner stringLenght = new Scanner(System.in);
        Random arrayRandom = new Random();
        int lenght2 = stringLenght.nextInt();
        int[] array2 = new int[lenght2];
        for (int i = 0; i < lenght2; i++) {
            array2[i] = arrayRandom.nextInt(11);
        }
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < lenght2; i++) {
            if (array2[i] < 6) array2[i] *= 2;
        }
        System.out.println(Arrays.toString(array2));
    }


    static void SquareArray() {
        System.out.println("Enter the matrix's lenght: ");
        Scanner lenghtScn = new Scanner(System.in);
        int lenght = lenghtScn.nextInt();
        System.out.println(lenght);
        int[][] matrix = new int[lenght][lenght];
        for (int i = 0; i < lenght; i++) {
            matrix[i] = new int[lenght];
            for (int k = 0; k < lenght; k++) {
                if ((i == k) || (i + k == lenght - 1))    //не забывать, что это программирование, а не линейная алгебра
                    matrix[i][k] = 1;                     //ЭЛЕМЕНТЫ МАССИВА НУМЕРУЮТСЯ С 0 !
                else matrix[i][k] =0;
            }
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    static String[] MakeAnArray() {
        Scanner mkArray = new Scanner(System.in);
        int len = mkArray.nextInt();
        String initialValue = mkArray.nextLine();    //работает, но ввод происходит в одну строку, надо узнать, можно ли
        String[] array = new String[len];           //без создания другого класса или без создания другого сканера
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    static int[] ExtremesOfArray(int lenght) {
        int[] mainArray = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            mainArray[i] = (int) (Math.random() * 100);
        }
        int max = mainArray[0];
        int min = mainArray[0];
        for (int i = 0; i < lenght; i++) {
            if (mainArray[i] > max) max = mainArray[i];
            if (mainArray[i] < min) min = mainArray[i];
        }
        System.out.println(Arrays.toString(mainArray));
        return new int[]{min, max};
    }

    static boolean EqualSumsOfArray(int[] inArray) {
        boolean ifEqual = false;
        int sumLeft = 0;
        int sumTotal = 0;
        for (int i = 0; i < inArray.length; i++) {
            sumTotal += inArray[i];
        }
        for (int i = 0; i < inArray.length; i++) {
            sumLeft += inArray[i];
            sumTotal -= inArray[i];
            if (sumLeft == sumTotal) {
                System.out.println("Point is after element: " + i);
                ifEqual = true;
                break;
            }
        }
        return  ifEqual;
    }

    // можно и в один метод, но это непрактично. можно и в больше методов, но это задание того не стоит
    static int[] ILikeToMoveItMoveIt(int[] moveArray) {
        int cashIn = moveArray[0];
        int cashOut;
        for (int i = 1; i <= moveArray.length; i++) {
            cashOut = moveArray[i % moveArray.length];
            moveArray[i % moveArray.length] = cashIn;
            cashIn = cashOut;
        }
        return moveArray;
    }

    static int[] MoveHowMuch(int n, int[] moveArray) {
        if (n == 0) return moveArray;
        else if (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                ILikeToMoveItMoveIt(moveArray);
            }
            return moveArray;
        }
        else {
            int revertCount = moveArray.length + (n % moveArray.length) - 1;
            for (int i = 0; i < revertCount; i++) {
                ILikeToMoveItMoveIt(moveArray);
            }
            return moveArray;
        }
    }
}





