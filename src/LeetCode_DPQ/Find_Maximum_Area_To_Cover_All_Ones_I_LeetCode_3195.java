package LeetCode_DPQ;
import java.util.*;
public class Find_Maximum_Area_To_Cover_All_Ones_I_LeetCode_3195 {
    public int minimumArea(int[][] grid) {
        int m = grid.length;       // rows
        int n = grid[0].length;    // columns

        int minRow = m, maxRow = -1;
        int minCol = n, maxCol = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        // If no '1' found, area = 0
        if (maxRow == -1) return 0;

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    public static void main(String[] args) {
        Find_Maximum_Area_To_Cover_All_Ones_I_LeetCode_3195 obj =
                new Find_Maximum_Area_To_Cover_All_Ones_I_LeetCode_3195();

        // Test 1
        int[][] grid1 = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        System.out.println("Output 1: " + obj.minimumArea(grid1));  // Expected 9

        // Test 2
        int[][] grid2 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Output 2: " + obj.minimumArea(grid2));  // Expected 1

        // Test 3
        int[][] grid3 = {
                {0, 0},
                {0, 0}
        };
        System.out.println("Output 3: " + obj.minimumArea(grid3));  // Expected 0 (no 1's)
    }
}
