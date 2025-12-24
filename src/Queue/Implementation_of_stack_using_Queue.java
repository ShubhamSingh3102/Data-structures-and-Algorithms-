package Queue;
import java.util.*;
public class Implementation_of_stack_using_Queue {
   public static class Stack<T>{
       Queue<Integer> q1 = new LinkedList<>();
//       public void push(int x){ // push efficient.....TC-->O(1)
//           q1.add(x);
//       }
       public void push(int x){ // TC-->0(n)
           if(q1.isEmpty()){
               q1.add(x);
           }
           else{
               q1.add(x);
               for(int i=1;i<=q1.size()-1;i++){
                   q1.add(q1.remove());
               }
           }
       }
       // 1 2 3 4 5
//       public int top(){ // TC-->0(n)
//           for(int i=1;i<=q1.size()-1;i++){
//               q1.add(q1.remove());
//           }
//           // 5 1 2 3 4
//           int x = q1.peek(); // 5
//           q1.add(q1.remove());
//           return x;
//       }
       public int top(){ // TC-->0(1)
           if(q1.isEmpty()){
               System.out.println("Stack is empty");
               return -1;
           }
           else{
               return q1.peek();
           }
       }
       // 1 2 3 4 5
//       public int pop(){ // TC-->0(n)
//           for(int i=1;i<=q1.size()-1;i++){
//               q1.add(q1.remove());
//           }
//           // 5 1 2 3 4
//           return q1.remove();
//       }

       // pop efficient....0(1)
       public int pop(){
           if(q1.isEmpty()){
               System.out.println("Stack is empty");
               return -1;
           }
           else{
               return q1.remove();
           }
       }
       public boolean isEmpty(){
           if(q1.size()==0){
               return true;
           }
           else{
               return false;
           }
       }
//       public void display(){
//           System.out.println(q1);
//       }
       public void display(){
           System.out.println(q1);
       }
   }
    public static void main(String[] args) {
       Stack<Integer> s = new Stack<>();
       s.push(1);
       s.push(2);
       s.push(3);
       s.push(4);
       s.push(5);
       s.display();
       s.pop();
       s.display();
       s.pop();
       s.display();
       System.out.println(s.top());
    }
}
