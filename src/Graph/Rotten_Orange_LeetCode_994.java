package Graph;
import java.util.*;
public class Rotten_Orange_LeetCode_994 {
    static class  Pair {
        int row;
        int col;
        int tm;
        public Pair(int row,int col,int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
    static class Solution{
        public int orangesRotting(int[][] grid){
            int n = grid.length;
            int m = grid[0].length;

            // n * m
            Queue<Pair> q = new LinkedList<>();
            int[][] vis = new int[n][m];
            int cntFresh = 0;

            for(int i=0;i<n;i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        q.add(new Pair(i, j, 0));
                        vis[i][j] = 2;
                    } else {
                        vis[i][j] = 0;
                    }
                    if (grid[i][j] == 1) {
                        cntFresh++;
                    }
                }
            }
                int tm = 0;
                int drow[] = {-1,0,+1,0};
                int dcol[] = {0,1,0,-1};
                int cnt = 0;
                while (!q.isEmpty()) {
                    int r = q.peek().row;
                    int c = q.peek().col;
                    int t = q.peek().tm;
                    tm = Math.max(tm,t);
                    q.remove();
                    for(int a=0;a<4;a++){
                        int nrow = r + drow[a];
                        int ncol = c + dcol[a];
                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                            q.add(new Pair(nrow,ncol,t+1));
                            vis[nrow][ncol] = 2;
                            cnt++;
                        }
                    }
                }
                if(cnt != cntFresh){
                    return -1;
                }
                return tm;
            }
        }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
                {0, 1, 2},
                {0, 1, 1},
                {2, 1, 1}
        };

        int ans = sol.orangesRotting(grid);
        System.out.println("Minimum time to rot all oranges: " + ans);
    }
}
