//package Dynamic_Programming;
//import java.util.*;
//public class Unique_Paths_II {
//    public static int UniquePathsII(int i, int j,int[][] grid) {
//        //        //// Recursive way....
//        if(i >= 0 && j >= 0 && grid[i][j] == 1){
//            return 0;
//        }
//        if (i == 0 && j == 0) {
//            return 1;
//        }
//        if (i < 0 || j < 0) {
//            return 0;
//        }
//        int up = UniquePathsII(i - 1, j,grid);
//        int left = UniquePathsII(i, j - 1,grid);
//
//        return up + left;
//    }
//
//    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
//        int m = grid.length;
//        int n = grid[0].length;
//        System.out.println(UniquePathsII(m - 1, n - 1,grid));
//    }
//}


















//package Dynamic_Programming;
//import java.util.*;
//public class Unique_Paths_II {
//    public static int uniquePathsII(int i, int j, int[][] grid, int[][] dp) {
//        //// Memoization way....
//        if (i < 0 || j < 0 || grid[i][j] == -1)
//            return 0;
//
//        if (i == 0 && j == 0)
//            return 1;
//
//        if (dp[i][j] != -1)
//            return dp[i][j];
//
//        int up = uniquePathsII(i - 1, j, grid, dp);
//        int left = uniquePathsII(i, j - 1, grid, dp);
//
//        return dp[i][j] = up + left;
//    }
//
//    public static void main(String[] args) {
//
//        int[][] grid = {
//                {0, 0, 0},
//                {0, -1, 0},
//                {0, 0, 0}
//        };
//
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[][] dp = new int[m][n];
//        for (int[] row : dp)
//            Arrays.fill(row, -1);
//
//        System.out.println(uniquePathsII(m - 1, n - 1, grid, dp));
//    }
//}












package Dynamic_Programming;
import java.util.*;
public class Unique_Paths_II {
    public static int uniquePathsII(int[][] grid) {
//        int mod = (int)(1e9 + 7);
        //// Tabulation way....
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        if (grid[0][0] == -1)
            return 0;

        dp[0][0] = 1; // Base condition....

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                int up = 0, left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsII(grid));
    }
}

