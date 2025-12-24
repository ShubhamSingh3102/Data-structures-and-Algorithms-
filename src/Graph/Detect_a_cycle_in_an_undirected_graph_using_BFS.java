package Graph;
import java.util.*;
public class Detect_a_cycle_in_an_undirected_graph_using_BFS {
    // Helper class to store node and parent
    static class Pair {
        int first;   // current node
        int second;  // parent node

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean checkForCycle(int src,int V,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for(int adjacentNode: adj.get(node)) {
                if(vis[adjacentNode] == false) {
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode,node));
                }

                // when someone is visited && it doesn't come from parent it means it forms a cycle...
                else if(parent != adjacentNode){
                    return true;
                }
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph
    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V+1];
        for(int i=0;i<V;i++){
            vis[i] = false;
        }
        // code for component graph....
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                if(checkForCycle(i,V,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 7; // no of nodes

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        // n+1
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);


        adj.get(2).add(5);
        adj.get(2).add(1);


        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(6);

        adj.get(4).add(3);

        adj.get(5).add(2);
        adj.get(5).add(7);

        adj.get(6).add(3);
        adj.get(6).add(7);

        adj.get(7).add(5);
        adj.get(7).add(6);

        Detect_a_cycle_in_an_undirected_graph_using_BFS obj = new Detect_a_cycle_in_an_undirected_graph_using_BFS();
        if (obj.isCycle(n, adj)) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle found in the graph.");
        }
    }
}
