//package Dynamic_Programming;
//import java.util.*;
//public class Frog_Jump {
//    //// recursive way....
//    static int f(int ind, int[] heights) {
//        if (ind == 0) {
//            return 0;
//        }
//        int left = f(ind - 1, heights) + Math.abs(heights[ind] - heights[ind - 1]);
//        int right = Integer.MAX_VALUE;
//        if (ind > 1) {
//            right = f(ind - 2, heights)
//                    + Math.abs(heights[ind] - heights[ind - 2]);
//        }
//        return Math.min(left, right);
//    }
//
//    static int frogJump(int n, int[] heights) {
//        return f(n - 1, heights);
//    }
//
//    public static void main(String[] args) {
//        int[] heights = {10, 20, 30, 10};
//        int n = heights.length;
//
//        System.out.println(frogJump(n, heights));
//    }
//}





















//package Dynamic_Programming;
//import java.util.*;
//public class Frog_Jump {
//    //// memoization way....
//    static int f(int ind, int[] heights,int[] dp) {
//        if (ind == 0) {
//            return 0;
//        }
//        if(dp[ind] != -1){
//            return dp[ind];
//        }
//        int left = f(ind - 1, heights,dp) + Math.abs(heights[ind] - heights[ind - 1]);
//        int right = Integer.MAX_VALUE;
//        if (ind > 1) {
//            right = f(ind - 2, heights,dp)
//                    + Math.abs(heights[ind] - heights[ind - 2]);
//        }
//        return dp[ind] = Math.min(left, right);
//    }
//
//    static int frogJump(int n, int[] heights) {
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        return f(n - 1, heights,dp);
//    }
//
//    public static void main(String[] args) {
//        int[] heights = {10, 20, 30, 10};
//        int n = heights.length;
//
//        System.out.println(frogJump(n, heights));
//    }
//}

















//package Dynamic_Programming;
//import java.util.*;
//public class Frog_Jump {
//    //// tabulation way....
//    static int frogJump(int n, int[] heights) {
//        int[] dp = new int[n];
//        Arrays.fill(dp,0);
//        dp[0] = 0;
//        for(int i=1;i<n;i++){
//            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
//            int right = Integer.MAX_VALUE;
//            if (i > 1)
//                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
//            dp[i] = Math.min(left, right);
//        }
//        return dp[n-1];
//    }
//    public static void main(String[] args) {
//        int[] heights = {10, 20, 30, 10};
//        int n = heights.length;
//        System.out.println(frogJump(n, heights));
//    }
//}

















package Dynamic_Programming;
import java.util.*;
public class Frog_Jump {
    //// space optimization way....
    static int frogJump(int n, int[] heights) {
        int prev = 0;
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int left = prev + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curr = Math.min(left, right);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
        int n = heights.length;
        System.out.println(frogJump(n, heights));
    }
}