package Graph;
import java.util.*;

public class DFS_Traversal {
    // Recursive DFS function
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;   // mark current node as visited
        ls.add(node);       // add to traversal list

        // visit all unvisited neighbors
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    // DFS traversal of the whole graph
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V + 1];   // visited array (1-based indexing)
        ArrayList<Integer> ls = new ArrayList<>();

        dfs(1, vis, adj, ls); // start DFS from node 1
        return ls;
    }

    public static void main(String[] args) {
        int n = 5; // no of nodes
        int m = 6; // no of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // n+1 for 1-based indexing
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // edge 1---2 and 1--3
        adj.get(1).add(2);
        adj.get(1).add(3);

        // edge 2--1 and 2--4 and 2--5
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(5);

        // edge 3--1 and 3--4
        adj.get(3).add(1);
        adj.get(3).add(4);

        // edge 4--2 and 4--3 and 4--5
        adj.get(4).add(2);
        adj.get(4).add(3);
        adj.get(4).add(5);

        // edge 5--2 and 5--4
        adj.get(5).add(2);
        adj.get(5).add(4);

        // Call DFS
        ArrayList<Integer> dfsResult = dfsOfGraph(n, adj);

        // Print DFS result
        System.out.println("DFS Traversal: " + dfsResult);
    }
}
