package Binary_Search_Tree;
import java.util.*;
public class Max_depth_of_binary_Tree {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null ){
            return 1;
        }
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        System.out.println(maxDepth(root));
    }
}
