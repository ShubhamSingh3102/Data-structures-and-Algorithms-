package Backtracking;
import java.util.*;
public class Rat_in_a_dead_maze_3 {
    public static void printMaze(int cr,int cc,int er,int ec,String s,int[][] maze){
        if (cr> er || cc > ec){
            return;
        }
        if (cr == er && cc == ec) {
            System.out.println(s);
            return;
        }

        if(maze[cr][cc] == 0){
            return;
        }
        // go down
        printMaze(cr+1,cc,er,ec,s+"D",maze);
        // go right
        printMaze(cr,cc+1,er,ec,s+"R",maze);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of rows of the maze: ");
        int n = sc.nextInt();
        System.out.print("Enter no of columns of the maze: ");
        int m = sc.nextInt();
        int[][] maze = {{1,0,1,1,1,1},
                        {1,1,1,1,0,1},
                        {0,1,1,1,1,1},
                        {0,0,1,0,1,1}};
        printMaze(0, 0, n-1, m-1,"",maze);
    }
}