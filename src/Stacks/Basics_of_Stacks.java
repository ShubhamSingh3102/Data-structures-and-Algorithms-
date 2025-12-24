package Stacks;
//import java.util.ArrayList;
//import java.util.Stack;
import java.util.*;
public class Basics_of_Stacks {
    public static void printStack(Stack<Integer> st){
        Stack<Integer> temp = new Stack<>();
        while(st.size()>0){
            temp.push(st.pop());
        }
        while(temp.size()>0){
            st.push(temp.pop());
            System.out.print(st.peek()+" ");
        }
    }
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
//        System.out.println(st.isEmpty());
        st.push(1);
        st.push(23);
        st.push(90);
        st.push(5);
        st.push(34);
//        System.out.println(st.peek());
//        System.out.println(st);
//        st.pop();
//        System.out.println(st);
//        st.pop();
//        System.out.println(st);
//        System.out.println("Size of stack : " + st.size());
//
//        System.out.println(st.isEmpty());
//
//        while(st.size()>1){
//            st.pop();
//        }
//        System.out.println(st.peek());

        printStack(st);
    }
}
