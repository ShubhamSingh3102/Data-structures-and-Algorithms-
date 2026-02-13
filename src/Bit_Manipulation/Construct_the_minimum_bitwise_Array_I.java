package Bit_Manipulation;
import java.util.*;
public class Construct_the_minimum_bitwise_Array_I {
    public static int[] minBitwiseArray(List<Integer> nums){
        int n = nums.size();
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            int target = nums.get(i);
            int res = -1;

            for(int x = 0; x < target;x++){
                if((x | (x+1)) == target){
                    res = x;
                    break;
                }
            }
            ans[i] = res;
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,3,5,7);
        System.out.println(Arrays.toString(minBitwiseArray(nums)));
    }
}
