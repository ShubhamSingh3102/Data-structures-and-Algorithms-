package Binary_Search_Tree;

public class Ceil_in_BST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
public static int findCeil(Node root,int key) {
    int ceil = -1;
    while (root != null) {
        if (root.val == key) {
            ceil = root.val;
            return ceil;
        }
        if (key > root.val) {
            root = root.right;
        } else {
            ceil = root.val;
            root = root.left;
        }
    }
    return ceil;
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
        int ans = findCeil(root,8);
        System.out.println(ans);
    }
}
