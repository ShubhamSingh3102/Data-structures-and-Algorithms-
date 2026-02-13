//package Dynamic_Programming;
//import java.util.*;
//public class Knapsack_Problem_0_1 {
//// Recursive way....
//    public static int maxProfit(int index,int[] wt,int w,int[] profit){
//       // Base case.....
//        if(index == 0){
//            if(wt[0] <= w){
//                // take
//                return profit[0];
//            }
//            else{ // wt[0] >= w
//                // not take
//                return 0;
//            }
//        }
//        int notTake = 0 + maxProfit(index-1,wt,w,profit);
//        int take = Integer.MIN_VALUE;
//        if(wt[index] <= w){
//            take = profit[index] + maxProfit(index-1,wt,w-wt[index],profit);
//        }
//        return Math.max(notTake,take);
//    }
//    public static void main(String[] args) {
//        int[] wt = {3,4,5};
//        int[] profit = {30,50,60};
//        int bag_capacity = 8;
//        int n = wt.length;
//        System.out.println(maxProfit(n-1,wt,bag_capacity,profit));
//    }
//}
//
//

















//package Dynamic_Programming;
//import java.util.*;
//public class Knapsack_Problem_0_1 {
//    //// Memoization way....
//    public static int maxProfit(int index,int[] wt,int w,int[] profit,int[][] dp){
//        // Base case.....
//        if(index == 0){
//            if(wt[0] <= w){
//                // take
//                return profit[0];
//            }
//            else{ // wt[0] >= w
//                // not take
//                return 0;
//            }
//        }
//        if(dp[index][w] != -1){
//            return dp[index][w];
//        }
//        int notTake = maxProfit(index-1,wt,w,profit,dp);
//        int take = Integer.MIN_VALUE;
//        if(wt[index] <= w){
//            take = profit[index] + maxProfit(index-1,wt,w-wt[index],profit,dp);
//        }
//        return dp[index][w] =  Math.max(notTake,take);
//    }
//    public static void main(String[] args) {
//        int[] wt = {3,4,5};
//        int[] profit = {30,50,60};
//        int bag_capacity = 8;
//        int n = wt.length;
//        int[][] dp = new int[n][bag_capacity+1];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        System.out.println(maxProfit(n-1,wt,bag_capacity,profit,dp));
//    }
//}











//package Dynamic_Programming;
//import java.util.*;
//public class Knapsack_Problem_0_1 {
//    // Tabulation way....
//    public static int maxProfit(int[] wt,int[] profit,int w){
//        // Base case.....
//        int n = wt.length;
//        int index = n - 1;
//        int[][] dp = new int[n][w+1];
//        // Base case....
//        for (int i = wt[0]; i <= w; i++) {
//            // take it...
//            dp[0][i] = profit[0];
//        }
//        for(int i = 1;i < n;i++){
//            for(int w1 = 0;w1 <= w; w1++){ // current capacity...
//                int notTake = dp[i-1][w1];
//                int take = Integer.MIN_VALUE;
//                if(wt[index] <= w1){
//                    take = profit[index] + dp[i-1][w1-wt[i]];
//                }
//                dp[i][w1] = Math.max(notTake,take);
//            }
//        }
//        return dp[n-1][w];
//    }
//    public static void main(String[] args) {
//        int[] wt = {3,4,5};
//        int[] profit = {30,50,60};
//        int bag_capacity = 8;
//        System.out.println(maxProfit(wt,profit,bag_capacity));
//    }
//}

















//package Dynamic_Programming;
//import java.util.*;
//public class Knapsack_Problem_0_1 {
//    // Space Optimization way....
//    public static int maxProfit(int[] wt,int[] profit,int w){
//        // Base case.....
//        int n = wt.length;
//        int index = n - 1;
//        int[] prev = new int[w+1];
//        int[] curr = new int[w+1];
//        // Base case....
//        for (int i = wt[0]; i <= w; i++) {
//            // take it...
//            prev[i] = profit[0];
//        }
//        for(int i = 1;i < n;i++){
//            for(int w1 = 0;w1 <= w; w1++){ // current capacity...
//                int notTake = prev[w1];
//                int take = Integer.MIN_VALUE;
//                if(wt[i] <= w1){
//                    take = profit[i] + prev[w1-wt[i]];
//                }
//                curr[w1] = Math.max(notTake,take);
//            }
//            prev = curr.clone();
//        }
//        return prev[w];
//    }
//    public static void main(String[] args) {
//        int[] wt = {3,4,5};
//        int[] profit = {30,50,60};
//        int bag_capacity = 8;
//        System.out.println(maxProfit(wt,profit,bag_capacity));
//    }
//}















package Dynamic_Programming;
import java.util.*;
public class Knapsack_Problem_0_1 {
    // Single array space optimization....
    // More Space Optimization way...using only single array....from right to left....
    public static int maxProfit(int[] wt,int[] profit,int w){
        // Base case.....
        int n = wt.length;
        int index = n - 1;
        int[] prev = new int[w+1];
        // Base case....
        for (int i = wt[0]; i <= w; i++) {
            // take it...
            prev[i] = profit[0];
        }
        for(int i = 1;i < n;i++){
            for(int w1 = w;w1 >= 0; w1--){ // current capacity...
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
        int[] wt = {3,4,5};
        int[] profit = {30,50,60};
        int bag_capacity = 8;
        System.out.println(maxProfit(wt,profit,bag_capacity));
    }
}


