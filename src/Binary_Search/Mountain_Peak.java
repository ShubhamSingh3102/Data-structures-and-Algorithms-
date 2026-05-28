//package Binary_Search;
//import java.util.*;
//public class Mountain_Peak {
//    public static int MountainPeak(int[] nums){
//        int low = nums[0];
//
//        for(int i = 1; i < nums.length; i++){
//            int high = nums[i];
//            if(low < high){
//                low ++;
//                high ++;
//            } else {
//                return low;
//            }
//        }
//        return low;
//    }
//    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,4,3,2,1};
//        System.out.println(MountainPeak(nums));
//    }
//}

















//package Binary_Search;
//import java.util.*;
//public class Mountain_Peak {
//    public static int MountainPeak(int[] nums){
//        int low = 0;
//
//        for(int i = 1; i < nums.length; i++){
//            int high = i;
//            if(nums[low] < nums[high]){
//                low ++;
//                high ++;
//            } else {
//                return low;
//            }
//        }
//        return low;
//    }
//    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,4,3,2,1};
//        System.out.println(MountainPeak(nums));
//    }
//}


















package Binary_Search;
import java.util.*;
public class Mountain_Peak {
    public static int MountainPeak(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,4,3,2,1};
        System.out.println(MountainPeak(nums));
    }
}
