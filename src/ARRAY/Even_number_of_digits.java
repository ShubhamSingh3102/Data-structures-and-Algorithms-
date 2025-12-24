package ARRAY;
import java.util.*;
public class Even_number_of_digits {
    static int findNumber(int[] nums) {
        int Count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitCount = 0;

            // for edge case
            if (num == 0) {
                digitCount = 1;
            } else {
                // for counting digits
                while (num != 0) {
                    digitCount++;
                    num /= 10;
                }
            }
            if (digitCount % 2 == 0) {
                Count++;
            }
        }
        return Count;
    }
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumber(nums));
    }
}
