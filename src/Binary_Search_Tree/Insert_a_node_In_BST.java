package Binary_Search_Tree;
import java.util.*;
public class Insert_a_node_In_BST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static Node insertIntoBST(Node root,int val){
        if(root == null){
            return new Node(val);
        }
        Node curr = root;
        while(true){
            if(curr.val <= val){
                // leave node me insert karna hai...
                if(curr.right != null){
                    curr = curr.right;
                }
                else{
                    curr.right = new Node(val);
                    break;
                }
            }
            else{ // curr.val > val
                if(curr.left != null){
                    curr = curr.left;
                }
                else{
                    curr.left = new Node(val);
                    break;
                }
            }
        }
        return root;
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
        Node node = insertIntoBST(root,4);
        System.out.println();
        preOrder(root);
    }
}
