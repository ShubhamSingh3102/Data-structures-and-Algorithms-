package Graph;
import java.util.*;
public class Topological_Sort {
    private static void dfs(int node,int vis[],Stack<Integer> st,ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(int it: adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it,vis,st,adj);
            }
        }
        st.push(node);
    }

    // Function to return list containing vertices in Topological order....
    static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                dfs(i,vis,st,adj);
            }
        }
        int ans[] = new int[V];
        int i = 0;
        while(!st.empty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        int V = 6; // number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example DAG edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Call topoSort
        int[] result = topoSort(V, adj);

        System.out.println("Topological Sort of the graph:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
