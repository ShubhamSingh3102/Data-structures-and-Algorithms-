package LeetCode_DPQ;
public class Maximum_Fruits_Harvested_LeetCode_2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;

        // Create arrays to hold positions and prefix sums
        int[] positions = new int[n];
        int[] prefixSum = new int[n];

        for (int i = 0; i < n; i++) {
            positions[i] = fruits[i][0];
            prefixSum[i] = fruits[i][1] + (i > 0 ? prefixSum[i - 1] : 0);
        }

        int maxFruits = 0;

        // Try all left distances d
        for (int d = 0; d <= k / 2; d++) {
            int remain = k - 2 * d;
            int left = startPos - d;
            int right = startPos + remain;

            int l = lowerBound(positions, left);
            int r = upperBound(positions, right) - 1;

            if (l <= r) {
                maxFruits = Math.max(maxFruits, prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0));
            }
        }

        // Try all right distances d
        for (int d = 0; d <= k / 2; d++) {
            int remain = k - 2 * d;
            int left = startPos - remain;
            int right = startPos + d;

            int l = lowerBound(positions, left);
            int r = upperBound(positions, right) - 1;

            if (l <= r) {
                maxFruits = Math.max(maxFruits, prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0));
            }
        }

        return maxFruits;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public static void main(String[] args) {
        Maximum_Fruits_Harvested_LeetCode_2106 obj = new Maximum_Fruits_Harvested_LeetCode_2106();

        int[][] fruits = {
                {2, 4},
                {4, 3},
                {6, 1},
                {8, 6}
        };
        int startPos = 5;
        int k = 4;

        int result = obj.maxTotalFruits(fruits, startPos, k);
        System.out.println("Maximum fruits harvested = " + result);  // Expected: 7
    }
}
