package Binary_Search_Tree;
import java.util.*;
public class Construct_BST_from_preOrder {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
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
    public static Node bstFromPreOrder(int[] preorder){
        if (preorder.length == 0) {
            return null;
        }
        Node root = new Node(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            root = insertIntoBST(root,preorder[i]);
        }
        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {10, 5, 3, 6, 13, 11, 14};
        Node node = bstFromPreOrder(preorder);
        System.out.println("Constructed BST preOrder");
        preOrder(node);
    }
}
