package LeetCode_DPQ;
import java.util.*;

public class Range_Product_Queries_of_Powers_LeetCode_2438 {
    public int M = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Build powers array
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) { // ith bit is set
                powers.add(1 << i);
            }
        }

        // Process each query
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            long product = 1;

            for (int i = start; i <= end; i++) {
                product = (product * powers.get(i)) % M;
            }

            result.add((int) product);
        }

        // Convert List<Integer> to int[]
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Range_Product_Queries_of_Powers_LeetCode_2438 obj = new Range_Product_Queries_of_Powers_LeetCode_2438();

        // Example test
        int n = 15; // Binary: 1111 => powers = [1, 2, 4, 8]
        int[][] queries = {
                {0, 1}, // 1*2 = 2
                {2, 3}, // 4*8 = 32
                {0, 3}  // 1*2*4*8 = 64
        };

        int[] ans = obj.productQueries(n, queries);

        System.out.println(Arrays.toString(ans)); // Output: [2, 32, 64]
    }
}
