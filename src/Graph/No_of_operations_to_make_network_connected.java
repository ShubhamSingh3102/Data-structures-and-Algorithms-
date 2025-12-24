package Graph;
import java.util.*;
public class No_of_operations_to_make_network_connected {
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

    static class Solution {
        public int Solve(int n, int[][] edges) {
            DisjointSet ds = new DisjointSet(n);
            int cntExtra = 0;
            int m = edges.length;
            for (int i = 0; i < m; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                if (ds.findUPar(u) == ds.findUPar(v)) {
                    cntExtra++;
                } else {
                    ds.unionBySize(u, v);
                }
            }
            // counting connected component...
            int cntC = 0;
            for (int i = 0; i < n; i++) {
                if (ds.parent.get(i) == i) {
                    cntC++;
                }
            }
            int ans = cntC - 1;
            if (cntExtra >= ans) {
                return ans;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        System.out.println("Enter number of edges:");
        int m = sc.nextInt();

        int[][] edges = new int[m][2];

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.Solve(n, edges);

        System.out.println("Minimum operations required: " + result);
    }
}
