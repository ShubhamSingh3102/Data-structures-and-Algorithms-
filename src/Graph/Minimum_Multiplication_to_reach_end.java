package Graph;
import java.util.*;
public class Minimum_Multiplication_to_reach_end {
//
    // Pair class for PQ: (distance, node)
    static class Pair {
        int dist, node;
        Pair(int dist, int node) {
            this.dist = dist; // number of steps taken so far
            this.node = node; // current value (0–99999)
        }
    }

    static class Solution {
        public int minimumMultiplications(int[] arr, int start, int end) {

            int MOD = 100000;

            int[] dist = new int[MOD];
            Arrays.fill(dist, Integer.MAX_VALUE);

            // Creates a min-heap priority queue that always pops the pair with the smallest dist...
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                    (a, b) -> a.dist - b.dist
            );

            // initialize...
            dist[start] = 0;
            pq.add(new Pair(0, start));

            while (!pq.isEmpty()) {

                Pair p = pq.poll();
                int steps = p.dist;
                int value = p.node;


                if (value == end) return steps;

                // Relax edges: multiply by arr[i]
                for (int num : arr) {

                    int newValue = (value * num) % MOD;
                    int newSteps = steps + 1;

                    // If a shorter path is found...
                    if (newSteps < dist[newValue]) {
                        dist[newValue] = newSteps;
                        pq.add(new Pair(newSteps, newValue));
                    }
                }
            }

            return -1; // Not reachable
        }
    }


//    static class Pair {
//        int steps, value;
//        Pair(int steps, int value) {
//            this.steps = steps;
//            this.value = value;
//        }
//    }
//
//    static class Solution {
//        int minimumMultiplications(int[] arr, int start, int end) {
//
//            int mod = 100000;
//            int[] dist = new int[mod];
//            Arrays.fill(dist, Integer.MAX_VALUE);
//
//            PriorityQueue<Pair> pq = new PriorityQueue<>(
//                    (a, b) -> a.steps - b.steps
//            );
//
//            dist[start] = 0;
//            pq.add(new Pair(0, start));
//
//            while (!pq.isEmpty()) {
//
//                Pair p = pq.poll();
//                int steps = p.steps;
//                int value = p.value;
//
//                if (value == end)
//                    return steps;
//
//                for (int num : arr) {
//
//                    int newValue = (value * num) % mod;
//
//                    if (steps + 1 < dist[newValue]) {
//
//                        dist[newValue] = steps + 1;
//                        pq.add(new Pair(steps + 1, newValue));
//                    }
//                }
//            }
//
//            return -1;
//        }
//    }
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;

        int result = obj.minimumMultiplications(arr, start, end);

        System.out.println("Minimum multiplications to reach end = " + result);
    }
}
