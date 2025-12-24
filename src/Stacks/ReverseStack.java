package Stacks;
import java.util.Stack;
public class ReverseStack {
    public static void pushAtBottomRec(Stack<Integer> st,int value){
        if(st.size() == 0){
            st.push(value);
            return;
        }
        int top = st.pop();
        pushAtBottomRec(st,value);
        st.push(top);
    }
    public static void reverseStackRec(Stack<Integer> st){
        if(st.size() == 1){
            return;
        }
        int top = st.pop();
        reverseStackRec(st);
        pushAtBottomRec(st,top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
//
//        // Iterative solution....
//        Stack<Integer> rt = new Stack<>();
//        while(st.size()>0){
//            rt.push(st.pop());
//        }
//        System.out.println(rt);
//        Stack<Integer> at = new Stack<>();
//        while(rt.size()>0){
//            at.push(rt.pop());
//        }
//        System.out.println(at);
//        while(at.size()>0){
//            st.push(at.pop());
//        }
//        System.out.println(st);

        reverseStackRec(st);
        System.out.println(st);
    }
}
