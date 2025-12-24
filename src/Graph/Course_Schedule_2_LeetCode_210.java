package Graph;
import java.util.*;
public class Course_Schedule_2_LeetCode_210 {
    public int[] findOrder(int V, int[][] prerequisites) {
        // Form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            // pre[0] depends on pre[1] => edge: pre[1] -> pre[0]
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int inDegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
//        ArrayList<Integer> topo = new ArrayList<>();
        int[] topo = new int[V];
        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[cnt++] = node;

            // node is in your topo sort
            // so please remove it from the inDegree

            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        // If there’s no cycle, you’ll be able to process
        // all V nodes → topo.size() == V.....
        if (cnt == V) { // no cycle
            return topo;
        } else {
            // If cycle exists → return empty array
            return new int[0]; // cycle detected
        }
    }
    public static void main(String[] args) {
        Course_Schedule_2_LeetCode_210 obj = new Course_Schedule_2_LeetCode_210();

        int V1 = 2;
        int[][] pre1 = {{1,0}};
        System.out.println(Arrays.toString(obj.findOrder(V1, pre1))); // [0,1]

        int V2 = 2;
        int[][] pre2 = {{1,0},{0,1}};
        System.out.println(Arrays.toString(obj.findOrder(V2, pre2))); // []
    }
}
