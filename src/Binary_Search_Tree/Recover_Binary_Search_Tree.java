package Binary_Search_Tree;
import java.util.*;
public class Recover_Binary_Search_Tree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void recoverTree(Node root){
        Node curr= root;
        Node prev = null;
        Node prevPrev = null;
        List<Node> arr = new ArrayList<>(); // no extra space is being used here....
        while (curr != null) {
            // if curr.left exists krta hai...if exists krt hai then find predecessor...
            if (curr.left != null) { // curr.left exists krta hai....find predecessor....
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                // connect pred with curr....
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else { // if pred.right == curr.....
                    // unlink pred and curr....
                    pred.right = null;
                    // visit
                    if(prev!=null && prevPrev!=null){
                        if(prev.val> curr.val && prev.val> prevPrev.val){
                            arr.add(prev);
                        }
                        if(prev.val< curr.val && prev.val< prevPrev.val){
                            arr.add(prev);
                        }
                    }
                    // starting me kahi node garbad ho....
                    else if(prev!=null){
                        if(prev.val> curr.val){
                            arr.add(prev);
                        }
                    }
                    // aage bada do...
                    prevPrev = prev;
                    prev = curr;
                    curr = curr.right;
                }
            }
            else{ // if curr.left == null,no pred...
               // visit
                if(prev!=null && prevPrev!=null){
                    if(prev.val> curr.val && prev.val> prevPrev.val){
                        arr.add(prev);
                    }
                    if(prev.val< curr.val && prev.val< prevPrev.val){
                        arr.add(prev);
                    }
                }
                // starting me kahi node garbad ho....
                else if(prev!=null){
                    if(prev.val> curr.val){
                        arr.add(prev);
                    }
                }
                // aage bada do...
                prevPrev = prev;
                prev = curr;
                curr = curr.right;
            }
        }
        // ending me kahi garbad to nahi....
        if(prev.val< prevPrev.val){
            arr.add(prev);
        }
        // swapping
        Node first = arr.get(0);
        Node second = arr.get(arr.size()-1);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        Node a = new Node(5);
        Node b = new Node(13);
        root.left = a;
        root.right = b;

        Node c = new Node(3);
        Node d = new Node(10);
        a.left = c;
        a.right = d;

        Node e = new Node(11);
        Node f = new Node(14);
        b.left = e;
        b.right = f;
        System.out.println("Before recovery (Inorder): ");
        inorder(root);
        System.out.println();

        recoverTree(root);

        System.out.println("After recovery (Inorder): ");
        inorder(root);
        System.out.println();
    }
}
