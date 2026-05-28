package Sliding_Window;
import java.util.*;
public class Max_Consecutive_Ones_III_LeetCode_1004 {
    public static int longestOnes(int[] nums, int k){

        // Variable Window Size
        int low = 0;
        int high = 0;
        int result = Integer.MIN_VALUE;
        int zeroes = 0;

        while(high < nums.length) {

            if (nums[high] == 0) {
                zeroes++;
            }

            // invalid window...
            while(zeroes > k){
                if(nums[low] == 0){
                    zeroes--;
                }
                low++;
            }
            int len = high - low + 1;
            result = Math.max(result,len);
            high++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }
}












// ******
// max me galat pe shrink krte hai....
// min me sahi me shrink krte hai...aur shrink krne se phele ans me include kr liya jaata hai...
// ******