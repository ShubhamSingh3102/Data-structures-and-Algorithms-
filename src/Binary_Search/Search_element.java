package Binary_Search;
import java.util.*;
public class Search_element {
    public static int searchElement(int[] nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,12,17,21,25};
        int target = 21;
        System.out.println(searchElement(nums,target));
    }
}
