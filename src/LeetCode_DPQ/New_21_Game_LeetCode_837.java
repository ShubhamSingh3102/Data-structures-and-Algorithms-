package LeetCode_DPQ;
import java.util.*;
// Alice plays the following game, loosely based on the card game "21".
//
//Alice starts with 0 points and draws numbers while she has less than k points. During each draw, she gains an integer number of points randomly from the range [1, maxPts], where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.
//
//Alice stops drawing numbers when she gets k or more points.
//
//Return the probability that Alice has n or fewer points.
//
//Answers within 10-5 of the actual answer are considered accepted.
//
//
//
//Example 1:
//
//Input: n = 10, k = 1, maxPts = 10
//Output: 1.00000
//Explanation: Alice gets a single card, then stops.
//Example 2:
//
//Input: n = 6, k = 1, maxPts = 10
//Output: 0.60000
//Explanation: Alice gets a single card, then stops.
//In 6 out of 10 possibilities, she is at or below 6 points.
//Example 3:
//
//Input: n = 21, k = 17, maxPts = 10
//Output: 0.73278
//
//
//Constraints:
//
//0 <= k <= n <= 104
//1 <= maxPts <= 104



// Approach 1--->Brute force approach...
// Time complexity-->O(n*maxpts)
//public class New_21_Game_LeetCode_837 {
//        public double new21Game(int n, int k, int maxPts) {
//            double[] P = new double[n + 1];
//            P[0] = 1.0; // base case
//
//            for (int i = 1; i <= n; i++) {
//                for (int card = 1; card <= maxPts; card++) {
//                    if (i - card >= 0 && i - card < k) {
//                        P[i] += P[i - card] / maxPts;
//                    }
//                }
//            }
//
//            double ans = 0.0;
//            for (int i = k; i <= n; i++) {
//                ans += P[i];
//            }
//            return ans;
//        }
//    public static void main(String[] args) {
//        New_21_Game_LeetCode_837 obj = new New_21_Game_LeetCode_837();
//
//        // Example test cases
//        int n = 21, k = 17, maxPts = 10;
//        double result = obj.new21Game(n, k, maxPts);
//        System.out.println("Probability: " + result);
//
//        // Another test
//        System.out.println("Probability: " + obj.new21Game(6, 1, 10));
//        System.out.println("Probability: " + obj.new21Game(10, 1, 10));
//    }
//}


// Approach 2-->Optimised approach(sliding window sum)

public class New_21_Game_LeetCode_837 {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n + 1];
        P[0] = 1.0;

        double currProbSum = (k == 0) ? 0.0 : 1.0;
        // same as: double currProbSum = (k == 0 ? 0 : 1);

        for (int i = 1; i <= n; i++) {
            P[i] = currProbSum / maxPts;

            if (i < k) {
                currProbSum += P[i];
            }

            if (i - maxPts >= 0 && i - maxPts < k) {
                currProbSum -= P[i - maxPts];
            }
        }

        double result = 0.0;
        for (int i = k; i <= n; i++) {
            result += P[i];
        }
        return result;
    }

    public static void main(String[] args) {
        New_21_Game_LeetCode_837 obj = new New_21_Game_LeetCode_837();

        // Example test cases
        System.out.println(obj.new21Game(21, 17, 10)); // Expected ~0.73278
        System.out.println(obj.new21Game(6, 1, 10));   // Expected 0.6
        System.out.println(obj.new21Game(10, 1, 10));  // Expected 1.0
    }
}
