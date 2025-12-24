package Backtracking;
import java.util.*;
public class Rat_Maze_Optimised_4_direction {
    public static void printMaze(int cr,int cc,int er,int ec,String s,int[][] maze){
        if(cr < 0 || cc < 0 ){
            return;
        }
        if (cr> er || cc > ec){
            return;
        }
        if (cr == er && cc == ec) {
            System.out.println(s);
            return;
        }

        if(maze[cr][cc] == 0){ // blocked...
            return;
        }
        if(maze[cr][cc] == -1){ // this was already visited....
            return;
        }
        maze[cr][cc] = -1;
        // go down
        printMaze(cr+1,cc,er,ec,s+"D",maze);
        // go right
        printMaze(cr,cc+1,er,ec,s+"R",maze);
        // go left
        printMaze(cr,cc-1,er,ec,s+"L",maze);
        // go up
        printMaze(cr-1,cc,er,ec,s+"U",maze);

        // backtracking
        maze[cr][cc] = 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of rows of the maze: ");
        int n = sc.nextInt();
        System.out.print("Enter no of columns of the maze: ");
        int m = sc.nextInt();
        int[][] maze = {{1,0,1,1},
                        {1,1,1,1},
                        {1,1,0,1}};
        printMaze(0, 0, n-1, m-1,"",maze); // 0 based indexing...
    }
}
