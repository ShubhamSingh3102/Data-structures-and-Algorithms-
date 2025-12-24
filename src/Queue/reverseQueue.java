package Queue;
import java.util.*;
public class reverseQueue {
    public static void reverse(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.remove());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        System.out.println(q);
    }
    public static void removeFirstKElement(Queue<Integer> q,int k){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<k;i++){
            st.push(q.remove());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        // Step 3: Move remaining (n-k) elements to back to preserve order
        int remaining = q.size() - k;
        for(int i=0;i<remaining;i++){
            q.add(q.remove());
        }
        System.out.println(q);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();
        System.out.println(q);
//        reverse(q);
        removeFirstKElement(q,k);
    }
}
