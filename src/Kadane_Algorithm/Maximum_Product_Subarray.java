package Kadane_Algorithm;
import java.util.*;
public class Maximum_Product_Subarray {
    public static int max_Product_SubArray(int[] nums){
        int n = nums.length;

        int minEnding = nums[0];
        int maxEnding = nums[0];
        int ans = nums[0];

        for(int i = 1; i < n; i++){
            int v1 = nums[i];
            int v2 = minEnding * nums[i];
            int v3 = maxEnding * nums[i];

            maxEnding = Math.max(v1, Math.max(v2,v3));
            minEnding = Math.min(v1, Math.min(v2,v3));

            ans = Math.max(ans, Math.max(maxEnding,minEnding));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-2,3,-4};
        System.out.println(max_Product_SubArray(nums));
    }
}
