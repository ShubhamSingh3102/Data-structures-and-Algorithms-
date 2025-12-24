//package Dynamic_Programming;
//import java.util.*;
//public class Climbing_Stairs {
//// Recursive way.....
//    public static int climbStairs(int n){
//        if(n == 0){
//            return 1;
//        }
//        if(n == 1){
//            return 1;
//        }
//        int left = climbStairs(n-1);
//        int right = climbStairs(n-2);
//        return left + right;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the value of n : ");
//        int n = sc.nextInt();
//        System.out.println(climbStairs(n));
//    }
//}

















//
//package Dynamic_Programming;
//import java.util.*;
//public class Climbing_Stairs {
//// Memoization way
//    public static int climbStairs(int n,int[] dp){
//        if(n == 0){
//            return 1;
//        }
//        if(n == 1){
//            return 1;
//        }
//        if (dp[n] != -1) {
//            return dp[n];
//        }
//
//        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
//        return dp[n];
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the value of n : ");
//        int n = sc.nextInt();
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        System.out.println(climbStairs(n, dp));
//    }
//}














//package Dynamic_Programming;
//import java.util.*;
//public class Climbing_Stairs {
//// Tabulation way
//    public static int climbStairs(int n){
//        if(n == 0){
//            return 1;
//        }
//        if(n == 1){
//            return 1;
//        }
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++){
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the value of n : ");
//        int n = sc.nextInt();
//        System.out.println(climbStairs(n));
//    }
//}
























package Dynamic_Programming;
import java.util.*;
public class Climbing_Stairs {
    //// Optimised way
    public static int climbStairs(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int prev2 = 1, prev = 1;
        for(int i = 2; i <= n; i++){
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        System.out.println(climbStairs(n));
    }
}
