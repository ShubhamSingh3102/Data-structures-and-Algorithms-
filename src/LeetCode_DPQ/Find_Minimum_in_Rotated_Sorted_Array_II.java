package LeetCode_DPQ;
import java.util.*;
public class Find_Minimum_in_Rotated_Sorted_Array_II {
    public static int findMinimum(int[] nums){
        int mini = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(mini > nums[i]){
                mini = nums[i];
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(findMinimum(nums));
    }
}