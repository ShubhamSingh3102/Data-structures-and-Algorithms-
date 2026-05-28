package Binary_Search;
import java.util.*;
public class First_and_last_position {
        public static int first_position(int[] nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] < target){
                low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            }
            else { // nums[mid] == target
                // first dukan ke liye
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int last_position(int[] nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] < target){
                low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            }
            else { // nums[mid] == target
                // last dukan ke liye
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int[] searchRange(int[] nums, int target){
            int first = first_position(nums,target);
            int last = last_position(nums,target);

            return new int[]{first,last};
    }
    public static void main(String[] args) {
        int[] nums = {5,10,15,30,30,30,30,40,50};
        int target = 30;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
}
