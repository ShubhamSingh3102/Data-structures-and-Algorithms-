package Graph;
import java.util.*;
public class Eventual_Safe_States {
    private boolean dfsCheck(int node, List<List<Integer>> adj,int vis[],int pathVis[],int check[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        // traverse for adjacent nodes.....
        for (int it : adj.get(node)) {

            // when the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis,check) == true) {
                    check[node] = 0; // unsafe because a cycle detected
                    return true;
                }
            }

            // if the node is visited and also in the same path → cycle....
            else if (pathVis[it] == 1) {
                return true; // cycle detected
            }
        }
        check[node] = 1; // safe node
        pathVis[node] = 0; // remove from current path
        return false;
    }
    List<Integer> eventualSafeNodes(int V,List<List<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];

        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                dfsCheck(i,adj,vis,pathVis,check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(check[i] == 1) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    public static void main(String[] args) {
        Eventual_Safe_States obj = new Eventual_Safe_States();

        // Example graph
        int V = 7;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example edges (directed graph)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(5);
        adj.get(3).add(0);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);

        List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
        System.out.println("Eventual Safe Nodes: " + safeNodes);
    }
}
