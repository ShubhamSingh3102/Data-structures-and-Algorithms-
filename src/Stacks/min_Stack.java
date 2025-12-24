package Stacks;
import java.util.Stack;
public class min_Stack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int x){
        if(st.isEmpty()){
            st.push(x);
            min.push(x);
        }
        else{
            st.push(x);
            if(x>=min.peek()){
                min.push(min.peek());
            }
            else{
                min.push(x);
            }
        }
    }
    public void pop(){
        if(st.isEmpty()){
            System.out.println("Stack underflow");
        }
        else{
            st.pop();
            min.pop();
        }
    }
    public int top(){
        return st.peek();
    }
    public int getMin(){
        return min.peek();
    }
    public static void main(String[] args) {
        min_Stack obj = new min_Stack();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(25);
        obj.push(5);
        obj.push(60);
        obj.push(70);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
