package Graph;
import java.util.*;
public class Dijkstra_Algorithm_using_Priority_Queue {
    // Pair class for PriorityQueue
    static class Pair {
        int distance;
        int node;
        Pair(int first, int second) {
            this.distance = first;
            this.node = second;
        }
    }

    // Dijkstra method using nested ArrayLists
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // min-heap
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V];
        for(int i = 0; i < V; i++) {
            dist[i] = (int)1e9;
        }

        dist[S] = 0;
        pq.add(new Pair(0, S));

        while(!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for(int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if(dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    // Add edge in nested ArrayList adjacency list
    static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int u, int v, int w) {
        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(v);  // destination node
        edge1.add(w);  // weight
        adj.get(u).add(edge1);

        ArrayList<Integer> edge2 = new ArrayList<>();
        edge2.add(u);  // for undirected graph
        edge2.add(w);
        adj.get(v).add(edge2);
    }

    public static void main(String[] args) {
        int V = 5;

        // Create nested adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add edges
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, 1);
        addEdge(adj, 1, 3, 7);
        addEdge(adj, 2, 4, 3);
        addEdge(adj, 3, 4, 1);

        // Run Dijkstra
        Dijkstra_Algorithm_using_Priority_Queue obj = new Dijkstra_Algorithm_using_Priority_Queue();
        int[] dist = obj.dijkstra(V, adj, 0);

        System.out.println("Shortest distances from source 0: " + Arrays.toString(dist));
    }
}




































































/*
package Graph;
import java.util.*;
public class Dijkstra_Algorithm_using_Priority_Queue {
    // Function to find the shortest distance of all vertices...
    // from the source vertex S...

    // Edge class to represent a node and its edge weight
    static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Pair class for PriorityQueue
    static class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    // Dijkstra method using ArrayList<Edge>[] adjacency list
    int[] dijkstra(int V, ArrayList<Edge>[] adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
        int[] dist = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = (int)1e9;
        }
        dist[S] = 0;

        pq.add(new Pair(0, S));

        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int distance = current.distance;

            // Skip if we already have a shorter distance
            if(distance > dist[node]) continue;

            for(Edge edge : adj[node]) {
                int adjNode = edge.node;
                int weight = edge.weight;

                if(distance + weight < dist[adjNode]) {
                    dist[adjNode] = distance + weight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    // Utility method to add edges (for undirected graph)
    static void addEdge(ArrayList<Edge>[] adj, int u, int v, int w) {
        adj[u].add(new Edge(v, w));
        adj[v].add(new Edge(u, w)); // comment this line for directed graph
    }

    // Main method to test
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        // Add edges
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, 1);
        addEdge(adj, 1, 3, 7);
        addEdge(adj, 2, 4, 3);
        addEdge(adj, 3, 4, 1);

        Dijkstra_Algorithm_using_Priority_Queue obj = new Dijkstra_Algorithm_using_Priority_Queue();
        int[] dist = obj.dijkstra(V, adj, 0);

        System.out.println("Shortest distances from source 0: " + Arrays.toString(dist));
    }
}
*/