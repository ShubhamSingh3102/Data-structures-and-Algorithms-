package Trees;
import java.util.*;
public class Balanced_Binary_Tree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public static boolean isBalanced(Node root){
        if(root == null){
            return true;
        }
        int lh = height(root.left);
        if(root.left!=null){
            lh++;
        }
        int rh = height(root.right);
        if(root.right!=null){
            rh++;
        }
        int diff = lh - rh;
        if(diff < 0){ // making absolute....
            diff = - diff;
        }
        if(diff > 1){
            return false;
        }
        return (isBalanced(root.left) && isBalanced(root.right));
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
        Node e = new Node(6);
        b.left = e;
        Node f = new Node(7);
        b.right = f;
        System.out.println(isBalanced(root));
    }
}
