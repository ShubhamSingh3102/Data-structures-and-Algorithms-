package Graph;
import java.util.*;
public class Bellman_Ford_Algorithm {
    static int[] bellman_ford(int V,ArrayList<ArrayList<Integer>> edges,int S){
        int[] dist = new int[V];
        for(int i=0;i<V;i++) {
            dist[i] = (int) (1e8);
        }
        dist[S] = 0; // Source node....


        // V*E

        // N-1 iterations....
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> it: edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth relaxation to check negative cycle...
        for(ArrayList<Integer> it: edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp; // Negative cycle detected
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 8; // Number of edges

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        // Each edge: [u, v, weight]
        edges.add(new ArrayList<>(Arrays.asList(0, 1, -1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2, 4)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4, 2)));
        edges.add(new ArrayList<>(Arrays.asList(3, 2, 5)));
        edges.add(new ArrayList<>(Arrays.asList(3, 1, 1)));
        edges.add(new ArrayList<>(Arrays.asList(4, 3, -3)));

        int S = 0; // Source vertex

        int[] dist = bellman_ford(V, edges, S);

        if (dist.length == 1 && dist[0] == -1) {
            System.out.println("Graph contains a negative weight cycle");
        } else {
            System.out.println("Shortest distances from source " + S + ":");
            for (int i = 0; i < V; i++) {
                System.out.println("Node " + i + " : " + dist[i]);
            }
        }
    }
}
