//package Dynamic_Programming;
//import java.util.*;
//public class Maximum_sum_of_non_adjacent_elements {
//    public static int maximumSum(int ind,int[] nums){
//        //// recursion way....
//        if(ind == 0){
//            return nums[ind];
//        }
//        if(ind < 0){
//            return 0;
//        }
//        int pick = nums[ind] + maximumSum(ind-2,nums);
//        int notPick = 0 + maximumSum(ind - 1, nums);
//
//        return Math.max(pick,notPick);
//    }
//    public static void main(String[] args) {
//        int[] nums = {2, 1, 4, 9};
//        int n = nums.length;
//
//        System.out.println(maximumSum(n - 1, nums));
//    }
//}
















//package Dynamic_Programming;
//import java.util.*;
//public class Maximum_sum_of_non_adjacent_elements {
//    public static int maximumSum(int ind,int[] nums,int[] dp){
//        //// memoization way....
//        if(ind == 0){
//            return nums[ind];
//        }
//        if(ind < 0){
//            return 0;
//        }
//        if (dp[ind] != -1){
//            return dp[ind];
//        }
//        int pick = nums[ind] + maximumSum(ind-2,nums,dp);
//        int notPick = maximumSum(ind - 1, nums, dp);
//
//        return dp[ind] = Math.max(pick,notPick);
//    }
//    public static void main(String[] args) {
//        int[] nums = {2, 1, 4, 9};
//        int n = nums.length;
//
//        int[] dp = new int[n];
//        Arrays.fill(dp,-1);
//        System.out.println(maximumSum(n - 1, nums,dp));
//    }
//}














//package Dynamic_Programming;
//import java.util.*;
//public class Maximum_sum_of_non_adjacent_elements {
//    public static int maximumSum(int[] nums){
//        //// tabulation way....
//        int n = nums.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp,0);
//
//        dp[0] = nums[0];
//
//        for(int i=1;i<n;i++){
//            int pick = nums[i];
//            if(i>1){
//                pick = nums[i] + dp[i-2];
//            }
//            int notPick = 0 + dp[i-1];
//
//            dp[i] = Math.max(pick,notPick);
//        }
//        return dp[n-1];
//    }
//    public static void main(String[] args) {
//        int[] nums = {2, 1, 4, 9};
//        int n = nums.length;
//        System.out.println(maximumSum(nums));
//    }
//}
//


















//// House Robber 1
package Dynamic_Programming;
import java.util.*;
public class Maximum_sum_of_non_adjacent_elements {
    public static int maximumSum(int[] nums) {
        //// Space Optimization way....
        int prev2 = 0;
        int prev = nums[0];

        int n = nums.length;
        for(int i=1;i<n;i++){
            int pick = nums[i] + prev2;
            int notPick = prev; //// 0 + prev;

            int curr = Math.max(pick,notPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 9};
        System.out.println(maximumSum(nums));
    }
}






















