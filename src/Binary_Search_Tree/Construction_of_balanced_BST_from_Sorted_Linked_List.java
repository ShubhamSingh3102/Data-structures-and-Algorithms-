package Binary_Search_Tree;

public class Construction_of_balanced_BST_from_Sorted_Linked_List {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode RecursiveBS(int[] arr,int low, int high){
        if(low>high){ // base case
            return null;
        }
    //    int mid = (low+high)/2;
        int mid = low + (high-low)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = RecursiveBS(arr,low,mid-1);
        root.right = RecursiveBS(arr,mid+1,high);
        return root;
    }
    // LeetCode 109
    public static TreeNode sortedLinkedListToBST(Node head){

        // first calculate the length of the linked list...
        Node temp = head;
        int n = 0;
        while (temp!=null){
            n++;
            temp = temp.next;
        }

        // now filled the array with linked list node...
        int[] arr = new int[n];
        int i = 0;
        temp = head;
        while (temp!=null){
            arr[i++] = temp.data;
            temp = temp.next;
        }
        return RecursiveBS(arr,0,n-1);
    }
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(5);
        Node c = new Node(7);
        Node d = new Node(13);
        Node e = new Node(87);
        Node f = new Node(100);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        TreeNode node = sortedLinkedListToBST(a);
        inOrder(node);
    }
}
