package Graph;
import java.util.*;
public class Print_Shortest_Path_Dijkstra_Algorithm {
    static class Pair {
        int distance;
        int node;
        Pair(int first, int second) {
            this.distance = first;
            this.node = second;
        }
    }

    public static List<Integer> shortestPath(int n,int m,int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            dist[i] = (int)(1e9);
            parent[i] = i;
        }

        dist[1] = 0; // src = 1 and destination = 5....
        pq.add(new Pair(0,1));
        while (!pq.isEmpty()) {
            Pair it = pq.peek();
            int node = it.node;
            int dis = it.distance;
            pq.remove();

            for(Pair iter : adj.get(node)) {
                int adjNode = iter.node;
                int edgeWeight = iter.distance;
                if(dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dis+edgeWeight,adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9) {
            path.add(-1);
            return path;
        }
        int node = n;
        // maximum time complexity = O(n)....
        while(parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
