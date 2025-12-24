package Binary_Search_Tree;
import java.util.*;
public class Binary_Tree_PreOrder_Traversal {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static List<Integer> preOrder(Node root){
        List<Integer> ans = new ArrayList<>();
        preOrderHelper(root, ans);
        return ans;
    }
    private static void preOrderHelper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preOrderHelper(root.left, ans);
        preOrderHelper(root.right, ans);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        List<Integer> result = preOrder(root);
        System.out.println(result); // [1, 2, 3]
    }
}
