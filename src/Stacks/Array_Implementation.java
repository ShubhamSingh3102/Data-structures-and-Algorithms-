package Stacks;
public class Array_Implementation {
    //// LIFO
    public static class Stack{
        private int[] arr = new int[5];
        private int idx = 0;
        void push(int x){
            if(isFull()){
                System.out.println("Stack overflow");
                return;
            }
            arr[idx] = x;
            idx++;
        }
        int peek(){
            if(idx == 0){
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[idx-1];
        }

        int pop(){
            if(idx == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            int top = arr[idx-1];
            arr[idx-1] = 0;
            idx--;
            return top;
        }
        void display(){
            for(int i=0;i<=idx-1;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        int size(){
            return idx;
        }
        boolean isEmpty(){
            if(idx == 0){
                return true;
            }
            else{
                return false;
            }
        }
        boolean isFull() {
            if (idx == arr.length) {
                return true;
            }
            else{
                return false;
            }
        }
        int capacity(){
            return arr.length;
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(4);
        st.push(5);
        st.push(1);
        st.display();
        System.out.println(st.size());
        st.pop();
        st.display();
        st.push(2);
        st.push(3);
        st.push(6);
        st.display();
        System.out.println(st.isFull());
        st.push(7);
    }
}





//// FlowChart of Stack
//// 1 --> items(string,arrays)
//// 2 --> left to right
//// 3 --> most recent elements
//// 4 --> Matching/Cancelling/Cleaning
//// 5 --> Reverse

//// Three types of stacks
//// 1 --> Simple Stack
//// 2 --> Monotonic Stack (increasing or decreasing)  // sorted order
//// 3 --> Greedy Stack (condition)


//// Universal Template
//// items ko dekho (I1,I2,I3,I4)  --->
//// when to pop and what to pop???
//// when to push
//// store the result