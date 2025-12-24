package Binary_Search_Tree;
import java.util.*;
public class Count_Complete_Tree_Nodes {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    int count = 0;
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Counting nodes
        int result = countNodes(root);
        System.out.println("Total nodes in tree: " + result);
    }
}
