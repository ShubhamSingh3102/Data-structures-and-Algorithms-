package Graph;
import java.util.*;
public class Shortest_Path_in_a_Binary_Maze_LeetCode_1091 {
    static class tuple {
        int first,second,third;
        tuple(int _first,int _second, int _third){
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }
    int shortestPath(int[][] grid,int[] source,int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        Queue<tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]] = 0; // src node
        q.add(new tuple(0,source[0],source[1]));
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};

        // n*m
        while (!q.isEmpty()) {
            tuple it = q.peek();
            q.remove();
            int dis = it.first;
            int row = it.second;
            int col = it.third;

            // 4 direction.....
            for(int i=0;i<4;i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];

                if(newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis;
                    if(newr == destination[0] && newc == destination[1]) {
                        return dis + 1;
                    }
                    q.add(new tuple(1+dis,newr,newc));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Shortest_Path_in_a_Binary_Maze_LeetCode_1091 obj = new Shortest_Path_in_a_Binary_Maze_LeetCode_1091();

        int[][] grid = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int[] source = {0, 0};
        int[] destination = {2, 3};

        int ans = obj.shortestPath(grid, source, destination);
        System.out.println("Shortest path length: " + ans);
    }
}
