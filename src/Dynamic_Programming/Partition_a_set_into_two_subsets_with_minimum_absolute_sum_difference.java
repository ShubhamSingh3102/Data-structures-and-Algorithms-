//package Dynamic_Programming;
//import java.util.*;
//public class Partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference {
//    /// Tabulation way...
//    public static int minSubsetSumDifference(int[] nums){
//        int n = nums.length;
//        int totalSum = 0;
//        for(int i=0;i<n;i++){
//            totalSum += nums[i];
//        }
//        int k = totalSum;
//        boolean[][] dp = new boolean[n][k + 1];
//
//        for (int i = 0; i <= n - 1; i++) {
//            dp[i][0] = true;
//        }
//
//        if (nums[0] <= k) {
//            dp[0][nums[0]] = true;
//        }
//
//        for (int index = 1; index <= n - 1; index++) {
//            for (int target = 1; target <= k; target++) {
//                boolean notTaken = dp[index - 1][target];
//                boolean taken = false;
//                if (target >= nums[index]) {
//                    taken = dp[index - 1][target - nums[index]];
//                }
//                dp[index][target] = taken || notTaken;
//            }
//        }
//        //// dp[n-1][col --> 0 to totalSum/2]
//
//        int mini = (int)1e9;
//        for(int s1 = 0;s1 <= totalSum/2; s1++){
//            if(dp[n-1][s1] == true){
//                //// s1 possible...
//            int s2 = totalSum - s1;
//                mini = Math.min(mini,Math.abs(s2-s1));
//            }
//        }
//        return mini;
//    }
//    public static void main(String[] args) {
//        int[] nums = {3,9,7,3};
//        int n = nums.length;
//        System.out.println(minSubsetSumDifference(nums));
//    }
//}




















package Dynamic_Programming;
import java.util.*;
public class Partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference {
    /// Space optimization way...
    public static int minSubsetSumDifference(int[] nums){
        int n = nums.length;
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        int k = totalSum;
        boolean[] prev = new boolean[k+1];
        boolean[] curr = new boolean[k+1];

        prev[0] = curr[0] = true;

        if (nums[0] <= k) {
            prev[nums[0]] = true;
        }

        for(int index = 1;index <= n-1; index++){
            for(int target = 1; target <= k;target++){
                boolean notTaken = prev[target];
                boolean taken = false;
                if(target >= nums[index]) {
                    taken = prev[target - nums[index]];
                }
                curr[target] = taken || notTaken;
            }
            prev = curr.clone();
        }
        //// prev[col --> 0 to totalSum/2]

        int mini = (int)1e9;
        for(int s1 = 0;s1 <= totalSum/2; s1++){
            if(prev[s1] == true){
                //// s1 possible...
                int s2 = totalSum - s1;
                mini = Math.min(mini,Math.abs(s2-s1));
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        int[] nums = {3,9,7,3};
        int n = nums.length;
        System.out.println(minSubsetSumDifference(nums));
    }
}