package Dynamic_Programming;
import java.util.*;
public class Frog_Jump_with_K_distance {
    /// / Tabulation....
    static int frogJumpK(int n, int k, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stones: ");
        int n = sc.nextInt();

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        int[] heights = new int[n];
        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int result = frogJumpK(n, k, heights);
        System.out.println("Minimum energy required: " + result);
    }
}
