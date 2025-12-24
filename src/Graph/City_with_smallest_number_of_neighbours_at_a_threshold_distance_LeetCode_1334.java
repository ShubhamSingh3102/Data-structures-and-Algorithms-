package Graph;
import java.util.*;
public class City_with_smallest_number_of_neighbours_at_a_threshold_distance_LeetCode_1334 {
    static class Solution {
        int findCity(int n, int m, int edges[][], int distanceThreshold) {
            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            // Fill Direct Edges
            for (int i = 0; i < m; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                dist[u][v] = wt;
                dist[v][u] = wt;
            }

            for (int i = 0; i < n; i++) {
                dist[i][i] = 0;
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        // Skip if any of the paths are unreachable
                        if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                            continue;
                        }
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            int cntCity = n;
            int cityNo = -1; // store city index
            for (int city = 0; city < n; city++) {
                int cnt = 0;
                for (int adjCity = 0; adjCity < n; adjCity++) {
                    if (dist[city][adjCity] <= distanceThreshold) {
                        cnt++;
                    }
                }
                if (cnt <= cntCity) {
                    cntCity = cnt;
                    cityNo = city;
                }
            }
            return cityNo;
        }
    }
    public static void main(String[] args) {

        int n = 4; // number of cities
        int m = 4; // number of edges

        int[][] edges = {
                {0, 1, 3},
                {1, 2, 1},
                {2, 3, 4},
                {0, 3, 2}
        };

        int distanceThreshold = 4;

        Solution obj = new Solution();
        int ans = obj.findCity(n, m, edges, distanceThreshold);

        System.out.println("City with smallest number of reachable neighbours: " + ans);
    }
}
