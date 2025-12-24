package Backtracking;
import java.util.*;
public class Check_Knight_Tour_Configuration {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0){
            return false;
        }
        return helper(grid,0,0,0);
    }
    public static boolean helper(int[][] grid,int row,int col,int number){
        int n = grid.length;

        // base case
        if(grid[row][col] == (n*n-1)){
            return true;
        }
        int i,j;
        // 2 Up 1 right
        i = row - 2;
        j = col + 1;
        if(i>=0 && j<n && grid[i][j] == number + 1){
            return helper(grid,i,j,number + 1);
        }
        // 2 Up 1 left
        i = row - 2;
        j = col - 1;
        if(i>=0 && j>=0 && grid[i][j] == number + 1){
            return helper(grid,i,j,number + 1);
        }


        // 2 Down 1 right
        i = row + 2;
        j = col + 1;
        if(i<n && j<n && grid[i][j] == number + 1){
            return helper(grid,i,j,number + 1);
        }
        // 2 Down 1 left
        i = row + 2;
        j = col - 1;
        if(i<n && j>=0 && grid[i][j] == number + 1){
            return helper(grid,i,j,number + 1);
        }


        // 2 Right 1 up
        i = row - 1;
        j = col + 2;
        if(i>=0 && j<n && grid[i][j] == number + 1){
            return helper(grid,i,j,number + 1);
        }
        // 2 Right 1 Down
        i = row + 1;
        j = col + 2;
        if(i<n && j<n && grid[i][j] == number + 1){
            return helper(grid,i,j,number + 1);
        }


        // 2 Left 1 up
        i = row - 1;
        j = col - 2;
        if(i>=0 && j>=0 && grid[i][j] == number + 1){
            return helper(grid,i,j,number + 1);
        }
        // 2 Left 1 Down
        i = row + 1;
        j = col - 2;
        if(i<n && j>=0 && grid[i][j] == number + 1){
            return helper(grid,i,j,number + 1);
        }
        return false;
    }
    public static void main(String[] args) {
        Check_Knight_Tour_Configuration obj = new Check_Knight_Tour_Configuration();
        // Sample 5×5 valid knight tour grid
        int[][] grid = {
                {0,  11,  16,  5, 20},
                {17,  4, 19, 10, 15},
                {12,  1,  8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2,  7,  22}
        };
        boolean result = obj.checkValidGrid(grid);
        System.out.println("Is Knight Tour Valid? " + result);
    }
}
