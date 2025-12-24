package Binary_Search_Tree;
import java.util.*;
public class Sum_of_left_leaves {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static int sumOfLeftLeaves(Node root){
        int sum = 0;
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        // check if left child exists and is a leaf
        if(root.left != null &&
                root.left.left == null &&
                root.left.right == null){
            sum += root.left.val;
        }
        // recurse on left and right subtree
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(sumOfLeftLeaves(root)); // Output: 24
    }
}
