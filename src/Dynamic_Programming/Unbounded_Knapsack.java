//package Dynamic_Programming;
//import java.util.*;
//public class Unbounded_Knapsack {
//// Recursion....
//    public static int maximumProfit(int index,int[] wt,int w,int[] profit){
//        // Base case
//        if(index == 0){
//            if(wt[0] <= w){
//                // take....
//                return (w / wt[0]) * profit[0];
//            }else{
//                // not take....
//                return 0;
//            }
//        }
//        int notTake = maximumProfit(index-1,wt,w,profit);
//        int take = Integer.MIN_VALUE;
//        if(wt[index] <= w){
//            take = profit[index] + maximumProfit(index,wt,w-wt[index],profit);
//        }
//        return Math.max(notTake,take);
//    }
//    public static void main(String[] args) {
//        int[] wt = {2,4,6};
//        int[] profit = {5,11,13};
//        int bag_capacity = 10;
//        int n = wt.length;
//        System.out.println(maximumProfit(n-1,wt,bag_capacity,profit));
//    }
//}



















//package Dynamic_Programming;
//import java.util.*;
//public class Unbounded_Knapsack {
//// Memoization....
//    public static int maximumProfit(int index,int[] wt,int w,int[] profit,int[][] dp){
//        // Base case
//        if(index == 0){
//            if(wt[0] <= w){
//                // take....
//                return (w / wt[0]) * profit[0];
//            }else{
//                // not take....
//                return 0;
//            }
//        }
//        if(dp[index][w] != -1){
//            return dp[index][w];
//        }
//        int notTake = maximumProfit(index-1,wt,w,profit,dp);
//        int take = Integer.MIN_VALUE;
//        if(wt[index] <= w){
//            take = profit[index] + maximumProfit(index,wt,w-wt[index],profit,dp);
//        }
//        return dp[index][w] =  Math.max(notTake,take);
//    }
//    public static void main(String[] args) {
//        int[] wt = {2,4,6};
//        int[] profit = {5,11,13};
//        int bag_capacity = 10;
//        int n = wt.length;
//        int[][] dp = new int[n][bag_capacity+1];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        System.out.println(maximumProfit(n-1,wt,bag_capacity,profit,dp));
//    }
//}













//package Dynamic_Programming;
//import java.util.*;
//public class Unbounded_Knapsack {
//// Tabulation....
//public static int maximumProfit(int[] wt,int[] profit,int w){
//        // Base case.....
//        int n = wt.length;
//        int index = n - 1;
//        int[][] dp = new int[n][w+1];
//        // Base case....
//        for (int i = 0; i <= w; i++) {
//            // take it...
//            dp[0][i] = (i / wt[0]) * profit[0];
//        }
//        for(int i = 1;i < n;i++){
//            for(int w1 = 0;w1 <= w; w1++){ // current capacity...
//                int notTake = dp[i-1][w1];
//                int take = Integer.MIN_VALUE;
//                if(wt[i] <= w1){
//                    take = profit[i] + dp[i][w1-wt[i]];
//                }
//                dp[i][w1] = Math.max(notTake,take);
//            }
//        }
//        return dp[n-1][w];
//    }
//    public static void main(String[] args) {
//        int[] wt = {2,4,6};
//        int[] profit = {5,11,13};
//        int bag_capacity = 10;
//        System.out.println(maximumProfit(wt,profit,bag_capacity));
//    }
//}

















//package Dynamic_Programming;
//import java.util.*;
//public class Unbounded_Knapsack {
//    // Space optimization....
//    public static int maximumProfit(int[] wt,int[] profit,int w){
//        // Base case.....
//        int n = wt.length;
//        int index = n - 1;
//
//        int[] prev = new int[w+1];
//        int[] curr = new int[w+1];
//
//        // Base case....
//        for (int i = 0; i <= w; i++) {
//            // take it...
//            prev[i] = (i / wt[0]) * profit[0];
//        }
//        for(int i = 1;i < n;i++){
//            for(int w1 = 0;w1 <= w; w1++){ // current capacity...
//                int notTake = prev[w1];
//                int take = Integer.MIN_VALUE;
//                if(wt[i] <= w1){
//                    take = profit[i] + curr[w1-wt[i]];
//                }
//                curr[w1] = Math.max(notTake,take);
//            }
//            prev = curr.clone();
//        }
//        return prev[w];
//    }
//    public static void main(String[] args) {
//        int[] wt = {2,4,6};
//        int[] profit = {5,11,13};
//        int bag_capacity = 10;
//        System.out.println(maximumProfit(wt,profit,bag_capacity));
//    }
//}



















package Dynamic_Programming;
import java.util.*;
public class Unbounded_Knapsack {
    // More Space optimization....(1D array)
    public static int maximumProfit(int[] wt,int[] profit,int w){
        // Base case.....
        int n = wt.length;
        int index = n - 1;

        int[] prev = new int[w+1];

        // Base case....
        for (int i = 0; i <= w; i++) {
            // take it...
            prev[i] = (i / wt[0]) * profit[0];
        }
        for(int i = 1;i < n;i++){
            for(int w1 = 0;w1 <= w; w1++){ // current capacity...
                int notTake = prev[w1];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= w1){
                    take = profit[i] + prev[w1-wt[i]];
                }
                prev[w1] = Math.max(notTake,take);
            }
        }
        return prev[w];
    }
    public static void main(String[] args) {
        int[] wt = {2,4,6};
        int[] profit = {5,11,13};
        int bag_capacity = 10;
        System.out.println(maximumProfit(wt,profit,bag_capacity));
    }
}

