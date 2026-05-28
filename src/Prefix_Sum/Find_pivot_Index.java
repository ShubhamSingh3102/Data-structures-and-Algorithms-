package Prefix_Sum;
import java.util.*;
public class Find_pivot_Index {
    //// prefix(i) === suffix(i) --> index batana hai...
    public static int pivotIndex(int[] nums){
        int n = nums.length;

        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        int left = 0;
        int right;
        for(int i = 0; i < n; i++){
            right = totalSum - left - nums[i];

            if(left == right){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
