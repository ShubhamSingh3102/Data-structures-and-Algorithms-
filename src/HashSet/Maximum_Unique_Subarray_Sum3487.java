package HashSet;
import java.util.*;
public class Maximum_Unique_Subarray_Sum3487 {
    public static int maxSum(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int sum = 0;
        int maxNeg = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num <= 0) {
                maxNeg = Math.max(maxNeg, num);
            } else if (!st.contains(num)) {
                sum += num;
                st.add(num);
            }
        }

        return sum == 0 ? maxNeg : sum;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {-1,3,4,-4,5,-5};
        System.out.println("Maximum Unique Subarray Sum: " + maxSum(nums));
    }
}
