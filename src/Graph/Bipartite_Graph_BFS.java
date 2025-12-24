package Graph;
import java.util.*;
public class Bipartite_Graph_BFS {
    private boolean check(int start,int V,ArrayList<ArrayList<Integer>> adj,int color[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int it : adj.get(node)) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node
                if(color[it] == -1) {
                    // color[node] can be 0 or 1...
                    color[it] = 1 - color[node];
                    q.add(it);
                }

                // is the adjacent guy having the same color...
                // someone did color on the same path...
                else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int V,ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        for(int i=0;i<V;i++) {
            color[i] = -1;
        }
        for(int i=0;i<V;i++) {
            if(color[i] == -1) {
                if(!check(i, V, adj, color)) {
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

//        // sample edges (graph: 0-1, 1-2, 2-3, 3-0) → Bipartite
//        adj.get(0).add(1);
//        adj.get(1).add(0);
//
//        adj.get(1).add(2);
//        adj.get(2).add(1);
//
//        adj.get(2).add(3);
//        adj.get(3).add(2);
//
//        adj.get(3).add(0);
//        adj.get(0).add(3);

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(0);
        adj.get(0).add(2);

        Bipartite_Graph_BFS obj = new Bipartite_Graph_BFS();
        if(obj.isBipartite(V, adj)) {
            System.out.println("Graph is Bipartite Graph");
        } else {
            System.out.println("Graph is NOT Bipartite Graph");
        }
    }
}
