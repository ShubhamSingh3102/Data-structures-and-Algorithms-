package Binary_Search_Tree;
import java.util.*;
public class Balanced_Binary_Tree {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val =val;
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        ////already unbalanced....
        if(lh == -1 || rh == -1 || Math.abs(lh - rh) > 1){
            return -1;
        }
        return 1 + Math.max(lh,rh);
    }
    public boolean isBalanced(Node root){
        return height(root) != -1;
    }
    public static void main(String[] args) {
        Balanced_Binary_Tree tree = new Balanced_Binary_Tree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(tree.isBalanced(root)); // true
    }
}
