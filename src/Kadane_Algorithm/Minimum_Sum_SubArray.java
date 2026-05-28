package Kadane_Algorithm;
import java.util.*;
public class Minimum_Sum_SubArray {
    public static int minimum_sum_subArray(int[] nums){
        int n = nums.length;

        int bestEnding = nums[0];
        int ans = nums[0];

        for(int i = 0; i < n; i++){
            int v1 = bestEnding + nums[i];
            int v2 = nums[i];
            bestEnding = Math.min(v1,v2);
            ans = Math.min(ans,bestEnding);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2};
        System.out.println(minimum_sum_subArray(nums));
    }
}
