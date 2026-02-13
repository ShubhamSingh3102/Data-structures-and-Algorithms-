package Dynamic_Programming;
import java.util.*;
public class House_Robber_2 {
    public static int maximumSum(int[] nums) {
        //// Space Optimization way of House Robber 1...
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
    public static long houseRobber2(int[] nums){
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: Exclude first house
        int[] temp1 = new int[n - 1];
        // Case 2: Exclude last house
        int[] temp2 = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                //// Copying all elements except the first one into a new array...
                temp1[i - 1] = nums[i];
            }
            if (i != n - 1) {
                //// Copying all elements except the last one into a new array....
                temp2[i] = nums[i];
            }
        }
        return Math.max(maximumSum(temp1), maximumSum(temp2));
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 9};
        System.out.println(houseRobber2(nums));
    }
}
