package Graph;
import java.util.*;
public class Alien_Dictionary {
    static List<Integer> topoSort(int V, List<List<Integer>> adj) {
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
        List<Integer> topo = new ArrayList<>();
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            // node is in your topo sort
            // so please remove it from the inDegree

            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
    public String findOrder(String[] dict,int N,int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int ptr = 0;ptr<len;ptr++) {
                if(s1.charAt(ptr) != s2.charAt(ptr)) {
                    // zero based indexing...according to ascii value...
                    // 'b' - 'a' = 98 - 97 = 1
                    //'a' - 'a' = 97 - 97 = 0
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(K,adj);
        String ans = "";
        for(int it: topo) {
            // topo = [1, 3, 0, 2]
            // it	Calculation	Result Char
            //1    	1 + 97	      'b'
            //3	    3 + 97	      'd'
            //0	    0 + 97        'a'
            //2	    2 + 97	      'c'
            ans = ans + (char)(it + (int)('a'));
        }
        return ans;
        // ans = ""
        //ans = "" + 'b' = "b"
        //ans = "b" + 'd' = "bd"
        //ans = "bd" + 'a' = "bda"
        //ans = "bda" + 'c' = "bdac"
    }
    public static void main(String[] args) {
        // Example test case
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int N = dict.length;
        int K = 4; // Number of unique characters in the alien language

        Alien_Dictionary obj = new Alien_Dictionary();
        String order = obj.findOrder(dict, N, K);

        System.out.println("The order of characters is: " + order);
    }
}
