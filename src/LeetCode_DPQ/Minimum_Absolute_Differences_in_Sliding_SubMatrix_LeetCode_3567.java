package LeetCode_DPQ;
import java.util.*;
public class Minimum_Absolute_Differences_in_Sliding_SubMatrix_LeetCode_3567 {
    public static int[][]  minAbsDiff(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m-k+1][n-k+1];

        for(int i = 0; i <= m-k; i++){
            for(int j = 0; j <= n-k; j++){

                // TreeSet for sorted + distinct elements
                TreeSet<Integer> vals = new TreeSet<>();

                for(int r = i; r <= i+k-1; r++){
                    for(int c = j; c <= j+k-1; c++){
                        vals.add(grid[r][c]);
                    }
                }
                if (vals.size() == 1){ // if all elements are same...
                    result[i][j] = 0;
                    continue;
                }
                int minAbsDiff = Integer.MAX_VALUE;

                Integer prev = null;
                for(int val: vals){
                    if(prev != null){
                        minAbsDiff = Math.min(minAbsDiff, val - prev);
                    }
                    prev = val;
                }
                result[i][j] = minAbsDiff;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1,-2,3},
                {2,3,5},
        };
        int k = 2;
        System.out.println(Arrays.deepToString(minAbsDiff(grid, k)));
    }
}
