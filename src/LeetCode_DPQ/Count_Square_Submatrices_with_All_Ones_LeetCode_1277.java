//package LeetCode_DPQ;
//import java.util.*;
//// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
////
////
////
////Example 1:
////
////Input: matrix =
////[
////  [0,1,1,1],
////  [1,1,1,1],
////  [0,1,1,1]
////]
////Output: 15
////Explanation:
////There are 10 squares of side 1.
////There are 4 squares of side 2.
////There is  1 square of side 3.
////Total number of squares = 10 + 4 + 1 = 15.
////Example 2:
////
////Input: matrix =
////[
////  [1,0,1],
////  [1,1,0],
////  [1,1,0]
////]
////Output: 7
////Explanation:
////There are 6 squares of side 1.
////There is 1 square of side 2.
////Total number of squares = 6 + 1 = 7.
////
////
////Constraints:
////
////1 <= arr.length <= 300
////1 <= arr[0].length <= 300
////0 <= arr[i][j] <= 1
//public class Count_Square_Submatrices_with_All_Ones_LeetCode_1277 {
//    public int countSquares(int[][] arr) {
//        int n = arr.length;
//        int m = arr[0].length;
//
//        int[][] dp = new int[n][m];
//
//        // First row
//        for (int j = 0; j < m; j++) {
//            dp[0][j] = arr[0][j];
//        }
//
//        // First column
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = arr[i][0];
//        }
//
//        // Fill dp table
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                if (arr[i][j] == 0) {
//                    dp[i][j] = 0;
//                } else {
//                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
//                            Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
//                }
//            }
//        }
//
//        // Count total squares
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                sum += dp[i][j];
//            }
//        }
//
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        Count_Square_Submatrices_with_All_Ones_LeetCode_1277 solver =
//                new Count_Square_Submatrices_with_All_Ones_LeetCode_1277();
//
//        int[][] matrix1 = {
//                {0, 1, 1, 1},
//                {1, 1, 1, 1},
//                {0, 1, 1, 1}
//        };
//        System.out.println("Output 1: " + solver.countSquares(matrix1)); // Expected 15
//
//        int[][] matrix2 = {
//                {1, 0, 1},
//                {1, 1, 0},
//                {1, 1, 0}
//        };
//        System.out.println("Output 2: " + solver.countSquares(matrix2)); // Expected 7
//    }
//}








































package LeetCode_DPQ;
import java.util.*;
// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
//
//
//
//Example 1:
//
//Input: matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
//Output: 15
//Explanation:
//There are 10 squares of side 1.
//There are 4 squares of side 2.
//There is  1 square of side 3.
//Total number of squares = 10 + 4 + 1 = 15.
//Example 2:
//
//Input: matrix =
//[
//  [1,0,1],
//  [1,1,0],
//  [1,1,0]
//]
//Output: 7
//Explanation:
//There are 6 squares of side 1.
//There is 1 square of side 2.
//Total number of squares = 6 + 1 = 7.
//
//
//Constraints:
//
//1 <= arr.length <= 300
//1 <= arr[0].length <= 300
//0 <= arr[i][j] <= 1
public class Count_Square_Submatrices_with_All_Ones_LeetCode_1277 {
    public int countSquares(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] dp = new int[n][m];

        // First row
        for (int j = 0; j < m; j++) {
            dp[0][j] = arr[0][j];
        }

        // First column
        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
        }

        // Fill dp table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        // Count total squares
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += dp[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Count_Square_Submatrices_with_All_Ones_LeetCode_1277 solver =
                new Count_Square_Submatrices_with_All_Ones_LeetCode_1277();

        int[][] matrix1 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println("Output 1: " + solver.countSquares(matrix1)); // Expected 15

        int[][] matrix2 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println("Output 2: " + solver.countSquares(matrix2)); // Expected 7
    }
}

