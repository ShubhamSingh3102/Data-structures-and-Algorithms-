package ARRAY;
import java.util.*;
public class Divide_an_array_into_subArrays_with_minimum_cost_I_LeetCode_3010 {
    public static int minimumCost(int[] nums){
        int n = nums.length;

        int score = nums[0];

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int i = 1;i<n;i++){
            if(nums[i] < firstMin){
                secondMin = firstMin;
                firstMin = nums[i];
            }else if(nums[i] < secondMin){
                secondMin = nums[i];
            }
        }
        return score + firstMin + secondMin;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,12};
        System.out.println(minimumCost(nums));
    }
}
