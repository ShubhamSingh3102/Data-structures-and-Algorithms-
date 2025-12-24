package Stacks;
import java.util.*;
public class Insertion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st);
        // Insertion at bottom
        Stack<Integer> rt = new Stack<>();
        while (st.size() > 0) {
            rt.push(st.pop());
        }
        System.out.println(rt);

        st.push(5);

        while(rt.size()>0){
            st.push(rt.pop());
        }
        System.out.println(st);

        // Insertion at any index
        Stack<Integer> st1 = new Stack<>();
        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.push(4);
        System.out.println(st1);

        int index = 2;
        Stack<Integer> rt1 = new Stack<>();
        while(st1.size()>index){
            rt1.push(st1.pop());
        }
        st1.push(5);
        while(rt1.size()>0){
            st1.push(rt1.pop());
        }
        System.out.println(st1);
    }
}
