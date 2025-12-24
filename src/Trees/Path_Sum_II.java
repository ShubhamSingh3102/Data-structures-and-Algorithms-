package Trees;
import java.util.*;
public class Path_Sum_II {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void helper(List<List<Integer>> ans, List<Integer> arr, Node root, int target) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            arr.add(root.val);
            if (root.val == target) {
                List<Integer> a = new ArrayList<>();

                // copying....
                for (int i = 0; i < arr.size(); i++) {
                    a.add(arr.get(i));
                }
                ans.add(a);
            }
            arr.remove(arr.size() - 1); // last wala ko remove kr do...backtracking
            return;
        }
        arr.add(root.val);
        helper(ans, arr, root.left, target - root.val);
        helper(ans, arr, root.right, target - root.val);
        arr.remove(arr.size() - 1); // backtracking...
    }

    public static List<List<Integer>> PathSum(Node root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(ans, arr, root, target);
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node a = new Node(4);
        Node b = new Node(8);
        root.left = a;
        root.right = b;
        Node c = new Node(11);
        Node d = new Node(13);
        a.left = c;
        b.left = d;
        Node e = new Node(4);
        b.right = e;
        Node f = new Node(1);
        e.right = f;
        Node g = new Node(7);
        c.left = g;
        Node h = new Node(2);
        c.right = h;
        int target = 22;
        List<List<Integer>> result = PathSum(root, target);
        System.out.println("Paths with sum " + target + ":");
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}