package LeetCode_DPQ;
import java.util.*;

// Given an integer array nums, return the number of subarrays filled with 0.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//
//Example 1:
//
//Input: nums = [1,3,0,0,2,0,0,4]
//Output: 6
//Explanation:
//There are 4 occurrences of [0] as a subarray.
//There are 2 occurrences of [0,0] as a subarray.
//There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
//Example 2:
//
//Input: nums = [0,0,0,2,0,0]
//Output: 9
//Explanation:
//There are 5 occurrences of [0] as a subarray.
//There are 3 occurrences of [0,0] as a subarray.
//There is 1 occurrence of [0,0,0] as a subarray.
//There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
//Example 3:
//
//Input: nums = [2,10,2019]
//Output: 0
//Explanation: There is no subarray filled with 0. Therefore, we return 0.
//



// Approach 1....
//public class Number_of_zero_filled_subArrays_LeetCode_2348 {
//
//    public long zeroFilledSubarray(int[] nums) {
//        long result = 0;
//        int n = nums.length;
//        int i = 0;
//
//        while (i < n) {
//            long  L = 0;
//
//            if (nums[i] == 0) {
//                while (i < n && nums[i] == 0) {
//                    i++;
//                    L++;
//                }
//            } else {
//                i++;
//            }
//
//            // add subarray count: (L * (L + 1)) / 2
//            result += (long) L * (L + 1) / 2;
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Number_of_zero_filled_subArrays_LeetCode_2348 obj = new Number_of_zero_filled_subArrays_LeetCode_2348();
//
//        int[] nums1 = {1, 3, 0, 0, 2, 0, 0, 4};
//        int[] nums2 = {0, 0, 0, 2, 0, 0};
//        int[] nums3 = {1, 2, 3};
//
//        System.out.println(obj.zeroFilledSubarray(nums1)); // Output: 6
//        System.out.println(obj.zeroFilledSubarray(nums2)); // Output: 9
//        System.out.println(obj.zeroFilledSubarray(nums3)); // Output: 0
//    }
//}
//


// Approach 2...


public class Number_of_zero_filled_subArrays_LeetCode_2348 {

    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int n = nums.length;

        int count = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                count++;
            }else{
                count = 0;
            }
            result = result + count;
        }
        return result;
    }

    public static void main(String[] args) {
        Number_of_zero_filled_subArrays_LeetCode_2348 obj = new Number_of_zero_filled_subArrays_LeetCode_2348();

        int[] nums1 = {1, 3, 0, 0, 2, 0, 0, 4};
        int[] nums2 = {0, 0, 0, 2, 0, 0};
        int[] nums3 = {1, 2, 3};

        System.out.println(obj.zeroFilledSubarray(nums1)); // Output: 6
        System.out.println(obj.zeroFilledSubarray(nums2)); // Output: 9
        System.out.println(obj.zeroFilledSubarray(nums3)); // Output: 0
    }
}

