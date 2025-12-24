package Backtracking;
import java.util.*;
public class Print_maze_path_1 {
    public static void printMaze(int cr,int cc,int er,int ec,String s){
        if (cr> er || cc > ec){
            return;
        }
        if (cr == er && cc == ec) {
            System.out.println(s);
            return;
        }
        // go down
        printMaze(cr+1,cc,er,ec,s+"D");
        // go right
        printMaze(cr,cc+1,er,ec,s+"R");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of rows of the maze: ");
        int n = sc.nextInt();
        System.out.print("Enter no of columns of the maze: ");
        int m = sc.nextInt();
        printMaze(1, 1, n, m,"");
    }
}
