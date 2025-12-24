package Queue;
import java.util.*;
public class Implementation_of_queue_using_Stacks {
    public static class Queue<T> {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        //        public void add(int x){ // TC--> 0(1)....push efficient...
//            st1.push(x);
//        }
        public void add(int x) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            st1.push(x); // directly jumps if st1.isEmpty
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }

        //        public int remove(){ // TC--> O(n)
//            while(st1.size() > 1){
//                st2.push(st1.pop());
//            }
//            int x = st1.pop();
//            while(!st2.isEmpty()){
//                st1.push(st2.pop());
//            }
//            return x;
//        }
        public int remove() { // pop efficient....
            return st1.pop();
        }

        //        public int peek(){ // TC--> 0(n)
//            while(st1.size() > 1){
//                st2.push(st1.pop());
//            }
//            int x = st1.peek();
//            while(!st2.isEmpty()){
//                st1.push(st2.pop());
//            }
//            return x;
//        }
        public int peek() {
            return st1.peek();
        }

        public boolean isEmpty() {
            if (st1.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        //        public void display(){
//            Stack<Integer> s = new Stack<>();
//            while(!st1.isEmpty()){
//                s.push(st1.pop());
//            }
//            while(!s.isEmpty()){
//                int x = s.pop();
//                System.out.print(x+" ");
//                st1.push(x);
//            }
//            System.out.println();
//        }
        public void display() {
//            Stack<Integer> s = new Stack<>();
//            while(!st1.isEmpty()){
//                s.push(st1.pop());
//            }
//            while(!s.isEmpty()){
//                int x = s.pop();
//                System.out.print(x+" ");
//                st1.push(x);
//            }
//            System.out.println();
//        }
            for (int i=st1.size()-1; i>=0; i--) {
                System.out.print(st1.get(i) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(6);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.display();
        q.remove();
        q.display();
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}
