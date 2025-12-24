package Graph;
import java.util.*;
public class Eventual_Safe_States_BFS_Topological_Sort {
    List<Integer> eventualSafeNodes(int V,List<List<Integer>> adj) {

        // Step 1: Reverse the graph

        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++) {
            // i --> it
            // it --> i
            for(int it: adj.get(i)) {
                adjRev.get(it).add(i);
                inDegree[i]++;  // count incoming edges (for reverse graph)
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for(int it: adjRev.get(node)) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Sorting in ascending Order...
        Collections.sort(safeNodes);
        return safeNodes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter " + E + " edges (u v): ");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }

        Eventual_Safe_States_BFS_Topological_Sort obj = new Eventual_Safe_States_BFS_Topological_Sort();
        List<Integer> res = obj.eventualSafeNodes(V, adj);

        System.out.println("Eventual Safe Nodes: " + res);
        sc.close();
    }
}
