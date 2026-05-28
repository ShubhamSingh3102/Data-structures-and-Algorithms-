//package ARRAY;
//import java.util.*;
//public class Dutch_National_flag {
//    public static List<Integer> dutchNationalFlag(int[] nums){
//        // In - Place
//        // Optimised
//        // TC --> O(n)
//        // SC --> O(1)
//        // 2 passes
//        int zeroes = 0;
//        int ones = 0;
//        int twos = 0;
//
//        // count
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == 0){
//                zeroes++;
//            } else if(nums[i] == 1){
//                ones++;
//            } else {
//                twos++;
//            }
//        }
//
//        // fill array
//        int i = 0;
//        while(zeroes-- > 0){
//            nums[i++] = 0;
//        }
//        while(ones-- > 0){
//            nums[i++] = 1;
//        }
//        while(twos-- > 0){
//            nums[i++] = 2;
//        }
//
//        // convert to list
//        List<Integer> res = new ArrayList<>();
//        for(int x: nums){
//            res.add(x);
//        }
//        return res;
//    }
//    public static void main(String[] args) {
//        int[] nums = {0,1,1,2,0,2,1,2,0};
//        System.out.println(dutchNationalFlag(nums));
//    }
//}











package ARRAY;
import java.util.*;
public class Dutch_National_flag {
    public static List<Integer> dutchNationalFlag(int[] nums){
        // In - Place
        // Optimised (Dutch National Flag Approach)
        // TC --> O(n)
        // SC --> O(1)
        // 1 passes
        int n = nums.length;

        int low = 0;
        int mid = 0;
        int high = n - 1;


        // Problematic area [ mid  --> high ]
        // sort problematic area mid to high - 1;
        while(mid <= high){
            if(nums[mid] == 0){ // low se sirf 1 aaega...
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){ // Best case 1 hi chahiye...
                mid++;
            }
            else {  // kuch bhi aa skta hai...  nums[mid] == 2
                swap(nums,mid,high);
                high--; // problematic area...  // mid nahi badhega yahan
            }
        }
        // convert to list
        List<Integer> res = new ArrayList<>();
        for(int x : nums) {
            res.add(x);
        }
        return res;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,1,2,0,2,1,2,0};
        System.out.println(dutchNationalFlag(nums));
    }
}
