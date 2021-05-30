package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static final char EmptySlotSymbol = '-';
    public static void start() {
        char[][] field = {
                {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol},
                {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol},
              //  {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol},
              //  {EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol, EmptySlotSymbol},
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
            DrawMatrix(ImprovedAIMove(field));
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
            System.out.printf("Enter  %s-coordinate [1..3]:%n", axisName);
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
            x = random.nextInt(3);
            y = random.nextInt(3);
        }while (!IsCellEmpty(field, x, y));
        field[y][x] = 'O';
        return field;
    }
    static boolean IsWin(char[][] field, char sign) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign/* && field[i][3] == sign && field[i][4] == sign*/) {
                return true;
            }
        }
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign/* && field[3][i] == sign && field[4][i] == sign*/) {
                return true;
            }
        }
        if (field[0][2] == sign && field[1][1] == sign && field[2][0] == sign) {
            return true;
        }
        if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign/* && field[3][3] == sign && field[4][4] == sign*/) {
            return true;
        }
//        if (field[0][4] == sign && field[1][3] == sign && field[2][2] == sign && field[3][1] == sign && field[4][0] == sign) {
//            return true;
//        }
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

    static char[][] ImprovedAIMove(char[][] field) {
        for (int i = 0; i < 3; i++) {   //Horizontal
            if (field[i][0] == 'X' && field[i][1] == 'X' && field[i][2] != 'O') {
                field[i][2] = 'O';
                return field;
            }
            else if (field[i][1] == 'X' && field[i][2] == 'X' && field[i][0] != 'O') {
                field[i][0] = 'O';
                return field;
            }
            else if (field[i][0] == 'X' && field[i][2] == 'X' && field[i][1] != 'O') {
                field[i][1] = 'O';
                return field;
            }
            else {
                for (int j = 0; j < 3; j++) {  //Vertical
                    if (field[0][j] == 'X' && field[1][j] == 'X' && field[2][j] != 'O') {
                        field[2][j] = 'O';
                        return field;
                    }
                    else if (field[1][j] == 'X' && field[2][j] == 'X' && field[0][j] != 'O') {
                        field[0][j] = 'O';
                        return field;
                    }
                    else if (field[0][j] == 'X' && field[2][j] == 'X' && field[1][j] != 'O') {
                        field[1][j] = 'O';
                        return field;
                    }
                    else {  //Diagonal
                        if (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] != 'O') {
                            field[2][2] = 'O';
                            return field;
                        }
                        else if (field[0][0] == 'X' && field[2][2] == 'X' && field[1][1] != 'O') {
                            field[1][1] = 'O';
                            return field;
                        }
                        else if (field[2][2] == 'X' && field[1][1] == 'X' && field[0][0] != 'O') {
                            field[0][0] = 'O';
                            return field;
                        }
                        else if (field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] != 'O') {
                            field[2][0] = 'O';
                            return field;
                        }
                        else if (field[0][2] == 'X' && field[2][0] == 'X' && field[1][1] != 'O') {
                            field[1][1] = 'O';
                            return field;
                        }
                        else if (field[2][0] == 'X' && field[1][1] == 'X' && field[0][2] != 'O') {
                            field[0][2] = 'O';
                            return field;
                        }
                    }
                }
            }
        }
        return DoSystemMove(field);
    }

}
