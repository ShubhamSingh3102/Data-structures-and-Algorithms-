package Trees;
import java.util.*;
public class print_Element_of_nth_level {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
//    public static void preOrder(Node root){
//        // root left right
//        if(root == null){
//            return;
//        }
//        System.out.print(root.val+" ");
//        preOrder(root.left);
//        preOrder(root.right);
//    }
    public static void nthLevel(Node root,int n){
        if(root == null){
            return;
        }
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        nthLevel(root.left,n-1);
        nthLevel(root.right,n-1);
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
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
        Node e = new Node(6);
        b.left = e;
        Node f = new Node(7);
        b.right = f;
        int level = height(root) + 1;
        for(int i=1;i<=level;i++){
            nthLevel(root,i); // O(n)...
            System.out.println();
        }
        // TC--> O(n*log n)
    }
}
