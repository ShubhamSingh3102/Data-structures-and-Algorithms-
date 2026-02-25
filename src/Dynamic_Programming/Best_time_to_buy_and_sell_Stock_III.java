//package Dynamic_Programming;
//import java.util.*;
//public class Best_time_to_buy_and_sell_Stock_III {
//    public static int maxProfit(int ind,int buy,int[] prices,int cap){
//// Recursion.....
//        int n = prices.length;
//        if(ind == n){
//            return 0;
//        }
//        if(cap == 0){
//            return 0;
//        }
//        int profit;
//        if(buy == 1){
//            int take = -prices[ind] + maxProfit(ind+1,0,prices,cap);
////            int notTake = 0 +  maxProfit(ind+1,1,prices);
//            int notTake = maxProfit(ind+1,1,prices,cap);
//            profit =  Math.max(take,notTake);
//        }else{ // sell
//            int take = +prices[ind] + maxProfit(ind+1,1,prices,cap-1);
//            int notTake = maxProfit(ind+1,0,prices,cap);
//            profit =  Math.max(take,notTake);
//        }
//        return profit;
//    }
//    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
//        System.out.println(maxProfit(0,1,prices,2));
//    }
//}




















//package Dynamic_Programming;
//import java.util.*;
//public class Best_time_to_buy_and_sell_Stock_III {
//// Memoization.......
//    public static int maxProfit(int ind,int buy,int[] prices,int cap, int[][][] dp){
//        int n = prices.length;
//        if(ind == n){
//            return 0;
//        }
//        if(cap == 0){
//            return 0;
//        }
//        if (dp[ind][buy][cap] != -1) {
//            return dp[ind][buy][cap];
//        }
//        int profit;
//        if(buy == 1){
//            int take = -prices[ind] + maxProfit(ind+1,0,prices,cap,dp);
////            int notTake = 0 +  maxProfit(ind+1,1,prices);
//            int notTake = maxProfit(ind+1,1,prices,cap,dp);
//            profit =  Math.max(take,notTake);
//        }else{ // sell
//            int take = +prices[ind] + maxProfit(ind+1,1,prices,cap-1,dp);
//            int notTake = maxProfit(ind+1,0,prices,cap,dp);
//            profit =  Math.max(take,notTake);
//        }
//        return dp[ind][buy][cap] = profit;
//    }
//    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
//        int n = prices.length;
//        int[][][] dp = new int[n][2][3];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//        System.out.println(maxProfit(0,1,prices,2,dp));
//    }
//}



















//package Dynamic_Programming;
//import java.util.*;
//public class Best_time_to_buy_and_sell_Stock_III {
//// Tabulation.....
//    public static int maxProfit(int[] prices){
//        int n = prices.length;
//
//        int[][][] dp = new int[n+1][2][3];
//
//        // cap == 0
//        for(int ind = 0; ind < n; ind++ ){
//            for(int buy = 0 ; buy <= 1; buy++){
//                dp[ind][buy][0] = 0;
//            }
//        }
//
//        // ind == n
//        for(int buy = 0 ; buy <= 1; buy++){
//            for(int cap = 0 ; cap <= 2; cap++){
//                dp[n][buy][cap] = 0;
//            }
//        }
//        int profit;
//
//        for(int ind = n-1 ; ind >= 0; ind--){
//            for(int buy = 0 ; buy <= 1; buy++){
//                for(int cap = 1; cap <= 2; cap++){
//                    if(buy == 1) {
//                        int take = -prices[ind] + dp[ind+1][0][cap];
//                        int notTake = dp[ind+1][1][cap];
//                        dp[ind][buy][cap] = Math.max(take, notTake);
//                    }else { // sell
//                        int take = +prices[ind] + dp[ind+1][1][cap-1];
//                        int notTake = dp[ind+1][0][cap];
//                        dp[ind][buy][cap]  = Math.max(take, notTake);
//                    }
//                }
//            }
//        }
//        return dp[0][1][2];
//    }
//    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
//        int n = prices.length;
//        System.out.println(maxProfit(prices));
//    }
//}























package Dynamic_Programming;
import java.util.*;
public class Best_time_to_buy_and_sell_Stock_III {
    //// Space Optimization....
    public static int maxProfit(int[] prices){
        int n = prices.length;

        // after and cur arrays (like screenshot)
        int[][] after = new int[2][3];
        int[][] cur = new int[2][3];


        int profit;

        for(int ind = n-1 ; ind >= 0; ind--){
            for(int buy = 0 ; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 1) {
                        int take = -prices[ind] + after[0][cap];
                        int notTake = after[1][cap];
                        cur[buy][cap] = Math.max(take, notTake);
                    }else { // sell
                        int take = +prices[ind] + after[1][cap-1];
                        int notTake = after[0][cap];
                        cur[buy][cap]  = Math.max(take, notTake);
                    }
                }
            }
            // move cur → after....
            for (int i = 0; i < 2; i++) {
                after[i] = cur[i].clone();
            }
        }
        return after[1][2];
    }
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}