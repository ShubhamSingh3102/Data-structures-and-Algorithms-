package Backtracking;
import java.util.*;
public class M_coloring_Problem {
    private static boolean isSafe(int node,List<Integer>[]G,int[] color,int n,int col){
        for(int it: G[node]){
            // if adjacency node is having the same color returns false...
            if(color[it] == col){
                return false;
            }
        }
        return true;
    }
    private static boolean solve(int node,List<Integer>[]G,int[] color,int n,int m){
        if(node == n){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isSafe(node,G,color,n,i)){
                color[node] = i;
                if(solve(node+1,G,color,n,m) == true){
                    return true;
                }
                color[node] = 0; // backtracking....
            }
        }
        return false;
    }
    public static boolean graphColoring(List<Integer>[] G,int[] color,int i,int m){
        int n = G.length;
        if(solve(0,G,color,n,m) == true){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4, m = 3;
        List<Integer>[] G = new ArrayList[V];
        for(int i=0;i<V;i++) {
            G[i] = new ArrayList<>();
        }

        // edges (undirected graph)
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);

        int[] color = new int[V];
        System.out.println(graphColoring(G, color, 0, m));
        System.out.println(Arrays.toString(color));
    }
}
