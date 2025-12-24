package Binary_Search_Tree;

public class Construct_Balanced_BST_from_sorted_array {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    // Sorted array me binary search lagao recursively...
    public static Node RecursiveBS(int[] arr,int low, int high){
        if(low>high){ // base case
            return null;
        }
    //    int mid = (low+high)/2;
        int mid = low + (high-low)/2;
        Node root = new Node(arr[mid]);
        root.left = RecursiveBS(arr,low,mid-1);
        root.right = RecursiveBS(arr,mid+1,high);
        return root;
    }
    public static Node sortedArrayToBst(int[] arr){
        int n = arr.length;
        return RecursiveBS(arr,0,n-1);
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int [] arr = {-10,-3,0,5,9};
        Node node = sortedArrayToBst(arr);
        inorder(node);
    }
}