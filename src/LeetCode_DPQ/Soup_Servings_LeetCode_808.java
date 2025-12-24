package LeetCode_DPQ;
import java.util.*;
// You have two soups, A and B, each starting with n mL. On every turn, one of the following four serving operations is chosen at random, each with probability 0.25 independent of all previous turns:
//
//pour 100 mL from type A and 0 mL from type B
//pour 75 mL from type A and 25 mL from type B
//pour 50 mL from type A and 50 mL from type B
//pour 25 mL from type A and 75 mL from type B
//Note:
//
//There is no operation that pours 0 mL from A and 100 mL from B.
//The amounts from A and B are poured simultaneously during the turn.
//If an operation asks you to pour more than you have left of a soup, pour all that remains of that soup.
//The process stops immediately after any turn in which one of the soups is used up.
//
//Return the probability that A is used up before B, plus half the probability that both soups are used up in the same turn. Answers within 10-5 of the actual answer will be accepted.
//
//
//
//Example 1:
//
//Input: n = 50
//Output: 0.62500
//Explanation:
//If we perform either of the first two serving operations, soup A will become empty first.
//If we perform the third operation, A and B will become empty at the same time.
//If we perform the fourth operation, B will become empty first.
//So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
//Example 2:
//
//Input: n = 100
//Output: 0.71875
//Explanation:
//If we perform the first serving operation, soup A will become empty first.
//If we perform the second serving operations, A will become empty on performing operation [1, 2, 3], and both A and B become empty on performing operation 4.
//If we perform the third operation, A will become empty on performing operation [1, 2], and both A and B become empty on performing operation 3.
//If we perform the fourth operation, A will become empty on performing operation 1, and both A and B become empty on performing operation 2.
//So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.71875.
//
//
//Constraints:
//
//0 <= n <= 109
public class Soup_Servings_LeetCode_808 {
    // Serving operations: {A taken, B taken}
        private static int[][] serves = {
                {4, 0},  // 100 ml
                {3, 1},  // 75, 25 ml
                {2, 2},  // 50, 50 ml
                {1, 3}   // 25, 75 ml
        };

        private double[][] memo;

        private double solve(int A, int B) {
            if (A <= 0 && B <= 0) return 0.5;
            if (A <= 0) return 1.0;
            if (B <= 0) return 0.0;

            if (memo[A][B] != -1.0) return memo[A][B];

            double prob = 0.0;
            for (int[] p : serves) {
                prob += solve(A - p[0], B - p[1]);
            }

            memo[A][B] = 0.25 * prob;
            return memo[A][B];
        }

        public double soupServings(int n) {
            // Optimization: For large n, probability tends to 1
            if (n >= 4800) return 1.0;

            int units = (n + 24) / 25; // Convert to 25 ml units
            memo = new double[units + 1][units + 1];
            for (int i = 0; i <= units; i++) {
                Arrays.fill(memo[i], -1.0);
            }

            return solve(units, units);
        }

        public static void main(String[] args) {
            Soup_Servings_LeetCode_808 obj = new Soup_Servings_LeetCode_808();
            System.out.println(obj.soupServings(50));   // 0.625
            System.out.println(obj.soupServings(100));  // 0.71875
        }
    }
