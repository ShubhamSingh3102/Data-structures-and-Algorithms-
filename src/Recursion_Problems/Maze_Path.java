package Recursion_Problems;
import java.util.*;
public class Maze_Path {
    public static int maze(int cr, int cc, int er, int ec) {

        int rightWays = 0;
        int downWays = 0;

        if (cr> er || cc > ec){
            return 0;
        }
        if (cr == er && cc == ec) {
            return 1; // reached destination
        }

        if (cr == er) { // only move right
            rightWays += maze(cr, cc + 1, er, ec);
        }

        if (cc == ec) { // only move down
            downWays += maze(cr + 1, cc, er, ec);
        }

        if (cr < er && cc < ec) { // both moves possible
            rightWays += maze(cr, cc + 1, er, ec);
            downWays += maze(cr + 1, cc, er, ec);
        }

        int totalWays = rightWays + downWays;
        return totalWays;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no of rows of the maze: ");
        int n = sc.nextInt();

        System.out.print("Enter no of columns of the maze: ");
        int m = sc.nextInt();

        int noOfWays = maze(1, 1, n, m);
        System.out.println("Total ways = " + noOfWays);

        sc.close();
    }
}
