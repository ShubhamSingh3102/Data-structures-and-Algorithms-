//package Dynamic_Programming;
//import java.util.*;
//public class Subset_Sum_Equals_to_target_K {
//    //// Recursive way.....
//    public static boolean isSubsetSum(int index,int target,int[] arr){
//        if(target == 0){
//            return true;
//        }
//        if(index == 0){
//            return (arr[0] == target);
//        }
//        boolean notTaken = isSubsetSum(index-1,target,arr);
//        boolean take = false;
//        if(target >= arr[index]){
//            take = isSubsetSum(index-1,target-arr[index],arr);
//        }
//        return take || notTaken;
//    }
//    public static void main(String[] args) {
//        int[] arr = {3,34,4,12,5,2};
//        int n = arr.length;
//        int target = 9;
//        System.out.println(isSubsetSum(n-1,target,arr));
//    }
//}














//package Dynamic_Programming;
//import java.util.*;
//public class Subset_Sum_Equals_to_target_K {
//    //// Memoization way.....
//    public static boolean isSubsetSum(int index,int target,int[] arr,Boolean[][] dp){
//        if(target == 0){
//            return true;
//        }
//        if(index == 0){
//            return (arr[0] == target);
//        }
//        if(dp[index][target] != null){ // not computed yet
//            return dp[index][target];
//        }
//        boolean notTaken = isSubsetSum(index-1,target,arr,dp);
//        boolean take = false;
//        if(target >= arr[index]){
//            take = isSubsetSum(index-1,target-arr[index],arr,dp);
//        }
//        return dp[index][target] = take || notTaken;
//    }
//    public static void main(String[] args) {
//        int[] arr = {3,34,4,12,5,2};
//        int n = arr.length;
//        int target = 9;
//
//        Boolean[][] dp = new Boolean[n][target+1];
//        System.out.println(isSubsetSum(n-1,target,arr,dp));
//    }
//}




















//package Dynamic_Programming;
//import java.util.*;
//public class Subset_Sum_Equals_to_target_K {
//    //// Tabulation way.....
//    public static boolean isSubsetSum(int k,int[] arr){
//        int n = arr.length;
//        boolean [][] dp = new boolean[n][k+1];
//
//        for(int i=0;i<=n-1;i++){
//            dp[i][0] = true;
//        }
//
//        if (arr[0] <= k) {
//            dp[0][arr[0]] = true;
//        }
//
//        for(int index = 1;index <= n-1; index++){
//            for(int target = 1; target <= k;target++){
//                boolean notTaken = dp[index -1][target];
//                boolean taken = false;
//                if(target >= arr[index]) {
//                    taken = dp[index - 1][target - arr[index]];
//                }
//                dp[index][target] = taken || notTaken;
//            }
//        }
//        return dp[n-1][k];
//    }
//    public static void main(String[] args) {
//        int[] arr = {3,34,4,12,5,2};
//        int target = 9;
//        System.out.println(isSubsetSum(target,arr));
//    }
//}
















package Dynamic_Programming;
import java.util.*;
public class Subset_Sum_Equals_to_target_K {
    //// Space Optimization.....
    public static boolean isSubsetSum(int k,int[] arr){
        int n = arr.length;
        boolean[] prev = new boolean[k+1];
        boolean[] curr = new boolean[k+1];

        prev[0] = curr[0] = true;

        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        for(int index = 1;index <= n-1; index++){
            for(int target = 1; target <= k;target++){
                boolean notTaken = prev[target];
                boolean taken = false;
                if(target >= arr[index]) {
                    taken = prev[target - arr[index]];
                }
                curr[target] = taken || notTaken;
            }
            prev = curr.clone();
        }
        return prev[k];
    }
    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
        int target = 9;
        System.out.println(isSubsetSum(target,arr));
    }
}
