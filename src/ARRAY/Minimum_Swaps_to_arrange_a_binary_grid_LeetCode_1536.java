package ARRAY;
import java.util.*;
public class Minimum_Swaps_to_arrange_a_binary_grid_LeetCode_1536 {
    public static int minSwaps(int[][] grid){

        int n = grid.length;  // rows == columns

        int[] endZeroes = new int[n];

        // endZeros[i] = count of consecutive 0s from the end of ith row.....

        for(int i = 0; i < n; i++){
            int j = n - 1; // start from end....

            int count = 0;

            // counting no of zeroes from end....
            while(j >= 0 && grid[i][j] == 0){
                count++;
                j--;
            }

            endZeroes[i] = count;
        }

        int steps = 0;

        for(int i = 0; i < n; i++){
            int need = n - i - 1;

            int j = i;

            while(j < n && endZeroes[j] < need){
                j++;
            }

            if(j == n){
                return -1;
            }

            steps += (j-i);

            while(j > i){
                int temp = endZeroes[j];
                endZeroes[j] = endZeroes[j-1];
                endZeroes[j-1] = temp;
                j--;
            }
        }
        return steps;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1},
                {1,1,0},
                {1,0,0}
        };
        System.out.println(minSwaps(grid));
    }
}
