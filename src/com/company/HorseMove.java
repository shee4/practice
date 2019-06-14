
package com.company;

import java.util.Scanner;

public class HorseMove {

    public static Point[] moves = {
            new Point(2, 1),
            new Point(2, -1),
            new Point(1, 2),
            new Point(1, -2),
            new Point(-1, 2),
            new Point(-1, -2),
            new Point(-2, 1),
            new Point(-2, -1)};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x;
        int y;
        while (true) {
            System.out.println("Enter start coords:\nx:");
            x = scan.nextInt();
            System.out.println("y:");
            y = scan.nextInt();
            if (x > 0 && x < 8 && y > 0 && y < 8) break;
            else System.out.println("wrong coords, please try again");
        }
        System.out.println();

        char[][] arr = new char[8][8];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = 'O';
        arr[x][y] = 'X';
        Point current = new Point(x, y);
        printBoard(arr, current, "Start position is: ");
        while (true){
            int count = 10;
            int movesCount = 0;
            for (int i = 0; i < moves.length; i++) {
                if(current.check(moves[i], arr)){
                    int c = countMoves(current.sum(moves[i]), arr);
                    if(c < count){
                        count = c;
                        movesCount = i;
                    }
                }
            }

            current = current.sum(moves[movesCount]);
            arr[current.x][current.y] = 'X';
            printBoard(arr, current, "Moved to: ");
            if(count == 0)
                break;
        }
    }

    public static int countMoves(Point p, char[][] arr){
        int result = 0;
        if(p.x + 2 < 8 && p.y - 1 >= 0 && arr[p.x + 2][p.y - 1] == 'O')
            result += 1;
        if(p.x - 2 >= 0 && p.y + 1 < 8 && arr[p.x - 2][p.y + 1] == 'O')
            result += 1;
        if(p.x + 1 < 8 && p.y - 2 >= 0 && arr[p.x + 1][p.y - 2] == 'O')
            result += 1;
        if(p.x - 1 >= 0 && p.y - 2 >= 0 && arr[p.x - 1][p.y - 2] == 'O')
            result += 1;
        if(p.x + 2 < 8 && p.y + 1 < 8 && arr[p.x + 2][p.y + 1] == 'O')
            result += 1;
        if(p.x - 2 >= 0 && p.y - 1 >= 0 && arr[p.x - 2][p.y - 1] == 'O')
            result += 1;
        if(p.x + 1 < 8 && p.y + 2 < 8 && arr[p.x + 1][p.y + 2] == 'O')
            result += 1;
        if(p.x - 1 >= 0 && p.y + 2 < 8 && arr[p.x - 1][p.y + 2] == 'O')
            result += 1;
        return result;
    }

    public static void printBoard(char[][] arr, Point p, String moveStatus){
        for (int i = 0; i < arr.length; i++ ){
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + "  ");
            System.out.println();
        }
        System.out.println(moveStatus + p.x + ":" + p.y + "\n");
    }

    public static class Point {
        final int x;
        final int y;

        public Point(int frst, int scnd) {
            x = frst;
            y = scnd;
        }

        public Point sum(Point p) {
            return new Point(p.x + x, p.y + y);
        }

        public boolean check(Point p, char[][] arr) {
            return x + p.x >= 0 && x + p.x < 8 && y + p.y >= 0 && y + p.y < 8 &&
                    arr[x + p.x][y + p.y] == 'O';
        }
    }

}

