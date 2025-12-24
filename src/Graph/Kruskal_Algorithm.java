package Graph;
import java.util.*;
public class Kruskal_Algorithm {

    // implements Comparable<Edge> ---> means objects of Edge can be compared to each other (so you can sort edges by weight).......
    class Edge implements Comparable<Edge> {
        int src,dest,weight;
        Edge(int _src,int _dest,int _wt){
            this.src = _src;
            this.dest = _dest;
            this.weight = _wt;
        }

        // Comparator function is used for sorting edgesBased on their weight....
        public int compareTo(Edge compareEdge){
            return this.weight - compareEdge.weight;
        }
    };
    class Solution{
        // Function to find sum of weights of edges of the mst
        int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){

            // Each adj.get(i) is ArrayList<ArrayList<Integer>> for node i....
            // Creates an empty list edges which will store all edges of the graph as Edge objects....
            List<Edge> edges = new ArrayList<Edge>();

            // O(N+E)
            // Converting Adjacency List to Edge List....
            for(int i=0;i<V;i++){

                // adj.get(i) is the adjacency list of node i....
                //.size() gives number of neighbors for node i....
                for(int j=0;j<adj.get(i).size();j++){
                    int adjNode = adj.get(i).get(j).get(0);
                    int wt = adj.get(i).get(j).get(1);
                    int node = i;
                    Edge temp = new Edge(i,adjNode,wt);
                    edges.add(temp);
                }
            }

            // Create DSU...
            Disjoint_Set.DisjointSet ds = new Disjoint_Set.DisjointSet(V);


            // M log M
            // Sort by weight...
            Collections.sort(edges);


            // Kruskal’s Algorithm....
            int mstWt = 0;
            // M * 4 * alpha * 2
            for(int i=0;i< edges.size();i++){
                int wt = edges.get(i).weight;
                int u = edges.get(i).src;
                int v = edges.get(i).dest;

                if(ds.findUPar(u) != ds.findUPar(v)){
                    mstWt += wt;
                    ds.unionByRank(u,v);
                }
            }
            return mstWt;
        }
    }
    public static void main(String[] args) {

        Kruskal_Algorithm obj = new Kruskal_Algorithm();
        Solution sol = obj.new Solution();

        int V = 4;

        // adj list: for each node -> { {adjNode, weight}, ... }
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges (undirected graph)
        // 0 --1--> 1
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 1)));

        // 1 --3--> 2
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 3)));

        // 0 --4--> 2
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 4)));

        // 2 --2--> 3
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 2)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 2)));

        int mstWeight = sol.spanningTree(V, adj);

        System.out.println("Total weight of MST = " + mstWeight);
    }
}
