package Binary_Search_Tree;
import java.util.*;
public class Sum_of_root_to_leaf_Binary_numbers {
    //// LeetCode 1022 and 129...
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static int solve(Node root,int val){
        if(root == null){
            return 0;
        }

        val = (2 * val) + ( 1 * root.val);  // pow(2,0) = 1 // because new will be placed in the unit place....2*val means left shift...

        if(root.left == null && root.right == null){
            return val;
        }
        return solve(root.left,val) + solve(root.right,val);
    }
    public static int sumRootToLeaf(Node root){
        return solve(root,0);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(0);
        Node b = new Node(1);
        root.left = a;
        root.right = b;

        Node c = new Node(0);
        Node d = new Node(1);
        a.left = c;
        a.right = d;

        Node e = new Node(0);
        Node f = new Node(1);
        b.left = e;
        b.right = f;
        System.out.println(sumRootToLeaf(root));
    }
}
