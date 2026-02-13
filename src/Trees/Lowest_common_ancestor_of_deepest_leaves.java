package Trees;
import java.util.*;
public class Lowest_common_ancestor_of_deepest_leaves {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    static HashMap<Node, Integer> mp = new HashMap<>();
    static int maxDepth = 0;
    public static void depth(Node root,int depth){
        if(root == null){
            return;
        }
        mp.put(root,depth);
        maxDepth = Math.max(maxDepth,depth);

        depth(root.left,depth+1);
        depth(root.right,depth+1);
    }
    public static Node lowestCommonAncestor(Node root){
        if(root == null){
            return null;
        }
        if (mp.get(root) == maxDepth) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left);
        Node right = lowestCommonAncestor(root.right);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
    public static Node lcaDeepestLeaves(Node root){
        depth(root,1);

        return lowestCommonAncestor(root);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(7);
        b.right = e;
        Node f = new Node(18);
        Node g = new Node(10);
        e.left = f;
        e.right = g;
        Node h = new Node(6);
        d.left = h;

        Node n = lcaDeepestLeaves(root);
        System.out.println(n.val);
    }
}
