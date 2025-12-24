package Binary_Search_Tree;
import Trees.Lowest_Common_Ancestor;

import java.util.*;
public class Lowest_Common_Ancestor_BST {
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
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(p.val == root.val || q.val == root.val){
            return root;
        }
        else if(p.val < root.val && q.val > root.val){
            return root;
        }
        else if(q.val < root.val && p.val > root.val){
            return root;
        }
        else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
//        else if(p.val > root.val && q.val > root.val)
        else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(5);
        Node b = new Node(13);
        root.left = a;
        root.right = b;

        Node c = new Node(3);
        Node d = new Node(6);
        a.left = c;
        a.right = d;

        Node e = new Node(11);
        Node f = new Node(14);
        b.left = e;
        b.right = f;
        Node n= lowestCommonAncestor(root,c,d);
        System.out.println(n);
    }
}
