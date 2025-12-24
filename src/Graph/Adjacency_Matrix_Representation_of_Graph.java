package Graph;
import java.util.*;
public class Adjacency_Matrix_Representation_of_Graph {
    public static void main(String[] args) {
        // costly because its SC --> O(N^2)
        int n = 3; // no of nodes
        int m = 3; // no of edges
        int adj[][] = new int[n+1][n+1]; // 1-based indexing

        // edge 1---2
        adj[1][2] = 1;
        adj[2][1] = 1;

        // edge 2---3
        adj[2][3] = 1;
        adj[3][2] = 1;

        // edge 1---3
        adj[1][3] = 1;
        adj[3][1] = 1;

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
