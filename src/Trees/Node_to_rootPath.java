package Trees;

import java.util.ArrayList;
import java.util.List;

public class Node_to_rootPath {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static List<Integer> nodeRootpath(Node root,int target){
        if(root == null){
            return new ArrayList<>(); // khali list return ho jayega....
        }
        // if current node is the target,return list with just this node
        if(root.val == target){
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            return path;
        }
        // left recursion....
        List<Integer> leftPath = nodeRootpath(root.left,target);
           if(!leftPath.isEmpty()){
               // adding current node...
               leftPath.add(root.val);
               return leftPath;
        }
        List<Integer> rightPath = nodeRootpath(root.right,target);
            if(!rightPath.isEmpty()){
                // adding current node...
                rightPath.add(root.val);
                return rightPath;
            }
           return new ArrayList<>();
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
       Node e = new Node(7);
       b.right = e;
       Node f = new Node(18);
       Node g = new Node(10);
       e.left = f;
       e.right = g;
       Node h = new Node(6);
       d.left = h;
       int target = 6;
       List<Integer> path = nodeRootpath(root,target);

       if(path.isEmpty()){
           System.out.println("Target not found in tree");
       }
       else{
           System.out.println("Path from node " + target + " to root: "+ path);
       }
    }
}
