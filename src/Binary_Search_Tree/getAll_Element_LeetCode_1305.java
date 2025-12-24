package Binary_Search_Tree;
import java.util.*;
public class getAll_Element_LeetCode_1305 {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void merge( List<Integer> a , List<Integer> b,  List<Integer> ans ){
        int i = 0,j = 0;
        while(i<a.size() && j<b.size()) {
            if(a.get(i) <= b.get(j)) {
                ans.add(a.get(i));
                i++;
            }
            else{ // b[j] < a[i]
                ans.add(b.get(j));
                j++;
            }
        }
        if(i == a.size()){
            while(j<b.size()){
                ans.add(b.get(j));
                j++;
            }
        }
        if(j == b.size()){
            while(i<a.size()){
                ans.add(a.get(i));
                i++;
            }
        }
    }
    public static List<Integer> getAllElements(Node root1,Node root2){
        // for root1
        Node curr = root1;
        List<Integer> a = new ArrayList<>();
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
                    a.add(curr.val);
                    curr = curr.right;
                }
            } else { // if curr.left == null,no pred...
                a.add(curr.val);
                curr = curr.right;
            }
        }
            // for root2.....

            curr = root2;
            List<Integer> b = new ArrayList<>();
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
                        b.add(curr.val);
                        curr = curr.right;
                    }
                } else { // if curr.left == null,no pred...
                    b.add(curr.val);
                    curr = curr.right;
                }
            }
            // now merging to sorted arrayList...
            List<Integer> ans = new ArrayList<>();
            merge(a,b,ans);
            return ans;
        }
    public static void main(String[] args) {
        Node root1 = new Node(10);
        Node a = new Node(5);
        Node b = new Node(13);
        root1.left = a;
        root1.right = b;

        Node c = new Node(3);
        Node d = new Node(6);
        a.left = c;
        a.right = d;

        Node e = new Node(11);
        Node f = new Node(14);
        b.left = e;
        b.right = f;

        Node root2 = new Node(15);
        Node a1 = new Node(7);
        Node b1 = new Node(21);
        root2.left = a1;
        root2.right = b1;

        Node c1 = new Node(5);
        Node d1 = new Node(9);
        Node e1 = new Node(33);
        a1.left = c1;
        a1.right = d1;

        b1.right = e1;
        System.out.println(getAllElements(root1,root2));
    }
}
