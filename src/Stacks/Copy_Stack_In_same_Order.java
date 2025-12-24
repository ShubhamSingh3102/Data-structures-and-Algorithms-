package Stacks;
import java.util.*;
public class Copy_Stack_In_same_Order {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
//        int n;
//        System.out.println("Enter the numbers of elements you want to enter in the stack");
//        n = sc.nextInt();
//        System.out.println("Enter the elements of the stack");
//        for(int i=0;i<n;i++){
//            int x = sc.nextInt();
//            st.push(x);
//        }
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);

        // reverse order
        Stack<Integer> rt = new Stack<>();
        while(st.size()>0){
//            int x = st.peek();
//            rt.push(x);
//            st.pop();
            rt.push(st.pop());
        }
        System.out.println(rt);

        // same order using extra stack
        // Time complexity : O(n)
        Stack<Integer> st1 = new Stack<>();
        while(rt.size()>0){
            st1.push(rt.pop());
        }
        System.out.println(st1);
    }
}
