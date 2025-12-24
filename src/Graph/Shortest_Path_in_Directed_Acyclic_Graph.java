package Graph;
import java.util.*;
public class Shortest_Path_in_Directed_Acyclic_Graph {
    class Pair {
        int first,second;
        Pair(int _first,int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    private void topoSort(int node,ArrayList<ArrayList<Pair>> adj,int vis[],Stack<Integer> st) {
        vis[node] = 1;
        for(int i=0;i<adj.get(node).size();i++) {
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0) {
                topoSort(v,adj,vis,st);
            }
        }
        st.add(node);
    }
    public int[] shortestPath(int N,int M,int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<N;i++) { // N means vertex
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<M;i++) { // M means edges
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        int vis[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<N;i++) {
            if(vis[i] == 0) {
                topoSort(i,adj,vis,st);
            }
        }

        int dist[] = new int[N];
        for(int i=0;i<N;i++) {
            dist[i] = (int)(1e9);
        }

        dist[0] = 0; // source code...
        while(!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            for(int i=0;i<adj.get(node).size();i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if(dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        Shortest_Path_in_Directed_Acyclic_Graph obj = new Shortest_Path_in_Directed_Acyclic_Graph();

        int N = 6, M = 7;
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        int[] dist = obj.shortestPath(N, M, edges);
        System.out.println("Shortest distances from node 0:");
        for (int d : dist) {
            System.out.print(d + " ");
        }
    }
}
