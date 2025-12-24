package Graph;
import java.util.*;
public class Detect_a_cycle_in_an_undirected_graph_using_DFS {
    // Helper class to store node and parent
    static class Pair {
        int first;   // current node
        int second;  // parent node

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private boolean dfs (int node,int parent,int vis[],ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode] == 0) { // not visited
                if(dfs(adjacentNode,node,vis,adj) == true){
                    return true;
                }
                else if(adjacentNode != parent) { //visited but not parent...means here it has a cycle...
                    return true;
                }
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph...
    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V+1];
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(i,-1,vis,adj) == true){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 7; // no of nodes

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        // n+1
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);


        adj.get(2).add(5);
        adj.get(2).add(1);


        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(6);

        adj.get(4).add(3);

        adj.get(5).add(2);
        adj.get(5).add(7);

        adj.get(6).add(3);
        adj.get(6).add(7);

        adj.get(7).add(5);
        adj.get(7).add(6);

        Detect_a_cycle_in_an_undirected_graph_using_DFS obj = new Detect_a_cycle_in_an_undirected_graph_using_DFS();
        boolean hasCycle = obj.isCycle(n, adj);

        if (hasCycle) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle in the graph.");
        }
    }
}
