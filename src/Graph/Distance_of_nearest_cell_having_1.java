package Graph;
import java.util.*;
public class Distance_of_nearest_cell_having_1 {
    static class Node {
        int first;
        int second;
        int third;

        Node(int first,int second,int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    static class Solution {
        // Function to find distance of nearest 1 in the grid for each cell...

        public int[][] nearest(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int vis[][] = new int[n][m];
            int dis[][] = new int[n][m];
            Queue<Node> q = new LinkedList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j] == 1) {
                        q.add(new Node(i,j,0));
                        vis[i][j] = 1;
                    }
                    else {
                        vis[i][j] = 0;
                    }
                }
            }

            int delrow[] = {-1,0,+1,0};
            int delcol[] = {0,+1,0,-1};

            // n*m*4
            while(!q.isEmpty()) {
                int row = q.peek().first;
                int col = q.peek().second;
                int steps = q.peek().third;
                q.remove();
                dis[row][col] = steps;

                // traverse in four direction....
                for(int i=0;i<4;i++){
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.add(new Node(nrow,ncol,steps+1));
                    }
                }
            }
            return dis;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 1}
        };

        Solution sol = new Solution();
        int[][] ans = sol.nearest(grid);

        System.out.println("Distance matrix:");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
