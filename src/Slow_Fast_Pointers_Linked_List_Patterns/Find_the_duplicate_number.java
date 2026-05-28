package Slow_Fast_Pointers_Linked_List_Patterns;
import java.util.*;
public class Find_the_duplicate_number {
    public static int findDuplicate(int[] nums){
        // jispe bhi 2 arrow jayega na wahi jimmedar hoga cycle banane me...and wahi repeated element hoga...(starting point)
        // cycle find kro and cycle ka starting point khojo..
        int slow = 0;
        int fast = 0;

        // detect cycle
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if(slow == fast){
                slow = 0;

                while(slow != fast){
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
