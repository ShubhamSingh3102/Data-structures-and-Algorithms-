package Graph;
import java.util.*;
public class Number_of_enclaves_LeetCode_1020 {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Solution {
        int numberOfEnclaves(int[][] grid) {
            Queue<Pair> q = new LinkedList<>();
            int n = grid.length;
            int m = grid[0].length;
            int vis[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // first row,first col,last row,last col
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        if (grid[i][j] == 1) {
                            q.add(new Pair(i, j));
                            vis[i][j] = 1;
                        }
                    }
                }
            }
            int delrow[] = {-1, 0, +1, 0};
            int delcol[] = {0, +1, 0, -1};

            while (!q.isEmpty()) {
                int row = q.peek().first;
                int col = q.peek().second;
                q.remove();

                // traverse all 4 direction
                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                        q.add(new Pair(nrow, ncol));
                        vis[nrow][ncol] = 1;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1 && vis[i][j] == 0) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        // Sample grid: 0 = sea , 1 = land
        int[][] grid = {
                {0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        // Create outer class instance
        Number_of_enclaves_LeetCode_1020 outer = new Number_of_enclaves_LeetCode_1020();

        // Create inner Solution class instance
        Solution sol = outer.new Solution();

        // Call numberOfEnclaves and print result
        int result = sol.numberOfEnclaves(grid);
        System.out.println("Number of Enclaves: " + result);
    }
}
