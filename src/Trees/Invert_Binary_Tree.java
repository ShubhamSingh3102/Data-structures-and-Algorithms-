package Trees;
public class Invert_Binary_Tree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
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
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
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
        b.right = e;

        System.out.println("Original Tree");
        preorder(root);
        System.out.println();
        Node n = InvertBinaryTree(root);
        System.out.println("Inverted Tree");
        preorder(n);
        System.out.println();
    }
}
