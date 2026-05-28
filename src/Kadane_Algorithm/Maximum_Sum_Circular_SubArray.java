package Kadane_Algorithm;
import java.util.*;
public class Maximum_Sum_Circular_SubArray {
    public static int totalArraySum(int[] nums){
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum = sum + nums[i];
        }
        return sum;
    }
    public static int maxSubarraySumCircular(int[] nums){
        int n = nums.length;

        // if middle part me ho hamara maxSubArraySum  --> straight part me kadane's use kro..
        int bestEndingMax = nums[0];
        int ans1 = nums[0];

        for(int i = 1; i < n; i++){
            bestEndingMax = Math.max(nums[i], bestEndingMax + nums[i]);
            ans1 = Math.max(ans1,bestEndingMax);
        }

        // if all numbers are negative, circular case will give 0 incorrectly
        if(ans1 < 0){
            return ans1;
        }

        // agar hamara maxSubarray circular part me ho to

        // min subArray part
        int bestEndingMin = nums[0];
        int ans2 = nums[0];

        for(int i = 1; i < n; i++){
            bestEndingMin = Math.min(nums[i], bestEndingMin + nums[i]);
            ans2 = Math.min(ans2,bestEndingMin);
        }

        int circular = totalArraySum(nums) - ans2;

        return Math.max(ans1,circular);
    }
    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
