package Trees;
// root to node path...
import java.util.*;
public class binaryTreePaths {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static void helper(Node root,List<String> ans,String s){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            s += root.val;
            ans.add(s);
            return;
        }
        helper(root.left,ans,s+root.val+"->");
        helper(root.right,ans,s+root.val+"->");
    }
    public static List<String> binaryTreePath(Node root){
        List<String> ans = new ArrayList<>();
        helper(root,ans,"");
        return ans;
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
        List<String> i = binaryTreePath(root);

        for(String s: i){
            System.out.println(s);
        }
    }
}
