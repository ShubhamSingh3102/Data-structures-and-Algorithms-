//package ARRAY;
//import java.util.*;
//public class Two_Sum {
//    // Brute force....
//    // TC --> O(n^2)
//    public static int[] twoSum(int[] nums, int target){
//        int n = nums.length;
//        for(int i = 0; i < n; i++){
//            for(int j = i + 1; j < n; j++){
//                if(nums[i] + nums[j] == target){
//                    return new int[] {i,j};
//                }
//            }
//        }
//        return new int[]{-1,-1}; // if no solution....
//    }
//    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9;
//        System.out.println(Arrays.toString(twoSum(nums, target)));
//    }
//}
//

// Two-pointer → needs sorted array → O(n log n) + O(n)



















package ARRAY;
import java.util.*;
public class Two_Sum {
    // Hashmap
    // TC --> O(n)
    // SC --> O(n)
    public static int[] twoSum(int[] nums, int target){
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n ; i++){
            int pair = target - nums[i]; // pair khojo iska...agar mil gya then aacha h...

            if(map.containsKey(pair)){
                return new int[]{map.get(pair), i};
            }
            // if not present in map put the element in map...
            map.put(nums[i],i);
        }
        // if no solution then
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

