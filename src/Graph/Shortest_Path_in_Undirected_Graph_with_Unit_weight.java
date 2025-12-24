package Graph;
import java.util.*;
public class Shortest_Path_in_Undirected_Graph_with_Unit_weight {
    public int[] shortestPath(int[][] edges,int n,int m,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int dis[] = new int[n];

        for(int i=0;i<n;i++) {
            dis[i] = (int) 1e9;
        }
            dis[src] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            while (!q.isEmpty()) {
                int node = q.peek();
                q.remove();
                for(int it: adj.get(node)) {
                    if(dis[node] + 1 < dis[it]) {
                        dis[it] = dis[node] + 1;
                        q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++) {
            if(dis[i] == 1e9) {
                dis[i] = -1;
            }
        }
        return dis;
    }
    public static void main(String[] args) {
        Shortest_Path_in_Undirected_Graph_with_Unit_weight obj =
                new Shortest_Path_in_Undirected_Graph_with_Unit_weight();

        // Example: Graph with 6 nodes (0 to 5)
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 4},
                {3, 5}
        };

        int n = 6;  // Number of nodes
        int m = edges.length;
        int src = 0; // Start node

        int[] dist = obj.shortestPath(edges, n, m, src);

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " -> " + dist[i]);
        }
    }
}
