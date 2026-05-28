package Prefix_Sum;
import java.util.*;
public class Subarray_Sum_Divisible_by_K {
    public static int subArraysDivByK(int[] nums,int k){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0;
        int res= 0;

        map.put(0,1);

        for(int i = 0; i < n; i++){
            sum += nums[i];

            int rem = sum % k;

            // negative remainder fix
            if(rem < 0){
                rem += k;
            }

            int freq = map.getOrDefault(rem,0);

            res += freq;

            map.put(rem,map.getOrDefault(rem,0) + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subArraysDivByK(nums,k));
    }
}
