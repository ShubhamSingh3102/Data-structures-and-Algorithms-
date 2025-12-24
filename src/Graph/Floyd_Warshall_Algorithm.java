package Graph;
import java.util.*;
public class Floyd_Warshall_Algorithm {
    static class Solution {
        public void shortest_distance(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == -1) { // not reachable...
                        matrix[i][j] = (int) (1e9);
                    }
                    if (i == j) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }

            // To convert all unreachable distances (∞) back to -1,
            // because the final answer must use -1 for unreachable paths.....
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == (int) (1e9)) {
                        matrix[i][j] = -1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

        // Example adjacency matrix
        // -1 means there is NO DIRECT EDGE
        int[][] matrix = {
                {0, 3, -1, 7},
                {-1, 0, 2, -1},
                {-1, -1, 0, 1},
                {6, -1, -1, 0}
        };

        Solution obj = new Solution();
        obj.shortest_distance(matrix);

        // Print result
        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
