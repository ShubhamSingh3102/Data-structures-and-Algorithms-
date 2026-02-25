//package Dynamic_Programming;
//import java.util.*;
//public class Best_time_to_buy_and_sell_stock_II {
//
//    //// recursion....
//    public static int maxProfit(int ind,int buy,int[] prices){
//        int n = prices.length;
//        if(ind == n){
//            return 0;
//        }
//        int profit;
//        if(buy == 1){
//            int take = -prices[ind] + maxProfit(ind+1,0,prices);
////            int notTake = 0 +  maxProfit(ind+1,1,prices);
//            int notTake = maxProfit(ind+1,1,prices);
//            profit =  Math.max(take,notTake);
//        }else{ // sell
//            int take = +prices[ind] + maxProfit(ind+1,1,prices);
//            int notTake = maxProfit(ind+1,0,prices);
//            profit =  Math.max(take,notTake);
//        }
//        return profit;
//    }
//    public static void main(String[] args) {
//       int[] prices = {7,1,5,3,6,4};
//        System.out.println(maxProfit(0,1,prices));
//    }
//}































//package Dynamic_Programming;
//import java.util.*;
//public class Best_time_to_buy_and_sell_stock_II {
//
//    //// memoization way....
//    public static int maxProfit(int ind,int buy,int[] prices,int[][] dp){
//        int n = prices.length;
//        if(ind == n){
//            return 0;
//        }
//
//        if (dp[ind][buy] != -1){
//            return dp[ind][buy];
//        }
//
//        int profit;
//        if(buy == 1){
//            int take = -prices[ind] + maxProfit(ind+1,0,prices,dp);
////            int notTake = 0 +  maxProfit(ind+1,1,prices);
//            int notTake = maxProfit(ind+1,1,prices,dp);
//            profit =  Math.max(take,notTake);
//        }else{ // sell
//            int take = +prices[ind] + maxProfit(ind+1,1,prices,dp);
//            int notTake = maxProfit(ind+1,0,prices,dp);
//            profit =  Math.max(take,notTake);
//        }
//        return dp[ind][buy] = profit;
//    }
//    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
//        int n = prices.length;
//        int[][] dp = new int[n][2];
//        for (int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
//        System.out.println(maxProfit(0,1,prices,dp));
//    }
//}






















//package Dynamic_Programming;
//import java.util.*;
//public class Best_time_to_buy_and_sell_stock_II {
//
//    //// tabulation....
//    public static int maxProfit(int[] prices) {
//        int n = prices.length;
//
//        // dp[ind][buy]
//        int[][] dp = new int[n + 1][2];
//
//        // base case already 0
//        dp[n][0] = dp[n][1] = 0;
//
//        for (int ind = n - 1; ind >= 0; ind--) {
//            for (int buy = 0; buy <= 1; buy++) {
//
//                if (buy == 1) {
//                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
//                } else {
//                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 1][1], dp[ind + 1][0]);
//                }
//            }
//        }
//        return dp[0][1];
//    }
//    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
//        System.out.println(maxProfit(prices));
//    }
//}











package Dynamic_Programming;
import java.util.*;

public class Best_time_to_buy_and_sell_stock_II {

    // space optimized (prev & curr)
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[] prev = new int[2]; // ahead
        int[] curr = new int[2]; // current

        for (int ind = n - 1; ind >= 0; ind--) {

            // buy = 1
            curr[1] = Math.max(-prices[ind] + prev[0],
                    prev[1]);

            // buy = 0
            curr[0] = Math.max(prices[ind] + prev[1],
                    prev[0]);

            // shift
            prev = curr.clone();
        }

        return prev[1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}