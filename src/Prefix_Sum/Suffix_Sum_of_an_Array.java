package Prefix_Sum;
import java.util.*;
public class Suffix_Sum_of_an_Array {
    //// suffix(i) --> (i+1,n-1) tk ka sum...
    public static int[] SuffixSum(int[] nums){
        int n = nums.length;

        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];

        for(int i = n-2; i >= 0; i--){
            suffix[i] = suffix[i+1] + nums[i];
        }
        return suffix;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,5,6,7,8};
        System.out.println(Arrays.toString(SuffixSum(nums)));
    }
}
