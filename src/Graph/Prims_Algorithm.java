package Graph;
import java.util.*;
public class Prims_Algorithm {
    static class Pair{
        int node;
        int distance;
        public Pair(int distance,int node){
            this.node = node;
            this.distance = distance;
        }
    }
    static class Solution{
        // function to find sum of weights of edges of the minimum spanning tree....
        static int spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj){

            // Creates a min-heap priority queue of Pair.....
            // Pair with smaller distance is given higher priority.....
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);

            int[] vis = new int[V];
            // {wt,node}
            pq.add(new Pair(0,0));
            int sum = 0;
            while (!pq.isEmpty()){
                int wt = pq.peek().distance; // weight of this edge (or cost to include this node).....
                int node = pq.peek().node; // which node we are trying to include in MST....
                pq.remove();

                if(vis[node] == 1){
                    continue;
                }
                // add it to the mst....
                vis[node] = 1;
                sum = sum + wt;

                for(int i=0;i<adj.get(node).size();i++){
                    int edW = adj.get(node).get(i).get(1);
                    int adjNode = adj.get(node).get(i).get(0);
                    if(vis[adjNode] == 0){
                        pq.add(new Pair(edW,adjNode));
                    }
                }
            }
            return sum;
        }
        public static void main(String[] args) {

            // Number of vertices
            int V = 5;

            // Adjacency list representation
            // Each entry: adj.get(node) → list of {adjNode, weight}
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            // Add edges (u, v, w)
            addEdge(adj, 0, 1, 2);
            addEdge(adj, 0, 3, 6);
            addEdge(adj, 1, 2, 3);
            addEdge(adj, 1, 3, 8);
            addEdge(adj, 1, 4, 5);
            addEdge(adj, 2, 4, 7);
            addEdge(adj, 3, 4, 9);

            int result = Solution.spanningTree(V, adj);
            System.out.println("Sum of weights of MST = " + result);
        }

        // Utility function to add edges (undirected graph)
        static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int u, int v, int w) {
            ArrayList<Integer> t1 = new ArrayList<>();
            t1.add(v);
            t1.add(w);
            adj.get(u).add(t1);

            // Because graph is undirected, we must add both.....
            ArrayList<Integer> t2 = new ArrayList<>();
            t2.add(u);
            t2.add(w);
            adj.get(v).add(t2);
        }
    }
}
