//package Dynamic_Programming;
//import java.util.*;
//public class Best_time_to_buy_and_sell_stocks_with_cooldown {
//// recursion way....
//    public static int maxProfit(int ind,int buy,int[] prices){
//        int n = prices.length;
//        if(ind >= n){
//            return 0;
//        }
//        int profit;
//        if(buy == 1){
//            int take = -prices[ind] + maxProfit(ind+1,0,prices);
////            int notTake = 0 +  maxProfit(ind+1,1,prices);
//            int notTake = maxProfit(ind+1,1,prices);
//            profit =  Math.max(take,notTake);
//        }else{ // sell
//            int take = +prices[ind] + maxProfit(ind+2,1,prices);
//            int notTake = maxProfit(ind+1,0,prices);
//            profit =  Math.max(take,notTake);
//        }
//        return profit;
//    }
//    public static void main(String[] args) {
//        int[] prices = {1,2,3,0,2};
//        System.out.println(maxProfit(0,1,prices));
//    }
//}
//
//
//
//
//
//
















package Dynamic_Programming;
import java.util.*;
public class Best_time_to_buy_and_sell_stocks_with_cooldown {
        public static int maxProfit(int[] prices) {
        int n = prices.length;

        // dp[ind][buy]
        int[][] dp = new int[n + 2][2];

        // base case already 0
        dp[n][0] = dp[n][1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {

                if (buy == 1) {
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                } else {
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}






