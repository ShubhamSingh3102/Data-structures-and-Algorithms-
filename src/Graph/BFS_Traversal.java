package Graph;
import java.util.*;
public class BFS_Traversal {
    public static ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){

        // Creates an array list bfs to store the traversal order.
        ArrayList<Integer> bfs = new ArrayList<>();

        boolean vis[] = new boolean[V+1]; // 1-based indexing...
        Queue<Integer> q = new LinkedList<>();

        // Add 1 to the queue....
        //Mark node 1 as visited.....
        q.add(1);
        vis[1] = true;

        // BFS loop runs until the queue becomes empty....
        while (!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);


            // Traverse all neighbors of the current node from the adjacency list...
            for(Integer it : adj.get(node)) {
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
        int n = 5; // no of nodes
        int m = 6; // no of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        // n+1
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // edge 1---2 and 1--3
        adj.get(1).add(2);
        adj.get(1).add(3);

        // edge 2--1 and 2--4 and 2--5
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(5);

        // adj 3--1 and 3--4
        adj.get(3).add(1);
        adj.get(3).add(4);

        // adj 4--2 and 4--3 and 4--5
        adj.get(4).add(2);
        adj.get(4).add(3);
        adj.get(4).add(5);

        // adj 5--2 and 5--4
        adj.get(5).add(2);
        adj.get(5).add(4);

        ArrayList<Integer> bfsResult = bfsOfGraph(n, adj);

        // Print BFS result
        System.out.println("BFS Traversal: " + bfsResult);
    }
}