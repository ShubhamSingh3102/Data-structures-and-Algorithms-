//package LeetCode_DPQ;
//import java.util.*;
//public class N_Repeated_Element_in_size_2N_Array_LeetCode_961 {
//    public static int repeatedNTimes(int[] nums){
//        int n = nums.length;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                if(nums[i] == nums[j]){
//                    return nums[i];
//                }
//            }
//        }
//        return -1;
//    }
//    public static void main(String[] args) {
//        int[] nums = {1,2,3,3};
//        System.out.println(repeatedNTimes(nums));
//    }
//}
















package LeetCode_DPQ;
import java.util.*;
public class N_Repeated_Element_in_size_2N_Array_LeetCode_961 {
    public static int repeatedNTimes(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        System.out.println(repeatedNTimes(nums));
    }
}
