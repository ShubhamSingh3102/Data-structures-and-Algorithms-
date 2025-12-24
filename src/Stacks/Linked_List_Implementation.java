package Stacks;
public class Linked_List_Implementation {
    public static class Node{ // user defined data type...
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static class Stack{ // user defined data structure...
        private Node head = null;
        private int size = 0;
        void push(int x){
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size++;
        }
        int pop(){
            if(head == null){
                System.out.println("Stack is empty");
                return -1;
            }
            else{
                head = head.next;
                size--;
                return head.data;
            }
        }
        int peek(){
            if(head==null){
                return -1;
            }
            else{
                return head.data;
            }
        }

        void size(){
            System.out.println(size);
        }
        void displayRev(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        boolean isEmpty(){
            if(size==0){
                return true;
            }
            else{
                return false;
            }
        }
        void displayRec(Node h){
            if(h==null){
                return;
            }
            displayRec(h.next);
            System.out.print(h.data+" ");
        }
        void display(){
            displayRec(head);
            System.out.println();
        }
        boolean isFull(){
            if(size==Integer.MAX_VALUE){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(4);
        st.push(5);
        st.push(1);
        st.display();
        st.pop();
        st.display();
        st.pop();
        st.display();
        st.peek();
        st.display();
        st.size();
    }
}
