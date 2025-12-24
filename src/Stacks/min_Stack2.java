package Stacks;
import java.util.Stack;
public class min_Stack2 {
    // LeetCode 155 question...
    Stack<Long> st = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int val) {
        long x = (long)val;
        if(st.empty()){
            st.push(x);
            min = val;
        }
        else if(val >= min){
            st.push(x);
        }
        else {
            st.push(2*x-min); // fake value
            min = val;
        }
    }
    public void pop() {
        if(st.empty()){
            return;
        }
        else if(st.peek() >= min){
            st.pop();
        }
        else { // restore...peek pe fake value paari hai...
            long old = 2*min - st.peek();
            min = (int)old;
            st.pop();
        }
    }
    public int top() {
        if(st.empty()){
            return -1;
        }
        long q = st.peek();
        if(q >= min){
            return (int)(q);
        }
        if(st.peek() < min){ // fake value...
            return (int)min;
        }
        return -1;
    }
    public int getMin() {
        if(st.empty()){
            return -1;
        }
        return (int)min;
    }
    public static void main(String[] args) {
        min_Stack2 obj = new min_Stack2();
       obj.push(-2);
       obj.push(0);
       obj.push(-3);
       System.out.println(obj.getMin());
       obj.pop();
       System.out.println(obj.top());
       System.out.println(obj.getMin());
    }
}
