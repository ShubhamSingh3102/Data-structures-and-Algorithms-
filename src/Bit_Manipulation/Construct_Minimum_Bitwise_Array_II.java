package Bit_Manipulation;
import java.util.*;
public class Construct_Minimum_Bitwise_Array_II {
    public static int[] minBitwiseArray(List<Integer> nums){
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int target = nums.get(i);


            if (target == 2) {
                result[i] = -1;
                continue;
            }

            boolean found = false;

            // Try all bit positions
            for (int j = 0; j < 32; j++) {
                // If j-th bit is NOT set
                if ((target & (1 << j)) == 0) {
                    int x = target ^ (1 << (j - 1)); // flip previous bit
                    result[i] = x;
                    found = true;
                    break;
                }
            }

            if (!found) {
                result[i] = -1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,3,5,7);
        System.out.println(Arrays.toString(minBitwiseArray(nums)));
    }
}
