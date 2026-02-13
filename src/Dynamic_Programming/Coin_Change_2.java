//package Dynamic_Programming;
//import java.util.*;
//public class Coin_Change_2 {
//    public static int coinChange2(int[] coins,int target){
//        int n = coins.length;
//
//        int[] prev = new int[target+1];
//        int[] curr = new int[target+1];
//
//        for(int t =0; t <= target; t++){
//            if(t % coins[0] == 0){
//                prev[t] = 1; // take
//            }
//            else{
//                prev[t] = 0; // not take...
//            }
//        }
//        for(int index = 1;index <= n-1;index++){
//            for(int t = 0; t <= target; t++){
//                int notTake = prev[t];
//                int take = 0;
//                if(coins[index] <= t){
//                    take = curr[t - coins[index]];
//                }
//                curr[t] = take + notTake;
//            }
//            prev = curr.clone();
//        }
//        return prev[target];
//    }
//    public static void main(String[] args) {
//        int[] coins = {1,2,3};
//        int target = 4;
//        System.out.println(coinChange2(coins,target));
//    }
//}






















//
//package Dynamic_Programming;
//import java.util.*;
//public class Coin_Change_2 {
//    //// Memoization....
//    public static int coinChange2(int[] coins, int index, int target, int[][] dp) {
//        if (target == 0) {
//            return 1;
//        }
//        if (index == 0) {
//            if (target % coins[index] == 0) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//        if (dp[index][target] != -1) {
//            return dp[index][target];
//        }
//        int notTake = coinChange2(coins, index - 1, target, dp);
//        int take = 0;
//        if (coins[index] <= target) {
//            take = coinChange2(coins, index, target - coins[index], dp);
//        }
//        return dp[index][target] = notTake + take;
//    }
//    public static void main(String[] args) {
//        int[] coins = {1,2,3};
//        int target = 4;
//        int n = coins.length;
//        int[][] dp = new int[n][target+1];
//        for(int[] rows: dp){
//            Arrays.fill(rows,-1);
//        }
//        System.out.println(coinChange2(coins,n-1,target,dp));
//    }
//}
//
























package Dynamic_Programming;
import java.util.*;
public class Coin_Change_2 {
    //// Tabultion....
    public static int coinChange2(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target + 1];

        // Base case: target 0 → 1 way (pick nothing)
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // Base case: using only coin[0]
        for (int t = 0; t <= target; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = 1;
            }
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {

                int notTake = dp[i - 1][t];
                int take = 0;

                if (coins[i] <= t) {
                    take = dp[i][t - coins[i]]; // unbounded
                }

                dp[i][t] = notTake + take;
            }
        }

        return dp[n - 1][target];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 4;
        System.out.println(coinChange2(coins,target));
    }
}
























