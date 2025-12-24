package Binary_Search_Tree;
import java.util.*;
public class Trim_a_BST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void helper(Node root,int low,int high){
        if(root==null){
            return;
        }
        while(root.left!=null){
            if(root.left.val<low){
                root.left = root.left.right;
            }
            else if(root.left.val>high){
                root.left = root.left.left;
            }
            else break;
        }
        while(root.right!=null){
            if(root.right.val<low){
                root.right = root.right.right;
            }
            else if(root.right.val>high){
                root.right = root.right.left;
            }
            else break;
        }
        helper(root.left,low,high);
        helper(root.right,low,high);
    }
    public static Node trimBST(Node root,int low,int high){
        Node parent = new Node(Integer.MAX_VALUE);
        parent.left = root;
        helper(parent,low,high);
        return parent.left;
    }
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
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

        Node node = trimBST(root,6,11);
        inorder(node);
    }
}
