package Binary_Search_Tree;
import java.util.*;
public class Minimum_depth_of_Binary_Tree {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public int minDepth(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null ){
            return 1;
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        if(root.right == null){
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
    public static void main(String[] args) {
        Minimum_depth_of_Binary_Tree obj = new Minimum_depth_of_Binary_Tree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println(obj.minDepth(root)); // Output: 2
    }
}
