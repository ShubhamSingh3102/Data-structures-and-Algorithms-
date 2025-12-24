package Trees;
import java.util.*;
public class Same_Tree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static boolean isSameTree(Node root,Node root1){
        if(root == null && root1 == null){
            return true;
        }
        if(root == null){ // root1 != null
            return false;
        }
        if(root1 == null) { // root! = null
            return false;
        }
        if(root.val != root1.val){
            return false;
        }
        return (isSameTree(root.left,root1.left) && isSameTree(root.right,root1.right));
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

        Node root1 = new Node(1);
        Node a1 = new Node(2);
        Node b1 = new Node(3);
        root1.left = a1;
        root1.right = b1;
        Node c1 = new Node(4);
        Node d1 = new Node(5);
        a1.left = c1;
        a1.right = d1;
        Node e1 = new Node(6);
        b1.left = e1;
        Node f1 = new Node(7);
        b1.right = f1;
        System.out.println(isSameTree(root,root1));
    }
}
