package Prefix_Sum;
import java.util.*;
public class Prefix_sum_of_an_Array {
    //// prefix(i) --> (0,i-1) tk ka sum...
    public static int[] PrefixSum(int[] nums){
        int n = nums.length;

        int[] prefix = new int[n]; // n size ka ek array bana liye hai...
        prefix[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        return prefix;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,5,6,7,8};
        System.out.println(Arrays.toString(PrefixSum(nums)));
    }
}
