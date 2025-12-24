package Graph;

public class Flood_Fill_Algorithm_LeetCode_733 {

    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor,
                     int[] delRow, int[] delCol, int iniColor) {
        // Change color
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            // Valid cell and same initial color but not already colored
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];
        int[][] ans = image;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        Flood_Fill_Algorithm_LeetCode_733 sol = new Flood_Fill_Algorithm_LeetCode_733();

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = sol.floodFill(image, sr, sc, newColor);

        // Print result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
