package Graph;
import java.util.*;
public class No_of_provinces_by_disjoint_set {
    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        // finding ultimate parent....
        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            // If both nodes already share same root → no need to merge.....
            if (ulp_u == ulp_v) {
                return;
            }
            // attach smaller rank tree to bigger rank tree.....
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            }

            // both same rank → attach one and increase rank
            else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    static class Solution{
        // ArrayList<ArrayList<Integer>> adj --> adjacency matrix....
        static int numOfProvinces(ArrayList<ArrayList<Integer>> adj,int V){
            DisjointSet ds = new DisjointSet(V);
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){

                    // If matrix[i][j] = 1 →  nodes connected and merge them....
                    if(adj.get(i).get(j) == 1){
                        // i and j
                        ds.unionBySize(i,j);
                    }
                }
            }
            int count = 0;
            for(int i=0;i<V;i++){
                if(ds.parent.get(i) == i){
                    count++;
                }
            }
            return count;
        }
    }
    public static void main(String[] args) {

        // Hardcoded adjacency matrix
        int[][] matrix = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int V = matrix.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Convert int[][] → ArrayList<ArrayList<Integer>>
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                row.add(matrix[i][j]);
            }
            adj.add(row);
        }
        int provinces = Solution.numOfProvinces(adj, V);
        System.out.println("\nNumber of Provinces = " + provinces);
    }
}
