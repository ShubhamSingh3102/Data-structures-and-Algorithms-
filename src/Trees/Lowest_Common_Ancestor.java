package Trees;
import javax.swing.*;
import java.util.*;
public class Lowest_Common_Ancestor {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
    public static boolean contains(Node root,Node node){
        if(root == null){
            return false;
        }
        if(root == node){
            return true;
        }
        return contains(root.left,node) || contains(root.right,node);
    }
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(p==root || q==root){
            return root;
        }
        if(p == q){
            return p;
        }
        boolean leftp = contains(root.left,p);
        boolean rightq = contains(root.right,q);
        if(leftp && rightq){ // both are true....
            return root;
        }
        if(leftp && rightq == false){ // q right me lie nhi karta....
            return lowestCommonAncestor(root.left,p,q);
        }
        if(leftp == false && rightq){ // p left me nhi h...
            return lowestCommonAncestor(root.right,p,q);
        }
        if(!leftp && !rightq){
            return root;
        }
        return root;
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

        Node n= lowestCommonAncestor(root,h,e);
        System.out.println(n);
    }
}
