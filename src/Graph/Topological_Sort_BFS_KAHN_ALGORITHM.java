package Graph;
import java.util.*;
public class Topological_Sort_BFS_KAHN_ALGORITHM {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int inDegree[] = new int[V];
        for(int i=0;i<V;i++) {
            for(int it: adj.get(i)) {
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<V;i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        int topo[] = new int[V];
        int i = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;

            // node is in your topo sort
            // so please remove it from the inDegree

            for(int it: adj.get(node)) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
    public static void main(String[] args) {
        int V = 6; // number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example DAG edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Call topoSort
        int[] result = topoSort(V, adj);

        System.out.println("Topological Sort of the graph:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
