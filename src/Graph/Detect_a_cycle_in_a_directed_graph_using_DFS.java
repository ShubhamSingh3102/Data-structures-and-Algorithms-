package Graph;
import java.util.*;
public class Detect_a_cycle_in_a_directed_graph_using_DFS {
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1;
        pathVis[node] = 1;

        // traverse for adjacent nodes.....
        for (int it : adj.get(node)) {

            // when the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis) == true) {
                    return true;
                }
            }

            // if the node is visited and also in the same path → cycle....
            else if (pathVis[it] == 1) {
                return true;
            }
        }
        pathVis[node] = 0; // remove from current path
        return false;
    }

    // Function to detect cycle in a directed graph....
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4; // number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example 1: Graph with cycle (0 -> 1 -> 2 -> 0)
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);

        // Example 2: Uncomment below to test graph without cycle
        // adj.get(0).add(1);
        // adj.get(1).add(2);
        // adj.get(2).add(3);

        Detect_a_cycle_in_a_directed_graph_using_DFS obj = new Detect_a_cycle_in_a_directed_graph_using_DFS();
        if (obj.isCycle(V, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does NOT contain a cycle");
        }
    }
}