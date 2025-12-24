package Trees;
import java.util.*;

// Points to be noted....
// 1--> 1st element of preOrder traversal is always the root...
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static Node helper(int[] preorder,int preLow,int preHigh,int[] inorder,int inLow,int inHigh){
        if(preLow > preHigh){
            return null;
        }
        Node root = new Node(preorder[preLow]); // 1st element of preOrder traversal is always the root...
        int i = inLow;
        while(inorder[i] != preorder[preLow]){
            i++;
        }
        int leftSize = i - inLow;
        root.left = helper(preorder,preLow+1,preLow+leftSize,inorder,inLow,i-1);
        root.right = helper(preorder,preLow+leftSize+1,preHigh,inorder,i+1,inHigh);
        return root;
    }
    public static Node buildTree(int[] preorder,int[] inorder){
        int n = preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6};
        int[] inorder = {4,2,5,1,3,6};
        Node root = buildTree(preorder,inorder);

        System.out.println("Inorder of constructed tree: ");
        printInorder(root);
    }
}
