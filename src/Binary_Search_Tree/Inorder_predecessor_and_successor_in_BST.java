//package Binary_Search_Tree;
//import java.util.*;
//public class Inorder_predecessor_and_successor_in_BST {
//    public static class Node {
//        int val;
//        Node left;
//        Node right;
//
//        public Node(int val) {
//            this.val = val;
//        }
//    }
//    public static void inOrder(Node root, List<Integer> arr) {
//        if (root == null) {
//            return;
//        }
//        inOrder(root.left,arr);
//        arr.add(root.val);
//        inOrder(root.right,arr);
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
//        // Step 1 --> Inorder traversal and then store it in arrayList
//        // Step 2 --> Search that key in arrayList using BinarySearch
//        // Step 3 --> uske just phele wala predecessor hai and uske just baad wala Successor hai...
//
//
//        // TC --> O(n)
//        // SC --> O(n)
//        List<Integer> arr = new ArrayList<>();
//        inOrder(root,arr);
//        int key = 11;
//        int idx = -1;
//        for(int i=0;i<arr.size();i++){
////            System.out.print(arr.get(i)+" ");
//            if(arr.get(i) == key){
//                idx = i;
//                break;
//            }
//        }
//        int pred = arr.get(idx-1);
//        int succ = arr.get(idx+1);
//
//        System.out.println("Predecessor is : "+pred);
//        System.out.println("Successor is : "+succ);
//    }
//}






































package Binary_Search_Tree;
import java.util.*;
public class Inorder_predecessor_and_successor_in_BST {

    // global variable...
    static int pred = -1;
    static int succ = -1;
    static Node temp = null;
    static boolean flag = false;

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void inOrder(Node root,int val) {
        if (root == null) {
            return;
        }
        inOrder(root.left,val);
        // magic
        if(temp == null){
            temp = root;
        }
        else{
            if(root.val == val){
                pred = temp.val;
                flag = true; // val is found...
            }
            else if(root.val > val && flag == true){
                succ = root.val;
                flag = false;
            }
            else{ // root.val != val
                temp = root; // hamesha temp ko update krte rahna hai...
            }
        }
        inOrder(root.right,val);
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

        int val = 11;
        inOrder(root,val);
        System.out.println("Predecessor is : "+pred);
        System.out.println("Successor is : "+succ);
    }
}
