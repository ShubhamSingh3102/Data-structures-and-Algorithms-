package Binary_Search_Tree;
import java.util.*;
public class Deletion_in_BST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static Node deleteNode(Node root,int key){
        if(root == null){
            return null;
        }
        if(root.val == key){
            return helper(root);
        }
        Node dummy = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                } else{
                    root = root.left;
                }
            } else{ // root.val < key
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                } else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public static Node helper(Node root){
        if(root.left == null){
            return root.right;
        } else if(root.right == null){
            return root.left;
        } else {
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    public static Node findLastRight(Node root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
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

        preOrder(root);
        Node node = deleteNode(root,11);
        System.out.println();
        preOrder(node);
    }
}
