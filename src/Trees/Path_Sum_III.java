package Trees;
import java.util.*;
public class Path_Sum_III {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static int noOfPaths(Node root,long target){
        if(root == null){
            return 0;
        }
        int count = 0;
        if((long)(root.val) == target){
            count++;
        }
        return count + noOfPaths(root.left,target - (long)(root.val)) + noOfPaths(root.right,target - (long)(root.val));
    }
    public static int pathSum(Node root,int target){
        if(root == null){
            return 0;
        }
        int count = noOfPaths(root,(long) (target));
        count += (pathSum(root.left,target) + pathSum(root.right,target));
        return count;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(5);
        root.left = a;
        root.right = b;
        Node c = new Node(1);
        a.left = c;
        Node e = new Node(-1);
        c.left = e;
        Node f = new Node(-3);
        b.right = f;
        int target = 3;
        int ans = pathSum(root,target);
        System.out.println(ans);
    }
}
