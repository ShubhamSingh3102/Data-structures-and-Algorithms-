package Queue;
import java.util.*;
public class Array_Implementation_of_Circular_Queue {
    public static class MyCircularQueue {
        int[] arr = new int[5];
        int f = -1;
        int r = -1;
        int size = 0;

        public void add(int value) throws Exception {
            if (size == 0) {
                f = r = 0;
                arr[0] = value;
                size++;
            }
            else if (size == arr.length) {
                throw new Exception("Queue is full");
            }
            else if (r < arr.length - 1) {
                arr[++r] = value;
                size++;
            }
            else if (r == arr.length - 1) {
                r = 0;
                arr[0] = value;
                size++;
            }
        }
        public int remove() throws Exception{
            if (size == 0) {
                throw new Exception("Queue is empty");
            }
            else if (f < arr.length - 1) {
                int data = arr[f];
                f++;
                size--;
                return data;
            }
            else if (f == arr.length - 1) {
                int data = arr[f];
                f = 0;
                size--;
                return data;
            }
            return -1;
        }
        public int peek() throws Exception{
            if (size == 0) {
                throw new Exception("Queue is empty");
            }
            else {
                return arr[f];
            }
        }
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isFull() {
            if (size == arr.length) {
                return true;
            } else {
                return false;
            }
        }
        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty");
            }
            else if (f <= r) {
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            else if(f > r){
                for(int i=f;i<arr.length;i++){
                    System.out.print(arr[i]+" ");
                }
                for(int i=0;i<=r;i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) throws Exception{
        MyCircularQueue q = new MyCircularQueue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.display();
        q.remove();
        q.remove();
        q.display();
        q.add(60);
        q.add(70);
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.size);
        System.out.println(q.peek());
        for(int i=0;i<q.arr.length;i++){
            System.out.print(q.arr[i]+" ");
        }
    }
}
