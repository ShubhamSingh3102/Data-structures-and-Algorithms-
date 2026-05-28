package ARRAY;
import java.util.*;
public class Triplets_Smaller_Sum {
    public static int triplet_smaller_sum(int[] nums,int target) {
        // find sum is less than target....
        // TC --> O(n^2)
        // SC --> O(1)
        int n = nums.length;

        Arrays.sort(nums);

        int ans = 0;

        for (int i = 0; i < n - 2; i++) {     // kyuki (n - 2) ke baad 2 pair chahiye na sum krne ke liye...O(n-2)


            // O(n)
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum >= target) {
                    right--;
                } else {  // sum < target
                    ans = ans + (right - left);
                    left++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        int target = 2;
        System.out.println(triplet_smaller_sum(nums,target));
    }
}
