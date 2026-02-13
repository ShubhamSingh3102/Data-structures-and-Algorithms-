package Trees;
import javax.management.QueryEval;
import java.util.*;
public class Maximum_Level_Sum_of_a_Binary_Tree {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static int maxLevelSum(Node root){
        if(root == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int answerLevel = 1;

        while(q.size() > 0){
            int size = q.size();
            int sum = 0;
            level++;

            for(int i=0;i<size;i++){
                Node temp = q.poll();
                sum += temp.val;

                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                answerLevel = level;
            }
        }
        return answerLevel;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(7);
        Node b = new Node(0);
        root.left = a;
        root.right = b;
        Node c = new Node(7);
        Node d = new Node(-8);
        a.left = c;
        a.right = d;
        System.out.println(maxLevelSum(root));
    }
}
