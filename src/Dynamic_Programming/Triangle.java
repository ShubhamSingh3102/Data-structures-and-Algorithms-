//package Dynamic_Programming;
//import java.util.*;
//public class Triangle {
//    public static int minPathSum(int i,int j,int[][] grid){
       //// Recursive way....
//        int n = grid.length;
//        int m = grid[0].length;
//
//        // Base case...
//        if(i == n-1){
//            return grid[n-1][j];
//        }
//        int down = grid[i][j] + minPathSum(i+1,j,grid);
//        int diagonal = grid[i][j] + minPathSum(i+1,j+1,grid);
//
//        return Math.min(down,diagonal);
//    }
//    public static void main(String[] args) {
//        int[][] triangle = {
//                {2},
//                {3,4},
//                {6,5,7},
//                {4,1,8,3}
//        };
//        System.out.println(minPathSum(0,0,triangle));
//    }
//}












//package Dynamic_Programming;
//import java.util.*;
//public class Triangle {
//    public static int minPathSum(int i,int j,int[][] grid,int[][] dp){
        //// Memoization way....
//        int n = grid.length;
//
//        // Base case...
//        if(i == n-1){
//            return grid[n-1][j];
//        }
//
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//
//        int down = grid[i][j] + minPathSum(i+1,j,grid,dp);
//        int diagonal = grid[i][j] + minPathSum(i+1,j+1,grid,dp);
//
//        return dp[i][j] = Math.min(down,diagonal);
//    }
//    public static void main(String[] args) {
//        int[][] triangle = {
//                {2},
//                {3,4},
//                {6,5,7},
//                {4,1,8,3}
//        };
//        int n = triangle.length;
//
//        int[][] dp = new int[n][n];
//
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        System.out.println(minPathSum(0,0,triangle,dp));
//    }
//}












//package Dynamic_Programming;
//import java.util.*;
//public class Triangle {
//    public static int minPathSum(int[][] grid){
        //// Tabulation way....
//        int n = grid.length;
//
//        int[][] dp = new int[n][n];
//
//        for(int j=0;j<n;j++){
//            dp[n-1][j] = grid[n-1][j];
//        }
//
//        for(int i = n-2;i >= 0;i--){
//            for(int j = i;j >= 0;j--){
//                int down = grid[i][j] + dp[i+1][j];
//                int diagonal = grid[i][j] + dp[i+1][j+1];
//
//                dp[i][j] = Math.min(down,diagonal);
//            }
//        }
//        return dp[0][0];
//    }
//    public static void main(String[] args) {
//        int[][] triangle = {
//                {2},
//                {3,4},
//                {6,5,7},
//                {4,1,8,3}
//        };
//        System.out.println(minPathSum(triangle));
//    }
//}

















package Dynamic_Programming;
import java.util.*;
public class Triangle {
    public static int minPathSum(int[][] triangle){
        //// Space Optimization
        int n = triangle.length;
        int[] front = new int[n];
        int[] cur = new int[n];

        // base case: last row
        for (int j = 0; j < n; j++)
            front[j] = triangle[n - 1][j];

        // bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];
                cur[j] = Math.min(down, diagonal);
            }
            front = cur.clone(); // move current row up
        }
        return front[0];
    }
    public static void main(String[] args) {
        int[][] triangle = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        System.out.println(minPathSum(triangle));
    }
}
