//package Dynamic_Programming;
//import java.util.*;
//public class Cherry_PickUp_II {
//    public static int cherryPickup(int i,int j1,int j2,int[][] grid){
//        //// Recursive way.....
//        int n = grid.length;
//        int m = grid[0].length;
//
//        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
//            return (int)-1e9;
//        }
//        if(i == n-1){
//            if(j1 == j2){
//                return grid[i][j1];
//            }
//            else{
//                return grid[i][j1] + grid[i][j2];
//            }
//        }
//        int maxi = (int) -1e9;
//
//        for (int dj1 = -1; dj1 <= 1; dj1++) {
//            for (int dj2 = -1; dj2 <= 1; dj2++) {
//
//                if (j1 == j2)
//                    maxi = Math.max(maxi, grid[i][j1] + cherryPickup(i + 1, j1 + dj1, j2 + dj2, grid)
//                    );
//                else
//                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + cherryPickup(i + 1, j1 + dj1, j2 + dj2, grid)
//                    );
//            }
//        }
//        return maxi;
//    }
//    public static void main(String[] args) {
//        int[][] grid = {
//                {3,1,1},
//                {2,5,1},
//                {1,5,5},
//                {2,1,1}
//        };
//        int n = grid.length;
//        int m = grid[0].length;
//        System.out.println(cherryPickup(0,0,m-1,grid));
//    }
//}


















//package Dynamic_Programming;
//import java.util.*;
//public class Cherry_PickUp_II {
//    public static int cherryPickup(int i,int j1,int j2,int[][] grid,int[][][] dp){
//        //// Memoization way.....
//        int n = grid.length;
//        int m = grid[0].length;
//
//        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
//            return (int)-1e9;
//        }
//        if(i == n-1){
//            if(j1 == j2){
//                return grid[i][j1];
//            }
//            else{
//                return grid[i][j1] + grid[i][j2];
//            }
//        }
//
//        if (dp[i][j1][j2] != -1) {
//            return dp[i][j1][j2];
//        }
//
//        int maxi = (int) -1e9;
//
//        for (int dj1 = -1; dj1 <= 1; dj1++) {
//            for (int dj2 = -1; dj2 <= 1; dj2++) {
//
//                if (j1 == j2)
//                    maxi = Math.max(maxi, grid[i][j1] + cherryPickup(i + 1, j1 + dj1, j2 + dj2, grid,dp));
//                else
//                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + cherryPickup(i + 1, j1 + dj1, j2 + dj2, grid,dp));
//            }
//        }
//        return dp[i][j1][j2] = maxi;
//    }
//    public static void main(String[] args) {
//        int[][] grid = {
//                {3,1,1},
//                {2,5,1},
//                {1,5,5},
//                {2,1,1}
//        };
//        int n = grid.length;
//        int m = grid[0].length;
//
//        int[][][] dp = new int[n][m][m];
//
//        for (int i = 0; i < n; i++) {
//            for (int j1 = 0; j1 < m; j1++) {
//                for (int j2 = 0; j2 < m; j2++) {
//                    dp[i][j1][j2] = -1;
//                }
//            }
//        }
//
//        System.out.println(cherryPickup(0,0,m-1,grid,dp));
//    }
//}

























//package Dynamic_Programming;
//import java.util.*;
//public class Cherry_PickUp_II {
//    public static int cherryPickup(int[][] grid){
//        //// Memoization way.....
//        int n = grid.length;
//        int m = grid[0].length;
//
//        int[][][] dp = new int[n][m][m];
//
//        // Base case....
//        for(int j1 = 0; j1 < m; j1++){
//            for(int j2 = 0; j2 < m; j2++){
//                if(j1==j2){
//                    dp[n-1][j1][j2] = grid[n-1][j1];
//                }
//                else{
//                    dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
//                }
//            }
//        }
//
//        // Fill DP from bottom to top
//        for (int i = n - 2; i >= 0; i--) {
//            for (int j1 = 0; j1 < m; j1++) {
//                for (int j2 = 0; j2 < m; j2++) {
//
//                    int maxi = (int) -1e9;
//
//                    for (int dj1 = -1; dj1 <= 1; dj1++) {
//                        for (int dj2 = -1; dj2 <= 1; dj2++) {
//
//                            int nj1 = j1 + dj1;
//                            int nj2 = j2 + dj2;
//
//                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
//                                if (j1 == j2)
//                                    maxi = Math.max(maxi,grid[i][j1] + dp[i + 1][nj1][nj2]);
//                                else
//                                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + dp[i + 1][nj1][nj2]);
//                            }
//                        }
//                    }
//                    dp[i][j1][j2] = maxi;
//                }
//            }
//        }
//        return dp[0][0][m - 1];
//    }
//    public static void main(String[] args) {
//        int[][] grid = {
//                {3,1,1},
//                {2,5,1},
//                {1,5,5},
//                {2,1,1}
//        };
//        System.out.println(cherryPickup(grid));
//    }
//}





















package Dynamic_Programming;
import java.util.*;
public class Cherry_PickUp_II {
    public static int cherryPickup(int[][] grid){
        //// Space way.....
        int n = grid.length;
        int m = grid[0].length;

        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        // Base case: last row
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Build from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            cur = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = (int) -1e9;

                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {

                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                if (j1 == j2)
                                    maxi = Math.max(maxi,grid[i][j1] + front[nj1][nj2]);
                                else
                                    maxi = Math.max(maxi,grid[i][j1] + grid[i][j2] + front[nj1][nj2]);
                            }
                        }
                    }
                    cur[j1][j2] = maxi;
                }
            }
            front = cur;
        }
        // start positions
        return front[0][m - 1];
    }
    public static void main(String[] args) {
        int[][] grid = {
                {3,1,1},
                {2,5,1},
                {1,5,5},
                {2,1,1}
        };
        System.out.println(cherryPickup(grid));
    }
}



