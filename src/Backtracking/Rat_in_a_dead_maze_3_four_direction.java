package Backtracking;
import java.util.*;
public class Rat_in_a_dead_maze_3_four_direction {
    public static void printMaze(int cr,int cc,int er,int ec,String s,int[][] maze,boolean[][] isVisited){
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

        if(maze[cr][cc] == 0){
            return;
        }
        if(isVisited[cr][cc] == true){ // aap yaha pe phele se aa chuke ho...
            return;
        }
        isVisited[cr][cc] = true;
        // go down
        printMaze(cr+1,cc,er,ec,s+"D",maze,isVisited);
        // go right
        printMaze(cr,cc+1,er,ec,s+"R",maze,isVisited);
        // go left
        printMaze(cr,cc-1,er,ec,s+"L",maze,isVisited);
        // go up
        printMaze(cr-1,cc,er,ec,s+"U",maze,isVisited);

        // backtracking
        isVisited[cr][cc] = false;
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
        // creating extra 2D array for flag checking.....
        boolean[][] isVisited = new boolean[n][m]; // by default --> false....
        printMaze(0, 0, n-1, m-1,"",maze,isVisited); // 0 based indexing...
    }
}
