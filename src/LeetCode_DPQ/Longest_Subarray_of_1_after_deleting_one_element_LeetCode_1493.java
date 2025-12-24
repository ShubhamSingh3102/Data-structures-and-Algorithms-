package LeetCode_DPQ;
import java.util.*;
// Given a binary array nums, you should delete one element from it.
//
//Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
//
//
//
//Example 1:
//
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
//Example 2:
//
//Input: nums = [0,1,1,1,0,1,1,0,1]
//Output: 5
//Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
//Example 3:
//
//Input: nums = [1,1,1]
//Output: 2
//Explanation: You must delete one element.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//nums[i] is either 0 or 1....
public class Longest_Subarray_of_1_after_deleting_one_element_LeetCode_1493 {
    public static int longestSubarray(int[] nums) {
//        int i = 0;                 // left pointer
//        int zeros = 0;             // count zeros in the window
//        int result = 0;
//
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] == 0) {
//                zeros++;
//            }
//
//            // shrink window until at most one zero remains
//            while (zeros > 1) {
//                if (nums[i] == 0) {
//                    zeros--;
//                }
//                i++;
//            }
//
//            // j - i is the length after deleting one element
//            result = Math.max(result, j - i);
//        }
//
//        return result;
//    }

        // approach 2 --> sliding window approach...
//         int zeroCount = 0;
//         int maxLength = 0;
//         int i = 0;
//
//         for (int j = 0; j < nums.length; j++) {
//             if (nums[j] == 0) {
//                 zeroCount++;
//             }
//
//             while (zeroCount > 1) {
//                 if (nums[i] == 0) {
//                     zeroCount--;
//                 }
//                 i++;
//             }
//
//             maxLength = Math.max(maxLength, j - i);
//         }
//
//             return maxLength;


        // Approach 3 for better sliding window technique...

            int i = 0;
            int j = 0;
            int lastZeroIdx = -1;
            int result = 0;

            while (j < nums.length) {
                if (nums[j] == 0) {
                    i = lastZeroIdx + 1;
                    lastZeroIdx = j;
                }
                result = Math.max(result, j - i);
                j++;
            }

            return result;
        }
    public static void main(String[] args) {
        int[] nums1 = {1,1,0,1};
        System.out.println(longestSubarray(nums1)); // 3

        int[] nums2 = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums2)); // 5

        int[] nums3 = {1,1,1};
        System.out.println(longestSubarray(nums3)); // 2
    }
}

