//package Binary_Search;
//import java.util.*;
//public class Search_in_Rotated_Sorted_Array {
//    public static int binarySearch(int[] nums,int low, int high, int target){
//        while(low <= high){
//            int mid = low + (high - low) / 2;
//
//            if(nums[mid] == target){
//                return mid;
//            } else if(nums[mid] < target){
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return -1;
//    }
//    public static int search(int[] nums, int target){
//        int n = nums.length;
//        int low = 0;
//        int high = n - 1;
//        int idx = -1;
//
//        while(low <= high){
//            int mid = low + (high - low) / 2;
//            if(nums[mid] > nums[n-1]){ // 2nd part
//                low = mid + 1;
//            } else {
//                idx = mid;
//                high = mid - 1;
//            }
//        }
//
//        // decide which half to search
//        int low1 = 0;
//        int high1 = idx -1;
//
//        int low2 = idx;
//        int high2 = n - 1;
//
//        // Search in first half
//        int ans = binarySearch(nums,low1,high1,target);
//
//        // Search in second half
//        if(ans == -1){
//            ans = binarySearch(nums,low2,high2,target);
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
//        System.out.println(search(nums,target));
//    }
//}
//
//
//











package Binary_Search;
import java.util.*;
public class Search_in_Rotated_Sorted_Array {

    // 1 pass
    public static int search(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low )/ 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > nums[n-1]){   // part 1
                if(nums[mid] < target){   // right jaana h
                    low = mid + 1;
                } else {   // nums[mid] > target
                    if(nums[0] > target){   // part 1 ka sabse chota element
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else {   // part 2
                if(nums[mid] > target){
                    high = mid - 1;
                } else {
                    if(nums[n-1] < target){
                        // left
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
}
