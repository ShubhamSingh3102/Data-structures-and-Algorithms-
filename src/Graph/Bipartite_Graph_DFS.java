package Graph;
import java.util.*;
public class Bipartite_Graph_DFS {
    private boolean dfs(int node,int col,int color[],ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;

        for(int it: adj.get(node)) {
            // if uncoloured visited array
            if(color[it] == -1) {
                if (dfs(it, 1 - col, color, adj) == false) {
                    return false;
                }
            }
                else if(color[it] == col) {
                    return false;
                }
            }
        return true;
    }
    public boolean isBipartite(int V,ArrayList<ArrayList<Integer>> adj) {
        // visited coloured array...
        int color[] = new int[V];
        for(int i=0;i<V;i++) {
            color[i] = -1;
        }
        for(int i=0;i<V;i++) {
            if(color[i] == -1) {
                if(!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int V = 4; // number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // initialize adjacency list
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }

        // sample edges (graph: 0-1, 1-2, 2-3, 3-0) → Bipartite
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);

//        adj.get(0).add(1);
//        adj.get(1).add(0);
//
//        adj.get(1).add(2);
//        adj.get(2).add(1);
//
//        adj.get(2).add(0);
//        adj.get(0).add(2);

        Bipartite_Graph_DFS obj = new Bipartite_Graph_DFS();
        if(obj.isBipartite(V, adj)) {
            System.out.println("Graph is Bipartite Graph");
        } else {
            System.out.println("Graph is NOT Bipartite Graph");
        }
    }
}
