package ARRAY;
import java.util.*;
public class Remove_duplicates_from_sorted_array {
    // 2 pointer because of
    // array,sorted,removeDuplicate,inplace(no space)
    public static int removeDuplicates(int[] nums){
        // TC --> O(n)
        // SC --> O(1)
        if(nums.length == 0) {
            return 0;
        }

        int i = 0; // officer
        int unique = 1; // count
        int j = 1; // cm

        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++; // skip duplicate
            } else {
                nums[i+1] = nums[j];
                i++;
                unique++;
                j++;
            }
        }
        return unique;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
