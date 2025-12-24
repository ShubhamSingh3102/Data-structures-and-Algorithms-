package Binary_Search_Tree;
import java.util.*;
public class Floor_in_BST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    // find the greatest value node of the BST which is smaller than or equal to x.
    public static int floorInBSR(Node root,int key){
        int floor = -1;
        while(root != null){
            if(root.val == key){
                floor = root.val;
                return floor;
            }
            if(key > root.val){
                floor = root.val;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
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

        int ans = floorInBSR(root,8);
        System.out.println(ans);
    }
}
