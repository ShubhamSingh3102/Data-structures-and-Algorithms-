package Prefix_Sum;
import java.util.*;
public class Contiguous_Array_LeetCode_525 {
    public static int findMaxLength(int[] nums){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int res = 0;
        int zeroes = 0;
        int ones = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                zeroes++;
            }
            if(nums[i] == 1){
                ones++;
            }
            int diff = zeroes - ones;

            if(diff == 0){
                res = Math.max(res,i+1);
                continue;
            }

            if(map.containsKey(diff)){
                res = Math.max(res,i - map.get(diff));
            } else {
                map.put(diff,i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(nums));
    }
}
