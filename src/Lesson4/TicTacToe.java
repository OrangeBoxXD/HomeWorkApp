package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static final char EmptySlotSymbol = '-';
    public static void start() {
        char[][] field = {
                {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol},
                {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol},
                {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol},
                {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol},
                {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol}
        };
        DrawMatrix(field);
        do {
            DrawMatrix(DoPlayerMove(field));
            if (IsWin(field, 'X')) {
                System.out.println("You win!");
                System.out.println("GAME OVER");
                break;
            }
            else if (IsDraw(field)) {
                System.out.println("Draw.");
                System.out.println("GAME OVER");
                break;
            }
            DrawMatrix(DoSystemMove(field));
            if (IsWin(field, 'O')) {
                System.out.println("You lost.");
                System.out.println("GAME OVER");
                break;
            }
            else if (IsDraw(field)) {
                System.out.println("Draw.");
                System.out.println("GAME OVER");
                break;
            }
        } while (true);
    }

    static void DrawMatrix(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field.length; k++) {
                System.out.print(field[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static char[][] DoPlayerMove(char[][] field) {
        int x;
        int y;
        do {
            x = GetCoordinate(field, 'x');
            y = GetCoordinate(field, 'y');
        }while (!IsCellEmpty(field, x, y));
        field[y][x] = 'X';
        return field;
    }

    static int GetCoordinate(char[][] field, char axisName) {
        int coordinate;
        Scanner coordinateScanner = new Scanner(System.in);
        do {
            System.out.printf("Enter  %s-coordinate [1..5]:%n", axisName);
            coordinate = coordinateScanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= field.length);
        return coordinate;
    }

    static boolean IsCellEmpty(char[][] field, int x, int y) {
        return field[y][x] == EmptySlotSymbol;
    }

    static char[][] DoSystemMove(char[][] field) {
        Random random = new Random();
        int x;
        int y;
        do {
            x = random.nextInt(5);
            y = random.nextInt(5);
        }while (!IsCellEmpty(field, x, y));
        field[y][x] = 'O';
        return field;
    }
    static boolean IsWin(char[][] field, char sign) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign && field[i][3] == sign && field[i][4] == sign) {
                return true;
            }
        }
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign && field[3][i] == sign && field[4][i] == sign) {
                return true;
            }
        }
        if (field[0][4] == sign && field[1][3] == sign && field[2][2] == sign && field[3][1] == sign && field[4][0] == sign) {
            return true;
        }
        if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign && field[3][3] == sign && field[4][4] == sign) {
            return true;
        }
        return false;
    }

    static boolean IsDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (IsCellEmpty(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
