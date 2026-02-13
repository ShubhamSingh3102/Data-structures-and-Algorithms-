//package Dynamic_Programming;
//import java.util.*;
//public class Unique_Paths {
//    public static int uniquePaths(int i,int j){
//        //// Recursive way....
//        if(i == 0 && j == 0){
//            return 1;
//        }
//        if(i < 0 || j < 0){
//            return 0;
//        }
//        int up = uniquePaths(i-1,j);
//        int left = uniquePaths(i,j-1);
//        return up + left;
//    }
//    public static void main(String[] args) {
//        int m = 3, n = 7;
//        System.out.println(uniquePaths(m - 1, n - 1));
//    }
//}











//package Dynamic_Programming;
//import java.util.*;
//public class Unique_Paths {
//    public static int uniquePaths(int i,int j,int[][] dp){
//        //// Memoization way....
//        if(i == 0 && j == 0){
//            return 1;
//        }
//        if(i < 0 || j < 0){
//            return 0;
//        }
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//        int up = uniquePaths(i-1,j,dp);
//        int left = uniquePaths(i,j-1,dp);
//        dp[i][j] = up + left;
//        return dp[i][j];
//    }
//    public static void main(String[] args) {
//        int m = 3, n = 7;
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(uniquePaths(m - 1, n - 1,dp));
//    }
//}




















//package Dynamic_Programming;
//import java.util.*;
//public class Unique_Paths {
//    public static int uniquePaths(int m,int n,int[][] dp){
//        //// Tabulation way....Time: O(m × n)
//        ///
//        /// Space: O(m × n)
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(i == 0 && j == 0){
//                    dp[i][j] = 1;
//                }
//                else{
//                    int up = 0, left = 0;
//                    if (i > 0) {
//                        up = dp[i - 1][j];
//                    }
//                    if (j > 0) {
//                        left = dp[i][j - 1];
//                    }
//                    dp[i][j] = up + left;
//                }
//            }
//        }
//        return dp[m-1][n-1];
//    }
//    public static void main(String[] args) {
//        int m = 3, n = 7;
//        int[][] dp = new int[m][n];
//        System.out.println(uniquePaths(m,n,dp));
//    }
//}
















package Dynamic_Programming;
import java.util.*;
public class Unique_Paths {
    public static int uniquePaths(int m, int n) {
        //// Space Optimization.....Time: O(m × n)
        ///
        /// Space: O(n)
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] cur = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = 1;
                } else {
                    int up = 0, left = 0;

                    if (i > 0) {
                        up = prev[j];
                    }
                    if (j > 0) {
                        left = cur[j - 1];
                    }
                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[n - 1];
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
