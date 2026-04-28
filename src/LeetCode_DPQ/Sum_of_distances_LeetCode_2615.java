//package LeetCode_DPQ;
//import java.util.*;
//public class Sum_of_distances_LeetCode_2615 {
//    public static long[] distance(int[] nums){
//        long[] ans = new long[nums.length];
//        for(int i = 0; i < nums.length; i++){
//            long sum = 0;
//            for(int j = 0; j < nums.length; j++){
//                if(nums[i] == nums[j]){
//                    sum += Math.abs(i-j);
//                }
//            }
//            ans[i] = sum;
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        int[] nums = {1,3,1,1,2};
//        System.out.println(Arrays.toString(distance(nums)));
//    }
//}


















package LeetCode_DPQ;
import java.util.*;
public class Sum_of_distances_LeetCode_2615 {
    public static long[] distance(int[] nums){
        int n = nums.length;

        long[] arr = new long[n];

        Map<Integer,Long> indexSum = new HashMap<>();    // sum of indices seen.....
        Map<Integer,Long> indexCount = new HashMap<>();  // how many times seen....

        // Left to Right --> Left Hand
        for(int i = 0; i < n ; i++){
            long freq = indexCount.getOrDefault(nums[i],0L);
            long sum = indexSum.getOrDefault(nums[i],0L);

            arr[i] += (freq * i) - sum;

            indexCount.put(nums[i],freq + 1);
            indexSum.put(nums[i], sum + i);
        }

        // Left pass data will mix with right pass.....
        indexSum.clear();
        indexCount.clear();


        // Right to Left  --> Right Hand
        for (int i = n - 1; i >= 0; i--) {
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum  = indexSum.getOrDefault(nums[i], 0L);

            arr[i] += sum - (freq * i);

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,1,1,2};
        System.out.println(Arrays.toString(distance(nums)));
    }
}
