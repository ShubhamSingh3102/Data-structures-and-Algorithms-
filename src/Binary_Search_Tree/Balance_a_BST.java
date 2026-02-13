package Binary_Search_Tree;
import java.util.*;

public class Balance_a_BST {

    static class Node {
        int val;
        Node left, right;
        Node(int v){
            val = v;
        }
    }

    // Inorder to get sorted array
    public static void inorder(Node root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Build balanced BST
    public static Node buildBST(List<Integer> list, int low, int high){
        if(low > high) return null;

        int mid = low + (high - low) / 2;
        Node root = new Node(list.get(mid));

        root.left = buildBST(list, low, mid - 1);
        root.right = buildBST(list, mid + 1, high);

        return root;
    }

    public static Node balanceBST(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return buildBST(list, 0, list.size() - 1);
    }

    // Insert to create unbalanced BST
    public static Node insert(Node root, int val){
        if(root == null) return new Node(val);
        if(val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void printInorder(Node root){
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] values = {1,2,3,4,5,6,7};
        Node root = null;

        for(int v : values){
            root = insert(root, v);
        }

        System.out.print("Before Balancing (Inorder): ");
        printInorder(root);

        root = balanceBST(root);

        System.out.print("\nAfter Balancing (Inorder): ");
        printInorder(root);
    }
}
