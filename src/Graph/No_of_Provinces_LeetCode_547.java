package Graph;
import java.util.ArrayList;
public class No_of_Provinces_LeetCode_547 {
    public static void dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adjLs) {
        vis[node] = 1;   // mark current node as visited
        // visit all unvisited neighbors
        for (Integer it : adjLs.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adjLs);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj,int V){
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<V;i++){
            adjLs.add(new ArrayList<Integer>());
        }
        // to change adjacency matrix to list
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int vis[] = new int[V];
        int count = 0;
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                count++;
                dfs(i,vis,adjLs);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // Example adjacency matrix
        int V = 3;
        int[][] matrix = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        // Convert int[][] to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < V; j++) {
                adj.get(i).add(matrix[i][j]);
            }
        }

        // Call function
        int result = numProvinces(adj, V);
        System.out.println("Number of Provinces: " + result);
    }
}
