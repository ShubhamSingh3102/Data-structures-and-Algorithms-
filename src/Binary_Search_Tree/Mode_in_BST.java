package Binary_Search_Tree;
import java.util.*;
public class Mode_in_BST {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    Integer prev = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> modes = new ArrayList<>();


    public int[] findMode(Node root) {
        inorder(root);
        int[] ans = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            ans[i] = modes.get(i);
        }
        return ans;
    }

    private void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        if (prev == null || root.val != prev) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            maxCount = count;
            modes.clear(); //// removes old values when a new higher frequency is found.
            modes.add(root.val);
        } else if (count == maxCount) {
            modes.add(root.val);
        }

        prev = root.val;

        inorder(root.right);
    }
    public static void main(String[] args) {
        Mode_in_BST obj = new Mode_in_BST();

        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(2);

        int[] result = obj.findMode(root);
        System.out.println(Arrays.toString(result));
    }
}
