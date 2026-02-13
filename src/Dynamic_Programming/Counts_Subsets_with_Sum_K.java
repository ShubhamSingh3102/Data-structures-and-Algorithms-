//package Dynamic_Programming;
//import java.util.*;
//public class Counts_Subsets_with_Sum_K {
//    public static int totalSubsets(int index,int target,int[] arr){
//        int count = 0;
//        if(target == 0){
//            count++;
//            return count;
//        }
//        if(index == 0){
//            if(arr[0] == target){
//                count++;
//            }
//            return count;
//        }
//        int notTake = totalSubsets(index-1,target,arr);
//        int take = 0;
//        if(target >= arr[index]){
//            take = totalSubsets(index-1,target-arr[index],arr);
//        }
//        return take + notTake;
//    }
//    public static void main(String[] args) {
//        int[] arr = {3,4,12,5,1};
//        int target = 8;
//        int n = arr.length;
//        System.out.println(totalSubsets(n-1,target,arr));
//    }
//}















//package Dynamic_Programming;
//import java.util.*;
//public class Counts_Subsets_with_Sum_K {
//    ////Recursive way....
//    public static int totalSubsets(int index,int target,int[] arr){
//        if(target == 0){
//            return 1;
//        }
//        if(index == 0){
//            if(arr[index] == target){
//                return 1;
//            }
//            return 0;
//        }
//        int notTake = totalSubsets(index-1,target,arr);
//        int take = 0;
//        if(target >= arr[index]){
//            take = totalSubsets(index-1,target-arr[index],arr);
//        }
//        return take + notTake;
//    }
//    public static void main(String[] args) {
//        int[] arr = {3,4,12,5,1};
//        int target = 8;
//        int n = arr.length;
//        System.out.println(totalSubsets(n-1,target,arr));
//    }
//}

















//package Dynamic_Programming;
//import java.util.*;
//public class Counts_Subsets_with_Sum_K {
//    ////Memoization way....
//    public static int totalSubsets(int index,int target,int[] arr,int[][] dp){
////        if(target == 0){
////            return 1;
////        }
//        if (index == 0) {
//            if (target == 0 && arr[0] == 0) {
//                return 2; // {} and {0}
//            }
//            if (target == 0 || arr[0] == target){
//                return 1;
//            }
//            return 0;
//        }
//        if(dp[index][target] != -1){
//            return dp[index][target];
//        }
//        int notTake = totalSubsets(index-1,target,arr,dp);
//        int take = 0;
//        if(target >= arr[index]){
//            take = totalSubsets(index-1,target-arr[index],arr,dp);
//        }
//        return dp[index][target] = take + notTake;
//    }
//    public static void main(String[] args) {
//        int[] arr = {0,0,1};
//        int target = 1;
//        int n = arr.length;
//        int[][] dp = new int[n][target+1];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        System.out.println(totalSubsets(n-1,target,arr,dp));
//    }
//}






















//package Dynamic_Programming;
//import java.util.*;
//public class Counts_Subsets_with_Sum_K {
//    ////Tabulation way....
//    public static int totalSubsets(int k,int[] arr){
//        int n = arr.length;
//        int[][] dp = new int[n][k+1];
//
//        // base cases
//        if (arr[0] == 0) dp[0][0] = 2;   // {} and {0}
//        else dp[0][0] = 1;
//
//        for(int i = 0;i <= n-1; i++){
//            dp[i][0] = 1;
//        }
//
//        if(arr[0] <= k){
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
//    public static void main(String[] args) {
//        int[] arr = {3,4,12,5,1};
//        int target = 8;
//        int n = arr.length;
//        System.out.println(totalSubsets(target,arr));
//    }
//}





















package Dynamic_Programming;
import java.util.*;
public class Counts_Subsets_with_Sum_K {
    ////Space optimization way....
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
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int target = 2;
        int n = arr.length;
        System.out.println(totalSubsets(target,arr));
    }
}

