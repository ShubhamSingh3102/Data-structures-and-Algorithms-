package Binary_Search;
import java.util.*;
public class Ceiling_bound {
    public static int ceilingUpperBound(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] >= target){
                ans = nums[mid];
                high = mid - 1;  // aab iske phele wala check kro
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,12,17,21,25};
        int target = 15;
        System.out.println(ceilingUpperBound(nums,target));
    }
}
