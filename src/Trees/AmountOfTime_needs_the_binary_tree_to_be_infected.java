package Trees;
import java.util.*;
public class AmountOfTime_needs_the_binary_tree_to_be_infected {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static Node getNode(Node root,int start){
        if(root==null){
            return null;
        }
        if(root.val==start){
            return root;
        }
        Node left = getNode(root.left,start);
        Node right = getNode(root.right,start);
        if(left==null){
            return right;
        }
        else{
            return left;
        }
    }
    public static void preOrder(Node root,Map<Node,Node> parent){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parent.put(root.left,root);
        }
        if(root.right!=null){
            parent.put(root.right,root);
        }
        preOrder(root.left,parent);
        preOrder(root.right,parent);
    }
    // BFS Traversal in graph using queue....
    public static int amountOfTime(Node root,int start){
        Node node = getNode(root,start);
        Map<Node,Node> parent = new HashMap<>();
        preOrder(root,parent);
        // BFS
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Node,Integer> visited = new HashMap<>();
        visited.put(node,0);
        while(q.size()>0){
            Node temp = q.peek();
            int level = visited.get(temp);

            // left
            if(temp.left!=null && !visited.containsKey(temp.left)){
                q.add(temp.left);
                visited.put(temp.left,level+1);
            }

            // right
            if(temp.right!=null && !visited.containsKey(temp.right)){
                q.add(temp.right);
                visited.put(temp.right,level+1);
            }

            // parent
            if(parent.containsKey(temp) && !visited.containsKey(parent.get(temp))){
                q.add(parent.get(temp));
                visited.put(parent.get(temp),level+1);
            }
            q.remove();
        }
        // traversing visited Map for finding amount of time taken...
        int max = -1;
        for(int level : visited.values()){
            max = Math.max(max,level);
        }
        return max;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(3);
        Node b = new Node(5);
        root.left = b;
        root.right = a;
        Node c = new Node(10);
        Node d = new Node(6);
        a.left = c;
        a.right = d;
        Node e = new Node(2);
        b.left = e;
        Node f = new Node(4);
        b.right = f;
        Node g = new Node(9);
        f.left = g;
        Node h = new Node(2);
        f.right = h;
        int start = 3;
        int result = amountOfTime(root,start);
        System.out.println(result);
    }
}
