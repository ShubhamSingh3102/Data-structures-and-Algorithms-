//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Coin_Coin_Change {
//// Recursion way....
//    public static int coinChange(int[] coins,int index,int target){
//        if(target == 0){
//            return 0;
//        }
//        if(index == 0){
//            if(target % coins[index] == 0){
//                return target / coins[index];
//            }else{
//                return (int)1e9;
//            }
//        }
//        int notTake = 0 + coinChange(coins,index-1,target);
//        int take = Integer.MAX_VALUE;
//        if(coins[index] <= target){
//            take = 1 + coinChange(coins,index,target-coins[index]);
//        }
//        return Math.min(take,notTake);
//    }
//    public static void main(String[] args) {
//        int[] coins = {1,2,5};
//        int n = coins.length;
//        int target = 11;
//        int ans = coinChange(coins,n-1,target);
//        if(ans >= (int)1e9){
//            System.out.println(-1);
//        }
//        else{
//            System.out.println(ans);
//        }
//    }
//}














//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Coin_Coin_Change {
//// Memoization way....
//    public static int coinChange(int[] coins,int index,int target,int[][] dp){
//        if(target == 0){
//            return 0;
//        }
//        if(index == 0){
//            if(target % coins[index] == 0){
//                return target / coins[index];
//            }else{
//                return (int)1e9;
//            }
//        }
//        if(dp[index][target] != -1){
//            return dp[index][target];
//        }
//        int notTake = coinChange(coins,index-1,target,dp);
//        int take = Integer.MAX_VALUE;
//        if(coins[index] <= target){
//            take = 1 + coinChange(coins,index,target-coins[index],dp);
//        }
//        return dp[index][target] =  Math.min(take,notTake);
//    }
//    public static void main(String[] args) {
//        int[] coins = {1,2,5};
//        int n = coins.length;
//        int target = 11;
//        int[][] dp = new int[n][target+1];
//        for(int[] rows: dp){
//            Arrays.fill(rows,-1);
//        }
//        int ans = coinChange(coins,n-1,target,dp);
//        if(ans >= (int)1e9){
//            System.out.println(-1);
//        }
//        else{
//            System.out.println(ans);
//        }
//    }
//}


















//package Dynamic_Programming;
//import java.util.*;
//public class Minimum_Coin_Coin_Change {
//// Tabulation way......
//    public static int coinChange(int[] coins){
//        int n = coins.length;
//        int target = 8;
//        int[][] dp = new int[n][target+1];
//        for(int t =0; t <= target; t++){
//            if(t % coins[0] == 0){
//                dp[0][t] = t/coins[0];
//            }
//            else{
//                dp[0][t] =  (int)1e9;
//            }
//        }
//        for(int index = 1;index <= n-1;index++){
//            for(int t = 0; t <= target; t++){
//                int notTake = dp[index-1][t];
//                int take = Integer.MAX_VALUE;
//                if(coins[index] <= t){
//                    take = 1 + dp[index][t - coins[index]];
//                }
//                dp[index][t] = Math.min(take,notTake);
//            }
//        }
//        return dp[n-1][target];
//    }
//    public static void main(String[] args) {
//        int[] coins = {1,2,5};
//        int ans = coinChange(coins);
//        if(ans >= (int)1e9){
//            System.out.println(-1);
//        }
//        else{
//            System.out.println(ans);
//        }
//    }
//}
















package Dynamic_Programming;
import java.util.*;
public class Minimum_Coin_Coin_Change {
    //// Space optimization.....
    public static int coinChange(int[] coins,int target){
        int n = coins.length;

        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        for(int t =0; t <= target; t++){
            if(t % coins[0] == 0){
                prev[t] = t/coins[0];
            }
            else{
                prev[t] =  (int)1e9;
            }
        }
        for(int index = 1;index <= n-1;index++){
            for(int t = 0; t <= target; t++){
                int notTake = prev[t];
                int take = Integer.MAX_VALUE;
                if(coins[index] <= t){
                    take = 1 + curr[t - coins[index]];
                }
                curr[t] = Math.min(take,notTake);
            }
            prev = curr.clone();
        }
        return prev[target];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 4;
        int ans = coinChange(coins,target);
        if(ans >= (int)1e9){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
}