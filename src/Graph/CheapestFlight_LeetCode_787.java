package Graph;
import java.util.*;
public class CheapestFlight_LeetCode_787 {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple {
        int first, second, third;

        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    static class Solution {
        public int CheapestFlight(int n, int flights[][], int src, int dst, int K) {
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());

            // building graph....
            int m = flights.length;
            for (int i = 0; i < m; i++) {
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }

            Queue<Tuple> q = new LinkedList<>();
            int[] dist = new int[n];
            Arrays.fill(dist, (int) 1e9);
            q.add(new Tuple(0, src, 0));
            dist[src] = 0;

            // TC --> E --> flights.size()
            // SC --> O(V+E)
            while (!q.isEmpty()) {
                Tuple it = q.peek();
                q.remove();
                int stops = it.first;
                int node = it.second;
                int cost = it.third;

                if (stops > K) continue;

                for (Pair iter : adj.get(node)) {
                    int adjNode = iter.first;
                    int edW = iter.second;

                    if (dist[node] + edW < dist[adjNode] && stops <= K) {
                        dist[adjNode] = cost + edW;
                        q.add(new Tuple(stops + 1, adjNode, cost + edW));
                    }
                }
            }
            if (dist[dst] == (int) 1e9) return -1;
            return dist[dst];
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        // Example test case
        int n = 4;
        int flights[][] = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 3, 100},
                {0, 2, 500}
        };
        int src = 0;
        int dst = 3;
        int K = 1;

        int result = obj.CheapestFlight(n, flights, src, dst, K);
        System.out.println("Cheapest Price from " + src + " to " + dst + " within " + K + " stops: " + result);
    }
}