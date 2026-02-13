//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Falling_Path_Sum {
//    public static int  minFallingPathSum(int i,int j,int[][] matrix){
//        //// Recursive way.....
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        if(j<0 || j>=m){
//            return (int)1e9;
//        }
//        if(i==0){
//            return matrix[0][j];
//        }
//        int st = matrix[i][j] + minFallingPathSum(i-1,j,matrix);
//        int ld = matrix[i][j] + minFallingPathSum(i-1,j-1,matrix);
//        int rd = matrix[i][j] + minFallingPathSum(i-1,j+1,matrix);
//
//        return Math.min(st,Math.min(ld,rd));
//    }
//    public static void main(String[] args) {
//        int[][] matrix = {
//                {2,1,3},
//                {6,5,4},
//                {7,8,9}
//        };
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int ans = Integer.MAX_VALUE;
//
//        // try all columns in last row
//        for (int j = 0; j < m; j++) {
//            ans = Math.min(ans, minFallingPathSum(n - 1, j, matrix));
//        }
//        System.out.println(ans);
//    }
//}












//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Falling_Path_Sum {
//    public static int  minFallingPathSum(int i,int j,int[][] matrix,int[][] dp){
//        //// Memoization way.....
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        if(j<0 || j>=m){
//            return (int)1e9;
//        }
//        if(i==0){
//            return matrix[0][j];
//        }
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//
//        int st = matrix[i][j] + minFallingPathSum(i-1,j,matrix,dp);
//        int ld = matrix[i][j] + minFallingPathSum(i-1,j-1,matrix,dp);
//        int rd = matrix[i][j] + minFallingPathSum(i-1,j+1,matrix,dp);
//
//        return dp[i][j] = Math.min(st,Math.min(ld,rd));
//    }
//    public static void main(String[] args) {
//        int[][] matrix = {
//                {2,1,3},
//                {6,5,4},
//                {7,8,9}
//        };
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int ans = Integer.MAX_VALUE;
//
//
//        int[][] dp = new int[n][m];
//
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//
//
//        // try all columns in last row
//        for (int j = 0; j < m; j++) {
//            ans = Math.min(ans, minFallingPathSum(n - 1, j, matrix,dp));
//        }
//        System.out.println(ans);
//    }
//}





















//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Falling_Path_Sum {
//    public static int  minFallingPathSum(int[][] matrix){
//        //// Tabulation way.....
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        int[][] dp = new int[n][m];
//
//        for(int j=0;j<m;j++){
//            dp[0][j] = matrix[0][j]; // Base Case
//        }
//        for(int i=1;i<n;i++){
//            for(int j=0;j<m;j++) {
//                int st = matrix[i][j] + dp[i - 1][j];
//                int ld = (int)1e9;
//                if (j - 1 >= 0) {
//                    ld = matrix[i][j] + dp[i - 1][j - 1];
//                }
//                int rd = (int)1e9;;
//                if (j + 1 < m) {
//                    rd = matrix[i][j] + dp[i - 1][j + 1];
//                }
//                dp[i][j] = Math.min(st, Math.min(ld, rd));
//            }
//        }
//        int maxi = dp[n-1][0];
//        for(int j=1;j<m;j++){
//            maxi = Math.min(maxi,dp[n-1][j]);
//        }
//        return maxi;
//    }
//    public static void main(String[] args) {
//        int[][] matrix = {
//                {2,1,3},
//                {6,5,4},
//                {7,8,9}
//        };
//        System.out.println(minFallingPathSum(matrix));
//    }
//}


















package Dynamic_Programming;
import java.util.*;
public class Minimum_Falling_Path_Sum {
    public static int  minFallingPathSum(int[][] matrix){
        //// Space Optimization way.....
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = new int[m];
        int[] curr = new int[m];

        for(int j=0;j<m;j++){
            prev[j] = matrix[0][j]; // Base Case
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++) {
                int st = matrix[i][j] + prev[j];
                int ld = (int)1e9;
                if (j - 1 >= 0) {
                    ld = matrix[i][j] + prev[j - 1];
                }
                int rd = (int)1e9;;
                if (j + 1 < m) {
                    rd = matrix[i][j] + prev[j + 1];
                }
                curr[j] = Math.min(st, Math.min(ld, rd));
            }
            prev = curr;
        }
        int ans = prev[0];
        for(int j=0;j<m;j++){
            ans = Math.min(ans,prev[j]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {2,1,3},
                {6,5,4},
                {7,8,9}
        };
        System.out.println(minFallingPathSum(matrix));
    }
}
