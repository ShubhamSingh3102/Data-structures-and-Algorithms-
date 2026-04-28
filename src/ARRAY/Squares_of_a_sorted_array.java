//package ARRAY;
//import java.util.*;
//public class Squares_of_a_sorted_array {
//    public static int[] sortedSquares(int[] nums){
//        // Brute force...
//        // TC --> O(n * log n)
//        int n = nums.length;
//        int[] res = new int[n];
//
//        for(int i = 0; i < n ; i++){
//            res[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(res);
//        return res;
//    }
//    public static void main(String[] args) {
//        int[] nums = {-4,-1,0,3,10};
//        System.out.println(Arrays.toString(sortedSquares(nums)));
//    }
//}



















package ARRAY;
import java.util.*;
public class Squares_of_a_sorted_array {
    public static int[] sortedSquares(int[] nums){
        // TC --> O(n)
        // SC --> O(n)
        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n - 1;
        int k = n - 1;

        while(left <= right){
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];

            if(l > r){
                res[k--] = l;
                left++;
            } else {
                res[k--] = r;
                right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
