//package Dynamic_Programming;
//import java.util.*;
//public class Rod_Cutting_Problem {
//// Recursion....
//    public static int maximumPrice(int index,int[] prices,int N){
//        if(index == 0){
//            // rodLength = ind + 1;
//            return N * prices[0];
//        }
//        int notTake = 0 + maximumPrice(index-1,prices,N);
//        int take = Integer.MIN_VALUE;
//        int rodLength = index + 1;
//        if(rodLength <= N){
//            take = prices[index] + maximumPrice(index,prices,N-rodLength);
//        }
//        return Math.max(take,notTake);
//    }
//    public static void main(String[] args) {
//        int[] prices = {2,5,7,8,10};
//        int n = prices.length;
//        int N = 5;
//        System.out.println(maximumPrice(n-1,prices,N));
//    }
//}















//package Dynamic_Programming;
//import java.util.*;
//public class Rod_Cutting_Problem {
//// Memoization.....
//    public static int maximumPrice(int index,int[] prices,int N,int[][] dp){
//        if(index == 0){
//            // rodLength = ind + 1;
//            return N * prices[0];
//        }
//        if(dp[index][N] != -1){
//            return dp[index][N];
//        }
//        int notTake = maximumPrice(index-1,prices,N,dp);
//        int take = Integer.MIN_VALUE;
//        int rodLength = index + 1;
//        if(rodLength <= N){
//            take = prices[index] + maximumPrice(index,prices,N-rodLength,dp);
//        }
//        return dp[index][N] = Math.max(take,notTake);
//    }
//    public static void main(String[] args) {
//        int[] prices = {2,5,7,8,10};
//        int n = prices.length;
//        int N = 5;
//        int[][] dp = new int[n][N+1];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        System.out.println(maximumPrice(n-1,prices,N,dp));
//    }
//}














//package Dynamic_Programming;
//import java.util.*;
//public class Rod_Cutting_Problem {
//// Tabulation....
//    public static int maximumPrice(int[] prices,int N){
//        int n = prices.length;
//        int[][] dp = new int[n][N+1];
//
//        for(int a = 0;a<=N;a++){
//            dp[0][a] = a * prices[0];
//        }
//
//        for(int index = 1;index<n;index++){
//            for(int b = 0;b <= N;b++){
//                int notTake = dp[index-1][b];
//                int take = Integer.MIN_VALUE;
//                int rodLength = index + 1;
//                if(rodLength <= b){
//                    take = prices[index] + dp[index][b-rodLength];
//                }
//                dp[index][b] = Math.max(take,notTake);
//            }
//        }
//        return dp[n-1][N];
//    }
//    public static void main(String[] args) {
//        int[] prices = {2,5,7,8,10};
//        int N = 5;
//        System.out.println(maximumPrice(prices,N));
//    }
//}














//package Dynamic_Programming;
//import java.util.*;
//public class Rod_Cutting_Problem {
//// Optimised way.....2D array
//    public static int maximumPrice(int[] prices,int N){
//        int n = prices.length;
//
//        int[] prev = new int[N+1];
//        int[] curr = new int[N+1];
//
//        for(int a = 0;a<=N;a++){
//            prev[a] = a * prices[0];
//        }
//
//        for(int index = 1;index<n;index++){
//            for(int b = 0;b <= N;b++){
//                int notTake = prev[b];
//                int take = Integer.MIN_VALUE;
//                int rodLength = index + 1;
//                if(rodLength <= b){
//                    take = prices[index] + curr[b-rodLength];
//                }
//                curr[b] = Math.max(take,notTake);
//            }
//            prev = curr.clone();
//        }
//        return prev[N];
//    }
//    public static void main(String[] args) {
//        int[] prices = {2,5,7,8,10};
//        int N = 5;
//        System.out.println(maximumPrice(prices,N));
//    }
//}


















package Dynamic_Programming;
import java.util.*;
public class Rod_Cutting_Problem {
    //// More Optimised....1D array...
    public static int maximumPrice(int[] prices,int N){
        int n = prices.length;

        int[] prev = new int[N+1];

        for(int a = 0;a<=N;a++){
            prev[a] = a * prices[0];
        }

        for(int index = 1;index<n;index++){
            for(int b = 0;b <= N;b++){
                int notTake = prev[b];
                int take = Integer.MIN_VALUE;
                int rodLength = index + 1;
                if(rodLength <= b){
                    take = prices[index] + prev[b-rodLength];
                }
                prev[b] = Math.max(take,notTake);
            }
        }
        return prev[N];
    }
    public static void main(String[] args) {
        int[] prices = {2,5,7,8,10};
        int N = 5;
        System.out.println(maximumPrice(prices,N));
    }
}