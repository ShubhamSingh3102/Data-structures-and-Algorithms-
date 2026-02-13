//package Dynamic_Programming;
////// same as LECTURE NO - 17 with derived sum...
//import java.util.*;
//public class Count_Partitions_with_Given_Difference {
//// Memoization....
//    public static int totalSubsets(int index,int target,int[] arr,int[][] dp) {
////        if(target == 0){
////            return 1;
////        }
//        if (index == 0) {
//            if (target == 0 && arr[0] == 0) {
//                return 2; // {} and {0}
//            }
//            if (target == 0 || arr[0] == target) {
//                return 1;
//            }
//            return 0;
//        }
//        if (dp[index][target] != -1) {
//            return dp[index][target];
//        }
//        int notTake = totalSubsets(index - 1, target, arr, dp);
//        int take = 0;
//        if (target >= arr[index]) {
//            take = totalSubsets(index - 1, target - arr[index], arr, dp);
//        }
//        return dp[index][target] = take + notTake;
//    }
//    public static int countPartitions(int n,int d,int[] arr){
//        int totalSum = 0;
//        for(int i=0;i<n;i++){
//            totalSum += arr[i];
//        }
//        if(totalSum - d < 0 || (totalSum -d) % 2 != 0){
//            return 0;
//        }
//        int target = (totalSum - d)/2;
//        int[][] dp = new int[n][target+1];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        return totalSubsets(n-1,target,arr,dp);
//    }
//    public static void main(String[] args) {
//        int[] arr = {0,0,1};
//        int d = 1;
//        int n = arr.length;
//        System.out.println(countPartitions(n,d,arr));
//    }
//}




















//package Dynamic_Programming;
////// same as LECTURE NO - 17 with derived sum...
//import java.util.*;
//public class Count_Partitions_with_Given_Difference {
//// Tabulation....
//    public static int totalSubsets(int k,int[] arr) {
//        int n = arr.length;
//        int[][] dp = new int[n][k+1];
//
//        // base cases
//        if (arr[0] == 0) dp[0][0] = 2;   // {} and {0}
//        else dp[0][0] = 1; // not take....
//
//        for(int i = 1; i < n; i++){
//            if(arr[i] == 0)
//                dp[i][0] = dp[i-1][0] * 2;
//            else
//                dp[i][0] = dp[i-1][0]; // not take...
//        }
//
//        if(arr[0] != 0 && arr[0] <= k){
//            dp[0][arr[0]] = 1;
//        }
//
//        for(int index = 1;index <= n-1; index++){
//            for(int target = 1;target <= k; target++){
//                int notTake = dp[index-1][target];
//                int take = 0;
//                if(target >= arr[index]){
//                    take = dp[index-1][target-arr[index]];
//                }
//                dp[index][target] = take + notTake;
//            }
//        }
//        return dp[n-1][k];
//    }
//    public static int countPartitions(int n,int d,int[] arr){
//        int totalSum = 0;
//        for(int i=0;i<n;i++){
//            totalSum += arr[i];
//        }
//        if(totalSum - d < 0 || (totalSum -d) % 2 != 0){
//            return 0;
//        }
//        int target = (totalSum - d)/2;
//        return totalSubsets(target,arr);
//    }
//    public static void main(String[] args) {
//        int[] arr = {0,0,1};
//        int d = 1;
//        int n = arr.length;
//        System.out.println(countPartitions(n,d,arr));
//    }
//}















package Dynamic_Programming;
//// same as LECTURE NO - 17 with derived sum...
import java.util.*;
public class Count_Partitions_with_Given_Difference {
    //// Space optimization....
    public static int totalSubsets(int k,int[] arr){
        int n = arr.length;

        int[] prev = new int[k+1];
        int[] curr = new int[k+1];

        if(arr[0] == 0){
            prev[0] = 2;
        }
        else prev[0] = 1;

        if(arr[0] != 0 && arr[0] <= k){
            prev[arr[0]] = 1;
        }


        for(int index = 1;index <= n-1; index++){
            Arrays.fill(curr,0);
            if(arr[index] == 0)
                curr[0] = prev[0] * 2;
            else
                curr[0] = prev[0];
            for(int target = 1;target <= k; target++){
                int notTake = prev[target];
                int take = 0;
                if(target >= arr[index]){
                    take = prev[target-arr[index]];
                }
                curr[target] = take + notTake;
            }
            prev = curr.clone();
        }
        return prev[k];
    }
    public static int countPartitions(int n,int d,int[] arr){
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += arr[i];
        }
        if(totalSum - d < 0 || (totalSum -d) % 2 != 0){
            return 0;
        }
        int target = (totalSum - d)/2;
        return totalSubsets(target,arr);
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1};
        int d = 1;
        int n = arr.length;
        System.out.println(countPartitions(n,d,arr));
    }
}