package Binary_Search;
import java.util.*;
public class Minimum_in_Rotated_Sorted_Array {
    public static int findMin(int[] nums){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[n - 1]){  // part 2
                low = mid + 1;
            } else {   // part 1
                ans = nums[mid];
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
