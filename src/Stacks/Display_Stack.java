package Stacks;
import java.util.Stack;
public class Display_Stack {
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
    public static void printStackArray(Stack<Integer> st){ // pass by reference....
        int n = st.size();
        int[] arr= new int[n];
        for(int i=n-1;i>=0;i--){
            int x = st.pop();
            arr[i] = x;
        }
        for(int i=0;i<=n-1;i++){
            System.out.print(arr[i]+" ");
            st.push(arr[i]);
        }
    }
    public static void displayReverseRec(Stack<Integer> st){
        if(st.size() == 0){
            return;
        }
        int top = st.pop();
        System.out.print(top+" ");
        displayReverseRec(st);
        st.push(top);
    }
    public static void displayStackRec(Stack<Integer> st){
        if(st.size() == 0){
            return;
        }
        int top = st.pop();
        displayStackRec(st);
        System.out.print(top+" ");
        st.push(top);
    }
    public static void pushAtBottomRec(Stack<Integer> st,int value){
        if(st.size() == 0){
            st.push(value);
            return;
        }
        int top = st.pop();
        pushAtBottomRec(st,value);
        st.push(top);
    }
    public static void removeFromIndex(Stack<Integer> st,int index){
        Stack<Integer> temp = new Stack<>();
        while(st.size()>index) {
            temp.push(st.pop());
        }
        st.pop(); // permanently hata diya isko.....
        while(temp.size()>0){
            st.push(temp.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(23);
        st.push(90);
        st.push(5);
        st.push(34);
//        printStack(st);
//        System.out.println();
//        printStackArray(st);
//        displayReverseRec(st);
//        System.out.println();
//        displayStackRec(st);
//        System.out.println();
//        pushAtBottomRec(st,6);
//        System.out.println(st);
        removeFromIndex(st,2);
        System.out.println(st);
    }
}
