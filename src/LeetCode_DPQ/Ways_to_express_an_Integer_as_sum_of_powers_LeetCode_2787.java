package LeetCode_DPQ;
// Given two positive integers n and x.
//
//Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.
//
//Since the result can be very large, return it modulo 109 + 7.
//
//For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.
//
//
//
//Example 1:
//
//Input: n = 10, x = 2
//Output: 1
//Explanation: We can express n as the following: n = 32 + 12 = 10.
//It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.
//Example 2:
//
//Input: n = 4, x = 1
//Output: 2
//Explanation: We can express n in the following ways:
//- n = 41 = 4.
//- n = 31 + 11 = 4.
//
//
//Constraints:
//
//1 <= n <= 300
//1 <= x <= 5
public class Ways_to_express_an_Integer_as_sum_of_powers_LeetCode_2787 {
    final int M = 1_000_000_007;
    int[][] t = new int[301][301];

    public int numberOfWays(int n, int x) {
        // Initialize memo table with -1
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                t[i][j] = -1;
            }
        }
        return solve(n, 1, x);
    }

    private int solve(int n, int num, int x) {
        // Base cases
        if (n == 0) return 1;
        if (n < 0) return 0;

        int currPowerValue = intPow(num, x);
        if (currPowerValue > n) return 0;

        if (t[n][num] != -1) return t[n][num];

        // Take current number or skip it
        int take = solve(n - currPowerValue, num + 1, x);
        int skip = solve(n, num + 1, x);

        return t[n][num] = (int) ((take + skip) % M);
    }

    // Safe integer power calculation to avoid floating-point issues
    private int intPow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Ways_to_express_an_Integer_as_sum_of_powers_LeetCode_2787 obj =
                new Ways_to_express_an_Integer_as_sum_of_powers_LeetCode_2787();

        int n = 10, x = 2;
        System.out.println("Number of ways: " + obj.numberOfWays(n, x));
    }
}
