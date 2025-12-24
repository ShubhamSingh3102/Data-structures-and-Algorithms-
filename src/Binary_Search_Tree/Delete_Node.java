//package Binary_Search_Tree.java;
//
//public class Delete_Node {
//    public static class Node {
//        int val;
//        Node left;
//        Node right;
//
//        public Node(int val) {
//            this.val = val;
//        }
//    }
//
//    public static void preOrder(Node root) {
//        if (root == null) {
//            return;
//        }
//        System.out.print(root.val + " ");
//        preOrder(root.left);
//        preOrder(root.right);
//    }
//
//    // deleting leave Node....
//    public static void deleteNode(Node root, int target) {
//        if (root == null) {
//            return;
//        }
//        if (root.val > target) { // go to left node...
//            if (root.left == null) {
//                return;
//            }
//            if (root.left.val == target) {
//                if (root.left.left == null && root.left.right == null) { // 0 children...
//                    root.left = null;
//                } else if (root.left.left == null || root.left.right == null) { // 1 children...
//                    if (root.left.left != null) {
//                        root.left = root.left.left;
//                    } else {
//                        root.left = root.left.right;
//                    }
//                } else { // 2 children...
//                    // // 2 children me...
//                    // jis node ko delete karna hai usko curr node maang lo and phir uske respect me predecessor nikalo...
//                    // predecessor niklate ke liye ek baar left jao and phir jab tak null nhi ho jaata right jaate raho...
//                    Node curr = root.left; // root node...
//                    Node pred = curr.left;
//                    while (pred.right != null) {
//                        pred = pred.right;
//                    }
//                    // pred ko phir se delete krna hai...
//                    deleteNode(curr, pred.val);
//                    pred.left = curr.left;
//                    pred.right = curr.right;
//                    root.left = pred;
//                }
//            } else {
//                deleteNode(root.left, target);
//            }
//        }
//        if (root.val < target) { // go to right node...
//            if (root.right == null) {
//                return;
//            }
//            if (root.right.val == target) {
//                // here Node r = root.right
//                if (root.right.left == null && root.right.right == null) { // 0 children...
//                    root.right = null;
//                } else if (root.right.left == null || root.right.right == null) { // 1 children...
//                    // mujhe dekhna hai kaunsa wala null nahi h...
//                    if (root.right.left != null) {
//                        root.right = root.right.left;
//                    } else {
//                        root.right = root.right.right;
//                    }
//                } else { // 2 children...
//                    // // 2 children me...
//                    // jis node ko delete karna hai usko curr node maang lo and phir uske respect me predecessor nikalo...
//                    // predecessor niklate ke liye ek baar left jao and phir jab tak null nhi ho jaata right jaate raho...
//                    Node curr = root.right; // root node...
//                    Node pred = curr.left;
//                    while (pred.right != null) {
//                        pred = pred.right;
//                    }
//                    // pred ko phir se delete krna hai...
//                    deleteNode(curr, pred.val);
//                    pred.left = curr.left;
//                    pred.right = curr.right;
//                    root.right = pred;
//                }
//            }
//            else{
//                deleteNode(root.right, target);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Node root = new Node(10);
//        Node a = new Node(5);
//        Node b = new Node(13);
//        root.left = a;
//        root.right = b;
//
//        Node c = new Node(3);
//        Node d = new Node(6);
//        a.left = c;
//        a.right = d;
//
//        Node e = new Node(11);
//        Node f = new Node(14);
//        b.left = e;
//        b.right = f;
//
//        Node temp = new Node(Integer.MAX_VALUE); // fake or dummy node...
//        temp.left = root;
//        preOrder(root);
//        deleteNode(temp,11);
//        System.out.println();
//        preOrder(root);
//    }
//}





























package Binary_Search_Tree;
import java.util.*;
public class Delete_Node {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // deleting leave Node....
    public static void deleteNode(Node root, int target) {
        if (root == null) {
            return;
        }
        if (root.val > target) { // go to left node...
            if (root.left == null) {
                return;
            }
            if (root.left.val == target) {
                if (root.left.left == null && root.left.right == null) { // 0 children...
                    root.left = null;
                } else if (root.left.left == null || root.left.right == null) { // 1 children...
                    if (root.left.left != null) {
                        root.left = root.left.left;
                    } else {
                        root.left = root.left.right;
                    }
                } else { // 2 children...
                    // // 2 children me...
                    // jis node ko delete karna hai usko curr node maang lo and phir uske respect me predecessor nikalo...
                    // predecessor niklate ke liye ek baar left jao and phir jab tak null nhi ho jaata right jaate raho...
                    Node curr = root.left; // root node...
                    Node pred = curr.left;
                    while (pred.right != null) {
                        pred = pred.right;
                    }
                    // pred ko phir se delete krna hai...
                    deleteNode(root, pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.left = pred;
                }
            } else {
                deleteNode(root.left, target);
            }
        }
        if (root.val < target) { // go to right node...
            if (root.right == null) {
                return;
            }
            if (root.right.val == target) {
                // here Node r = root.right
                if (root.right.left == null && root.right.right == null) { // 0 children...
                    root.right = null;
                } else if (root.right.left == null || root.right.right == null) { // 1 children...
                    // mujhe dekhna hai kaunsa wala null nahi h...
                    if (root.right.left != null) {
                        root.right = root.right.left;
                    } else {
                        root.right = root.right.right;
                    }
                } else { // 2 children...
                    // // 2 children me...
                    // jis node ko delete karna hai usko curr node maang lo and phir uske respect me predecessor nikalo...
                    // predecessor niklate ke liye ek baar left jao and phir jab tak null nhi ho jaata right jaate raho...
                    Node curr = root.right; // root node...
                    Node pred = curr.left;
                    while (pred.right != null) {
                        pred = pred.right;
                    }
                    // pred ko phir se delete krna hai...
                    deleteNode(root, pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.right = pred;
                }
            } else {
                deleteNode(root.right, target);
            }
        }
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

        Node temp = new Node(Integer.MAX_VALUE); // fake or dummy node...
        temp.left = root;
        inOrder(root);
        deleteNode(temp, 11);
        System.out.println();
        inOrder(root);
    }
}
