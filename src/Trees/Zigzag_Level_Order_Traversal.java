package Trees;
public class Zigzag_Level_Order_Traversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void nthLevel(Node root,int n){ // printing from left to right....
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
    public static void nthLevel2(Node root,int n){ // printing from right to left....
        if(root == null){
            return;
        }
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        nthLevel2(root.right,n-1);
        nthLevel2(root.left,n-1);
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
        for (int i = 1; i <= level; i++) {
            if(i%2!=0){ // odd level....
                nthLevel(root, i);
            }
            else{
                nthLevel2(root, i);
            }
            System.out.println();
        }
    }
}























//package Trees;
//import java.util.*;
//public class Zigzag_Level_Order_Traversal {
//    public static class Node {
//        int val;
//        Node left;
//        Node right;
//
//        public Node(int val) {
//            this.val = val;
//        }
//    }
//    public static void nthLevel(Node root,int n,List<Integer> arr){ // printing from left to right....
//        if(root == null){
//            return;
//        }
//        if(n==1){
//            arr.add(root.val);
//            return;
//        }
//        nthLevel(root.left,n-1,arr);
//        nthLevel(root.right,n-1,arr);
//    }
//    public static void nthLevel2(Node root,int n,List<Integer> arr){ // printing from right to left....
//        if(root == null){
//            return;
//        }
//        if(n==1){
//            arr.add(root.val);
//            return;
//        }
//        nthLevel2(root.right,n-1,arr);
//        nthLevel2(root.left,n-1,arr);
//    }
//    public static int height(Node root){
//        if(root == null){
//            return 0;
//        }
//        if(root.left == null && root.right == null){
//            return 0;
//        }
//        return 1 + Math.max(height(root.left),height(root.right));
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
//        int level = height(root) + 1;
//        for (int i = 1; i <= level; i++) {
//            List<Integer> arr = new ArrayList<>();
//            if(i%2!=0){ // odd level....
//                nthLevel(root, i,arr);
//            }
//            else{
//                nthLevel2(root, i,arr);
//            }
//            System.out.println();
//        }
//    }
//}
