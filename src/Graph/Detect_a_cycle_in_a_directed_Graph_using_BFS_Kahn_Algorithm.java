package Graph;
import java.util.*;
public class Detect_a_cycle_in_a_directed_Graph_using_BFS_Kahn_Algorithm {
    boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int inDegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            // node is in your topo sort
            // so please remove it from the inDegree

            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        // If there’s no cycle, you’ll be able to process
        // all V nodes → topo.size() == V.....
        if(topo.size() == V) { // no cycle
            return false;
        }
        // If there is a cycle, at least one node will always have non-zero
        // inDegree, and it will never enter the queue → topo.size() < V.
        return true; // cycle exists
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example: 0->1, 1->2, 2->3, 3->1 (cycle)
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Detect_a_cycle_in_a_directed_Graph_using_BFS_Kahn_Algorithm obj = new Detect_a_cycle_in_a_directed_Graph_using_BFS_Kahn_Algorithm();

        System.out.println(obj.isCyclic(V, adj)); // prints true
    }
}
