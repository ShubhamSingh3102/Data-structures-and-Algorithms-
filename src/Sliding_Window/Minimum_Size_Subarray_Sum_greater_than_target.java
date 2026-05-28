//package Sliding_Window;
//import java.util.*;
//public class Minimum_Size_Subarray_Sum_greater_than_target {
//    public static int minSubArrayLen(int target, int[] nums){
//        // Variable Sliding Window...
//
//        // by maximum window
//        // hiring and firing system in amazon...
//        // always in variable window size...window length = 1
//        int low = 0;
//        int high = 0;
//
//        int result = Integer.MAX_VALUE;
//        int sum = 0;
//
//        // hiring ---> high ke taraf se
//        // firing ---> low ke taraf se
//
//        while(high < nums.length){
//            sum = sum + nums[high];
//
//
//            // jab tk kaam ho rha h...
//            while(sum >= target){ // kaam ho rha h....
//                int length = high - low + 1;
//                result = Math.min(result,length);
//
//                // now fire kro
//                sum = sum - nums[low];
//                low++;
//            }
//            high++;
//        }
//        return (result == Integer.MAX_VALUE) ? 0 : result;
//    }
//    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
//        int target = 7;
//        System.out.println(minSubArrayLen(target,nums));
//    }
//}













package Sliding_Window;
import java.util.*;
public class Minimum_Size_Subarray_Sum_greater_than_target {
    public static int minSubArrayLen(int target, int[] nums){
        // Variable Sliding Window...

        // by minimum window
        // hiring and firing system in amazon...
        // always in variable window size...window length = 1
        int low = 0;
        int high = 0;

        int result = Integer.MAX_VALUE;
        int sum = 0;

        // hiring ---> high ke taraf se
        // firing ---> low ke taraf se

        while(high < nums.length){
            sum = sum + nums[high];


            // jab tk kaam ho rha h...
            while(sum >= target){ // kaam ho rha h....
                int length = high - low + 1;
                result = Math.min(result,length);

                // now fire kro
                sum = sum - nums[low];
                low++;
            }
            high++;
        }
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target,nums));
    }
}
