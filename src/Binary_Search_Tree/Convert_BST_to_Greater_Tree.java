package Binary_Search_Tree;

public class Convert_BST_to_Greater_Tree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    private static int sum = 0;
    public static void helper(Node root){
        if(root==null){
            return;
        }
        // ulta inorder traversal.....
        helper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        helper(root.left);
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    public static Node convertBST(Node root){
        sum = 0;
        helper(root);
        return root;
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
        Node node = convertBST(root);
        inOrder(node);
    }
}
