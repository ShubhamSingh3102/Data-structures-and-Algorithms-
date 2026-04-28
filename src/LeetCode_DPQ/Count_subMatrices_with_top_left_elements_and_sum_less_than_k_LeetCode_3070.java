package LeetCode_DPQ;
import java.util.*;
public class Count_subMatrices_with_top_left_elements_and_sum_less_than_k_LeetCode_3070 {
    public static int countSubMatrices(int[][] grid,int k){
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(i-1 >= 0){
                    grid[i][j] += grid[i-1][j];
                }
                if(j-1 >= 0) {
                    grid[i][j] += grid[i][j-1];
                }
                if(i-1 >= 0 && j-1 >= 0){
                    grid[i][j] -= grid[i-1][j-1];
                }

                if(grid[i][j] <= k){
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {7,2,9},
                {1,5,0},
                {2,6,6},
        };
        int k = 20;
        System.out.println(countSubMatrices(grid,k));
    }
}
