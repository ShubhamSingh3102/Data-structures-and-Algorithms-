package Queue;
import java.util.*;
public class print_all_the_element {
        public static void display(Queue<Integer> q){
        if(q.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        else{
            while(!q.isEmpty()){
                System.out.print(q.remove()+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(10);
        q.add(5);
        // rare -> 5 4 3 2 1 -> front
        display(q);
    }
}
