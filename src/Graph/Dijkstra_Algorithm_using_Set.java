package Graph;
import java.util.*;
public class Dijkstra_Algorithm_using_Set {
//    static class Solution {
//        // Function to find the shortest distance of all the vertices from the source vertex S
//        public List<Integer> dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
//            // TreeSet to simulate C++ set<pair<int,int>>
//            TreeSet<Pair> set = new TreeSet<>((a, b) -> {
//                if (a.distance == b.distance) return a.node - b.node;
//                return a.distance - b.distance;
//            });
//
//            int[] dist = new int[V];
//            Arrays.fill(dist, (int) 1e9);
//            dist[S] = 0;
//
//            set.add(new Pair(0, S)); // {distance, node}
//
//            while (!set.isEmpty()) {
//                Pair it = set.pollFirst(); // get and remove the smallest element
//                int dis = it.distance;
//                int node = it.node;
//
//                // Traverse adjacent nodes
//                for (ArrayList<Integer> edge : adj.get(node)) {
//                    int adjNode = edge.get(0);
//                    int edgeW = edge.get(1);
//
//                    if (dis + edgeW < dist[adjNode]) {
//                        // Erase if it already exists in set
//                        if (dist[adjNode] != (int) 1e9) {
//                            set.remove(new Pair(dist[adjNode], adjNode));
//                        }
//
//                        dist[adjNode] = dis + edgeW;
//                        set.add(new Pair(dist[adjNode], adjNode));
//                    }
//                }
//            }
//            List<Integer> ans = new ArrayList<>();
//            for (int d : dist) ans.add(d);
//            return ans;
//        }
//        // Pair class for distance-node pairs
//        static class Pair {
//            int distance;
//            int node;
//
//            Pair(int distance, int node) {
//                this.distance = distance;
//                this.node = node;
//            }
//        }
//
//        public static void main(String[] args) {
//            int V = 2;
//            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
//
//            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
//
//            // Edge 0 -> 1 with weight 9
//            adj.get(0).add(new ArrayList<>(Arrays.asList(1, 9)));
//            // Edge 1 -> 0 with weight 9
//            adj.get(1).add(new ArrayList<>(Arrays.asList(0, 9)));
//
//            int S = 0;
//
//            Solution obj = new Solution();
//            List<Integer> res = obj.dijkstra(V, adj, S);
//
//            System.out.println("Shortest distances from source:");
//            System.out.println(res);
//        }
//    }
//}
























    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        // TreeSet to act like a priority queue
        TreeSet<Pair> set = new TreeSet<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.dist != b.dist) return a.dist - b.dist;
                return a.node - b.node; // tie-breaker by node
            }
        });

        set.add(new Pair(S, 0));

        while (!set.isEmpty()) {
            Pair p = set.pollFirst();
            int u = p.node;

            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int w = neighbor.get(1);

                if (dist[u] + w < dist[v]) {
                    // If v already in set, remove it before updating
                    Pair old = new Pair(v, dist[v]);
                    set.remove(old);

                    dist[v] = dist[u] + w;
                    set.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add edges (u -> v with weight w)
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 4)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 5)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        int source = 0;
        int[] distances = dijkstra(V, adj, source);

        System.out.println("Shortest distances from source " + source + ": " + Arrays.toString(distances));
    }
}
