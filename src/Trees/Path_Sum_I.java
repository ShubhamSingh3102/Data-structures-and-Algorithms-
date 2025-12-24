package Trees;
import java.util.*;
public class Path_Sum_I {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static boolean hasPathSum(Node root,int target){
        if(root == null){
            return false;
        }
        if(root!=null && root.left == null && root.right == null){
            if(root.val == target){
                return true;
            }
        }
        return hasPathSum(root.left,target- root.val) || hasPathSum(root.right,target-root.val);
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
        boolean ans = hasPathSum(root,target);
        System.out.println(ans);
    }
}