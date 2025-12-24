package Trees;
public class Symmetric_Tree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static boolean isSameTree(Node root,Node root1){
        if(root == null && root1 == null){
            return true;
        }
        if(root == null){ // root1 != null
            return false;
        }
        if(root1 == null) { // root! = null
            return false;
        }
        if(root.val != root1.val){
            return false;
        }
        return (isSameTree(root.left,root1.left) && isSameTree(root.right,root1.right));
    }
    public static Node InvertBinaryTree(Node root){
        if(root == null){
            return null;
        }
        // swapping of two node....mirror
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        root.left = InvertBinaryTree(root.left);
        root.right = InvertBinaryTree(root.right);
        return root;
    }
    public static boolean isSymmetric(Node root){
        if(root == null){
            return true;
        }
        root.left = InvertBinaryTree(root.left);
        return isSameTree(root.left,root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(2);
        root.left = a;
        root.right = b;
        Node c = new Node(3);
        Node d = new Node(4);
        a.left = c;
        a.right = d;
        Node f = new Node(5);
        c.right = f;
        Node e = new Node(4);
        Node g = new Node(3);
        b.left = e;
        b.right = g;
        Node h = new Node(5);
        g.left = h;

        boolean result = isSymmetric(root);
        System.out.println(result);
    }
}
