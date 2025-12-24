package LeetCode_DPQ;
import java.util.*;
// Given an m x n binary matrix mat, return the number of submatrices that have all ones.
//
//
//
//Example 1:
//
//
//Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
//Output: 13
//Explanation:
//There are 6 rectangles of side 1x1.
//There are 2 rectangles of side 1x2.
//There are 3 rectangles of side 2x1.
//There is 1 rectangle of side 2x2.
//There is 1 rectangle of side 3x1.
//Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
//Example 2:
//
//
//Input: mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
//Output: 24
//Explanation:
//There are 8 rectangles of side 1x1.
//There are 5 rectangles of side 1x2.
//There are 2 rectangles of side 1x3.
//There are 4 rectangles of side 2x1.
//There are 2 rectangles of side 2x2.
//There are 2 rectangles of side 3x1.
//There is 1 rectangle of side 3x2.
//Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
//
//
//Constraints:
//
//1 <= m, n <= 150
//mat[i][j] is either 0 or 1.
public class Count_Submatrices_with_All_Ones_LeetCode_1504 {
    // Function to count subarrays with all ones in a given row segment
    private int oneDArrayCount(int[] vec) {
        int cons = 0;   // consecutive ones count
        int subCount = 0;

        for (int val : vec) {
            if (val == 0) {
                cons = 0;
            } else {
                cons++;
            }
            subCount += cons;
        }

        return subCount;
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;

        for (int startRow = 0; startRow < m; startRow++) {
            // Initialize an array filled with 1s
            int[] vec = new int[n];
            Arrays.fill(vec, 1);

            for (int endRow = startRow; endRow < m; endRow++) {
                // Update vec with AND operation
                for (int col = 0; col < n; col++) {
                    vec[col] = vec[col] & mat[endRow][col];
                }

                // Count subarrays with all ones in this row window
                result += oneDArrayCount(vec);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Count_Submatrices_with_All_Ones_LeetCode_1504 sol = new Count_Submatrices_with_All_Ones_LeetCode_1504();

        int[][] mat1 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println("Output 1: " + sol.numSubmat(mat1)); // Expected: 13

        int[][] mat2 = {
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}
        };
        System.out.println("Output 2: " + sol.numSubmat(mat2)); // Expected: 24
    }
}
