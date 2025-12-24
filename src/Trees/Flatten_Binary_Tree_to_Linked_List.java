//package Trees;
//import java.util.*;
//public class Flatten_Binary_Tree_to_Linked_List {
//    public static class Node {
//        int val;
//        Node left;
//        Node right;
//
//        public Node(int val){
//            this.val = val;
//        }
//    }

// Time complexity -> O(n^2) ---> in worst case
// Time complexity -> O(n log n) --> average case
// Space complexity -> O(log n) --> Balanced Tree
// Space complexity -> 	O(n) --> Skewed Tree
//    public static void flatten(Node root){
//        if(root == null){
//            return;
//        }
////        if(root.left==null && root.right==null){
////            return;
////        }
//        Node leftTree = root.left;
//        Node rightTree = root.right;
//        root.left = null;
//        flatten(leftTree);
//        flatten(rightTree);
//        root.right = leftTree;
//        Node temp = leftTree;
//        while (temp!=null && temp.right!=null){
//            temp = temp.right;
//        }
//        if(temp!=null){
//            temp.right = rightTree;
//        }
//        else{
//            root.right = rightTree;
//        }
//        return;
//    }
//    public static void printFlattenedList(Node root) {
//        while (root != null) {
//            System.out.print(root.val + " -> ");
//            root = root.right;
//        }
//        System.out.println("null");
//    }
//    public static void main(String[] args) {
//        Node root = new Node(1);
//        Node a = new Node(2);
//        Node b = new Node(3);
//        root.left = a;
//        root.right = b;
//        Node c = new Node(4);
//        Node d = new Node(5);
//        a.left = c;
//        a.right = d;
//        Node e = new Node(6);
//        b.left = e;
//        Node f = new Node(7);
//        b.right = f;
//        Node g = new Node(8);
//        e.left = g;
//        flatten(root);
//        printFlattenedList(root);
//    }
//}



































package Trees;
import java.util.*;
public class Flatten_Binary_Tree_to_Linked_List {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    // Morris traversal...
    // Time complexity -> 0(n)
    // Space complexity -> 0(1)
    public static void flatten(Node root){
        Node curr = root;
        while(curr!=null){
            if(curr.left!=null){
                Node pred = curr.left;
                while(pred.right!=null){
                    pred = pred.right;
                }
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    public static void printFlattenedList(Node root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
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
        Node g = new Node(8);
        e.left = g;
        flatten(root);
        printFlattenedList(root);
    }
}
