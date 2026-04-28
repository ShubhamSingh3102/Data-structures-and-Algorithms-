package LeetCode_DPQ;
import java.util.*;
public class Flip_Square_SubMatrix_Vertically_LeetCode_3643 {
    public static int[][] reverseSubMatrix(int[][] grid, int x, int y, int k){
        int startRow = x;
        int endRow = x+k-1;

        int startCol = y;
        int endCol = y+k-1;

        while(startRow < endRow){
            for(int j = startCol; j <= endCol; j++){
                int temp = grid[startRow][j];
                grid[startRow][j] = grid[endRow][j];
                grid[endRow][j] = temp;
            }
            startRow++;
            endRow--;
        }
        return grid;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        int x = 1,y=0,k=3;
        System.out.println(Arrays.deepToString(reverseSubMatrix(grid, x, y, k)));
    }
}
