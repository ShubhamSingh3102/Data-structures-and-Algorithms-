package Binary_Search_Tree;
import java.util.*;
public class Add_One_Row_to_Tree {
    public static class Node {
        int val;
        Node left, right;
        Node(int v){
            val = v;
        }
    }
    public static Node add(Node root,int val,int depth,int curr){
        if(root == null){
            return null;
        }
        if(curr == depth - 1){
            Node leftTemp = root.left;
            Node rightTemp = root.right;

            root.left = new Node(val);
            root.right = new Node(val);

            root.left.left = leftTemp;
            root.right.right = rightTemp;
            return root;
        }
        ////if curr != depth -1
        root.left = add(root.left,val,depth,curr+1);
        root.right = add(root.right,val,depth,curr+1);
        return root;
    }
    public static Node addOneRow(Node root,int val,int depth){
        if(depth == 1){
            Node newRoot = new Node(val);
            newRoot.left = root;
            return newRoot;
        }
        return add(root,val,depth,1);
    }
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.val + " ");

            if(curr.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.right.left = new Node(5);

        int val = 1;
        int depth = 2;

        root = addOneRow(root,val,depth);
        levelOrder(root);
    }
}
