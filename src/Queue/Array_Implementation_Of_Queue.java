package Queue;
import java.util.*;
public class Array_Implementation_Of_Queue {
    public static class QueueArray{
        int f = -1;
        int r = -1;
        int size = 0;
        int[] arr = new int[100];
        public void add(int x){
            if(r == arr.length-1){
                System.out.println("Queue is full");
                return;
            }
            if(f == -1){
                r = 0;
                f = 0;
                arr[0] = x;
            }
            else{
                arr[++r] = x;
            }
            size++;
        }
        public int remove(){
            if(f == -1){
                System.out.println("Queue is empty");
                return -1;
            }
            else{
                f++;
                size--;
                return arr[f-1];
            }
        }
        public int peek(){
            if(f == -1){
                System.out.println("Queue is empty");
                return -1;
            }
            else{
                return arr[f];
            }
        }
        public void display(){
            if(f == -1){
                System.out.println("Queue is empty");
                return;
            }
            else {
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        public boolean isEmpty(){
            if(f == -1){
                return true;
            }
            else{
                return false;
            }
        }
        public boolean isFull(){
            if(r == arr.length-1){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        QueueArray q = new QueueArray();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.display();
        q.remove();
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        System.out.println(q.peek());
        System.out.println(q.size);
    }
}
