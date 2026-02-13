//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Path_Sum {
//// Recursive way.....
//    public static int minimumPathSum(int i,int j,int[][] cost){
//        int m = cost.length;
//        int n = cost[0].length;
//
//        if(i == m-1 && j == n-1){
//            return cost[i][j];
//        }
//        if(i >= m || j >= n){
//            return Integer.MAX_VALUE;
//        }
//        int right = minimumPathSum(i,j+1,cost);
//        int down = minimumPathSum(i+1,j,cost);
//
//        return cost[i][j] + Math.min(right,down);
//    }
//    public static void main(String[] args) {
//        int[][] cost = {
//                {5, 9, 6},
//                {11, 5, 2},
//        };
//        System.out.println(minimumPathSum(0,0,cost));
//    }
//}













//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Path_Sum {
//    //// Memoization way....
//    public static int f(int i,int j,int[][] cost,int[][] dp){
//        int m = cost.length;
//        int n = cost[0].length;
//
//        if(i == m-1 && j == n-1){
//            return cost[i][j];
//        }
//        if(i >= m || j >= n){
//            return Integer.MAX_VALUE;
//        }
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//        int right = f(i,j+1,cost,dp);
//        int down = f(i+1,j,cost,dp);
//
//        return dp[i][j] = cost[i][j] + Math.min(right,down);
//    }
//    public static int minPathSum(int[][] cost){
//        int m = cost.length;
//        int n = cost[0].length;
//
//        int[][] dp = new int[m][n];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        return f(0,0,cost,dp);
//    }
//    public static void main(String[] args) {
//        int[][] cost = {
//                {5, 9, 6},
//                {11, 5, 2},
//        };
//        System.out.println(minPathSum(cost));
//    }
//}



















package Dynamic_Programming;
import java.util.*;
public class Minimum_Path_Sum {
    //// Tabulation way....
    public static int minPathSum(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0;i <m;i++){
            for(int j = 0;j <n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = cost[i][j];
                }
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if(i>0){
                        up = cost[i][j] + dp[i-1][j];
                    }
                    if(j>0){
                        left = cost[i][j] + dp[i][j-1];
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] cost = {
                {5, 9, 6},
                {11, 5, 2},
        };
        System.out.println(minPathSum(cost));
    }
}











//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Path_Sum {
//// Space Optimization....
//    public static int minPathSum(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//
//        int[] prev = new int[m];
//
//        for (int i = 0; i < n; i++) {
//            int[] curr = new int[m];
//
//            for (int j = 0; j < m; j++) {
//
//                if (i == 0 && j == 0) {
//                    curr[j] = grid[i][j];
//                } else {
//                    int up = Integer.MAX_VALUE;
//                    int left = Integer.MAX_VALUE;
//
//                    if (i > 0) up = grid[i][j] + prev[j];
//                    if (j > 0) left = grid[i][j] + curr[j - 1];
//
//                    curr[j] = Math.min(up, left);
//                }
//            }
//            prev = curr;
//        }
//
//        return prev[m - 1];
//    }
//
//    public static void main(String[] args) {
//        int[][] cost = {
//                {5, 9, 6},
//                {11, 5, 2}
//        };
//
//        System.out.println(minPathSum(cost));
//    }
//}


