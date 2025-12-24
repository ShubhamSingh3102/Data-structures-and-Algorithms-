package Graph;
import java.util.*;
public class Adjacency_List_Representation_of_Graph {
    public static void main(String[] args) {
        int n = 3; // no of nodes
        int m = 3; // no of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        // n+1
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // edge 2---3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // adj 1---3
        adj.get(1).add(3);
        adj.get(3).add(1);

        // Print adjacency matrix
        System.out.println("Adjacency List:");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
