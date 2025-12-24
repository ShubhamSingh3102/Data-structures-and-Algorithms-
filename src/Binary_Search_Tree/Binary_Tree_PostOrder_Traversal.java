package Binary_Search_Tree;
import java.util.*;
public class Binary_Tree_PostOrder_Traversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> postOrder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postOrderHelper(root, ans);
        return ans;
    }

    private static void postOrderHelper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postOrderHelper(root.left, ans);
        postOrderHelper(root.right, ans);
        ans.add(root.val);
    }

    public static void main(String[] args) {
        Binary_Tree_PostOrder_Traversal bt = new Binary_Tree_PostOrder_Traversal();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(bt.postOrder(root)); // [4, 5, 2, 3, 1]
    }
}