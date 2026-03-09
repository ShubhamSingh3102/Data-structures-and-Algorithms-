//package LeetCode_DPQ;
//import java.util.*;
//public class Find_unique_Binary_String_LeetCode_1980 {
//    public static String findDifferentBinaryString(String[] nums){
//        // Approach 1
//        HashSet<Integer> set = new HashSet<>();
//
//        // convert String Binary to number...
//        for(String num: nums){
//            set.add(Integer.parseInt(num,2));
//        }
//
//        int n = nums.length;
//
//        String result = "";
//
//        for(int number = 0; number <= n ; number++){
//            if(!set.contains(number)){
//                result = Integer.toBinaryString(number);
//
//                while(result.length() < n) {  //to make till length n
//                    result = "0" + result;
//                }
//                return result;
//            }
//        }
//        return "";
//    }
//    public static void main(String[] args) {
//        String[] nums = {"01","10"};
//        System.out.println(findDifferentBinaryString(nums));
//    }
//}
//
//














package LeetCode_DPQ;
import java.util.*;
public class Find_unique_Binary_String_LeetCode_1980 {
    public static String findDifferentBinaryString(String[] nums){
        // Approach 2
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String[] nums = {"01","10"};
        System.out.println(findDifferentBinaryString(nums));
    }
}

